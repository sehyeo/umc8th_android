package com.example.umc8th

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.umc8th.databinding.ActivityMainBinding
import android.app.Activity
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object {
        const val INTENT_KEY_RETURN_TITLE = "album_title"
    }

    private lateinit var binding: ActivityMainBinding

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val albumTitle = data?.getStringExtra(INTENT_KEY_RETURN_TITLE)
            Toast.makeText(this, "선택한 앨범: $albumTitle", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainPlayerCl.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java).apply {
                putExtra("title", "라일락")
                putExtra("singer", "아이유 (IU)")
            }
            getResult.launch(intent)
        }
    }
}