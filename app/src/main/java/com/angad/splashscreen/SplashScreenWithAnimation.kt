package com.angad.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.angad.splashscreen.databinding.ActivitySplashScreenWithAnimationBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenWithAnimation : AppCompatActivity() {

//    creating binding instance
    private lateinit var binding: ActivitySplashScreenWithAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised the binding
        binding = ActivitySplashScreenWithAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Using the Handler for jump to the Main Activity after 3 seconds automatically
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}