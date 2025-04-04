package com.example.tugas3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    private lateinit var makananRecycler : RecyclerView
    private lateinit var makananArrayList : MyAdapter
    private lateinit var listMakanan : ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        makananRecycler = findViewById(R.id.makananRV)
        listMakanan = ArrayList()

        listMakanan.add(ItemData(R.drawable.rendang,"Rendang","Sumatra Barat"))
        listMakanan.add(ItemData(R.drawable.coto,"Coto","Makasar"))
        listMakanan.add(ItemData(R.drawable.ketoprak,"Ketoprak","DKI Jakarta"))
        listMakanan.add(ItemData(R.drawable.pempek,"Pempek","Sumatra Selatan"))
        listMakanan.add(ItemData(R.drawable.chaikwe,"Chai Kwe","Kalimantan Barat"))
        listMakanan.add(ItemData(R.drawable.gudeg,"Gudeg","DI Yogyakarta"))
        listMakanan.add(ItemData(R.drawable.satelilit,"Sate Lilit","Bali"))
        listMakanan.add(ItemData(R.drawable.taliwang,"Ayam Taliwang","Nusa Tenggara Barat (NTB)"))
        listMakanan.add(ItemData(R.drawable.buburmanado,"Bubur Tinutuan","Sulawesi Utara"))
        listMakanan.add(ItemData(R.drawable.kaledo,"Kaledo","Sulawesi Tengah"))
        listMakanan.add(ItemData(R.drawable.gatang,"Gatang Kenari","Maluku"))
        listMakanan.add(ItemData(R.drawable.papeda,"Papeda","Papua"))
        listMakanan.add(ItemData(R.drawable.rawon,"Rawon","Jawa Timur"))

        makananRecycler.layoutManager = LinearLayoutManager(this)
        makananRecycler.setHasFixedSize(true)
        makananArrayList = MyAdapter(listMakanan)
        makananRecycler.adapter = makananArrayList

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}