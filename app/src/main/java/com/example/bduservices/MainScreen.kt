package com.example.bduservices

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun MainScreen(context: Context) {
    val navController = rememberNavController()
    var currentScreenTitle by remember { mutableStateOf("BDU Services") }

    Scaffold(
        topBar = {
            AppBarView(
                title = currentScreenTitle,
                showBackButton = navController.previousBackStackEntry != null,
                onBackNavClicked = { navController.popBackStack() }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                selectedTab = getSelectedTab(navController),
                onTabSelected = { tabIndex ->
                    val destination = when (tabIndex) {
                        0 -> "home"
                        1 -> "categories"
                        2 -> "favorites"
                        3 -> "about"
                        else -> "home"
                    }
                    navController.navigate(destination) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    currentScreenTitle = "BDU Services"
                    HomeScreen(onExploreClick = { navController.navigate("categories") })
                }

                composable("categories") {
                    currentScreenTitle = "Categories"
                    CategoryListScreen(
                        onCategorySelected = { categoryId ->
                            // Pass ID instead of name
                            navController.navigate("categories/$categoryId")
                        }
                    )
                }

                composable(
                    "categories/{categoryId}",  // Changed to ID
                    arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: -1
                    val category = ServiceData.categories.find { it.id == categoryId }

                    currentScreenTitle = category?.name ?: "Category Not Found"
                    CategoryServicesScreen(
                        categoryId = categoryId,  // Pass ID instead of name
                        onServiceSelected = { serviceName ->
                            navController.navigate("serviceDetails/$serviceName")
                        }
                    )
                }

                composable("favorites") {
                    currentScreenTitle = "Favorites"
                    val favoritesViewModel: FavoritesViewModel = viewModel(
                        factory = FavoritesViewModelFactory(context)
                    )
                    FavoritesScreen(favoritesViewModel)
                }

                composable("about") {
                    currentScreenTitle = "About"
                    AboutScreen()
                }

                composable("serviceDetails/{serviceName}") { backStackEntry ->
                    val serviceName = backStackEntry.arguments?.getString("serviceName") ?: ""
                    currentScreenTitle = serviceName
                    ServiceDetailsScreen(serviceName = serviceName)
                }
            }
        }
    }
}

fun getSelectedTab(navController: NavController): Int {
    val baseRoute = navController.currentDestination?.route?.substringBefore("/")
    return when (baseRoute) {
        "home" -> 0
        "categories" -> 1
        "favorites" -> 2
        "about" -> 3
        else -> 0
    }
}