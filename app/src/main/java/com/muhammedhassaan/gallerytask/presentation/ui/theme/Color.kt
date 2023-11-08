package com.muhammedhassaan.gallerytask.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val lightThemeSplashColor = Color(0xFF3b8d99)
val shimmer = Color(0xFFE4E3E2)

object MyColors{
    val localColorsPalette = staticCompositionLocalOf<MyThemeColors> {
        error("No palette provided")
    }

    private val white = Color(0xFFFFFFFF)
    private val whiteDark = Color(0x0DFFFFFF)

    private val blackSolid = Color(0xFF000000)
    private val blackSolidDark = Color(0xFF000000)

    private val whiteSolid = Color(0xFFFFFFFF)
    private val whiteSolidDark = Color(0xFFFFFFFF)

    private val black = Color(0xFF000000)
    private val blackDark = Color(0xFFFFFFFF)

    private val darkGray = Color(0xFF4B5563)
    private val darkGrayDark = Color(0xFFCCCCCC)

    private val purple = Color(0xFF9164CC)
    private val purpleDark = Color(0xFF9164CC)


    val lightModePalette = MyThemeColors(
        white = white,
        whiteSolid = whiteSolid,
        black = black,
        blackSolid = blackSolid,
        darkGray = darkGray,
        purple = purple
    )

    val darkModePalette = MyThemeColors(
        white = whiteDark,
        whiteSolid = whiteSolidDark,
        black = blackDark,
        blackSolid = blackSolidDark,
        darkGray = darkGrayDark,
        purple = purpleDark
    )
}

data class MyThemeColors(
    val white: Color,
    val whiteSolid: Color,
    val black: Color,
    val blackSolid: Color,
    val darkGray: Color,
    val purple: Color,
)

val MaterialTheme.ThemeColors: MyThemeColors
@Composable
@ReadOnlyComposable
get() = MyColors.localColorsPalette.current
