package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("LifeCycle","onCreate(): Activity1 ")
        findViewById<Button>(R.id.button2).setOnClickListener{
            val intent: Intent = Intent(
                this@Activity1,
                Activity1::class.java
            )
            startActivity(intent)
        }

        findViewById<Button>(R.id.button3).setOnClickListener{
            val intent: Intent = Intent(
                this@Activity1,
                Activity2::class.java
            )
            startActivity(intent)
        }
    }



    override fun onStart() {
        Log.d("LifeCycle","onStart(): Activity1 ")
        super.onStart()
    }

    override fun onResume() {
        Log.d("LifeCycle","onResume(): Activity1 ")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifeCycle","onPause(): Activity1 ")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("LifeCycle","onRestart(): Activity1 ")
        super.onRestart()
    }

    override fun onStop() {
        Log.d("LifeCycle","onStop(): Activity1 ")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("LifeCycle","onDestroy(): Activity1 ")
        super.onDestroy()
    }
}