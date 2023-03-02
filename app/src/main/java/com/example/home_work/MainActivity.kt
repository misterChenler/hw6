package com.example.home_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.home_work.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.image, Image_fragment()).commit()

        supportFragmentManager.beginTransaction().add(R.id.rv, SongsFragment()).commit()

    }
}