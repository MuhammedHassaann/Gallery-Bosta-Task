package com.muhammedhassaan.gallerytask.presentation.screens.splash


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.presentation.ui.theme.lightThemeSplashColor
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(onFinish: ()->Unit){
    LaunchedEffect(key1 = true){
        delay(3000)
        onFinish()
    }
    Splash()
}

@Composable
fun Splash(){
    val logoComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.splash_anim)
    )
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else lightThemeSplashColor)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LottieAnimation(
            modifier = Modifier.size(dimensionResource(id = R.dimen.logo)),
            composition = logoComposition
        )
    }
}

@Preview
@Composable
fun PreviewSplashScreen(){
    AnimatedSplashScreen(){

    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewSplashScreenDark(){
    AnimatedSplashScreen(){

    }
}