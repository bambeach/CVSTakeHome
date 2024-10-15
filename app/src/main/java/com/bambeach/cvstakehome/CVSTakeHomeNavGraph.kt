package com.bambeach.cvstakehome

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.bambeach.cvstakehome.model.Image
import com.bambeach.cvstakehome.ui.details.DetailsRoute
import com.bambeach.cvstakehome.ui.home.HomeRoute

@Composable
fun CVSTakeHomeNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = CVSTakeHomeDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = CVSTakeHomeDestinations.HOME_ROUTE,
        modifier = modifier
    ) {
        val navActions = CVSTakeHomeNavigationActions(navController)
        composable(route = CVSTakeHomeDestinations.HOME_ROUTE) {
            HomeRoute(
                onImageClick = { image ->
                    navController.navigate(route = image)
                },
                onBackClick = {}
            )
        }
        composable<Image> { backStackEntry ->
            val imageDetails: Image = backStackEntry.toRoute()
            DetailsRoute(
                image = imageDetails,
                onBackClick = navActions.navigateToHome
            )
        }
//        composable(route = CVSTAkeHomeDestinations.DETAIL_ROUTE) {
//            DetailRoute()
//        }
    }
}