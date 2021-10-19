package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)


        val etText1=findViewById<EditText>(R.id.etFirst)
        val etText2=findViewById<EditText>(R.id.etSecond)

        val btSharedPreference=findViewById<Button>(R.id.btSHPFS)
        val btIntent=findViewById<Button>(R.id.btIntent)

        btSharedPreference.setOnClickListener{
            setText("text","From shared preferences:\n ${etText1.text} \n ${etText2.text} ")
        }
        btIntent.setOnClickListener{
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("text","From Intent: \n ${etText1.text} \n ${etText2.text} ")
            startActivity(intent)
        }
    }


    fun setText(key: String,text:String) {
        with(sharedPreferences.edit()) {
            putString(key, text)
            apply()
        }
    }
}