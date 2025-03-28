package com.example.umc8th

import android.content.Intent
import android.os.Bundle
import android.app.Activity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.umc8th.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title") ?: "제목 없음"
        val singer = intent.getStringExtra("singer") ?: "가수 없음"

        // UI에 표시하고 싶으면 binding 으로 텍스트 세팅
        binding.songTitleTv.text = title
        binding.songSingerTv.text = singer

        binding.icArrowBottom.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra(MainActivity.INTENT_KEY_RETURN_TITLE, "Journey")
            }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}