package com.example.appinvestidor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.appinvestidor.data.data
import com.example.appinvestidor.data.questions
import com.example.appinvestidor.databinding.FragmentQuestion1Binding


class Question1 : Fragment() {
    private var _binding: FragmentQuestion1Binding? = null
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
            view.findNavController().navigate(R.id.action_question1_to_question2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion1Binding.inflate(inflater, container, false)
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
            view.findNavController().navigate(R.id.action_question1_to_mainActivity)
            data[0].Score -= selectScore
        }
    }

    private fun configQuestion() {

        binding.question1.text =  questions[0].Question
        binding.resp1.setText(questions[0].question1)
        binding.resp2.setText(questions[0].question2)
        binding.resp3.setText(questions[0].question3)
        binding.resp4.setText(questions[0].question4)
    }
    }