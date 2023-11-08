package com.muhammedhassaan.gallerytask.presentation.screens.photo

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    val photoUrl: String? = savedStateHandle["photoUrl"]

    fun shareImage(context: Context, imageFile: File) {
        val uri = FileProvider.getUriForFile(
            context,
            "com.muhammedhassaan.gallerytask.provider",
            imageFile
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)

        val chooser = Intent.createChooser(shareIntent, "Share Image")
        context.startActivity(chooser)
    }


}