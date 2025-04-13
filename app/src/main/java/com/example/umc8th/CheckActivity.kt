package com.example.umc8th

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.umc8th.databinding.ActivityCheckBinding

class CheckActivity : ComponentActivity() {
    private lateinit var binding: ActivityCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 저장된 메모 보여주기
        val memoText = intent.getStringExtra("memo_text")
        binding.textViewMemo.text = memoText ?: "저장된 메모가 없습니다."
    }

}