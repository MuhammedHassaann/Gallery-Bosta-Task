package com.muhammedhassaan.gallerytask.presentation.screens.album

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedhassaan.gallerytask.core.Result
import com.muhammedhassaan.gallerytask.domain.model.Photo
import com.muhammedhassaan.gallerytask.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _viewState = mutableStateOf(AlbumViewState())
    val viewState: State<AlbumViewState> = _viewState

    val albumId: String? = savedStateHandle["albumId"]
    val albumName: String? = savedStateHandle["albumName"]

    var enableSearch by mutableStateOf(false)

    private val _filteredPhotos = mutableStateOf<List<Photo>>(emptyList())
    val filteredPhotos: State<List<Photo>> = _filteredPhotos

    init {
        getPhotos()
    }

    fun getPhotos() {
        viewModelScope.launch {
            albumId?.let { albumId ->
                getPhotosUseCase(albumId.toInt()).onEach { photosResult ->
                    when (photosResult) {
                        is Result.Success -> {
                            enableSearch = true
                            val photos = photosResult.data
                            _viewState.value = AlbumViewState(photos = photos)
                            if (photos != null) {
                                _filteredPhotos.value = photos
                            }
                        }

                        is Result.Loading -> {
                            _viewState.value = AlbumViewState(isLoading = true)
                        }

                        is Result.Error -> {
                            _viewState.value = AlbumViewState(
                                error = photosResult.message
                            )
                        }

                        else -> {}
                    }
                }.launchIn(this)
            }
        }
    }


    private fun filterPhotos(photos: List<Photo>, query: String) {
        val filtered = if (query.isEmpty()) {
            photos
        } else {
            photos.filter { it.title.contains(query, ignoreCase = true) }
        }
        _filteredPhotos.value = filtered
    }


    fun setSearchQuery(query: String) {
        //_searchQuery.value = query
        filterPhotos(_viewState.value.photos.orEmpty(), query)
    }
}