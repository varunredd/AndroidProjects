package com.example.aidlimplementation

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlin.random.Random

class AIDLColorService : Service() {

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    private val binder = object : IAIDLColorInterface.Stub() {
        override fun getColor(): Int {
            val red = Random.nextInt(0, 256)
            val green = Random.nextInt(0, 256)
            val blue = Random.nextInt(0, 256)

            return (0xFF shl 24) or (red shl 16) or (green shl 8) or blue
        }
    }
}
