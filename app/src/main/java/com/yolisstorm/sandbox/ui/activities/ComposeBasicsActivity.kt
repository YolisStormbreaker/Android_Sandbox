package com.yolisstorm.sandbox.ui.activities

import android.content.res.Configuration.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yolisstorm.sandbox.R
import com.yolisstorm.sandbox.ui.theme.SandboxTheme
import kotlin.random.Random

class ComposeBasicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SandboxTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    SandboxTheme {
        OnboardingScreen {  }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun MyAppPreview() {
    SandboxTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen { shouldShowOnboarding = false }
        } else {
            Greetings()
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SandboxTheme {
        Greetings()
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<Int> = List(1000) { Random(it).nextInt(10, 76) }
) {
    LazyColumn(modifier = modifier.padding(4.dp)) {
        items(items = names) { name ->
            Greeting(name)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(
    name: Int = 1,
    modifier: Modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
) {
    Card (
        modifier = modifier,
    ) {
        CardContent(name)
    }
}

@Composable
fun CardContent(
    name: Int = 1,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var count by rememberSaveable { mutableStateOf(name) }

    Row(modifier = modifier
        .padding(24.dp)
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        )
    ) {
        Column(modifier = Modifier
            .weight(1f)
        ) {
            Text(text = stringResource(R.string.hello_ronya))
            Text(text = "${count.coerceAtLeast(0)}", style = MaterialTheme.typography.headlineMedium)
            if (expanded) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(
                        R.string.i_love_you_times,
                        count.coerceAtLeast(0)
                    ),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
        ElevatedButton(onClick = {
            expanded = !expanded
            if (expanded) count--
        }) {
            Text(if (expanded) {
                stringResource(R.string.show_less)
            } else {
                stringResource(R.string.show_more)
            }, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}