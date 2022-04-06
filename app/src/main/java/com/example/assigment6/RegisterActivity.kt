package com.example.assigment6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = com.example.assigment6.databinding.ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this,MainActivity::class.java)
        var id:String
        var username:String
        var mail:String
        var gender:String


        binding.buttonRegister.setOnClickListener {
            with(binding){
                gender = if(radioButtonFemale.isChecked){
                    "Female"
                } else "male"
                id = editTextId.text.toString()
                username= editTextUsername.text.toString()
                mail= editTextEmail.text.toString()
            }
            with(intent){
                putExtra("id",id)
                putExtra("username",username)
                putExtra("mail",mail)
                putExtra("gender",gender)
            }
            startActivity(intent)
        }


    }
}