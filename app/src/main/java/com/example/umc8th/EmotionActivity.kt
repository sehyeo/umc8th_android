package com.example.umc8th

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.widget.ImageView
import android.widget.TextView

class EmotionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion)

        // XML에서 TextView와 ImageView 가져오기
        val emotionTextView: TextView = findViewById(R.id.emotionText)
        val emotionImageView: ImageView = findViewById(R.id.emotionImage)

        // MainActivity에서 전달된 감정 타입 가져오기
        val emotionType = intent.getStringExtra("emotion_type")

        // 감정 타입에 따라 화면 요소 변경
        when (emotionType) {
            "happy" -> {
                emotionTextView.text = "더없이 행복한 하루였어요!"
                emotionImageView.setImageResource(R.drawable.happystamp)
            }
            "excited" -> {
                emotionTextView.text = "들뜨고 흥분돼요!"
                emotionImageView.setImageResource(R.drawable.excitedstamp)
            }
            "normal" -> {
                emotionTextView.text = "평범한 하루였어요!"
                emotionImageView.setImageResource(R.drawable.normalstamp)
            }
            "worried" -> {
                emotionTextView.text = "생각이 많아지고 불안해요!"
                emotionImageView.setImageResource(R.drawable.worriedstamp)
            }
            "angry" -> {
                emotionTextView.text = "부글부글 화가 나요!"
                emotionImageView.setImageResource(R.drawable.angrystamp)
            }
        }
    }
}