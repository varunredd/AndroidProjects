package com.example.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.KeyEventDispatcher.Component
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobscheduler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var jobScheduler: JobScheduler? = null
    private val JOB_ID = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jobScheduler = getSystemService(JobScheduler :: class.java )// Getting the object of a Abstract Class

        binding.apply {
            binding.btnStartJob.setOnClickListener{
                startJob()
            }
            binding.btnStopJob.setOnClickListener{
                stopJob()
            }
        }

    }

    fun startJob(){
        val componentName = ComponentName(this,AndroidScheduler::class.java)
        val jobInfo = JobInfo.Builder(JOB_ID, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setPersisted(true)
            .setPeriodic(15 * 60 * 1000)
            .setOverrideDeadline(0)
            .build()

        var result = jobScheduler?.schedule(jobInfo)

        if(result == JobScheduler.RESULT_SUCCESS){
            Log.d("Job Status :", "Success")
        }else{
            Log.d("Job Status :", "Failure")
        }
    }

    fun stopJob(){
        jobScheduler?.cancel(JOB_ID)
        Log.d("Job Status :", "Stopped")
    }
}