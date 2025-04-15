package com.example.mikocompany

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mikocompany.screens.Acceptance
import com.example.mikocompany.screens.AcceptanceAdd
import com.example.mikocompany.screens.ApplicationInfo
import com.example.mikocompany.screens.Authorization
import com.example.mikocompany.screens.Category
import com.example.mikocompany.screens.CategoryAdd
import com.example.mikocompany.screens.CategoryInfo
import com.example.mikocompany.screens.Employees
import com.example.mikocompany.screens.Filling
import com.example.mikocompany.screens.Offer
import com.example.mikocompany.screens.Order
import com.example.mikocompany.screens.Profile
import com.example.mikocompany.screens.Registration
import com.example.mikocompany.screens.Start
import com.example.mikocompany.screens.Statistic
import com.example.mikocompany.screens.Warehouse
import com.example.mikocompany.ui.theme.MikoCompanyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MikoCompanyTheme {

                val navController = rememberNavController()
                val start = remember{ mutableStateOf(false) }
                val profile = remember{ mutableStateOf(false) }
                val warehouse = remember{ mutableStateOf(false) }
                val acceptance = remember{ mutableStateOf(false) }
                val category = remember{ mutableStateOf(false) }
                val offer = remember{ mutableStateOf(false) }
                val order = remember{ mutableStateOf(false) }
                val statistic = remember{ mutableStateOf(false) }
                val authorization = remember{ mutableStateOf(false) }
                val registration = remember{ mutableStateOf(false) }
                val applicationInfo = remember{ mutableStateOf(false) }
                val filling = remember{ mutableStateOf(false) }
                val acceptanceAdd = remember{ mutableStateOf(false) }
                val employees = remember{ mutableStateOf(false) }
                val categoryAdd = remember { mutableStateOf(false) }
                val categoryInfo = remember { mutableStateOf(false) }

                NavHost(
                    navController = navController,
                    startDestination = "start"
                ){
                    composable("start") {
                        Start(
                            navController,
                            start = start
                        )
                    }
                    composable("profile") {
                        Profile(
                            navController,
                            profile = profile
                        )
                    }
                    composable("warehouse") {
                        Warehouse(
                            navController,
                            warehouse = warehouse
                        )
                    }
                    composable("acceptance") {
                        Acceptance(
                            navController,
                            acceptance = acceptance
                        )
                    }
                    composable("category") {
                        Category(
                            navController,
                            category = category
                        )
                    }
                    composable("offer"){
                        Offer(
                            navController,
                            offer = offer
                        )
                    }
                    composable("order") {
                        Order(
                            navController,
                            order = order
                        )
                    }
                    composable("statistic") {
                        Statistic(
                            navController,
                            statistic = statistic
                        )
                    }
                    composable("authorization") {
                        Authorization(
                            navController,
                            authorization = authorization
                        )
                    }
                    composable("registration") {
                        Registration(
                            navController,
                            registration = registration
                        )
                    }
                    composable("applicationInfo") {
                        ApplicationInfo(
                            navController,
                            applicationInfo = applicationInfo
                        )
                    }
                    composable("filling") {
                        Filling(
                            navController,
                            filling = filling
                        )
                    }
                    composable("acceptanceAdd") {
                        AcceptanceAdd(
                            navController,
                            acceptanceAdd = acceptanceAdd
                        )
                    }
                    composable("employees") {
                        Employees(
                            navController,
                            employees = employees
                        )
                    }
                    composable("categoryAdd") {
                        CategoryAdd(
                            navController,
                            categoryAdd = categoryAdd
                        )
                    }
                    composable("categoryInfo") {
                        CategoryInfo(
                            navController,
                            categoryInfo = categoryInfo
                        )
                    }
                }
            }
        }
    }
}
