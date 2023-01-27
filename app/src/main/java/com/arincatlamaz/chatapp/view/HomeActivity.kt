package com.arincatlamaz.chatapp.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.arincatlamaz.chatapp.R
import com.arincatlamaz.chatapp.databinding.ActivityHomeBinding
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

        val navController : NavController = Navigation.findNavController(this,
            R.id.fragmentContainerView2
        )
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

            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            intent.putExtra("logout",true)
            overridePendingTransition(0,0)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            finish()
            startActivity(intent)

        }
        return super.onOptionsItemSelected(item)

    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure?")
        builder.setMessage("Hello")
        builder.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->

        })

        auth.signOut()
        val intent = Intent(this@HomeActivity, MainActivity::class.java)
        intent.putExtra("backpress",true)
        overridePendingTransition(0,0)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        startActivity(intent)



        super.onBackPressed()
    }












}