package com.example.umc8th

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc8th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, PokemonFragment())
//            .commit()
//    }
//    }

