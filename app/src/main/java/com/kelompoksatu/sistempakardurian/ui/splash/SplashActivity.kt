package com.kelompoksatu.sistempakardurian.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.kelompoksatu.sistempakardurian.R
import com.kelompoksatu.sistempakardurian.ui.onboarding.OnBoardingScreen

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
    fun toOnBoardingScreen(v: View?) {
        Intent(this@SplashActivity, OnBoardingScreen::class.java).also {
            startActivity(it)
            finish()
        }
    }

}