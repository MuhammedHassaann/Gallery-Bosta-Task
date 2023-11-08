package com.muhammedhassaan.gallerytask.presentation.screens.album

import com.muhammedhassaan.gallerytask.domain.model.Photo

data class AlbumViewState(
    val isLoading: Boolean = false,
    val error: String? = "",
    val photos: List<Photo>? = null
)
