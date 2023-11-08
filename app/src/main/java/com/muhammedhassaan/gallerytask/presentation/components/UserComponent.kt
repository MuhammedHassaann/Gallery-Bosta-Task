package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.FontSize
import com.muhammedhassaan.gallerytask.core.ViewUtils.shimmerBackground
import com.muhammedhassaan.gallerytask.domain.model.User
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors

@Composable
fun UserComponent(
    modifier: Modifier = Modifier,
    user: User
) {
    Row(
        modifier = modifier
            .padding(vertical = dimensionResource(id = R.dimen.medium))
            .fillMaxWidth()
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(dimensionResource(id = R.dimen.profile_img)),
            painter = painterResource(
                id = if (isSystemInDarkTheme()) R.drawable.ic_user_dark
                else R.drawable.ic_user_light
            ),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.medium))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = user.name,
                fontSize = FontSize.FONT_16,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.ThemeColors.black
            )


            Text(
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.x_small)),
                text = user.address,
                fontSize = FontSize.FONT_12,
                color = MaterialTheme.ThemeColors.darkGray
            )

        }
    }
}

@Composable
fun UserShimmerComponent(){
    Row(
        modifier = Modifier
            .padding(vertical = dimensionResource(id = R.dimen.medium))
            .fillMaxWidth()
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.profile_img))
                .shimmerBackground()
        )
        Column(
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.medium))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.small))
                    .fillMaxWidth(0.4f)
                    .shimmerBackground()
            )

            Box(
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.small))
                    .height(dimensionResource(id = R.dimen.small))
                    .fillMaxWidth(0.85f)
                    .shimmerBackground()
            )
        }
    }
}