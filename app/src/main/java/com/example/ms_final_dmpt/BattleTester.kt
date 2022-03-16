package com.example.ms_final_dmpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_battle_tester.*
import kotlinx.android.synthetic.main.activity_dice_roller.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class BattleTester : AppCompatActivity() {

    var enemyHP: Int = 20
    val enemyAc: Int = 12
    var hp = 0
    var ac = 0
    var att: String? = null

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
        setContentView(R.layout.activity_battle_tester)


        val fileName = importTxt
        var text: String? = null

        enemyHpTxt.setText("Enemy HP: " + enemyHP.toString())

        importBtn.setOnClickListener(View.OnClickListener {
            myExternalFile = File(getExternalFilesDir(filepath), fileName.text.toString() + ".txt")

            val filename = fileName.text.toString() + ".txt"
            myExternalFile = File(getExternalFilesDir(filepath),filename)
            if(filename.toString()!=null && filename.toString().trim()!=""){
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var textList: List<String>? = null

                while ({ text = bufferedReader.readLine(); text }() != null) {
                    stringBuilder.append(text)
                }
                textList = stringBuilder.split("_")
                var hpString =  textList[0].split(":")
                hp = hpString[1].toInt()
                hpTxtResult.setText("HP: " + hp.toString())

                var acString = textList[1].split(":")
                ac = acString[1].toInt()
                acTxtResult.setText("AC: " + ac.toString())

                var attString = textList[10].split(":")
                att = attString[1]
                attTxtResult.setText("Attack: " + att)
                fileInputStream.close()
                //Displaying data on EditText
                Toast.makeText(applicationContext,stringBuilder.toString(),Toast.LENGTH_SHORT).show()
            }
        })


        attackBtn.setOnClickListener {
            var total: Int = 0
            var d20Total: Int = 0

            //your creation attack
            if (att == "D4") {
                d20Total = d20Total+((1..20).random())
                resultTxtMulti.append("Your attack to hit: " + d20Total +"\n")
                if (d20Total >= enemyAc) {
                    total = total + ((1..4).random())
                    resultTxtMulti.append("Damage: " + total +"\n")
                    enemyHP = enemyHP-total
                    enemyHpTxt.setText("Enemy HP: " + enemyHP)
                    total = 0
                    d20Total = 0
                } else {
                    resultTxtMulti.append("Missed!\n")
                    total = 0
                    d20Total = 0
                }
            } else if (att == "D6") {
                d20Total = d20Total+((1..20).random())
                resultTxtMulti.append("Your attack to hit: " + d20Total +"\n")
                if (d20Total >= enemyAc) {
                    total = total + ((1..6).random())
                    resultTxtMulti.append("Damage: " + total +"\n")
                    enemyHP = enemyHP-total
                    enemyHpTxt.setText("Enemy HP: " + enemyHP)
                    total = 0
                    d20Total = 0
                } else {
                    resultTxtMulti.append("Missed!\n")
                    total = 0
                    d20Total = 0
                }
            } else if (att == "D8") {
                    d20Total = d20Total + ((1..20).random())
                    resultTxtMulti.append("Your attack to hit: " + d20Total +"\n")
                    if (d20Total >= enemyAc) {
                        total = total + ((1..8).random())
                        resultTxtMulti.append("Damage: " + total +"\n")
                        enemyHP = enemyHP-total
                        enemyHpTxt.setText("Enemy HP: " + enemyHP)
                        total = 0
                        d20Total = 0
                    } else {
                        resultTxtMulti.append("Missed!\n")
                        total = 0
                        d20Total = 0
                    }
            } else if (att == "D10") {
                d20Total = d20Total + ((1..20).random())
                resultTxtMulti.append("Your attack to hit: " + d20Total +"\n")
                if (d20Total >= enemyAc) {
                    total = total + ((1..10).random())
                    resultTxtMulti.append("Damage: " + total +"\n")
                    enemyHP = enemyHP-total
                    enemyHpTxt.setText("Enemy HP: " + enemyHP)
                    total = 0
                    d20Total = 0
                } else {
                    resultTxtMulti.append("Missed!\n")
                    total = 0
                    d20Total = 0
                }
            } else if (att == "D12") {
                d20Total = d20Total + ((1..20).random())
                resultTxtMulti.append("Your attack to hit: " + d20Total +"\n")
                if (d20Total >= enemyAc) {
                    total = total + ((1..12).random())
                    resultTxtMulti.append("Damage: " + total +"\n")
                    enemyHP = enemyHP-total
                    enemyHpTxt.setText("Enemy HP: " + enemyHP)
                    total = 0
                    d20Total = 0
                } else {
                    resultTxtMulti.append("Missed!\n")
                    total = 0
                    d20Total = 0
                }
            }
            //enemy attack
            d20Total = d20Total + ((1..20).random())
            resultTxtMulti.append("Enemies attack to hit: " + d20Total +"\n")
            if (d20Total >= ac) {
                total = total + ((1..6).random())
                resultTxtMulti.append("Enemies Damage: " + total +"\n")
                hp = hp - total
                hpTxtResult.setText("HP: " + hp)
            } else {
                resultTxtMulti.append("Missed!\n")
            }
            resultTxtMulti.append("\n")

            if (enemyHP <= 0) {
                resultTxtMulti.append("You Win!\n")
            } else if (hp <= 0) {
                resultTxtMulti.append("You Lose.\n")
            }


        }
    }
}



class EnemyAttack {

}


