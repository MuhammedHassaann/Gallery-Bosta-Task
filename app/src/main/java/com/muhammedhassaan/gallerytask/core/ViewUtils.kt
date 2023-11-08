package com.muhammedhassaan.gallerytask.core

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.SubcomposeAsyncImageScope
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.presentation.ui.theme.Purple40
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors
import com.muhammedhassaan.gallerytask.presentation.ui.theme.shimmer

object ViewUtils {

    fun Modifier.noRippleClickable(
        onClick: () -> Unit
    )= composed {
        clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
        ) {
            onClick()
        }
    }

    fun Modifier.shimmerBackground(
        shape: Shape = RoundedCornerShape(16.dp)
    ): Modifier = composed {
        val transition = rememberInfiniteTransition(label = "")

        val translateAnimation by transition.animateFloat(
            initialValue = 0f,
            targetValue = 400f,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 1500, easing = LinearOutSlowInEasing), RepeatMode.Restart
            ),
            label = "",
        )
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.4f),
        )
        val brush = Brush.linearGradient(
            colors = shimmerColors,
            start = Offset(translateAnimation, translateAnimation),
            end = Offset(translateAnimation + 100f, translateAnimation + 100f),
            tileMode = TileMode.Mirror,
        )
        return@composed this.then(background(brush, shape))
    }

    @Composable
    fun ImageError(subComposeAsyncImageScope: SubcomposeAsyncImageScope, size: Dp) {
        Box(
            modifier = Modifier.background(shimmer),
            contentAlignment = Alignment.Center
        ) {
            subComposeAsyncImageScope.SubcomposeAsyncImageContent(
                modifier = Modifier.size(size), painterResource(id = R.drawable.ic_error_img)
            )
        }
    }

    @Composable
    fun SomeThingWentWrongScreen(
        modifier: Modifier = Modifier,
        errorImage: Int,
        errorTitle: String,
        isBoldTitle: Boolean = true,
        errorDescription: String = "",
        buttonText: String = "",
        action: () -> Unit = {}
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.x_large)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(errorImage), contentDescription = "",
            )
            Text(
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.small))
                    .align(Alignment.CenterHorizontally),
                text = errorTitle,
                fontWeight = if (isBoldTitle) FontWeight.Bold else FontWeight.Normal,
                fontSize = FontSize.FONT_14,
                color = MaterialTheme.ThemeColors.black,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = dimensionResource(id = R.dimen.x_large)),
                text = errorDescription,
                fontSize = FontSize.FONT_12,
                color = MaterialTheme.ThemeColors.black,
                textAlign = TextAlign.Center
            )
            if (buttonText.isNotEmpty()) Button(
                onClick = action,
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.x_large))
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple40
                ),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.large)),
            ) {
                Text(
                    modifier = Modifier.padding(
                            vertical = dimensionResource(id = R.dimen.x_small),
                            horizontal = dimensionResource(id = R.dimen.x_large)
                        ),
                    text = buttonText,
                    style = TextStyle(
                        fontSize = FontSize.FONT_14,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                )
            }
        }
    }

}