package com.example.english.learn_activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.english.R
import kotlinx.android.synthetic.main.item_view.view.*

class LearnAdapter(var activity: LearnActivity):RecyclerView.Adapter<LearnAdapter.MyViewHolder>() {

    var list = mutableListOf<String>()
    set(value) {
        field = value
    }

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun setData(str:String,position: Int){
            itemView.tv_name.text = str
            if(activity.type == "ui"){
                itemView.tv_info.setText("Uzbek-English")
            }else{
                itemView.tv_info.text = "English-Uzbek"
            }

            itemView.setOnClickListener {
                activity.itemOnClickListener(position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}