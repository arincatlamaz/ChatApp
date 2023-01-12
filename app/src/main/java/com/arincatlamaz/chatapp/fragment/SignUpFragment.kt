package com.arincatlamaz.chatapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.arincatlamaz.chatapp.R
import com.arincatlamaz.chatapp.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        auth = Firebase.auth



        binding.btnBack.setOnClickListener(){
            findNavController().popBackStack(R.id.onBoardingFragment, false)
        }

        binding.signUpBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                    findNavController().navigate(R.id.signUpToLogin)
                }.addOnFailureListener {
                    Toast.makeText(context,it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(context,"Please Enter Email and Password!", Toast.LENGTH_LONG).show()
            }


        }

        return binding.root
    }



}