package com.sumele.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cal:Button = findViewById(R.id.btcCal)

//        cal.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View?) {
//                calculate()
//            }
//
//        })
        cal.setOnClickListener {
            calculate()
        }
    }

    fun calculate(){
        //declare all the variables in conjuntion with your widgets
        var txtOne:EditText = findViewById(R.id.txtOne)
        var txtTwo:EditText = findViewById(R.id.txtTwo)
        var rdoAdd:RadioButton = findViewById(R.id.rdoAdd)
        var rdoSub:RadioButton = findViewById(R.id.rdoSubtract)
        var rdoMulti:RadioButton = findViewById(R.id.rdoMulti)
        var rdoDiv:RadioButton = findViewById(R.id.rdoDiv)
        var answer:TextView = findViewById(R.id.lblAnswer)
        //convert the number to int
        var intNo1  = txtOne.text.toString().toInt()
        var intNo2  = txtTwo.text.toString().toInt()
        var soldier:String? = "Roberto"
        //soldier?.let { it.toLowerCase() }
       // var numb:String = soldier?:"hello"
        soldier?:print("your name is $soldier")// called the elvis operator

        var solution:Float

        when{
            rdoAdd.isChecked ->{
                solution = (intNo1+intNo2).toFloat()
            }
            rdoSub.isChecked ->{
                solution = (intNo1-intNo2).toFloat()
            }
            rdoMulti.isChecked ->{
                solution = (intNo1*intNo2).toFloat()
            }
            else->{
                if(intNo2 == 0){
                    Toast.makeText(this@MainActivity, "You can not divide by zero.", Toast.LENGTH_SHORT).show()
                    return
                }
                solution = (intNo1/intNo2).toFloat()
            }
        }
        answer.setText("Your answer is $solution")


    }
}


