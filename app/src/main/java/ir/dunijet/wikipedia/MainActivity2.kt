package ir.dunijet.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import ir.dunijet.wikipedia.databinding.ActivityMain2Binding
import kotlin.math.log

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.collapsing.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val datapost=intent.getParcelableExtra<ItemPost>(KEY)
        if (datapost!=null){
            showdata(datapost)

        }


    }

    private fun showdata(itemPost: ItemPost) {
        Glide.with(this).load(itemPost.img_url).into(binding.imgMain2)
        binding.txtDetailTitle.text=itemPost.txt_title
        binding.txtDetailText.text=itemPost.txt_description
        binding.txtDetailSub.text=itemPost.txt_detail
        binding.fab.setOnClickListener {
            val url="https://en.wikipedia.org/wiki/Main_Page"
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse(url))


        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }

        return true
    }
}