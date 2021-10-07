package com.myproject.myapplication.com.myproject.myapplication

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.myapplication.Finish
import com.myproject.myapplication.R
import com.myproject.myapplication.constants
import com.myproject.myapplication.databinding.ActivityExreciseBinding
import com.myproject.myapplication.exercisemodel
import exerciseadapter
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


class ExerciseActivity(): AppCompatActivity(),TextToSpeech.OnInitListener{
    private var resttimer: CountDownTimer? = null
    private var restprogress = 0
    private var restexercisetimer: CountDownTimer? = null
    private var restExerciseProgress = 0
    private var exerciselist:ArrayList<exercisemodel>?=null
    private var currentExerciseposition=-1
    private var tts: TextToSpeech? =null
    private var player:MediaPlayer?=null
    private  var exerciseAdapter:exerciseadapter?=null



    private lateinit var binding: ActivityExreciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExreciseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener() {
           customDialogForBackButton()


        }
        tts= TextToSpeech(this,this)

        exerciselist= constants.defaultexerciselist()
        setupRestview()

        exercisestatusrecyclerview()

    }

    override fun onDestroy() {
        if (resttimer != null) {
            resttimer!!.cancel()
            restprogress = 0
        }
        if (restexercisetimer != null) {
            restexercisetimer!!.cancel()
            restExerciseProgress = 0
        }
        if (tts !=null){
            tts!!.stop()
            tts!!.shutdown()
        }
        if (player!=null){

            player!!.stop()

        }
        super.onDestroy()

    }

    private fun setrestProgressBar() {
        binding.progressbar.progress = restprogress
        resttimer = object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restprogress++
                binding.progressbar.progress = 10 - restprogress
                binding.tvtimer.text = (10 - restprogress).toString()
            }

            override fun onFinish() {
                binding.llExerciseview.visibility = View.GONE
                binding.llRestview.visibility = View.VISIBLE

                currentExerciseposition++
                exerciselist!![currentExerciseposition].setisselected(true)
                exerciseAdapter!!.notifyDataSetChanged()
                exercisetimer()


            }
        }.start()
    }

    private fun setupRestview() {


        try {
            player= MediaPlayer.create(applicationContext, R.raw.press_start)
            player!!.isLooping=false
            player!!.start()
        }catch (e:Exception){
            e.printStackTrace()
        }

        binding.llRestview.visibility=View.VISIBLE
        binding.llExerciseview.visibility=View.GONE
        if (resttimer != null) {
            resttimer!!.cancel()
            restprogress = 0
        }

        setrestProgressBar()

        binding.tvupcomingexercise.text=exerciselist!![currentExerciseposition+1].getname()
    }

    private fun setupExerciseBar() {
        binding.progressbar2.progress = restExerciseProgress
        restexercisetimer = object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restExerciseProgress++
                binding.progressbar2.progress = 30 - restExerciseProgress
                binding.tvtimer2.text = (30 - restExerciseProgress).toString()

            }

            override fun onFinish() {

                if (currentExerciseposition < exerciselist?.size!! - 1) {
                    exerciselist!![currentExerciseposition].setisselected(false)
                    exerciselist!![currentExerciseposition].setiscompleted(true)
                    exerciseAdapter!!.notifyDataSetChanged()
                    setupRestview()
                } else {
                    val intent = Intent(this@ExerciseActivity,Finish::class.java)
                    startActivity(intent)
                }
            }

        }.start()

    }

    private fun exercisetimer() {
        binding.llRestview.visibility = View.GONE
        binding.llExerciseview.visibility = View.VISIBLE
        if (restexercisetimer != null) {
            restexercisetimer!!.cancel()
            restExerciseProgress = 0
        }
        Speakout(("the Current exercise ees"+exerciselist!![currentExerciseposition].getname()))
        setupExerciseBar()


        binding.Exerciseimageview.setImageResource(exerciselist!![currentExerciseposition].getimage())
        binding.tvExerciseName.text=(exerciselist!![currentExerciseposition].getname())

    }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "unsupported",)
            }
        }else{
            Log.e("tts","Initialization failed")
        }
    }
    private fun Speakout(text:String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }
    private fun exercisestatusrecyclerview(){
        binding.recyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        exerciseAdapter=exerciseadapter(this,exerciselist!!)
        binding.recyclerview.adapter=exerciseAdapter
    }
    private fun customDialogForBackButton() {
        val customDialog = Dialog(this)
        /*Set the screen content from a layout resource.
         The resource will be inflated, adding all top-level views to the screen.*/
        customDialog.setContentView(R.layout.custom_dialog_back_button)
        customDialog.findViewById<TextView>(R.id.btnyes).setOnClickListener {
            finish()
            customDialog.dismiss() // Dialog will be dismissed
        }
        customDialog.findViewById<TextView>(R.id.btnno).setOnClickListener {
            customDialog.dismiss()
        }
        //Start the dialog and display it on screen.
        customDialog.show()
    }
}



