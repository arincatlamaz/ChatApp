package com.arincatlamaz.chatapp.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arincatlamaz.chatapp.R
import com.arincatlamaz.chatapp.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        var extras : Bundle? = activity?.intent?.extras
        var extras2 : Bundle? = activity?.intent?.extras


        /*if (extras2 != null && extras2.containsKey("backpress")){
            val backpress : Boolean = extras2.getBoolean("backpress")
            if (backpress){
                findNavController().navigate(R.id.splashToLogin)

            }
        }*/

        if (extras != null && extras.containsKey("logout")){
            val logout : Boolean = extras.getBoolean("logout")
            if (logout){
                findNavController().navigate(R.id.splashToLogin)

            }
        } else if (extras2 != null && extras2.containsKey("backpress")){
            val backpress : Boolean = extras2.getBoolean("backpress")
            if (backpress){
                findNavController().navigate(R.id.splashToLogin)

            }
        }

        else{
            val delay = 2000L
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.splashToOnBoarding)
            }, delay)

            auth = Firebase.auth
            val currentUser = auth.currentUser
            if (currentUser != null){
                startActivity(Intent(context, HomeActivity::class.java))
            }
        }



        return binding.root
    }

}