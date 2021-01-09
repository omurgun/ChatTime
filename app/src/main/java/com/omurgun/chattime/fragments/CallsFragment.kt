package com.omurgun.chattime.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omurgun.chattime.databinding.FragmentCallsBinding

class CallsFragment:Fragment() {
    private lateinit var binding: FragmentCallsBinding
    private lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCallsBinding.inflate(inflater, container, false)
        root = binding.root
        return root
    }

}