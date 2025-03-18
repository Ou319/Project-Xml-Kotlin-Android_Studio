package com.example.ex22

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class inputDialogue(var contx:Context):Dialog(contx) {
    init {
        setContentView(R.layout.input_dialog)
    }



    val input:EditText=findViewById(R.id.input1)
    val btn:Button=findViewById(R.id.btn2)


    fun ValueInput(viewText:TextView){

        btn.setOnClickListener(){
            val valueInput=input.text.toString()
             viewText.text=valueInput
             dismiss()
        }

    }

    // this for dsplayed text in input

    fun setInput(text:String){
        input.setText(text)
    }
}
