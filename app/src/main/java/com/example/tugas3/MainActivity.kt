package com.example.tugas3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas3.databinding.ActivityMainBinding
import com.example.tugas3.databinding.ActivityMainBinding.inflate
import com.google.firebase.auth.FirebaseAuth
import org.intellij.lang.annotations.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding.btLogin.setOnClickListener {
            val intentHome = Intent(this, Home::class.java)
            startActivity(intentHome)
        }
        binding.tvRegister.setOnClickListener {
            val intentRegister = Intent(this, Register::class.java)
            startActivity(intentRegister)
        }
        binding.tvForgotPass.setOnClickListener {
            val intentForgotPass = Intent(this, ForgotPass::class.java)
            startActivity(intentForgotPass)
        }

        binding.btLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtpass.text.toString()

            if (email.isEmpty()) {
                binding.edtEmail.error = "Masukan Email"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmail.error = "Email Tidak Valid"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6) {
                binding.edtpass.error = "Kata Sandi Harus Lebih Dari 6 Karakter"
                binding.edtpass.requestFocus()
                return@setOnClickListener
            }
            loginUser(email, password)
        }

    }

    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Intent(this, Home::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            } else {
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onStart(){
        super.onStart()
        if (firebaseAuth.currentUser != null){
            Intent(this, Home::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}

