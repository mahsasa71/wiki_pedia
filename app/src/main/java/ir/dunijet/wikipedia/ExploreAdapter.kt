package ir.dunijet.wikipedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.dunijet.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(private val data:ArrayList<ItemPost>,  val itemEvent: ItemEvent) :RecyclerView.Adapter<ExploreAdapter.ExploreVH>(){
    lateinit var binding: ItemExploreBinding
    inner class ExploreVH(itemview:View):RecyclerView.ViewHolder(itemview){
        fun onbindView(itemPost: ItemPost){
            binding.txtDescription.text=itemPost.txt_description
            binding.txtDetail.text=itemPost.txt_detail
            binding.txtTitle.text=itemPost.txt_title
            Glide.with(itemView.context)
                .load(itemPost.img_url).into(binding.imgExplore)
            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)

                


            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreVH {
        binding= ItemExploreBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExploreVH(binding.root)

    }

    override fun getItemCount(): Int {
    return    data.size

    }

    override fun onBindViewHolder(holder: ExploreVH, position: Int) {
        holder.onbindView(data[position])

    }
}