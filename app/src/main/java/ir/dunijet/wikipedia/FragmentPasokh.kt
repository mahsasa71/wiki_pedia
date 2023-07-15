package ir.dunijet.wikipedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ir.dunijet.wikipedia.databinding.FragmentPasokhBinding


class FragmentPasokh : Fragment() {
    lateinit var binding: FragmentPasokhBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasokhBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = arguments
        if (bundle != null) {
            val javab2 = bundle.getString(key)
            if (javab2 == "gol") {
                Glide.with(this).load(R.color.white)
                    .into(view.findViewById(R.id.img_frag))




                Glide.with(this@FragmentPasokh).load(R.drawable.gol)
                    .into(binding.imgFrag)


            }
            if (bundle != null) {
                val javab2 = bundle.getString(key)
                if (javab2 == "mashin") {

                    Glide.with(this).load(R.color.white)
                        .into(view.findViewById(R.id.img_frag))

                    Glide.with(this@FragmentPasokh).load(R.drawable.mashin)
                        .into(binding.imgFrag)


                }
                if (bundle != null) {
                    val javab2 = bundle.getString(key)
                    if (javab2 == "toop") {
                        Glide.with(this).load(R.color.white)
                            .into(view.findViewById(R.id.img_frag))

                        Glide.with(this@FragmentPasokh).load(R.drawable.toop2)
                            .into(binding.imgFrag)


                    }
                    if (bundle != null) {
                        val javab2 = bundle.getString(key)
                        if (javab2 == "ghayegh") {
                            Glide.with(this).load(R.color.white)
                                .into(view.findViewById(R.id.img_frag))


                            Glide.with(this@FragmentPasokh).load(R.drawable.boat)
                                .into(binding.imgFrag)


                        }


                    }
                }
            }
        }
    }
}