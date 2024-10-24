package com.angad.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angad.splashscreen.databinding.ActivitySplashScreenWithLoadingBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenWithLoading : AppCompatActivity() {

//    creating instance of binding class
    private lateinit var binding: ActivitySplashScreenWithLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised the binding class
        binding = ActivitySplashScreenWithLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startHeavyTask()
    }

    private fun startHeavyTask() {
        LongOperation().execute()
    }

//    creating a inner class
    @SuppressLint("StaticFieldLeak")
    private open inner class LongOperation: AsyncTask<String?, Void?, String?>(){
        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg p0: String?): String? {
             for(i in 0..6){
                 try {
                     Thread.sleep(1000)
                 }
                 catch (e: Exception){
                     Thread.interrupted()
                 }
             }
            return "result"
        }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        startActivity(Intent(this@SplashScreenWithLoading, MainActivity::class.java))
    }

    }
}