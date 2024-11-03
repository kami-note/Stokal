package com.kryptforge.stokal

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kryptforge.stokal.ui.screen.HomeScreen
import com.kryptforge.stokal.ui.screen.LabelScreen
import com.kryptforge.stokal.ui.screen.LotTypeScreen
import com.kryptforge.stokal.ui.viewmodel.ActionViewModel
import com.kryptforge.stokal.ui.viewmodel.LabelViewModel
import com.kryptforge.stokal.ui.viewmodel.LotTypeViewModel

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController(), startDestination: String = "home") {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = "home") {
            val actionViewModel: ActionViewModel = viewModel()
            HomeScreen(actionViewModel, navController)
        }
        composable(route = "labelscreen") {
            val labelViewModel: LabelViewModel = viewModel()
            LabelScreen(viewModel = labelViewModel)
        }

        composable(route = "lottypescreen") {
            val lotTypeViewModel: LotTypeViewModel = viewModel()
            LotTypeScreen(viewModel = lotTypeViewModel)
        }

        composable(route = "details") {
            DetailsScreen()
        }
    }
}

@Composable
fun DetailsScreen() {
    Text("Detalhes da Tela")
}
