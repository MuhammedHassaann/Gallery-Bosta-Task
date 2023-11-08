package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.FontSize
import com.muhammedhassaan.gallerytask.core.ViewUtils.noRippleClickable
import com.muhammedhassaan.gallerytask.core.ViewUtils.shimmerBackground
import com.muhammedhassaan.gallerytask.domain.model.Album
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors

@Composable
fun AlbumComponent(
    modifier: Modifier = Modifier,
    album: Album,
    photoUrl: String,
    albumSize: Int,
    onAlbumClick: (albumId: String, albumName: String) -> Unit
) {
    Column(
        modifier = modifier.noRippleClickable {
            onAlbumClick(album.id.toString(), album.title)
        }
    ) {
        Box(
            modifier = Modifier.clip(RoundedCornerShape(16.dp))
        ) {
            ImageComponent(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.album_thumbnail)),
                imageUrl = photoUrl
            )
        }
        Text(
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.xxx_small)),
            text = album.title,
            fontSize = FontSize.FONT_12,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.ThemeColors.black
        )
        Text(
            text = albumSize.toString(),
            fontSize = FontSize.FONT_10,
            color = MaterialTheme.ThemeColors.darkGray
        )
    }
}

@Composable
fun AlbumShimmerComponent() {
    val width = LocalConfiguration.current.screenWidthDp.toFloat() / 0.25f
    Column(
        Modifier.width(width.dp)
    ) {
        Box(
            Modifier
                .size(dimensionResource(id = R.dimen.album_thumbnail))
                .shimmerBackground()
        )
        Box(
            Modifier
                .padding(dimensionResource(id = R.dimen.xxx_small))
                .height(dimensionResource(id = R.dimen.small))
                .fillMaxWidth(0.85f)
                .shimmerBackground()
        )
        Box(
            Modifier
                .height(dimensionResource(id = R.dimen.small))
                .fillMaxWidth(0.20f)
                .shimmerBackground()
        )
    }
}