package com.example.home_work

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.home_work.databinding.ItemSongBinding

class SongAdapter(
    private val list: ArrayList<Song>,
    private val onItemClick: (title: String) -> Unit
) :
    Adapter<SongAdapter.SongViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            ItemSongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class SongViewHolder(private val binding: ItemSongBinding) : ViewHolder(binding.root) {
        fun bind(music: Song) = with(binding) {
            number.text = music.number
            title.text = music.title
            autor.text = music.autor
            time.text = music.time
            root.setOnClickListener {
                onItemClick(list[adapterPosition].title)
            }
        }
    }
}