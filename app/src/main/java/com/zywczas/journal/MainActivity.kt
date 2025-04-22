package com.zywczas.journal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.zywczas.commoncompose.theme.Theme
import com.zywczas.featurevideorecords.ui.VideoRecordsScreen
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinAndroidContext {
                Theme.App {
                    VideoRecordsScreen()
                }
            }
        }
    }
}
