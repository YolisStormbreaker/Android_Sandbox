package com.yolisstorm.sandbox.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yolisstorm.sandbox.data.WellnessTasksList
import com.yolisstorm.sandbox.data.WellnessViewModel
import com.yolisstorm.sandbox.data.models.WellnessTask
import com.yolisstorm.sandbox.ui.activities.ui.theme.SandboxTheme
import com.yolisstorm.sandbox.ui.views.StatefulCounter
import com.yolisstorm.sandbox.ui.views.WaterCounter

class WaterCounterActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SandboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}



@Composable
fun WellnessScreen(
    wellnessViewModel: WellnessViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedChanged = { task, isChecked ->
                wellnessViewModel.changeTaskChecked(task, isChecked)
            },
            onCloseClicked = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}