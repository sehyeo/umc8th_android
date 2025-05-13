package com.example.umc8th

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.widget.Toast
import com.example.umc8th.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터베이스 클래스 객체 생성
        val dao = UserDao()

        binding.addBtn.setOnClickListener {

            val name = binding.nameEdit.text.toString() // 이름
            val age = binding.ageEdit.text.toString() // 나이

            val user = User("", name, age)

            dao.add(user)?.addOnSuccessListener {
                Toast.makeText(this, "등록 성공", Toast.LENGTH_SHORT).show()
            }?.addOnFailureListener {
                Toast.makeText(this, "등록 실패: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        }

        // 사용자 목록 버튼 이벤트
        binding.listBtn.setOnClickListener {

            val intent: Intent = Intent(this@MainActivity, UserListActivity::class.java)
            startActivity(intent)
        }
    }

}