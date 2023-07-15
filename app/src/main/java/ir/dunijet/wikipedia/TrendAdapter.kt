package ir.dunijet.wikipedia

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

import ir.dunijet.wikipedia.databinding.ItemTrendBinding

class TrendAdapter(private val data:ArrayList<ItemPost>, val itemEvent: ItemEvent):RecyclerView.Adapter<TrendAdapter.TrendVH>() {
    lateinit var binding: ItemTrendBinding
    inner class TrendVH(itemview:View):RecyclerView.ViewHolder(itemview){
      fun  onbindViews(itemPost: ItemPost){
          Glide.with(itemView.context).load(itemPost.img_url)
              .transform(RoundedCorners(16))

              .into(binding.imageTrend)
          binding.txtDescrptionTrend.text=itemPost.txt_detail
          binding.txtTitleTrend.text=itemPost.txt_title
          binding.txtInsight.text=itemPost.insight
          binding.txtShomare.text=(adapterPosition+1).toString()

          itemView.setOnClickListener{
              itemEvent.onItemClicked(itemPost)


          }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendVH {
        binding= ItemTrendBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TrendVH(binding.root)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TrendVH, position: Int) {
        holder.onbindViews(data[position])

    }
}