package com.example.umc8th

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AlbumPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TrackListFragment()
            1 -> DetailInfoFragment()
            2 -> VideoFragment()
            else -> TrackListFragment()
        }
    }


}
