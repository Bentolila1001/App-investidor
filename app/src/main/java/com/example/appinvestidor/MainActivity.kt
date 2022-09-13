package com.example.appinvestidor

import android.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appinvestidor.data.data
import com.example.appinvestidor.databinding.ActivityMainBinding
import com.example.appinvestidor.model.User
import com.google.android.material.snackbar.Snackbar

interface MensagemListener {
    fun onSendMessage(msg: Number)
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var user : User = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }

    private fun setup() {
        setupClickListeners()
    }



    private fun setupClickListeners() {
        binding.mainBtn.setOnClickListener{iniciarQuestionario()}
    }



    private fun iniciarQuestionario() {
        user.Name = binding.mainName.text.toString()
        data.add(user)
        val intent = Intent(this, QuestionActivity  ::class.java)
        if(data[0].Name != ""){
            startActivity(intent)
        }
    }
}