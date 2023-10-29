package com.muhammedhassaan.gallerytask.presentation.navgraph

private const val ALBUM_ID = "albumId"
private const val PHOTO_URL = "photoUrl"

sealed class Screens(val route: String){
    object Splash: Screens(route = "splash_screen")
    object Home: Screens(route = "home_screen")
    object Album: Screens(route = "album_screen/${ALBUM_ID}"){
        fun passAlbumId(albumId: String): String {
            return Album.route.replace(
                oldValue = "{$ALBUM_ID}",
                newValue = albumId
            )
        }
    }
    object Photo: Screens(route = "photo_screen/${PHOTO_URL}"){
        fun passPhotoUrl(photoUrl: String): String {
            return Photo.route.replace(
                oldValue = "{$PHOTO_URL}",
                newValue = photoUrl
            )
        }
    }
}
