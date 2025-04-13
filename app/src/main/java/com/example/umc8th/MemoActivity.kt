package com.example.umc8th

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.umc8th.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
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

    override fun onRestart() {
        super.onRestart()

        AlertDialog.Builder(this)
            .setTitle("확인")
            .setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("예") { dialog, _ ->
                dialog.dismiss()
                // 아무것도 하지 않음 -> onResume()에서 복원됨
            }
            .setNegativeButton("아니요") { dialog, _ ->
                dialog.dismiss()
                // 저장된 내용 삭제 및 EditText 초기화
                savedMemoText = null
                binding.editTextMemo.setText("")
            }
            .show()
    }

}