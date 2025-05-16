package com.example.tugas3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val makanan = intent.getParcelableExtra<ItemData>("makanan")
        if (makanan != null) {
            val imageView: ImageView = findViewById(R.id.imageView2)
            val textView: TextView = findViewById(R.id.textView6)
            val textView1: TextView = findViewById(R.id.textView7)

            imageView.setImageResource(makanan.imageSource)
            textView.text = makanan.imageTitle
            textView1.text = makanan.imageDesc

            val bottNavigation = findViewById<BottomNavigationView>(R.id.bottNav)
            bottNavigation.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.navHome -> {
                        val intent = Intent(this, ListActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    else -> false
                }

            }


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}