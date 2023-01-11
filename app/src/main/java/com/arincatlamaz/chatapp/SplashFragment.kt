package com.arincatlamaz.chatapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arincatlamaz.chatapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        val delay = 2000L
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.splashToOnBoarding)
        }, delay)

        return binding.root
    }

}