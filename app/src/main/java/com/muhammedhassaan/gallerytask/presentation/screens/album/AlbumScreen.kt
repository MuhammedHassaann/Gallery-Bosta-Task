package com.muhammedhassaan.gallerytask.presentation.screens.album

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.EndString
import com.muhammedhassaan.gallerytask.core.FontSize
import com.muhammedhassaan.gallerytask.core.ViewUtils.noRippleClickable
import com.muhammedhassaan.gallerytask.presentation.components.DividerComponent
import com.muhammedhassaan.gallerytask.presentation.components.ImageComponent
import com.muhammedhassaan.gallerytask.presentation.components.NoInternetConnectionComponent
import com.muhammedhassaan.gallerytask.presentation.components.NotFoundComponent
import com.muhammedhassaan.gallerytask.presentation.components.SearchBarComponent
import com.muhammedhassaan.gallerytask.presentation.components.TechnicalErrorComponent
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors

@Composable
fun AlbumScreen(
    viewModel: AlbumViewModel = hiltViewModel(),
    onPhotoClick: (photoUrl: String) -> Unit,
) {

    val viewState = viewModel.viewState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        viewModel.albumName?.let { albumName ->
            Text(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium)),
                text = albumName,
                fontSize = FontSize.FONT_24,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.ThemeColors.black
            )
        }

        DividerComponent(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = MaterialTheme.ThemeColors.darkGray.copy(alpha = 0.5f)
        )

        SearchBarComponent(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.medium))
                .fillMaxWidth(),
            isEnabled = viewModel.enableSearch,
            placeholderText = stringResource(id = R.string.search_in_images),
            leadingIcon = {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Default.Search,
                    tint = MaterialTheme.ThemeColors.darkGray,
                    contentDescription = ""
                )
            },
            onSearchTextChanged = { searchText ->
                viewModel.setSearchQuery(searchText)
            }
        )

        when {
            //region loading state
            viewState.isLoading -> {
                Box(
                    Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            //endregion

            //region error state
            viewState.error?.isNotBlank() == true -> {
                val errorMessage = viewState.error
                Box(Modifier.fillMaxSize()) {
                    if (errorMessage == EndString.UNEXPECTED_ERROR_OCCURRED) {
                        TechnicalErrorComponent(onClick = viewModel::getPhotos)
                    } else {
                        NoInternetConnectionComponent(onClick = viewModel::getPhotos)
                    }
                }
            }
            //endregion

            //region success state
            else -> {
                val filteredPhotos = viewModel.filteredPhotos.value
                if (filteredPhotos.isEmpty()) {
                    Box (Modifier.fillMaxSize()){
                        NotFoundComponent(
                            modifier = Modifier.align(Alignment.Center),
                            body = stringResource(id = R.string.photo_not_found)
                        )
                    }
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3)
                    ) {
                        items(filteredPhotos) { photo ->
                            ImageComponent(
                                modifier = Modifier.noRippleClickable {
                                    onPhotoClick(photo.url)
                                },
                                imageUrl = photo.url
                            )
                        }

                    }
                }
            }
            //endregion
        }

    }
}