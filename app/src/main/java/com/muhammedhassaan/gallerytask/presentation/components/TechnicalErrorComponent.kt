package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.EndString
import com.muhammedhassaan.gallerytask.core.ViewUtils

@Composable
fun TechnicalErrorComponent(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ViewUtils.SomeThingWentWrongScreen(
        modifier = modifier,
        errorImage = R.drawable.ic_technical_error,
        errorTitle = EndString.UNEXPECTED_ERROR_TITLE,
        errorDescription = EndString.UNEXPECTED_ERROR_DESC,
        buttonText = stringResource(id = R.string.reload)
    ) {
        onClick.invoke()
    }
}