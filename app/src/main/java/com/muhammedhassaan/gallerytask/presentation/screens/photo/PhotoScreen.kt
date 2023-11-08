package com.muhammedhassaan.gallerytask.presentation.screens.photo

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.request.ImageRequest
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.FontSize
import com.muhammedhassaan.gallerytask.core.ViewUtils.noRippleClickable
import com.muhammedhassaan.gallerytask.presentation.components.ImageComponent
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors
import java.io.File
import java.io.FileOutputStream

@Composable
fun PhotoScreen(
    viewModel: PhotoViewModel = hiltViewModel()
) {
    var scale by remember {
        mutableFloatStateOf(1f)
    }

    var offset by remember {
        mutableStateOf(Offset.Zero)
    }

    var imageFile by remember { mutableStateOf<File?>(null) }

    val context = LocalContext.current

    // Use Coil to load the image and retrieve the local file
    LaunchedEffect(viewModel.photoUrl) {
        val imageLoader = ImageLoader.Builder(context).build()

        val request = ImageRequest.Builder(context)
            .data(viewModel.photoUrl)
            .target { drawable ->
                val bitmap = drawable.toBitmap()

                // Save the bitmap to a file
                val file = File(context.cacheDir, "shared_image.jpg")
                FileOutputStream(file).use { out ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
                }

                imageFile = file
            }
            .build()

        imageLoader.enqueue(request)
    }

    Box(
        Modifier.fillMaxSize()
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .aspectRatio(600f / 600f)
                .align(Alignment.Center)
        ) {
            val state = rememberTransformableState { onTransformation, panChange, onRotation ->
                scale = (scale * onTransformation).coerceIn(1f, 5f)

                val extraWidth = (scale - 1) * constraints.maxWidth
                val extraHeight = (scale - 1) * constraints.maxHeight

                val maxX = extraWidth / 2
                val maxY = extraHeight / 2

                offset = Offset(
                    x = (offset.x + scale * panChange.x).coerceIn(-maxX, maxX),
                    y = (offset.y + scale * panChange.y).coerceIn(-maxY, maxY)
                )
            }


            ImageComponent(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        translationX = offset.x
                        translationY = offset.y
                    }
                    .transformable(state),
                imageUrl = viewModel.photoUrl
            )
        }

        Box(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.large))
                .clip(CircleShape)
                .background(MaterialTheme.ThemeColors.purple)
                .align(Alignment.BottomEnd)
                .noRippleClickable {
                    imageFile?.let { viewModel.shareImage(context, it) }
                },
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.large),
                        vertical = dimensionResource(id = R.dimen.small)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.share_img),
                    fontSize = FontSize.FONT_18,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Icon(
                    modifier = Modifier
                        .padding(start = dimensionResource(id = R.dimen.xx_small)),
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = stringResource(id = R.string.share_img),
                    tint = Color.White
                )
            }
        }

    }
}