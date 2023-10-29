package com.muhammedhassaan.gallerytask.data.model

import com.muhammedhassaan.gallerytask.domain.model.Album

data class AlbumDTO(
    val id: Int,
    val title: String,
    val userId: Int
)

fun AlbumDTO.asAlbum(): Album =
    Album(
        id = id,
        title = title
    )