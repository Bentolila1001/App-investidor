package com.example.appinvestidor

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.navigation.findNavController
import com.example.appinvestidor.data.data
import com.example.appinvestidor.databinding.ActivityMainBinding
import com.example.appinvestidor.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup(view)
    }



    @SuppressLint("SetTextI18n")
    private fun setup(view: View) {
        var perfil : String
        var score = data[0].Score

        if (score <= 12)
        {
            perfil = "Conservador"
        }else if(score > 12 && score <= 29 ){
            perfil = "Moderado"
        }else{
            perfil = "Arrojado"
        }
        binding.resultText.text =
            "Parabéns " +  data[0].Name + ", você concluiu o teste. Seu perfil foi considerado " +  perfil + "seu score: " +  data[0].Score
        val intent = Intent(this, MainActivity  ::class.java)
        binding.backButton.setOnClickListener{
            startActivity(intent)
            data[0].Score = 0
        }
    }


}