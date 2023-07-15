package ir.dunijet.wikipedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ItemPost (
    val img_url:String,
    val txt_title:String,
    val txt_detail:String,
    val txt_description:String,
    val isterended:Boolean,
    val insight:String
        ) : Parcelable