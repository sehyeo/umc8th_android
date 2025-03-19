package com.example.umc8th

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.content.Intent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.emotionStamp1).setOnClickListener {
            val intent = Intent(this, HappyActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.emotionStamp2).setOnClickListener {
            val intent = Intent(this, ExcitedActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.emotionStamp3).setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.emotionStamp4).setOnClickListener {
            val intent = Intent(this, WorriedActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.emotionStamp5).setOnClickListener {
            val intent = Intent(this, AngryActivity::class.java)
            startActivity(intent)
        }
    }
}