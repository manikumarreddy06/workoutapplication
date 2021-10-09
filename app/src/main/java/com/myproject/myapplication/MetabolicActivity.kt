package com.myproject.myapplication


import android.os.Binder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.myproject.myapplication.databinding.ActivityMetabolicBinding
import java.math.BigDecimal
import java.math.RoundingMode
import kotlinx.android.synthetic.main.activity_metabolic.*



class MetabolicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metabolic)
          setSupportActionBar(toolbar_BMI_Activity)
       val actionBar=supportActionBar
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
           actionBar. setTitle("BMI CALCULATOR")
        }
      toolbar_BMI_Activity.setNavigationOnClickListener(){
            onBackPressed()
        }
        btncalculate.setOnClickListener(){
            validatemetricunits()
        }
    }

    private fun validatemetricunits(){
      if (etuserHeight.text.toString().isEmpty()){
          Toast.makeText(this,"field cannot be empty ",Toast.LENGTH_SHORT).show()
      }
        else if (etuserHeight.text.toString().isEmpty()){
          Toast.makeText(this,"field cannot be empty ",Toast.LENGTH_SHORT).show()
      }
        else{
            var heightvalue:Float=etuserHeight.text.toString().toFloat()/100
          var weightvalue:Float=etuserweeight.text.toString().toFloat()
          var bmi=weightvalue/(heightvalue*heightvalue)
          val bmilabel:String
          val bmidescription:String



          if (bmi.compareTo(15f)<=0){
              bmilabel="very severely underweight"
              bmidescription="take proper diet...health care is required"
          }
          else if(bmi.compareTo(15f)>0&&bmi.compareTo(16f)<=0){
              bmilabel="severely underweight"
              bmidescription="Take proper diet....health care is required"
          }
          else if (bmi.compareTo(16f)>0 && bmi.compareTo(18.5f)<=0){
              bmilabel="underweight"
              bmidescription="take proper diet...health care is required"
          }
          else if(bmi.compareTo(18.5f)>0 && bmi.compareTo(25f)<=0){
              bmilabel="perfect"
              bmidescription="your health condition is great"
          }
          else if(bmi.compareTo(25f)>0&& bmi.compareTo(30f)<=0){
              bmilabel="slight obese condition"
              bmidescription="you are slightly overweight....work out a bit"
          }
          else if (bmi.compareTo(30f)>0&& bmi.compareTo(35f)<=0){
              bmilabel="over weight"
              bmidescription="you are overweight....workout is recommended"
          }
          else if(bmi.compareTo(35f)>0 && bmi.compareTo(40f)<=0){
              bmilabel="moderately overweight"
              bmidescription="you are overweight....workout is recommended"
          }
          else{
              bmilabel="obese class"
              bmidescription="serious health issue"
          }
          tvyourBmi.visibility=View.VISIBLE
          bmivalue.visibility=View.VISIBLE
          bmitype.visibility=View.VISIBLE
          bmidescriptin.visibility=View.VISIBLE
          val bmivalue=BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
          tvyourBmi.text=bmivalue
          bmitype.text=bmilabel
          bmidescriptin.text=bmidescription
      }

    }
}
