package com.example.flightbooking.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val title: String,
                   val selectedIcon: ImageVector,
                   val unselectedIcon: ImageVector,
                   val badgeCount: Int? = null,
                   val route: String = "")

val listOfNavItems : List<NavItem> = listOf(
    NavItem(
        title = "Explore",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
//        route = Screens.ExploreScreen.name
    ),
    NavItem(
        title = "Dashboard",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
//        route = Screens.DashboardScreen.name
    ),
    NavItem(
        title = "Wishlist",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.Favorite,
//        route = Screens.WishlistScreen.name
    ),
//    NavItem(
//        title = "Profile",
//        selectedIcon = Icons.Filled.AccountCircle,
//        unselectedIcon = Icons.Outlined.AccountCircle,
//        route = Screens.ProfileScreen.name
//    )
)
