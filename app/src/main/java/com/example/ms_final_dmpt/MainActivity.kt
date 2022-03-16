package com.example.ms_final_dmpt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btCreator.setOnClickListener {
            val intent = Intent(this, Creator::class.java)
            startActivity(intent)
        }

        btDice.setOnClickListener {
            val intent = Intent(this, DiceRoller::class.java)
            startActivity(intent)
        }

        btBattle.setOnClickListener {
            val intent = Intent(this, BattleTester::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                //Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MySettings::class.java)
                startActivity(intent)
                true
            }
            R.id.action_share -> {
                Toast.makeText(applicationContext, "click on share", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_help -> {
                val intent = Intent(this, Help::class.java)
                startActivity(intent)
                true
            }
            R.id.action_exit -> {
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}