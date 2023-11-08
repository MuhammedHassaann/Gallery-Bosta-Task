package com.muhammedhassaan.gallerytask.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.EndString
import com.muhammedhassaan.gallerytask.core.FontSize
import com.muhammedhassaan.gallerytask.presentation.components.AlbumComponent
import com.muhammedhassaan.gallerytask.presentation.components.AlbumShimmerComponent
import com.muhammedhassaan.gallerytask.presentation.components.DividerComponent
import com.muhammedhassaan.gallerytask.presentation.components.NoInternetConnectionComponent
import com.muhammedhassaan.gallerytask.presentation.components.TechnicalErrorComponent
import com.muhammedhassaan.gallerytask.presentation.components.UserComponent
import com.muhammedhassaan.gallerytask.presentation.components.UserShimmerComponent
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onAlbumClick: (albumId: String, albumName: String) -> Unit
) {

    val viewState = viewModel.viewState.value

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.medium))
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.profile),
            fontSize = FontSize.FONT_24,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.ThemeColors.black
        )

        when {

            //region loading state
            viewState.isLoading -> {
                UserShimmerComponent()
                DividerComponent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = MaterialTheme.ThemeColors.darkGray.copy(alpha = 0.5f)
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.medium)),
                    text = stringResource(id = R.string.my_albums),
                    fontSize = FontSize.FONT_18,
                    color = MaterialTheme.ThemeColors.black
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.xx_small)),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.xx_small))
                ) {
                    items(5) {
                        AlbumShimmerComponent()
                    }
                }
            }
            //endregion

            //region error state
            viewState.error?.isNotBlank() == true -> {
                val errorMessage = viewState.error
                Box(Modifier.fillMaxSize()) {
                    if (errorMessage == EndString.UNEXPECTED_ERROR_OCCURRED) {
                        TechnicalErrorComponent(onClick = viewModel::getData)
                    } else {
                        NoInternetConnectionComponent(onClick = viewModel::getData)
                    }
                }
            }
            //endregion

            //region success state
            else -> {
                viewState.user?.let { user ->
                    UserComponent(user = user)
                }

                DividerComponent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = MaterialTheme.ThemeColors.darkGray.copy(alpha = 0.5f)
                )

                Text(
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.medium)),
                    text = stringResource(id = R.string.my_albums),
                    fontSize = FontSize.FONT_18,
                    color = MaterialTheme.ThemeColors.black
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.xx_small)),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.xx_small))
                ) {
                    viewState.albums?.let { albums ->
                        items(albums) { album ->
                            AlbumComponent(
                                album = album.first,
                                photoUrl = album.second,
                                albumSize = album.third,
                                onAlbumClick = { albumId , albumName->
                                    onAlbumClick(albumId,albumName)
                                }
                            )
                        }
                    }
                }

            }
            //endregion
        }

    }
}


