package com.example.umc8th

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.umc8th.databinding.ActivityStampBinding

class StampActivity : ComponentActivity() {
    private lateinit var binding: ActivityStampBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStampBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 감정 스탬프 클릭 시 EmotionActivity로 이동 (Intent에 감정 타입 전달)
        binding.emotionStamp1.setOnClickListener { navigateToEmotionActivity("happy") }
        binding.emotionStamp2.setOnClickListener { navigateToEmotionActivity("excited") }
        binding.emotionStamp3.setOnClickListener { navigateToEmotionActivity("normal") }
        binding.emotionStamp4.setOnClickListener { navigateToEmotionActivity("worried") }
        binding.emotionStamp5.setOnClickListener { navigateToEmotionActivity("angry") }
    }

    private fun navigateToEmotionActivity(emotion: String) {
        val intent = Intent(this, EmotionActivity::class.java)
        intent.putExtra("emotion_type", emotion)
        startActivity(intent)
    }
}