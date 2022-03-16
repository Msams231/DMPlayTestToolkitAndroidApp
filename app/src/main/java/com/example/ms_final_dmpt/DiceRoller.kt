package com.example.ms_final_dmpt

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_dice_roller.*
import kotlin.random.Random


class DiceRoller : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)


        var spinner:Spinner = diceSpn

        ArrayAdapter.createFromResource(
            this,
            R.array.diceAmount,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }



        d4Btn.setOnClickListener{
            var total: Int = 0
            var value= diceSpn.selectedItem.toString().toInt()
            for (i in 1..value) {
                total = total+((1..4).random())
            }
            diceTxt.text= total.toString()        }

        d6Btn.setOnClickListener{
            var total: Int = 0
            var value= diceSpn.selectedItem.toString().toInt()
            for (i in 1..value) {
                total = total+((1..6).random())
            }
            diceTxt.text= total.toString()        }

        d8Btn.setOnClickListener{
            var total: Int = 0
            var value= diceSpn.selectedItem.toString().toInt()
            for (i in 1..value) {
                total = total+((1..8).random())
            }
            diceTxt.text= total.toString()        }

        d10Btn.setOnClickListener{
            var total: Int = 0
            var value= diceSpn.selectedItem.toString().toInt()
            for (i in 1..value) {
                total = total+((1..10).random())
            }
            diceTxt.text= total.toString()        }

        d12Btn.setOnClickListener{
            var total: Int = 0
            var value= diceSpn.selectedItem.toString().toInt()
            for (i in 1..value) {
                total = total+((1..12).random())
            }
            diceTxt.text= total.toString()        }

        d20Btn.setOnClickListener{
            var total: Int = 0
            var value= diceSpn.selectedItem.toString().toInt()
            for (i in 1..value) {
                total = total+((1..20).random())
            }
            diceTxt.text= total.toString()        }
    }
}

