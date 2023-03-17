package com.example.english.story

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.english.R
import com.example.english.db.entity.Sound
import kotlinx.android.synthetic.main.item_story.view.*

class SoundAdapter(var activity:StoryActivity):RecyclerView.Adapter<SoundAdapter.SoundViewHolder>() {

    var sounds = mutableListOf<Sound>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class SoundViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun setData(sound: Sound){
            itemView.tv_sound_title.text = sound.title
            itemView.tv_shorter.text = sound.text.substring(0..60)+"..."
            itemView.setOnClickListener {
                activity.setOnClickSoundItem(sound)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story,parent,false)
        return SoundViewHolder(view)
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        holder.setData(sounds[position])
    }

    override fun getItemCount(): Int = sounds.size

}