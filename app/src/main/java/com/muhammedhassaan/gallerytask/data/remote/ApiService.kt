package com.muhammedhassaan.gallerytask.data.remote

import com.muhammedhassaan.gallerytask.data.model.AlbumDTO
import com.muhammedhassaan.gallerytask.data.model.PhotoDTO
import com.muhammedhassaan.gallerytask.data.model.UserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<UserDTO>>

    @GET("albums")
    suspend fun getAlbums(@Query("userId") userId: Int): Response<List<AlbumDTO>>

    @GET("photos")
    suspend fun getPhotos(@Query("albumId") albumId: Int): Response<List<PhotoDTO>>
}