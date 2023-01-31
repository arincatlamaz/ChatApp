package com.arincatlamaz.chatapp.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.arincatlamaz.chatapp.R
import com.arincatlamaz.chatapp.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        auth = Firebase.auth
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginBtn.setOnClickListener{
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                    startActivity(Intent(context, HomeActivity::class.java))
                    activity?.finish()
                }.addOnFailureListener {
                    Toast.makeText(context,it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(context,"Please Enter Email and Password!", Toast.LENGTH_LONG).show()
            }


        }

        binding.signUpBtn.setOnClickListener(){
            findNavController().navigate(R.id.signUpFragment)
        }


        return binding.root
    }



}