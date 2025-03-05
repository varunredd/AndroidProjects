package com.example.workmanager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnOneTime.setOnClickListener{
                oneTimeWork()
            }
            btnPeriodic.setOnClickListener{
                periodicWork()
            }
            binding.btnStopWork.setOnClickListener {
                stopPeriodicWork()
            }

        }

    }


    fun oneTimeWork(){
        val constraints = Constraints.Builder()
            .build()

        val workRequest: WorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }

    fun periodicWork(){
        val constraints = Constraints.Builder()
            .build()

        val workRequest = PeriodicWorkRequest.Builder(
            MyWorker::class.java,
            15,
            TimeUnit.MINUTES
        ).setConstraints(constraints)
            .addTag("period_id")
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork("period_id",ExistingPeriodicWorkPolicy.KEEP,workRequest)

    }

    fun stopPeriodicWork() {
        WorkManager.getInstance(this).cancelUniqueWork("period_id")
    }

}