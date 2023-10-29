package com.muhammedhassaan.gallerytask.data.remote.data_source

import android.accounts.NetworkErrorException
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
        val response = apiService.getUsers()
        return if (response.isSuccessful) {
            val users = response.body()?: emptyList()
            if (users.isNotEmpty()) {
                val randomIndex = (users.indices).random()
                 users[randomIndex].asUser()
            } else {
                throw NoSuchElementException("No users available")
            }
        }else{
            throw NetworkErrorException()
        }
    }

    override suspend fun getAlbums(userId: Int): List<Album> {
        val response = apiService.getAlbums(userId)
        return if (response.isSuccessful){
            response.body()?.map {
                it.asAlbum()
            } ?: emptyList()
        }else{
            throw NetworkErrorException()
        }
    }

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val response = apiService.getPhotos(albumId)
        return if (response.isSuccessful){
            response.body()?.map {
                it.asPhoto()
            } ?: emptyList()
        }else{
            throw NetworkErrorException()
        }
    }

}