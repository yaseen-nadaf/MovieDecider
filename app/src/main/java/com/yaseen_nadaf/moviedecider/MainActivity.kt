package com.yaseen_nadaf.moviedecider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yaseen_nadaf.moviedecider.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    val movieList = mutableListOf("Action", "Thriller", "Romance", "Horror", "Science Fiction", "Crime")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        binding.decideBtn.setOnClickListener {
            val random = Random()
            val randomMovie = random.nextInt(movieList.count())
            binding.selectedMovieText.text = movieList[randomMovie]
            println("${movieList[randomMovie]}")
        }

        binding.addMovieBtn.setOnClickListener {
            var inputText = binding.newMovieTypeInput.text.toString()
            inputText = inputText.uppercase()
            movieList.add(inputText)
            binding.newMovieTypeInput.text.clear()
            println(movieList)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}