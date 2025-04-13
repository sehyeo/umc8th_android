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
    }

}