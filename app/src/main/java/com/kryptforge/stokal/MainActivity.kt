package com.kryptforge.stokal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kryptforge.stokal.ui.screen.HomeScreen
import com.kryptforge.stokal.ui.theme.StokalTheme
import com.kryptforge.stokal.ui.viewmodel.ActionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enables edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            StokalTheme {
                Screen()
            }
        }
    }
}

@Composable
private fun Screen(actionViewModel: ActionViewModel = viewModel()) {
    HomeScreen(actionViewModel)
}
