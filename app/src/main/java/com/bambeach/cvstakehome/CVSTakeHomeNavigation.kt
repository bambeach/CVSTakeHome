package com.bambeach.cvstakehome

import androidx.navigation.NavHostController

object CVSTakeHomeDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
}

class CVSTakeHomeNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(CVSTakeHomeDestinations.HOME_ROUTE) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToDetail: () -> Unit = {
        navController.navigate(CVSTakeHomeDestinations.DETAIL_ROUTE) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}