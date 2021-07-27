package com.omurgun.chattime.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omurgun.chattime.databinding.FragmentStatusBinding

class StatusFragment: Fragment() {
    private lateinit var binding: FragmentStatusBinding
    private lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatusBinding.inflate(inflater, container, false)
        root = binding.root
        return root
    }
}