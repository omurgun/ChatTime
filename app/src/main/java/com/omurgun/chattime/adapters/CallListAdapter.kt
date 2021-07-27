package com.omurgun.chattime.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omurgun.chattime.R
import com.omurgun.chattime.models.CallListModel
import com.squareup.picasso.Picasso

class CallListAdapter(
        private val context: Context,
        private val dataListModel: List<CallListModel>,
) : RecyclerView.Adapter<CallListAdapter.GameViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallListAdapter.GameViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.call_list_item, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: CallListAdapter.GameViewHolder, position: Int) {
        holder.bind(dataListModel[position])
    }

    override fun getItemCount(): Int {
        return dataListModel.size
    }


    inner class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(dataModel: CallListModel)
        {
            itemView.findViewById<TextView>(R.id.tv_name).text = dataModel.userName
            itemView.findViewById<TextView>(R.id.tv_date).text = dataModel.date
            val arrow = itemView.findViewById<ImageView>(R.id.img_arrow)
            when (dataModel.callType) {
                "missed" -> {
                    arrow.setImageDrawable(context.getDrawable(R.drawable.ic_arrow_downward_black_24dp))
                    arrow.drawable.setTint(context.resources.getColor(android.R.color.holo_red_dark,null))
                }
                "income" -> {
                    arrow.setImageDrawable(context.getDrawable(R.drawable.ic_arrow_downward_black_24dp))
                    arrow.drawable.setTint(context.resources.getColor(android.R.color.holo_green_dark,null))
                }
                else -> {
                    arrow.setImageDrawable(context.getDrawable(R.drawable.ic_arrow_upward_black_24dp))
                    arrow.drawable.setTint(context.resources.getColor(android.R.color.holo_green_dark,null))
                }
            }

            Picasso.get().load(dataModel.urlProfile).centerCrop().fit().into(itemView.findViewById<ImageView>(R.id.image_profile))
        }
    }
}
