package com.omurgun.chattime.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omurgun.chattime.R
import com.omurgun.chattime.models.ChatListModel
import com.squareup.picasso.Picasso

class ChatListAdapter(
    private val context: Context,
    private val dataListModel: List<ChatListModel>,
) : RecyclerView.Adapter<ChatListAdapter.GameViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListAdapter.GameViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.chat_list_item, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatListAdapter.GameViewHolder, position: Int) {
        holder.bind(dataListModel[position])
    }

    override fun getItemCount(): Int {
        return dataListModel.size
    }


    inner class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(dataModel: ChatListModel)
        {
            itemView.findViewById<TextView>(R.id.tv_name).text = dataModel.userName
            itemView.findViewById<TextView>(R.id.tv_desc).text = dataModel.description
            itemView.findViewById<TextView>(R.id.tv_date).text = dataModel.date
            Picasso.get().load(dataModel.urlProfile).centerCrop().fit().into(itemView.findViewById<ImageView>(R.id.image_profile))
        }
    }
}
