package com.arincatlamaz.chatapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arincatlamaz.chatapp.databinding.FragmentCallsBinding

class CallsFragment : Fragment() {

    private lateinit var binding: FragmentCallsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCallsBinding.inflate(inflater, container, false)


        return binding.root
    }


}