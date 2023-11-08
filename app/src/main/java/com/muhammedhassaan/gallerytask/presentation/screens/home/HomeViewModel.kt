package com.muhammedhassaan.gallerytask.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedhassaan.gallerytask.core.Result
import com.muhammedhassaan.gallerytask.domain.usecase.GetAlbumsWithPhotoUseCase
import com.muhammedhassaan.gallerytask.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getAlbumsWithPhotoUseCase: GetAlbumsWithPhotoUseCase
) : ViewModel() {

    private val _viewState = mutableStateOf(HomeViewState())
    val viewState: State<HomeViewState> = _viewState

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            getUserUseCase().onEach { userResult ->
                when (userResult) {
                    is Result.Success -> {
                        val user = userResult.data
                        _viewState.value = _viewState.value.copy(user = user)
                        userResult.data?.id?.let { getAlbums(it) }
                    }

                    is Result.Loading -> {
                        _viewState.value = HomeViewState(isLoading = true)
                    }

                    is Result.Error -> {
                        _viewState.value = HomeViewState(
                            error = userResult.message
                        )
                    }

                    else -> {}
                }
            }.launchIn(this)
        }
    }

    private fun getAlbums(userId: Int) {
        viewModelScope.launch {
            getAlbumsWithPhotoUseCase(userId).onEach { albumsResult ->
                when (albumsResult) {
                    is Result.Success -> {
                        _viewState.value = _viewState.value.copy(
                            isLoading = false,
                            albums = albumsResult.data
                        )
                    }

                    is Result.Error -> {
                        _viewState.value = HomeViewState(
                            error = albumsResult.message
                        )
                    }

                    else -> {}
                }
            }.launchIn(this)
        }
    }

}