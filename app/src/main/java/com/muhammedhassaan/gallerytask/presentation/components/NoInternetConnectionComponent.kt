package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.core.EndString
import com.muhammedhassaan.gallerytask.core.ViewUtils

@Composable
fun NoInternetConnectionComponent(onClick: () -> Unit) {
    ViewUtils.SomeThingWentWrongScreen(
        errorImage = R.drawable.ic_no_internet,
        errorTitle = EndString.INTERNET_CONNECTION_UNSTABLE,
        errorDescription = EndString.CHECK_YOUR_INTERNET,
        buttonText = stringResource(id = R.string.retry)
    ) {
        onClick.invoke()
    }
}