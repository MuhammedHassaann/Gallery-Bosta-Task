package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.ViewUtils
import com.muhammedhassaan.gallerytask.core.ViewUtils.shimmerBackground

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    imageUrl: Any?,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        contentDescription = "",
        colorFilter = colorFilter,
        model = imageUrl ?: "",
        contentScale = contentScale,
        loading = {
            this.SubcomposeAsyncImageContent(
                modifier = Modifier.shimmerBackground(),
            )
        },
        error = {
            ViewUtils.ImageError(
                this,
                size = dimensionResource(id = R.dimen.error_img)
            )
        }
    )
}