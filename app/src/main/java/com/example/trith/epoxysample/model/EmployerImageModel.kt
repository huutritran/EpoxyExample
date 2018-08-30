package com.example.trith.epoxysample.model

import android.widget.ImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.trith.epoxysample.KotlinHolder
import com.example.trith.epoxysample.R
import com.example.trith.epoxysample.loadImage

/**
 * Created by tri.th on 30/08/2018.
 */
@EpoxyModelClass(layout = R.layout.item_employer_image)
abstract class EmployerImageModel : EpoxyModelWithHolder<EmployerImageModel.Holder>() {
    @EpoxyAttribute
    var avatar: Any? = null
    @EpoxyAttribute
    var banner: Any? = null
    @EpoxyAttribute
    lateinit var listener: (String) -> Unit

    object Action {
        val ADD_AVATAR = "ADD_AVATAR"
        val ADD_BANNER = "ADD_BANNER"
    }

    override fun bind(holder: Holder) {
        holder.imgAvatar.loadImage(avatar)
        holder.imgBanner.loadImage(banner)
        holder.imgAddAvatar.setOnClickListener { listener(Action.ADD_AVATAR) }
        holder.imgAddBanner.setOnClickListener { listener(Action.ADD_BANNER) }
    }

    class Holder : KotlinHolder() {
        val imgAvatar by bind<ImageView>(R.id.imgAvatar)
        val imgBanner by bind<ImageView>(R.id.imgBanner)
        val imgAddAvatar by bind<ImageView>(R.id.imgAddAvatar)
        val imgAddBanner by bind<ImageView>(R.id.imgAddBanner)
    }
}