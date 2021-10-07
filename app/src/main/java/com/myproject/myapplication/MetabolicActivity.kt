package com.myproject.myapplication


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
        setSupportActionBar(toolbarbmiactivity)
        val actionBar=supportActionBar
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title="BMI CALCULATOR"
        }
        toolbarbmiactivity.setNavigationOnClickListener(){
            onBackPressed()
        }
        btnCalculateUnits.setOnClickListener(){
            if (validatemetricunits()) {
                val heightvalue: Float = etMetricUnitHeight.text.toString().toFloat() / 100
                val weightvalue: Float = etMetricUnitWeight.text.toString().toFloat()
                val bmi=weightvalue/(heightvalue*heightvalue)
displabmiresult(bmi)
            }else{
                Toast.makeText(this@MetabolicActivity,"Please enter valid values",Toast.LENGTH_SHORT).show()
            }

        }
    }
    private  fun displabmiresult(bmi:Float){
        val bmilabel:String
        val bmidesciption:String
        if (bmi.compareTo(15f)<=0){
            bmilabel="very severe underweight"
            bmidesciption="you are suffering severe underweight issue... eat healthy"
        }
        else if (bmi.compareTo(15f)>0 && bmi.compareTo(16f)<=0){
            bmilabel="severe underweight"
            bmidesciption="you are suffering underweight issue... eat healthy"
        }
        else if(bmi.compareTo(16f)>0&& bmi.compareTo(18.5f)<0){
            bmilabel="Underweight"
            bmidesciption="slight underweight issues..eat healthy"
        }
        else if(bmi.compareTo(18.5f)>0&&bmi.compareTo(25f)>=0){
            bmilabel="noraml"
            bmidesciption="you have a good ealth condition"
        }
        else if (bmi.compareTo(25f)>0 && bmi.compareTo(30f)<=0 ){
            bmilabel="slight over weight"
            bmidesciption="work out a bit arder"
        }
        else if (bmi.compareTo(30f)>0 && bmi.compareTo(35f)<0){
            bmilabel="moderatley obese"
            bmidesciption="you are overweight work out  is necessary"
        }
        else if(bmi.compareTo(35f)>0&& bmi.compareTo(40f)<=0){
            bmilabel=" obese"
            bmidesciption="your health condition is critical"
        }
        else{
            bmilabel="severely obese"
            bmidesciption="you are severely obsese..act emergency"
        }
        tvYourBMI.visibility=View.VISIBLE
        tvBMIValue.visibility=View.VISIBLE
        tvBMIType.visibility=View.VISIBLE
        tvBMIDescription.visibility=View.VISIBLE
        val bmivalue= BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()

        tvBMIValue.text=bmivalue
        tvBMIType.text=bmilabel
        tvBMIDescription.text=bmidesciption
    }
    private fun validatemetricunits():Boolean{
        var isvalid=true
        if (etMetricUnitHeight.text.toString().isEmpty())
            isvalid=false
        else if(etMetricUnitWeight.text.toString().isEmpty())
            isvalid=false
        return true
    }
}
