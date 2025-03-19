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

        // 감정 스탬프 클릭 시 EmotionActivity로 이동 (Intent에 감정 타입 전달)
        findViewById<ImageView>(R.id.emotionStamp1).setOnClickListener {
            navigateToEmotionActivity("happy")
        }

        findViewById<ImageView>(R.id.emotionStamp2).setOnClickListener {
            navigateToEmotionActivity("excited")
        }

        findViewById<ImageView>(R.id.emotionStamp3).setOnClickListener {
            navigateToEmotionActivity("normal")
        }

        findViewById<ImageView>(R.id.emotionStamp4).setOnClickListener {
            navigateToEmotionActivity("worried")
        }

        findViewById<ImageView>(R.id.emotionStamp5).setOnClickListener {
            navigateToEmotionActivity("angry")
        }
    }

    // EmotionActivity로 이동하는 함수 (감정 타입 전달)
    private fun navigateToEmotionActivity(emotion: String) {
        val intent = Intent(this, EmotionActivity::class.java)
        intent.putExtra("emotion_type", emotion) // 감정 데이터 전달
        startActivity(intent)
    }
}