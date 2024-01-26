package com.kuldeepsinghrai.krypto.presentation.common_components

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextIsActive(isActive:Boolean,modifier:Modifier=Modifier, style: TextStyle=  LocalTextStyle.current) {
    Text(
        text = if(isActive) "active" else "inactive",
        color = if(isActive) Color.Green else Color.Red,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.End,
        style=style,
        modifier = modifier
    )
}