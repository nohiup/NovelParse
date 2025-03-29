package com.example.novelparse.presentation.authenticate.partial

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.novelparse.ui.theme.SepiaLight
import com.example.novelparse.ui.theme.SepiaPrimary

fun Modifier.textFieldModifier(): Modifier{
    return this
        .fillMaxWidth()
        .border(1.dp, SepiaPrimary, shape = RoundedCornerShape(10.dp))
        .background(Color.Transparent)
        .clip(RoundedCornerShape(10.dp))
}

@Composable
fun TextFieldColors() = TextFieldDefaults.colors(
    unfocusedIndicatorColor = Color.Transparent, // Ẩn underline khi chưa focus
    focusedIndicatorColor = Color.Transparent,
)

