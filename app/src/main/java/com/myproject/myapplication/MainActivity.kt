package com.myproject.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.myproject.myapplication.com.myproject.myapplication.ExerciseActivity
import com.myproject.myapplication.databinding.ActivityMainBinding
import com.myproject.myapplication.databinding.ItemExerciseStatusBinding

class MainActivity : AppCompatActivity() {
    private var countDownTimer: CountDownTimer? = null
    private var restprogress = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llBMI.setOnClickListener() {
            val intent = Intent(this, MetabolicActivity::class.java).also {
                startActivity(it)
                Toast.makeText(this,"naviagte",Toast.LENGTH_SHORT).show()
            }
        }
        binding.llStart.setOnClickListener(){
            val intent=Intent(this,ExerciseActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}

