package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.FontSize
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors

@Composable
fun NotFoundComponent(
    modifier: Modifier = Modifier,
    body: String,
    isUnderlineBody: Boolean = false,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_not_found),
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.xx_small),
                    start = dimensionResource(id = R.dimen.large),
                    end = dimensionResource(id = R.dimen.large)
                )
                .clickable {
                    onClick.invoke()
                },
            text = body,
            textAlign = TextAlign.Center,
            fontSize = FontSize.FONT_14,
            color = MaterialTheme.ThemeColors.black,
            textDecoration = if (isUnderlineBody) TextDecoration.Underline else TextDecoration.None
        )
    }
}