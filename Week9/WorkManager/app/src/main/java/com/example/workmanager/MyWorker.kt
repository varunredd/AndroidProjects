package com.example.workmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParameter: WorkerParameters) : Worker(context, workerParameter){
    companion object{
        const val CHANNEL_ID = "channel_id"
        const val NOTIFICATION = 1
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {
        Log.d("Notification Manager","Success")
        showNotification()
        return Result.success()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNotification(){
        val intent = Intent(applicationContext, MainActivity :: class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(applicationContext,0,intent,PendingIntent.FLAG_IMMUTABLE)

        val notification = Notification.Builder(applicationContext, CHANNEL_ID)
                                       .setSmallIcon(R.drawable.ic_launcher_foreground)
                                       .setContentTitle("New Task")
                                       .setContentText("Created A New Task")
                                       .setAutoCancel(true)
                                       .setContentIntent(pendingIntent)

        val channelName = "Channel Name"
        val channelDescription = "Channel Description"
        val channelImportance = NotificationManager.IMPORTANCE_HIGH

        val channel = NotificationChannel(CHANNEL_ID,channelName,channelImportance).apply {
            description = channelDescription
        }

        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager



        with(NotificationManagerCompat.from(applicationContext)) {
            notificationManager.notify(NOTIFICATION, notification.build())
        }


    }



}