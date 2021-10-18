package com.example.alertdialog

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val show = findViewById<Button>(R.id.btShow)
        show.setOnClickListener{
            showDialog( )
        }
    }


    private fun showDialog() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog)
        customDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val close = customDialog.findViewById(R.id.btClose) as ImageButton
        val tvBtn = customDialog.findViewById(R.id.btTV) as Button
        val goBtn = customDialog.findViewById(R.id.btGo) as Button
        var tvText =customDialog.findViewById(R.id.textMessage) as TextView
        var etText =customDialog.findViewById(R.id.etText) as TextView

        tvBtn.setOnClickListener {
            tvText.text = etText.text
            //customDialog.dismiss()
        }
        goBtn.setOnClickListener {
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("text", etText.text.toString())
            startActivity(intent)
            customDialog.dismiss()
        }
        close.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }

}