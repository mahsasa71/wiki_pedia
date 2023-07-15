package ir.dunijet.wikipedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.dunijet.wikipedia.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFab.setOnClickListener {
            val intentCall=Intent(Intent.ACTION_VIEW, Uri.parse("tel:0900000000"))
            startActivity(intentCall)
        }

    }
}