package ir.dunijet.wikipedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.dunijet.wikipedia.databinding.FragmentProfileBinding


class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnmore.setOnClickListener {
            val intent=Intent(context,MainActivity3::class.java)
            startActivity(intent)
        }
        binding.btnEmail.setOnClickListener {
            val intentweb=Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com"))
            startActivity(intentweb)
        }

    }


}