package com.arincatlamaz.chatapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arincatlamaz.chatapp.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment(){

    private lateinit var binding: FragmentMessagesBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMessagesBinding.inflate(inflater, container, false)
        return binding.root
    }


}