package com.muhammedhassaan.gallerytask.presentation.navgraph

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

private const val ALBUM_ID = "albumId"
private const val ALBUM_NAME = "albumName"
private const val PHOTO_URL = "photoUrl"

sealed class Screens(val route: String) {
    object Splash : Screens(route = "splash_screen")
    object Home : Screens(route = "home_screen")
    object Album : Screens(route = "album_screen/{$ALBUM_ID}/{$ALBUM_NAME}") {
        fun passAlbumIdAndName(albumId: String, albumName: String): String {
            return Album.route.replace(
                oldValue = "{$ALBUM_ID}/{$ALBUM_NAME}",
                newValue = "$albumId/$albumName"
            )
        }
    }

    object Photo : Screens(route = "photo_screen/{$PHOTO_URL}") {
        fun passPhotoUrl(photoUrl: String): String {
            val encodedUrl = URLEncoder.encode(photoUrl, StandardCharsets.UTF_8.toString())
            return Photo.route.replace(
                oldValue = "{$PHOTO_URL}",
                newValue = encodedUrl
            )
        }
    }
}
