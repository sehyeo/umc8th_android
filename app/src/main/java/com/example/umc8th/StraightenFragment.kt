package com.example.umc8th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc8th.databinding.FragmentStraightenBinding

class StraightenFragment : Fragment() {

    lateinit var binding: FragmentStraightenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStraightenBinding.inflate(inflater, container, false)

        return binding.root
    }
}