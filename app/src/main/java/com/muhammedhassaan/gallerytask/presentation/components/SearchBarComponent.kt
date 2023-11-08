package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.ImeAction
import com.muhammedhassaan.gallerytask.R
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    readOnly: Boolean = false,
    isEnabled: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    onSearchAction: () -> Unit = {},
    onSearchBarAction: () -> Unit = {},
    backgroundColor: Color = MaterialTheme.ThemeColors.white
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    var searchText by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier
            .clip(shape = CircleShape)
            .clickable {
                onSearchBarAction()
            },
        placeholder = {
            Text(
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.medium)),
                text = placeholderText,
                color = MaterialTheme.ThemeColors.darkGray
            )
        },
        value = searchText,
        onValueChange = {
            searchText = it
            onSearchTextChanged(it)
        },
        readOnly = readOnly,
        enabled = isEnabled,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent,
            focusedTextColor = MaterialTheme.ThemeColors.black,
            unfocusedTextColor = MaterialTheme.ThemeColors.darkGray,
            cursorColor = MaterialTheme.colorScheme.primary,
            disabledTextColor = MaterialTheme.ThemeColors.black,
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor
        ),
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Companion.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
                onSearchAction.invoke()
            }
        )
    )
}