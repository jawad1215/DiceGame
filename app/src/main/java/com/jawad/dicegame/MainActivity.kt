package com.jawad.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jawad.dicegame.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.RollBtn.setOnClickListener { rollDice() }
        binding.resetButton.setOnClickListener { resetGame() }

    }

    private fun rollDice() {
        binding.rollText.visibility=View.GONE
        binding.RollBtn.text="ROLL"
        val randomInt1 = Random.nextInt(6) + 1
        val randomInt2 = Random.nextInt(6) + 1
      //  binding.rollText.text=randomInt1.toString()

        val drawableResource1=when(randomInt1)
        {
            1 -> R.drawable.dice_1
            2 ->R.drawable.dice_2
            3-> R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        binding.FirstDice.setImageResource(drawableResource1)

        val drawableResource2=when(randomInt2)
        {
            1 -> R.drawable.dice_1
            2 ->R.drawable.dice_2
            3-> R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        binding.SecondDice.setImageResource(drawableResource2)

        if (randomInt1==randomInt2)
        {
            binding.rollText.visibility=View.VISIBLE
            binding.rollText.text="Congratulations!\nDo you Want to Play again???"
            binding.resetButton.visibility=View.VISIBLE
            binding.RollBtn.visibility= View.GONE

        }
    }

    private fun resetGame() {
        binding.RollBtn.visibility=View.VISIBLE
        binding.resetButton.visibility=View.GONE
        binding.rollText.visibility=View.GONE

    }

}
