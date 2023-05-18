package com.yolisstorm.sandbox.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yolisstorm.sandbox.ui.navigation.AlignYourBodyBottomNavigation
import com.yolisstorm.sandbox.ui.theme.SandboxTheme
import com.yolisstorm.sandbox.ui.views.HomeScreen

class AlignYourBodyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlignYourBodyScreen()
        }
    }
}

@Composable
private fun AlignYourBodyScreen() {
    SandboxTheme {
        Scaffold(
            bottomBar = { AlignYourBodyBottomNavigation() }
        ) { paddings ->
            HomeScreen(Modifier.padding(paddings))
        }
    }
}
