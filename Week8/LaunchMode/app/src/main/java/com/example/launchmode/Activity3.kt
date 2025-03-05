package com.example.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("Launch Mode", "onCreate(): Single Task Launch Mode Class : Activity 3")


        val textView = findViewById<TextView>(R.id.textView3)
        val textView5 = findViewById<TextView>(R.id.textView11)
        val textView6 = findViewById<TextView>(R.id.textView12)
        val textView7 = findViewById<TextView>(R.id.textView13)

        textView.setOnClickListener {
            val intent1 = Intent(
                this@Activity3,
                Activity1::class.java
            ) // Single Top Launch Mode Class
            startActivity(intent1)
        }

        textView5.setOnClickListener {
            val intent2 = Intent(
                this@Activity3,
                Activity2::class.java
            ) // Single Top Launch Mode Class
            intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent2)
        }

        textView6.setOnClickListener {
            val intent3 = Intent(
                this@Activity3,
                Activity3::class.java
            ) // SingleTask Launch Mode Class
            intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent3)
        }

        textView7.setOnClickListener {
            val intent4 = Intent(
                this@Activity3,
                Activity4::class.java
            ) // Single Instance Launch Mode Class
            startActivity(intent4)
        }
    }

    override fun onResume() {
        Log.d("Launch Mode", "onResume(): Single Task Launch Mode Class : Activity 3")
        super.onResume()
    }
}