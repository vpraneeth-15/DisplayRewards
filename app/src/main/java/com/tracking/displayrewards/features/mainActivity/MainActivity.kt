package com.tracking.displayrewards.features.mainActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tracking.displayrewards.features.rewards.compose.RewardsContent
import com.tracking.displayrewards.services.location.LocationManager
import com.tracking.displayrewards.ui.theme.DisplayRewardsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var locationManager: LocationManager

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayRewardsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    RewardsContent()
                }
            }
        }
    }
}
