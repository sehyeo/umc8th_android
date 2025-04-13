package com.example.umc8th

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.umc8th.databinding.ActivityMemoBinding

class MemoActivity : ComponentActivity() {
    private lateinit var binding: ActivityMemoBinding

    private var savedMemoText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNext.setOnClickListener {
            val memoText = binding.editTextMemo.text.toString()
            savedMemoText = memoText

            val intent = Intent(this, CheckActivity::class.java)
            intent.putExtra("memo_text", memoText)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        savedMemoText = binding.editTextMemo.text.toString() // 현재 입력된 텍스트를 저장
    }

    override fun onResume() {
        super.onResume()
        // 저장된 텍스트가 비어있지 않으면 EditText에 설정
        if(!savedMemoText.isNullOrBlank()){
            binding.editTextMemo.setText(savedMemoText)
        }
    }

}