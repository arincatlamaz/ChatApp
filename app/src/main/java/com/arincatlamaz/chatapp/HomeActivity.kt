package com.arincatlamaz.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.arincatlamaz.chatapp.databinding.ActivityHomeBinding
import com.arincatlamaz.chatapp.fragment.LoginFragment
import com.arincatlamaz.chatapp.fragment.OnBoardingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth

        val navController : NavController = Navigation.findNavController(this,R.id.fragmentContainerView2)
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.logout) {
            auth.signOut()

            val intent = Intent(this@HomeActivity,MainActivity::class.java)
            startActivity(intent)

        }
        return super.onOptionsItemSelected(item)

    }












}