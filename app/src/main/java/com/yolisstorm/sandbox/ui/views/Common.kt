package com.yolisstorm.sandbox.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yolisstorm.sandbox.ui.activities.Greeting
import com.yolisstorm.sandbox.ui.theme.SandboxTheme



@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    SandboxTheme {
        Greeting()
    }
}