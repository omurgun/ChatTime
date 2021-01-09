package com.omurgun.chattime.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omurgun.chattime.databinding.FragmentCameraBinding

class CameraFragment: Fragment() {
    private lateinit var binding: FragmentCameraBinding
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        root = binding.root
        return root
    }
}