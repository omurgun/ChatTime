package com.omurgun.chattime.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omurgun.chattime.adapters.ChatListAdapter
import com.omurgun.chattime.databinding.FragmentChatsBinding
import com.omurgun.chattime.models.ChatListModel

class ChatsFragment: Fragment() {
    private lateinit var binding: FragmentChatsBinding
    private lateinit var root:View
    private lateinit var chatList:ArrayList<ChatListModel>
    private lateinit var chatListRv:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatsBinding.inflate(inflater, container, false)
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
        chatList = ArrayList()
        chatListRv = binding.chatListRv
    }
    private fun getChatList()
    {
        chatList.add(ChatListModel("1","omçur","helle my name is ömür","18/01/2021","https://b7u4x9d3.stackpathcdn.com/wp-content/uploads/2019/09/cropped-oyun-karakter-tasarimi-Lara-Croft-%E2%80%93-Rise-of-the-Tomb-Raider-3dmadmax-1-780x405.jpg.webp"))
        chatList.add(ChatListModel("2","ohjfghfghmur","helle my name is ömür","18/01/2021","https://b7u4x9d3.stackpathcdn.com/wp-content/uploads/2019/09/cropped-oyun-karakter-tasarimi-Lara-Croft-%E2%80%93-Rise-of-the-Tomb-Raider-3dmadmax-1-780x405.jpg.webp"))
        chatList.add(ChatListModel("3","om566565ur","helle my name is ömür","18/01/2021","https://b7u4x9d3.stackpathcdn.com/wp-content/uploads/2019/09/cropped-oyun-karakter-tasarimi-Lara-Croft-%E2%80%93-Rise-of-the-Tomb-Raider-3dmadmax-1-780x405.jpg.webp"))

    }
    private fun setChatListAdapter()
    {
        val chatListAdapter = ChatListAdapter(root.context,chatList)
        chatListRv.adapter = chatListAdapter
        chatListRv.layoutManager = LinearLayoutManager(root.context, LinearLayoutManager.VERTICAL, false)
    }
}