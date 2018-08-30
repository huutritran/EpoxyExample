package com.example.trith.epoxysample.model

import android.widget.Button
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.trith.epoxysample.KotlinHolder
import com.example.trith.epoxysample.R

/**
 * Created by tri.th on 30/08/2018.
 */
@EpoxyModelClass(layout = R.layout.item_button_single)
abstract class ButtonSingleModel : EpoxyModelWithHolder<ButtonSingleModel.Holder>() {
    @EpoxyAttribute
    lateinit var listener:() -> Unit
    @EpoxyAttribute
    lateinit var buttonText: String

    override fun bind(holder: Holder) {
        holder.btnSingle.text = buttonText
        holder.btnSingle.setOnClickListener { listener.invoke() }
    }

    class Holder : KotlinHolder() {
        val btnSingle by bind<Button>(R.id.btnSingle)
    }
}