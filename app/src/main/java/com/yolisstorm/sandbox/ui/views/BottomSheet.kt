package com.yolisstorm.sandbox.ui.views

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yolisstorm.sandbox.ui.activities.Greeting
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun BottomSheet(
    sheetContent: @Composable ColumnScope.() -> Unit
) {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessMediumLow
        )
    )
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = { sheetContent() },
        sheetShape = RoundedCornerShape(10.dp),
        sheetElevation = 10.dp,
        sheetPeekHeight = 0.dp
    ) { PageContent(sheetState) }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun PageContent(sheetState: BottomSheetState) {
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Greeting()
        Button(onClick = {
            coroutineScope.launch {
                if (sheetState.isCollapsed)
                    sheetState.expand()
                else
                    sheetState.collapse()
            }
        }) {
            Text(text = "Open Picker")
        }
    }
}
