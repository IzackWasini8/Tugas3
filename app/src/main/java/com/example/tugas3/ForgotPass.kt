package com.example.tugas3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas3.databinding.ActivityForgotPassBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPass : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_pass)
        binding = ActivityForgotPassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tvLogin.setOnClickListener{
            val intentMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentMainActivity)
        }
        binding.btnReset.setOnClickListener{
            val email = binding.editEmail.text.toString()

            if (email.isEmpty()){
                binding.editEmail.error = "Email Harus Diisi"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editEmail.error = "Email Tidak Valid"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this, "Cek Email Untuk Reset Kata Sandi", Toast.LENGTH_SHORT).show()
                    Intent(this, MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}