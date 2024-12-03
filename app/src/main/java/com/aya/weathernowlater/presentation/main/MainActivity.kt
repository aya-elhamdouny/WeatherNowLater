package com.aya.weathernowlater.presentation.main

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aya.weathernowlater.presentation.weather.WeatherScreen
import com.aya.weathernowlater.presentation.weather.WeatherViewModel
import com.aya.weathernowlater.ui.theme.WeatherNowLaterTheme
import com.aya.weathernowlater.util.openAppSettings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val permissionsToRequest = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WeatherNowLaterTheme { WeatherScreen() }
        }

//        setContent {
//
//            WeatherNowLaterTheme {
//                val viewModel = viewModel<MainViewModel>()
//                val dialogQueue = viewModel.visiblePermissionDialogQueue
//
//                val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
//                    contract = ActivityResultContracts.RequestMultiplePermissions(),
//                    onResult = { perms ->
//                        permissionsToRequest.forEach { permission ->
//                            viewModel.onPermissionResult(
//                                permission = permission,
//                                isGranted = perms[permission] == true
//                            )
//                        }
//                    }
//                )
//
//
////
////                dialogQueue
////                    .reversed()
////                    .forEach { permission ->
////                        PermissionDialog(
////                            permissionTextProvider = when (permission) {
////                                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION -> {
////                                    LocationPermissionTextProvider()
////                                }
////                                else -> return@forEach
////                            },
////                            isPermanentlyDeclined = !shouldShowRequestPermissionRationale(
////                                permission
////                            ),
////                            onDismiss = viewModel::dismissDialog,
////                            onOkClick = {
////                                viewModel.dismissDialog()
////                                multiplePermissionResultLauncher.launch(
////                                    arrayOf(permission)
////                                )
////                            },
////                            onGoToAppSettingsClick = {this.openAppSettings()}
////                        )
////                    }
//
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//
//                    Greeting("Android")
//                }
////                multiplePermissionResultLauncher.launch(permissionsToRequest)
//
//            }
//        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    val weatherViewModel: WeatherViewModel = hiltViewModel()
    Log.d("AYAA", weatherViewModel.toString())
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherNowLaterTheme {
        Greeting("Android")
    }
}