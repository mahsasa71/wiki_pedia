package ir.dunijet.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ir.dunijet.wikipedia.databinding.ActivityMainActivityanimBinding

class MainActivityanim : AppCompatActivity() {
    lateinit var binding:ActivityMainActivityanimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainActivityanimBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this)
            .load(R.drawable.mashinjolo2)
            .transform(RoundedCorners(45))


            .into(binding.mashin)




        binding.btntoop1.setOnClickListener {
            rotateAnim()
        }
        binding.btnGhalb.setOnClickListener {
            tapesh()
        }
        binding.btnMashin.setOnClickListener {
            gasdadan()


        }

    }
    fun rotateAnim(){
        val anim=RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
          anim.duration=1000
        anim.fillAfter=true
        anim.repeatCount=5
        binding.toop1.startAnimation(anim)
    }
    fun tapesh(){
        val anim=AlphaAnimation(1f,0f)
        anim.duration=500
        anim.repeatCount=5
        binding.ghalb.startAnimation(anim)

    }
    fun gasdadan(){
        val anim=TranslateAnimation(0f,0f,0f,1000f)
        anim.duration=1000
        anim.repeatCount=8
        anim.setInterpolator (AccelerateDecelerateInterpolator())
        binding.mashin.startAnimation(anim)
    }
}