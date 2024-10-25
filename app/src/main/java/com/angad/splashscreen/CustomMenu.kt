package com.angad.splashscreen

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast

class CustomMenu {

    @SuppressLint("DiscouragedPrivateApi")
    fun showMenu(context: Context, view: View){
        val pop = PopupMenu(context, view)
        pop.inflate(R.menu.menu_items)

        pop.setOnMenuItemClickListener {
            when(it!!.itemId){
                R.id.edits -> {
                    Toast.makeText(context, "Edit clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.delete -> {
                    Toast.makeText(context, "Delete Item Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.share -> {
                    Toast.makeText(context, "Share Item Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        try {
            val fieldMpopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMpopup.isAccessible = true
            val mPopup = fieldMpopup.get(pop)
            mPopup.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(mPopup, true)
        }catch (e: Exception){
            Toast.makeText(context, "Exception: ${e.message}", Toast.LENGTH_LONG).show()
        }

        finally {
            pop.show()
        }
    }
}