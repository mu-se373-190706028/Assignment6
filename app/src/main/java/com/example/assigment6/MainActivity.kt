package com.example.assigment6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.assigment6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogout.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        with(binding){
            textViewId.text=intent.getStringExtra("id").toString()
            textViewEmail.text=intent.getStringExtra("mail").toString()
            textViewGender.text=intent.getStringExtra("gender").toString()
            textViewUsername.text= intent.getStringExtra("username").toString()
        }

    }
}