package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("LifeCycle","onCreate(): MainActivity ")
        findViewById<Button>(R.id.button).setOnClickListener{
            val intent: Intent = Intent(
                this@MainActivity,
                Activity1::class.java
            )
            startActivity(intent)
        }
    }


    override fun onStart() {
        Log.d("LifeCycle","onStart(): MainActivity ")
        super.onStart()
    }

    override fun onResume() {
        Log.d("LifeCycle","onResume(): MainActivity ")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifeCycle","onPause(): MainActivity ")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("LifeCycle","onRestart(): MainActivity ")
        super.onRestart()
    }

    override fun onStop() {
        Log.d("LifeCycle","onStop(): MainActivity ")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("LifeCycle","onDestroy(): MainActivity ")
        super.onDestroy()
    }

}