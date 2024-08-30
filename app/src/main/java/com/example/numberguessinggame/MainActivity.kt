package com.example.numberguessinggame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.numberguessinggame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var leftNumber: Int = (1..100).random()
    var rightNumber: Int = (1..100).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.buttonLeft.text = "Boton izquierdo"
        binding.buttonLeft.setOnClickListener {
            println("left number: $leftNumber")
            println("right number: $rightNumber")
            if(leftNumber>=rightNumber) {
                binding.myText.text = "Felicitaciones! Has ganado."
                leftNumber = (1..100).random()
                rightNumber = (1..100).random()
            }
            else {
                binding.myText.text = "Lo siento, has perdido :("
            }

        }
        binding.buttonRight.setOnClickListener {
            if(leftNumber<=rightNumber) {
                binding.myText.text = "Felicitaciones! Has ganado."
                leftNumber = (1..100).random()
                rightNumber = (1..100).random()
            }
            else {
                binding.myText.text = "Lo siento, has perdido :("
            }
        }

    }
}