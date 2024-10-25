package com.angad.splashscreen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.angad.splashscreen.databinding.ActivityMainBinding
import com.emreesen.sntoast.SnToast
import com.emreesen.sntoast.Type
import com.shashank.sony.fancytoastlib.FancyToast


class MainActivity : AppCompatActivity() {

    //    Creating binding instance
    private lateinit var binding: ActivityMainBinding

    //    Creating object of CustomMenu class
    private val customMenu = CustomMenu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised binding class
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        On click default toast button
        onCLickCustomToast()

//        On click custom toast button
        onClickFancyButtonToast()

//        On click menu demo button
        onClickMenuDemoButton()

//        On click show dialog button to display dialog
        onClickShowDialogButton()

//        On click custom dialog button to display custom dialog
        onClickCustomButtonDialog()

    }

    private fun onClickCustomButtonDialog() {
        binding.customDialogBtn.setOnClickListener {
            //   Dialog of type Success
            SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good Job")
                .setContentText("You clicked the Custom Button")
                .show()

            //   Dialog of type Failure
//            SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
//                .setTitleText("Bad Job")
//                .setContentText("You clicked the Custom Button")
//                .show()

            //   Dialog of type progress
//            SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
//                .setTitleText("Loading")
////                .setContentText("You clicked the Custom Button")
//                .show()

            //  Rest of the dialog type and properties we can show from sweet alert android github page.
        }
    }

    //    Implementing the alert dialog box in android
//    For dialog box
    private fun onClickShowDialogButton() {
        binding.alertBtn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog
                .setTitle("Delete Files")
                .setMessage(R.string.description)
                .setIcon(R.drawable.ic_delete)
                .setPositiveButton("Yes") { _, _ ->
                    FancyToast.makeText(
                        this,
                        "This file has been deleted",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    ).show()
                }
                .setNegativeButton("No") { _, _ ->
                    FancyToast.makeText(
                        this,
                        "This file has not been deleted",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    ).show()
                }
                .setNeutralButton("Cancel"){ _, _ ->
                    return@setNeutralButton
                }

            val alertDialog = dialog.create()
                alertDialog.setCancelable(false)
                alertDialog.show()

        }
    }

    //    For menu
    private fun onClickMenuDemoButton() {
        binding.menuBtn.setOnClickListener {
            customMenu.showMenu(this, it)
        }
    }

    private fun onClickFancyButtonToast() {
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

    private fun onCLickCustomToast() {
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