package com.example.english.words

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.english.R
import com.example.english.db.entity.Soz
import kotlinx.android.synthetic.main.word_view.view.*

class WordAdapter(var activity: WordsActivity): RecyclerView.Adapter<WordAdapter.MyViewHolder>() {

    var words = mutableListOf<Soz>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun setData(soz: Soz){
            if(activity.presenter.type == "ui"){
                itemView.tv_word.text = soz.uzbek+" - "+soz.english
            }else{
                itemView.tv_word.text = soz.english+" - "+soz.uzbek
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(words[position])
    }

    override fun getItemCount(): Int = words.size

}