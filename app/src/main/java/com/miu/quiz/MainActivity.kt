package com.miu.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.miu.quiz.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnReset.setOnClickListener{
            reset()
        }

        binding.btnSubmit.setOnClickListener{
            submit()
        }

    }

    private fun submit(){
        //score calculation
        //correct answers
        val correctAnswerForQ1 = binding.q1o4.id
        val correctAnswerForQ2 = setOf(true,true,true,true)
        val scoreQ1 = if(binding.q1.checkedRadioButtonId==correctAnswerForQ1) 1 else 0
        val answerForQ2 = setOf(binding.q2o1.isChecked,binding.q2o2.isChecked,binding.q2o3.isChecked,binding.q2o4.isChecked)
        val scoreQ2 = if(answerForQ2==correctAnswerForQ2) 1 else 0
        val finalScore= (scoreQ1+scoreQ2)*50

        //alert

        val currentDate = SimpleDateFormat("yyyy-MM-dd HH-mm", Locale.getDefault()).format(Date())
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Quiz Result!!!")
        builder.setMessage("Congratulations! You submitted on $currentDate, and you achieved $finalScore%.")
        builder.show()
    }


    private fun reset(){
        binding.q1.clearCheck()
        binding.q2o1.isChecked=false
        binding.q2o2.isChecked=false
        binding.q2o3.isChecked=false
        binding.q2o4.isChecked=false
    }
}