package com.example.umc8th

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import com.example.umc8th.ui.HappyActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.emotionStamp1).setOnClickListener {
            startActivity(Intent(this, HappyActivity::class.java))
        }
    }
}