package ir.dunijet.wikipedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import ir.dunijet.wikipedia.databinding.FragmentPasokhBinding
import ir.dunijet.wikipedia.databinding.FragmentTranslateBinding
import kotlin.random.Random

const val key="data"


class FragmentTranslate : Fragment() {
    lateinit var binding: FragmentTranslateBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTranslateBinding.inflate(layoutInflater)
        return(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnSoal.setOnClickListener {

            val list = listOf("ماشین", "توپ", "گل", "قایق")
            val randomlist = list.random()

            binding.txtRandom.text = randomlist


        }
        binding.btnPakidan.setOnClickListener {
            binding.txtRandom.text = ""
            binding.edtpasokh.setText("")
//            Glide.with(this).load(R.color.white)
//                .into(view.findViewById(R.id.img_frag))


        }


        binding.btnJavab.setOnClickListener {
            val javab = binding.edtpasokh.text.toString()
            val soal = binding.txtRandom.text.toString()
            if (javab == "flower" && soal == "گل")
            {
                Toast.makeText(context, "خیلی باهوشی عزیزم", Toast.LENGTH_LONG).show()
                val bundle=Bundle()
                bundle.putString(key,"gol")
                val fragment=FragmentPasokh()
                fragment.arguments=bundle
                val transaction=childFragmentManager.beginTransaction()
                transaction.add(R.id.contaner_2,fragment)
                transaction.commit()
            }
            else if (javab == "car" && soal == "ماشین")

            {
                Toast.makeText(context, "خیلی باهوشی عزیزم", Toast.LENGTH_LONG).show()
                val bundle=Bundle()
                bundle.putString(key,"mashin")
                val fragment=FragmentPasokh()
                fragment.arguments=bundle
                val transaction=childFragmentManager.beginTransaction()
                transaction.add(R.id.contaner_2,fragment)
                transaction.commit()
            }
           else if (javab == "ball" && soal == "توپ")

            {
                Toast.makeText(context, "خیلی باهوشی عزیزم", Toast.LENGTH_LONG).show()
                val bundle=Bundle()
                bundle.putString(key,"toop")
                val fragment=FragmentPasokh()
                fragment.arguments=bundle
                val transaction=childFragmentManager.beginTransaction()
                transaction.add(R.id.contaner_2,fragment)
                transaction.commit()
            }
            else if (javab == "boat" && soal == "قایق")

            {
                Toast.makeText(context, "خیلی باهوشی عزیزم", Toast.LENGTH_LONG).show()
                val bundle=Bundle()
                bundle.putString(key,"ghayegh")
                val fragment=FragmentPasokh()
                fragment.arguments=bundle
                val transaction=childFragmentManager.beginTransaction()
                transaction.add(R.id.contaner_2,fragment)
                transaction.commit()
            }
         else{
                Toast.makeText(context, "بیشتر دقت کنید", Toast.LENGTH_SHORT).show()
         }


        }



    }
}