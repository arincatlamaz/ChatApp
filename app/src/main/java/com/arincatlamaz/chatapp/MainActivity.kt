package com.arincatlamaz.chatapp

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arincatlamaz.chatapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }



}

