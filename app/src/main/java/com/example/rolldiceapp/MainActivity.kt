package com.example.rolldiceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    // Create new dice object with 6 sides and roll the dice
    private val dice = Dice(6)
    private val dice2 = Dice(6)

    // Find the image in the layout
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.imageView)
        diceImage2 = findViewById(R.id.imageView2)


        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do the dice roll when the app starts
        rollDice()

    }
    // Roll the dice and update the screen with the result

    private fun rollDice() {


        diceImage.setImageResource(dice.roll())
        diceImage2.setImageResource(dice2.roll())

    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        val value = (1..numSides).random()
        return getImageResource(value)

    }
    // return value for dice
    private fun getImageResource(value: Int): Int {
        return when (value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
