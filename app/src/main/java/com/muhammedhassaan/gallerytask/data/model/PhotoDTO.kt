package com.muhammedhassaan.gallerytask.data.model

import com.muhammedhassaan.gallerytask.domain.model.Photo

data class PhotoDTO(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)

fun PhotoDTO.asPhoto(): Photo =
    Photo(
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url
    )