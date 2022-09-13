package com.example.appinvestidor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.navigation.findNavController
import com.example.appinvestidor.data.data
import com.example.appinvestidor.data.questions
import com.example.appinvestidor.databinding.FragmentQuestion2Binding


class Question2 : Fragment() {
    private var _binding: FragmentQuestion2Binding? = null
    private val binding get() = _binding!!
    private var selectScore = 0
    private lateinit var radioGroup: RadioGroup

    fun onClickBtn(view: View){
        val selectedId = radioGroup.checkedRadioButtonId
        if(selectedId > 0){
            if(binding.resp1.isChecked){
                data[0].Score += 0
                selectScore = data[0].Score
            }
            else if(binding.resp2.isChecked){
                data[0].Score += 2
                selectScore = data[0].Score
            }
            else if(binding.resp3.isChecked){
                data[0].Score += 4
                selectScore = data[0].Score
            }
            else if(binding.resp4.isChecked){
                data[0].Score += 5
                selectScore = data[0].Score
            }
            view.findNavController().navigate(R.id.action_question2_to_question3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion2Binding.inflate(inflater, container, false)
        val view = binding.root
        setupClickListeners(view)
        return view
    }

    private fun setupClickListeners(view: View) {
        configQuestion()

        radioGroup = binding.radioGroup
        binding.button.setOnClickListener{
            onClickBtn(view)
        }

        binding.backButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_question2_to_question1)
            data[0].Score -= selectScore
        }
    }

    private fun configQuestion() {
        binding.question1.text =  questions[1].Question
        binding.resp1.setText(questions[1].question1)
        binding.resp2.setText(questions[1].question2)
        binding.resp3.setText(questions[1].question3)
        binding.resp4.setText(questions[1].question4)
    }
}