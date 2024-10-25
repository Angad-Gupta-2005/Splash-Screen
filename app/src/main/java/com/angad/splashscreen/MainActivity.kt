package com.angad.splashscreen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.angad.splashscreen.databinding.ActivityMainBinding
import com.emreesen.sntoast.SnToast
import com.emreesen.sntoast.Type
import com.shashank.sony.fancytoastlib.FancyToast


class MainActivity : AppCompatActivity() {

    //    Creating binding instance
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised binding class
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        On click default toast button
        onClickDefaultToast()

//        On click custom toast button
        onCLickCustomButtonToast()

    }

    private fun onCLickCustomButtonToast() {
        binding.customT.setOnClickListener {
            FancyToast.makeText(
                this,
                "This is a fancy toast",
                FancyToast.LENGTH_SHORT,
                FancyToast.SUCCESS,
                false
            ).show()
        }
    }

    private fun onClickDefaultToast() {
        binding.defaultT.setOnClickListener {
//            Toast.makeText(this, "This is a default toast", Toast.LENGTH_SHORT).show()
            SnToast.Builder()
                .context(this@MainActivity)
                .type(Type.INFORMATION)
                // .textColor(R.color.Your_color) default is white
                .message("I am a custom toast !") //.cancelable(false or true) Optional Default: False
                // .iconSize(int size) Optional Default: 34dp
                // .textSize(int size) Optional Default 18sp
                // .animation(false or true) Optional Default: True
                 .duration(2000)
                // .backgroundColor(R.color.example) Default: It is filled according to the toast type. If an assignment is made, the assigned value is used
                // .icon(R.drawable.example) Default: It is filled according to the toast type. If an assignment is made, the assigned value is used
                .build()
        }
    }
}