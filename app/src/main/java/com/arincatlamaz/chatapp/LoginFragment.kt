package com.arincatlamaz.chatapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arincatlamaz.chatapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginBtn.setOnClickListener{
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }

        binding.btnBack.setOnClickListener(){
            findNavController().popBackStack(R.id.onBoardingFragment, false)
        }


        return binding.root
    }



}