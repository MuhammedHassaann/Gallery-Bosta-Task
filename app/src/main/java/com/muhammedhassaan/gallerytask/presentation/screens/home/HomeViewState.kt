package com.muhammedhassaan.gallerytask.presentation.screens.home

import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.domain.model.User

data class HomeViewState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val albums: List<Triple<Album,String,Int>>? = emptyList(),
    val error: String? = ""
)
