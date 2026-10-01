package com.sealion.entertainment

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    // Standard Android Package Names for the requested apps
    companion object {
        private const val PKG_NETFLIX = "com.netflix.mediaclient"
        private const val PKG_PRIME = "com.amazon.avod.thirdpartyclient"
        private const val PKG_YOUTUBE = "com.google.android.youtube"
        private const val PKG_CRUNCHYROLL = "com.crunchyroll.crunchyroid"
        private const val PKG_DISNEY = "com.disney.disneyplus"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Install Splash Screen before super.onCreate()
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<View>(R.id.main_layout)
        mainLayout.alpha = 0f
        mainLayout.animate()
            .alpha(1f)
            .setDuration(1200)
            .setStartDelay(200)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .start()

        // Hide system UI for full immersive mode (Kiosk feel)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        findViewById<View>(R.id.btn_netflix).setOnClickListener { launchApp(PKG_NETFLIX) }
        findViewById<View>(R.id.btn_prime).setOnClickListener { launchApp(PKG_PRIME) }
        findViewById<View>(R.id.btn_youtube).setOnClickListener { launchApp(PKG_YOUTUBE) }
        findViewById<View>(R.id.btn_crunchyroll).setOnClickListener { launchApp(PKG_CRUNCHYROLL) }
        findViewById<View>(R.id.btn_disney).setOnClickListener { launchApp(PKG_DISNEY) }
    }

    private fun launchApp(packageName: String) {
        val pm: PackageManager = packageManager
        val intent: Intent? = pm.getLaunchIntentForPackage(packageName)

        if (intent != null) {
            // App is installed, launch it
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } else {
            // App isn't installed on the tablet yet
            Toast.makeText(this, "App not installed on this tablet.", Toast.LENGTH_SHORT).show()
        }
    }
}