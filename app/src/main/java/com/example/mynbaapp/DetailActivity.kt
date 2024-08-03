package com.example.mynbaapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mynbaapp.databinding.ActivityDetailBinding
import com.example.mynbaapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataStar = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_STAR, Star::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_STAR)
        }

        if (dataStar != null){
            binding.apply {
                imgDetail.setImageResource(dataStar.photo)
                tvNamaDetail.text = dataStar.name
                tvTeamDetail.text = dataStar.team
                tvHeightDetail.text = dataStar.height
                tvPosisiDetail.text = dataStar.pos
                tvDescDetail.text = dataStar.desc

                btnShare.setOnClickListener{
//                    val intentSend = intent.apply {
//                        action = Intent.ACTION_SEND
//                        type = "text/plain"
//                        putExtra(Intent.EXTRA_TEXT, "Hello World!")
//                    }
                    val intentSend = Intent(Intent.ACTION_SEND)
                    intentSend.type = "text/plain"
                    intentSend.putExtra(Intent.EXTRA_TEXT,"Hello World!")

                    startActivity(Intent.createChooser(intentSend,"Share Using:"))
                }
            }
        }
    }

    companion object{
        val KEY_STAR = "key_star"
    }
}