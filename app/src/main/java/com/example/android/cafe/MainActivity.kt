package com.example.android.cafe

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var orderQuantity = 1

    fun orderIncrement(view: View){
        if (orderQuantity == 10){
            orderQuantity = 10
            Toast.makeText(this , " You cannot hava more than 10 coffee" ,Toast.LENGTH_LONG).show()
        }else{
        orderQuantity = orderQuantity + 1
        }
        displayQuantity(orderQuantity)
    }

    fun orderDecrement(view: View){
        if (orderQuantity == 1){
            orderQuantity = 1
            Toast.makeText(this, "You cannot have less than 1 coffee" , Toast.LENGTH_SHORT).show()
        }else {
            orderQuantity = orderQuantity - 1
        }
        displayQuantity(orderQuantity)
    }
    fun calculate(whippedCream: Boolean , chocolate: Boolean):Int{
        var price = (orderQuantity * 5)
        if (whippedCream == true){
            price = price + (orderQuantity * 1)
        }
        if (chocolate == true){
            price = price + (orderQuantity * 2)
        }
        return price
    }
    fun orderSummary(name: String, price: Int ,whippedCream: Boolean , chocolate: Boolean):  String{
        return ("Name : "+name+"\n"+"Quantity :" +orderQuantity+ "\n"+"Has whipped cream :"+whippedCream+"\n"+"Has chocolate :"+chocolate+"\n" +"Total price : $"+ price + "\nThank you")
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun order(view: View){
        val whippedCream = findViewById<View>(R.id.whippedCreamCheckbox) as CheckBox
        val hasWhippedCream = whippedCream.isChecked
        val chocolate = findViewById<View>(R.id.chocolateCheckbox) as CheckBox
        val hasChocolate = chocolate.isChecked
        val edittext = findViewById<View>(R.id.input_text) as EditText
        val name = edittext.text.toString()
        val finalprice = calculate(hasWhippedCream,hasChocolate)
        val summary = orderSummary(name,finalprice,hasWhippedCream,hasChocolate)
        displaySummary(summary)

    }

    fun displayQuantity(Quantity: Int){
        val orderQuantity = findViewById<View>(R.id.orderQuantity) as TextView
        orderQuantity.text= Quantity.toString()
    }

    fun displaySummary(Quantity: String){
        val orderSummary = findViewById<View>(R.id.orderSummary) as TextView
        orderSummary.text= Quantity.toString()
    }
}