package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("LifeCycle","onCreate(): Activity2 ")

        findViewById<Button>(R.id.button4).setOnClickListener{
            val intent: Intent = Intent(
                this@Activity2,
                Activity1::class.java
            )
            startActivity(intent)
        }

        findViewById<Button>(R.id.button5).setOnClickListener{
            val intent: Intent = Intent(
                this@Activity2,
                Activity2::class.java
            )
            startActivity(intent)
        }
        findViewById<Button>(R.id.button6).setOnClickListener{
            val intent: Intent = Intent(
                this@Activity2,
                MainActivity::class.java
            )
            startActivity(intent)
        }


    }

    override fun onStart() {
        Log.d("LifeCycle","onStart(): Activity2 ")
        super.onStart()
    }

    override fun onResume() {
        Log.d("LifeCycle","onResume(): Activity2 ")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifeCycle","onPause(): Activity2 ")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("LifeCycle","onRestart(): Activity2 ")
        super.onRestart()
    }

    override fun onStop() {
        Log.d("LifeCycle","onStop(): Activity2 ")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("LifeCycle","onDestroy(): Activity2 ")
        super.onDestroy()
    }
}