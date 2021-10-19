package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val tvText=findViewById<TextView>(R.id.tv2Activity)
        //from intent
        tvText.text= intent.getStringExtra("text")
        val button=findViewById<Button>(R.id.bt2Activity)

        button.setOnClickListener{
            //from sharedpreference
            tvText.text=getText("text")
        }

    }
    fun getText(key: String): String? {
        val text = sharedPreferences.getString(key, "")
        return text
    }
}