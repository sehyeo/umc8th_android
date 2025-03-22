package com.example.umc8th

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.NavOptions
import com.example.umc8th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val tabOrder = listOf(
        R.id.navigation_home,
        R.id.navigation_social,
        R.id.navigation_record,
        R.id.navigation_mypage
    )

    // 현재 선택된 탭 인덱스
    private var currentTabIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        val navController = navHostFragment.navController

        // BottomNavigationView 설정
        binding.bottomNavi.setupWithNavController(navController)

        // BottomNavigationView 아이템 선택 리스너 설정
        binding.bottomNavi.setOnItemSelectedListener { item ->
            val newIndex = tabOrder.indexOf(item.itemId)

            // 현재 선택된 화면이 아니라면 이동
            if (item.itemId != navController.currentDestination?.id && newIndex != -1) {
                val navOptions = if (newIndex > currentTabIndex) {
                    // 오른쪽으로 이동 (→)
                    NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_right)
                        .setExitAnim(R.anim.slide_out_left)
                        .setPopEnterAnim(R.anim.slide_in_left)
                        .setPopExitAnim(R.anim.slide_out_right)
                        .build()
                } else {
                    // 왼쪽으로 이동 (←)
                    NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_left)
                        .setExitAnim(R.anim.slide_out_right)
                        .setPopEnterAnim(R.anim.slide_in_right)
                        .setPopExitAnim(R.anim.slide_out_left)
                        .build()
                }

                navController.navigate(item.itemId, null, navOptions)
                currentTabIndex = newIndex
            }

            true
        }
    }
}