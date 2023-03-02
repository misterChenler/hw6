package com.example.home_work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.home_work.databinding.FragmentSongsBinding
import com.example.home_work.databinding.ItemSongBinding

class SongsFragment : Fragment() {

    private lateinit var binding: FragmentSongsBinding
    private lateinit var adapter : SongAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSongsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var list = ArrayList<Song>()

        list.add(Song("1", "DNCE", "Cake By the Ocean", "3:45"))
        list.add(Song("2", "French Montana ft. Swae Lee", "Unforgettable", "3:51"))
        list.add(Song("3", "The Weeknd, Kendrick Lamar", "Pray for Me", "3:29"))
        list.add(Song("4", "Doja Cat, The Weeknd", "You Right", "3:05"))
        list.add(Song("5", "Allen Block", "I Need a Dollar", "4:18"))
        list.add(Song("6", "Billie Eilish", "everything i wanted", "4:07"))
        list.add(Song("7", "The Cat Empire", "The Lost Song", "5:54"))
        list.add(Song("8", "Pompeya", "90", "4:33"))
        list.add(Song("9", "Lil Nas X, Jack Harlow", "INDUSTRY BABY", "3:33"))
        list.add(Song("10", "bbno$ & Rich Brian", "edamame", "2:16"))
         adapter=SongAdapter(list,this::onItemClick)
        binding.recyclerView.adapter=adapter

    }

    private fun onItemClick(title: String) {
        requireActivity().supportFragmentManager.findFragmentById(R.id.image)?.view?.isGone = true

        val bundle = Bundle()
        bundle.putString("name", title)
        val titleFragment = TitleFragment()
        titleFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.rv, titleFragment).commit()
    }
}





