package com.example.aidlclient


import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.aidlclient.databinding.ActivityMainBinding
import com.example.aidlimplementation.IAIDLColorInterface


class MainActivity : AppCompatActivity() {

    private var colorService: IAIDLColorInterface? = null
    private var bound: Boolean = false
    private lateinit var mainLayout: ConstraintLayout
    private lateinit var changeColorButton: Button

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            colorService = IAIDLColorInterface.Stub.asInterface(service)
            bound = true
            Toast.makeText(this@MainActivity, "Service Connected", Toast.LENGTH_SHORT).show()
        }

        override fun onServiceDisconnected(className: ComponentName) {
            colorService = null
            bound = false

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.main)
        changeColorButton = findViewById(R.id.button)

        changeColorButton.setOnClickListener {
            if (bound) {
                try {
                    val color = colorService?.getColor() ?: return@setOnClickListener
                    Log.d("Test",color.toString())
                    mainLayout.setBackgroundColor(color)
                } catch (e: Exception) {
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Intent("com.example.aidlserver.COLOR_SERVICE").also { intent ->
            intent.setPackage("com.example.aidlserver")
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        if (bound) {
            unbindService(connection)
            bound = false
        }
    }

//    private var aidlColorInterface: IAIDLColorInterface? = null // Nullable to handle disconnection
//    private lateinit var binding: ActivityMainBinding
//
//    // Service connection
//    private val mConnection: ServiceConnection = object : ServiceConnection {
//        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//            aidlColorInterface = IAIDLColorInterface.Stub.asInterface(service)
//            Toast.makeText(this@MainActivity, "Service Connected", Toast.LENGTH_SHORT).show()
//        }
//
//        override fun onServiceDisconnected(name: ComponentName?) {
//            aidlColorInterface = null
//            Toast.makeText(this@MainActivity, "Service Disconnected", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        //  Initialize binding before using it
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        //  Bind to the AIDL service
//        val serviceIntent = Intent().apply {
//            action = "AIDLColorService"
//            setPackage("com.example.aidlimplementation")
//        }
//        startService(serviceIntent)
//
//
//        val isBound = bindService(intent, mConnection, BIND_AUTO_CREATE)
//
//        if (!isBound) {
//            Log.e("AIDLClient", "Failed to bind to the service!");
//        } else {
//            Log.d("AIDLClient", "Service binding initiated successfully.");
//        }
//
//
//        binding.button.setOnClickListener {
//            if (aidlColorInterface != null) {
//                val color = aidlColorInterface!!.color
//                binding.main.setBackgroundColor(color)
//            } else {
//                Toast.makeText(this, "Service not connected yet", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        unbindService(mConnection)
//    }
}