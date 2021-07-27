package com.omurgun.chattime.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omurgun.chattime.adapters.CallListAdapter
import com.omurgun.chattime.databinding.FragmentCallsBinding
import com.omurgun.chattime.models.CallListModel

class CallsFragment:Fragment() {
    private lateinit var binding: FragmentCallsBinding
    private lateinit var root:View
    private lateinit var callList:ArrayList<CallListModel>
    private lateinit var callListRv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCallsBinding.inflate(inflater, container, false)
        root = binding.root
        return root
    }

    override fun onStart() {
        super.onStart()
        init()
        getChatList()
        setChatListAdapter()
    }

    private fun init()
    {
        callList = ArrayList()
        callListRv = binding.callListRv
    }
    private fun getChatList()
    {
        callList.add(CallListModel(
                "1",
                "omur",
                "15/04/2019,9:10 pm",
                "https://b7u4x9d3.stackpathcdn.com/wp-content/uploads/2019/09/cropped-oyun-karakter-tasarimi-Lara-Croft-%E2%80%93-Rise-of-the-Tomb-Raider-3dmadmax-1-780x405.jpg.webp",
                "income"))
        callList.add(CallListModel(
                "2",
                "onur",
                "15/04/2019,9:10 pm",
                "https://b7u4x9d3.stackpathcdn.com/wp-content/uploads/2019/09/cropped-oyun-karakter-tasarimi-Lara-Croft-%E2%80%93-Rise-of-the-Tomb-Raider-3dmadmax-1-780x405.jpg.webp",
                "missed"))
        callList.add(CallListModel(
                "3",
                "sülo",
                "15/04/2019,9:10 pm",
                "https://b7u4x9d3.stackpathcdn.com/wp-content/uploads/2019/09/cropped-oyun-karakter-tasarimi-Lara-Croft-%E2%80%93-Rise-of-the-Tomb-Raider-3dmadmax-1-780x405.jpg.webp",
                "income"))
        callList.add(CallListModel(
                "4",
                "taha",
                "15/04/2019,9:10 pm",
                "https://b7u4x9d3.stackpathcdn.com/wp-content/uploads/2019/09/cropped-oyun-karakter-tasarimi-Lara-Croft-%E2%80%93-Rise-of-the-Tomb-Raider-3dmadmax-1-780x405.jpg.webp",
                "missed"))

    }

    private fun setChatListAdapter()
    {
        val chatListAdapter = CallListAdapter(root.context,callList)
        callListRv.adapter = chatListAdapter
        callListRv.layoutManager = LinearLayoutManager(root.context, LinearLayoutManager.VERTICAL, false)
    }

}