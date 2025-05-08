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

        initBottomNavigation()
    }

    private fun initBottomNavigation() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, PokemonFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.pokemonFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, PokemonFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.tagFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, TagFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.straightenFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, StraightenFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.weightFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, WeightFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
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

