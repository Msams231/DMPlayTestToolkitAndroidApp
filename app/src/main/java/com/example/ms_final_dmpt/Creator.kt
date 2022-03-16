package com.example.ms_final_dmpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_creator.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class Creator : AppCompatActivity() {

    private val filepath = "MyFileStorage"
    internal var myExternalFile: File?=null
    private val isExternalStorageReadOnly: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            true
        } else {
            false
        }
    }
    private val isExternalStorageAvailable: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            true
        } else{
            false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creator)

        //spinner set up
        val dieSpinner: Spinner = dieSpn
        val statSpinner: Spinner = statSpn

        //file creation
        val fileName = nameTxt



        ArrayAdapter.createFromResource(
            this,
            R.array.dieSides,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            dieSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.statSpinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            statSpinner.adapter = adapter
        }

        saveBtn.setOnClickListener {
            myExternalFile = File(getExternalFilesDir(filepath), fileName.text.toString() + ".txt")
            try {
                /*val fileOutPutStream = FileOutputStream(myExternalFile)
                fileOutPutStream.write(fileData.toByteArray())
                fileOutPutStream.close()*/
                myExternalFile!!.writeText("HP:" + hpTxt.text.toString() + "_\nAC:"+  acTxt.text.toString() + "_\nSpeed:" + speedTxt.text.toString() + "_\nStrength:" + strTxt.text.toString() + "_\nDexterity:" + dexTxt.text.toString() + "_\nConstitution:" + conTxt.text.toString() + "_\nIntelligence:" + intTxt.text.toString() + "_\nWisdom:" + wisTxt.text.toString() + "_\nCharisma:" + chaTxt.text.toString() + "_\nAttack:" + attNameTxt.text.toString() + "_\nDie:" + dieSpn.selectedItem.toString() + "_\nStat:" + statSpn.selectedItem.toString())
            } catch (e: IOException) {
                e.printStackTrace()
            }
            Toast.makeText(applicationContext, "data save", Toast.LENGTH_SHORT).show()
        }
        if (!isExternalStorageAvailable || isExternalStorageReadOnly) {
            saveBtn.isEnabled = false
        }
    }
}

