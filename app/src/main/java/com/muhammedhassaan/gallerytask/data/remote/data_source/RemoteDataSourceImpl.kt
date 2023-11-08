package com.muhammedhassaan.gallerytask.data.remote.data_source

import android.accounts.NetworkErrorException
import com.muhammedhassaan.gallerytask.core.EndString
import com.muhammedhassaan.gallerytask.data.model.asAlbum
import com.muhammedhassaan.gallerytask.data.model.asPhoto
import com.muhammedhassaan.gallerytask.data.model.asUser
import com.muhammedhassaan.gallerytask.data.remote.ApiService
import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.domain.model.Photo
import com.muhammedhassaan.gallerytask.domain.model.User
import com.muhammedhassaan.gallerytask.domain.remote.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource{
    override suspend fun getRandomUser(): User {
        try {
            val response = apiService.getUsers()
            return if (response.isSuccessful) {
                val users = response.body() ?: emptyList()
                if (users.isNotEmpty()) {
                    val randomIndex = (users.indices).random()
                    users[randomIndex].asUser()
                } else {
                    throw NoSuchElementException("No users available")
                }
            } else {
                throw Exception(EndString.UNEXPECTED_ERROR_TITLE)
            }
        }catch (e: Exception){
            throw NetworkErrorException(EndString.INTERNET_CONNECTION_UNSTABLE)
        }
    }

    override suspend fun getAlbums(userId: Int): List<Album> {
        try {
            val response = apiService.getAlbums(userId)
            return if (response.isSuccessful) {
                response.body()?.map {
                    it.asAlbum()
                } ?: emptyList()
            } else {
                throw Exception(EndString.UNEXPECTED_ERROR_TITLE)
            }
        }catch (e: Exception){
            throw NetworkErrorException(EndString.INTERNET_CONNECTION_UNSTABLE)
        }
    }

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        try {
            val response = apiService.getPhotos(albumId)
            return if (response.isSuccessful) {
                response.body()?.map {
                    it.asPhoto()
                } ?: emptyList()
            } else {
                throw Exception(EndString.UNEXPECTED_ERROR_TITLE)
            }
        }catch (e: Exception){
            throw NetworkErrorException(EndString.INTERNET_CONNECTION_UNSTABLE)
        }
    }

    override suspend fun getAlbumWithImage(userId: Int): List<Triple<Album, String, Int>> {
        val albums = getAlbums(userId)
        val albumInfo = mutableListOf<Triple<Album, String, Int>>()
        albums.forEach { album->
            val albumPhotos = getPhotos(album.id)
            if (albumPhotos.isNotEmpty()){
                val photoUrl = albumPhotos.first().thumbnailUrl
                val albumSize = albumPhotos.size
                albumInfo.add(Triple(album,photoUrl,albumSize))
            }
        }

        return albumInfo
    }

}