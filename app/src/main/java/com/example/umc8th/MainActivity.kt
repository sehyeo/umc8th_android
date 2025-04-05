package com.example.umc8th

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import com.example.umc8th.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isRunning = false
    private var time = 0
    private var thread: Thread? = null
    private var paused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            if (!isRunning) {
                startStopwatch()
            } else if (paused) {
                resumeStopwatch()
            }
        }

        binding.btnPause.setOnClickListener {
            pauseStopwatch()
        }

        binding.btnClear.setOnClickListener {
            clearStopwatch()
        }
    }

    private fun setTimerStatus(isRunning : Boolean) {

        if(isRunning){
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
        } else{
            binding.btnStart.visibility = View.VISIBLE
            binding.btnPause.visibility = View.GONE
        }
    }

    private fun startStopwatch() {
        isRunning = true
        paused = false
        setTimerStatus(true)
        thread = Thread {
            while (isRunning) {
                if (!paused) {
                    Thread.sleep(5)
                    time++
                    runOnUiThread {
                        val minute = time / 6000
                        val second = (time / 100) % 60
                        val milli = time % 100
                        binding.timeText.text = String.format("%d:%02d.%02d", minute, second, milli)
                    }
                }
            }
        }
        thread?.start()
    }

    private fun pauseStopwatch() {
        paused = true
        setTimerStatus(false)
    }

    private fun resumeStopwatch() {
        paused = false
        setTimerStatus(true)
    }

    private fun clearStopwatch() {
        time = 0
        runOnUiThread {
            binding.timeText.text = "0:00.00"
        }

        if (paused) {
            isRunning = false
            thread = null
            setTimerStatus(false)
        }

    }
}
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val a = A()
//        val b = B()
//
//        a.start()
//        a.join()
//        b.start()
//    }
//
//    class A : Thread(){
//        override fun run() {
//            super.run()
//            for (i in 1..1000){
//                Log.d("test", "first : $i")
//            }
//        }
//    }
//
//    class B : Thread(){
//        override fun run() {
//            super.run()
//            for (i in 1000 downTo 1){
//                Log.d("test", "second : $i")
//            }
//        }
//    }