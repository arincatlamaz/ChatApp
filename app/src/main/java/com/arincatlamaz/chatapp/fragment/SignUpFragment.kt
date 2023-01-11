package com.arincatlamaz.chatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arincatlamaz.chatapp.R
import com.arincatlamaz.chatapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)



        binding.btnBack.setOnClickListener(){
            findNavController().popBackStack(R.id.onBoardingFragment, false)
        }

        return binding.root
    }


}