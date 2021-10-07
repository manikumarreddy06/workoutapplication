package com.myproject.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myproject.myapplication.databinding.ActivityFinishBinding

class Finish : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(
            binding.root
        )

        setSupportActionBar(binding.toolbarfinishactivity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbarfinishactivity.setNavigationOnClickListener(){
            onBackPressed()
        }
       binding.btnfinishactivity.setOnClickListener(){
           finish()
       }
    }
}