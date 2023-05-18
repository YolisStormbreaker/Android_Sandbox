package com.yolisstorm.sandbox.ui.views

import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.emoji2.emojipicker.EmojiPickerView

@Composable
internal fun EmojiPicker() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            EmojiPickerView(context).apply {
                emojiGridColumns = 8
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                setOnEmojiPickedListener { emoji ->
                    Toast.makeText(context, emoji.emoji, Toast.LENGTH_SHORT).show()
                }
            }
        },
        update = { view ->

        }
    )
}