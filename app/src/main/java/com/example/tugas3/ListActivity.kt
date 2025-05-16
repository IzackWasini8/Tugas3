package com.example.tugas3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ListActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var makananRecyclerView: RecyclerView
    private lateinit var makananList: ArrayList<ItemData>
    private lateinit var makananAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        makananList = ArrayList()

        makananList.add(
            ItemData(
                R.drawable.rendang,
                "Rendang",
                "Sumatra Barat",
                "Rendang (bahasa Minangkabau: randang; Jawi: رندڠ) adalah hidangan lauk pauk yang berasal Minangkabau, Indonesia dengan berbahan dasar daging (rusa, sapi, kerbau) dan campuran beragam jenis rempah-rempah yang dihasilkan dari proses memasak suhu rendah dalam waktu lama dengan menggunakan aneka rempah-rempah dan santan. Hidangan ini terlahir akibat perilaku lampau suku Minangkabau yang gemar merantau ke sana kemari sehingga butuh banyak perbekalan, terutama hidangan yang awet, tahan lama, dan bercita rasa sesuai lidah asli orang Minang. Awalnya menggunakan daging rusa. Namun, karena rusa mulai sulit didapat, bahan dasarnya beralih menjadi daging sapi atau kerbau.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.papeda,
                "Papeda",
                "Papua",
                "Papeda adalah makanan berupa bubur sagu yang berasal dari Kepulauan Maluku dan pesisir barat Papua. Hidangan ini biasanya disajikan dengan ikan tongkol atau bubara yang dibumbui dengan kunyit. Papeda berwarna putih dan bertekstur lengket menyerupai lem dengan rasa yang tawar. Papeda merupakan makanan yang kaya serat, rendah kolesterol, dan cukup bergizi.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.gudeg, "Gudeg", "DI Yogyakarta",
                "Gudeg (bahasa Jawa: Gudhěg) adalah hidangan khas Daerah Istimewa Yogyakarta yang terbuat dari nangka muda yang dimasak dengan santan.\n" +
                        "\n" +
                        "Perlu waktu berjam-jam untuk membuat hidangan gudeg. Warna cokelat biasanya dihasilkan oleh daun jati yang dimasak bersamaan. Gudeg biasanya dimakan dengan nasi dan disajikan dengan kuah santan kental (areh), ayam kampung, telur, tempe, tahu, dan sambal goreng krecek.\n" +
                        "\n" +
                        "Gudeg sangat populer di Jawa, hidangan ini merupakan hidangan populer baik sebagai masakan rumahan maupun hidangan jalanan. Gudeg juga diproduksi secara industri sebagai makanan kaleng. Gudeg juga bisa ditemui di luar Indonesia, khususnya di negara tetangga seperti Malaysia dan Singapura.",
            )
        )

        makananList.add(
            ItemData(
                R.drawable.buburmanado,
                "Bubur Manado",
                "Sulawesi Utara",
                "Tinutuan atau Bubur Manado adalah salah satu makanan khas Indonesia dari Manado, Sulawesi Utara. Ada juga yang mengatakan tinutuan adalah makanan khas Minahasa, Sulawesi Utara. Tinutuan merupakan campuran berbagai macam sayuran, tidak mengandung daging, sehingga makanan ini bisa menjadi makanan pergaulan antarkelompok masyarakat di Manado. Tinutuan biasanya disajikan untuk sarapan pagi beserta berbagai pelengkap hidangannya. Walaupun demikian, tinutuan umumnya tetap dapat ditemukan di berbagai rumah makan di luar waktu sarapan",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.coto, "Coto Makasar", "Sulawesi Selatan",
                "Coto makassar atau Pallu coto mangkasarak adalah hidangan tradisional Suku Makassar, Sulawesi Selatan. Makanan ini terbuat dari jeroan sapi yang direbus dalam waktu yang lama. Rebusan jeroan bercampur daging sapi ini kemudian diiris-iris, lalu dibumbui dengan bumbu yang diracik secara khusus. Biasanya, Coto makassar dihidangkan dalam mangkuk dan dinikmati dengan ketupat. Biasanya dijual secara terpisah, tergantung konsumen memilih campur antara jeroan dan daging, jeroan saja, atau daging saja.\n" +
                        "\n" +
                        "Coto Makassar diperkirakan telah ada semenjak masa Kerajaan Gowa, tepatnya di Kabupaten Gowa pada abad ke-16. Dahulu, hidangan coto bagian daging sapi sirloin dan tenderloin hanya disajikan untuk disantap oleh keluarga kerajaan. Sementara bagian jeroan disajikan untuk masyarakat kelas bawah atau abdi dalem pengikut kerajaan.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.gatang,
                "Gatang Kenari",
                "Maluku Utara",
                "Gatang kenari adalah salah satu makanan yang berasal dari Maluku utara. Makanan ini merupakan makanan yang dibuat dari bahan kepiting. Ya, meski namanya adalah kenari tapi makanan ini tidak dibuat dari kacang kenari melainkan dari kepiting kenari. Selain disebut dengan nama gatang kenari, gatang kenari ini juga bisa di sebut dengan nama Ketam kenari. Untuk membuat gatang kenari ini akan dibutuhkan kepiting kenari secara khusus. Hal ini disebabkan karena kepiting kenari dianggap sebagai salah satu satwa cerdas yang memiliki kemampuan tinggi untuk mengupas buah kelapa. Keahlian ini disebabkan karena buah kelapa memang merupakan makanan favorit dari kepiting kenari ini. Karena makanan favoritnya adalah buah kelapa, maka kepiting kenari dianggap memiliki daging yang lebih gurih dan lebih manis dibandingkan dengan kepiting lainnya.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.kaledo, "Kaledo", "Suleawesi Tengah",
                "Kaki Lembu Donggala atau yang lebih dikenal dengan nama Kaledo ini adalah makanan khas masyarakat Donggala yang terletak di provinsi Sulawesi Tengah, tepatnya di kota Palu. Makanan ini mirip dengan sup buntut, bedanya tulangnya dari kaki lembu dan disajikan bukan dengan nasi melainkan dengan ubi.\n" +
                        "\n" +
                        "Tulangnya itu sendiri adalah ruas tulang lutut yang masih penuh dengan sum-sum. Ada juga yang mengatakan, bahwa Kaledo berasal dari Bahasa Kaili, bahasa penduduk Palu. Ka artinya Keras, dan Ledo artinya Tidak, sehingga dapat diartikan \"tidak keras\".",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.ketoprak,
                "Ketoprak",
                "DKI Jakarta",
                "Ketoprak merupakan makanan khas Indonesia yang menggunakan ketupat sebagai bahan utamanya. Biasanya, ketoprak dijajakan menggunakan kereta dorong di jalan-jalan atau kaki lima. Makanan khas ini banyak ditemui di wilayah Jadetabek dan Kota Cirebon, Jawa Barat. Nama makanan ini berasal dari masa krisis tahun 1930-1931 dimana seorang pemain pentas seni Ketoprak di daerah Krukut Jakarta mencari penghasilan tambahan dengan berjualan tahu goreng menggunakan pikulan. Orang yang ingin membeli dagangannya memanggil dia \"Bang Ketoprak!\" karena ketenarannya sebagai pemain Ketoprak, sejak saat itu makanan tahu goreng yang dicampur tauge dan bumbu menjadi identik dengan sebutan Ketoprak.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.pempek, "Pempek", "Sumatera Selatan",
                "Pempek, mpek-mpek, atau empek-empek adalah makanan khas Palembang, Sumatera Selatan. Pempek terbuat dari daging tenggiri atau gabus yang digiling lembut, dicampur tepung kanji atau tepung sagu, serta dengan bahan-bahan lain seperti telur, bawang putih halus, penyedap rasa, dan garam. Pempek biasanya disajikan dengan kuah yang disebut cuko yang terasa asam, manis, dan pedas.\n" +
                        "\n" +
                        "Ada pula pempek panggang yang seperti namanya, yakni pempek yang dimasak dengan cara dipanggang. Pempek jenis ini biasanya disajikan dengan isian ebi atau sambal, memberikan cita rasa yang khas dan berbeda dari pempek pada umumnya. Tekstur bagian luarnya yang sedikit garing berpadu dengan rasa gurih dan aroma bakaran yang menggoda selera, menjadikannya favorit bagi pecinta kuliner khas Palembang yang ingin mencoba variasi pempek yang unik.\n" +
                        "\n" +
                        "Pada tahun 1880-an, para penjual pempek biasa memikul satu keranjang penuh sambil berjalan kaki berkeliling untuk menjajakan dagangannya. Saat ini pempek dijual oleh pedagang kaki lima maupun restoran. Para penjual pempek dapat ditemukan dengan mudah di beberapa daerah pada provinsi Sumatera Selatan hingga Bengkulu",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.rawon,
                "Rawon",
                "Jawa Timur",
                "Rawon (Aksara Jawa:ꦫꦮꦺꦴꦤ꧀) adalah masakan khas Indonesia yang berasal dari Ponorogo, Jawa Timur, yang berupa sup daging berkuah hitam dengan campuran bumbu khas yang menggunakan kluwek. Makanan ini telah berusia lebih dari 1.000 tahun. Rawon dari Ponorogo menyebar ke penjuru Jawa Timur dan dikenal sebagai masakan khas Jawa Timur.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.satelilit,
                "Sate Lilit",
                "Bali",
                "Sate Lilit adalah sebuah varian sate asal Bali. Sate ini terbuat dari daging babi, ikan, ayam, daging sapi, atau bahkan kura-kura yang dicincang, kemudian dicampur dengan parutan kelapa, santan, jeruk nipis, bawang merah, dan merica. Daging cincang yang telah berbumbu dilekatkan pada sebuah bambu atau tebu, kemudian dipanggang di atas arang. Tidak seperti sate lainnya yang dibuat dengan tusuk sate yang sempit dan tajam, tusuk sate lilit berbentuk datar dan lebar. Permukaan yang lebih luas memungkinkan daging cincang untuk melekat. Istilah lilit dalam bahasa Bali dan Indonesia berarti \"membungkus\", yang sesuai untuk cara pembuatan sate ini.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.taliwang, "Ayam Taliwang", "Nusa Tenggara Barat (NTB)",
                "Ayam Taliwang adalah makanan khas yang berasal dari Taliwang, Sumbawa Barat, Nusa Tenggara Barat. Makanan ini berbahan dasar daging ayam. Daging ayam yang disajikan berasal dari ayam kampung muda yang dibakar kemudian dibumbui dengan semacam saus yang bahannya antara lain cabai merah kering, bawang merah, bawang putih, tomat, terasi goreng, kencur, gula merah, dan garam. Makanan ini biasanya disajikan bersama makanan khas Lombok yang lain, misalnya plecing kangkung.\n" +
                        "\n" +
                        "Saat ini Ayam Bakar Taliwang semakin populer di seluruh penjuru Indonesia karena cita rasa pedas dan gurihnya yang menggoyang lidah. Ditambah lagi banyak berdiri rumah makan yang menyajikan menu Ayam Bakar Taliwang di seluruh Indonesia, termasuk Jakarta, tidak hanya di kota asalnya saja, Nusa Tenggara Barat (NTB). Adapun rumah makan Ayam Bakar Taliwang di Jakarta meliputi Rumah Makan Taliwang Bersaudara, Taliwang Bali, Ayam Bakar Taliwang Remaja, Ayam Bakar Taliwang Bang Tangu, Ayam Taliwang Lima Rasa, Ayam Bakar Taliwang Rinjani, dan banyak lagi.",
            )
        )
        makananList.add(
            ItemData(
                R.drawable.chaikwe,
                "Chai kwe",
                "Kalimantan Barat",
                "Chai kwe, juga dikenal sebagai choi pan, adalah kue tradisional Tionghoa yang populer di berbagai daerah di Indonesia, terutama di Pontianak. Kue ini memiliki kulit tipis yang terbuat dari tepung beras dan tepung tapioka, dengan berbagai pilihan isian seperti bengkuang, kucai, atau talas. Chai kwe biasanya dikukus dan disajikan dengan sambal cuka atau saus pedas",
            )
        )




        makananRecyclerView = findViewById(R.id.makananRV)
        makananRecyclerView.setHasFixedSize(true)
        makananRecyclerView.layoutManager = LinearLayoutManager(this)

        makananAdapter = MyAdapter(makananList)
        makananRecyclerView.adapter = makananAdapter
        makananAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("makanan", it)
            startActivity(intent)

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

//            val bottomNavi = findViewById<BottomNavigationView>(R.id.bottNav)
//            bottomNavi.setOnNavigationItemSelectedListener { menuItem ->
//                when (menuItem.itemId) {
//                    R.id.navUser -> {
//                        val intent = Intent(this, ProfileActivity::class.java)
//                        startActivity(intent)
//                        true
//                    }
//                    else -> false
//                }
//            }
        }
    }
}
