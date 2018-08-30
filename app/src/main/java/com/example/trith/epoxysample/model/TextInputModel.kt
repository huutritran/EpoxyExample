package com.example.trith.epoxysample.model

import android.support.design.widget.TextInputLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.trith.epoxysample.KotlinHolder
import com.example.trith.epoxysample.R
import com.example.trith.epoxysample.onChange

/**
 * Created by tri.th on 30/08/2018.
 */
@EpoxyModelClass(layout = R.layout.item_input_text)
abstract class TextInputModel : EpoxyModelWithHolder<TextInputModel.Holder>() {
    @EpoxyAttribute
    lateinit var hint: String
    @EpoxyAttribute
    lateinit var text: String
    @EpoxyAttribute
    var listener: (String) -> Unit = {}

    override fun bind(holder: Holder) {
        holder.tvInput.hint = hint
        holder.tvInput.editText?.setText(text)
        holder.tvInput.editText?.onChange(listener)
    }

    class Holder : KotlinHolder() {
        val tvInput by bind<TextInputLayout>(R.id.tvInput)
    }
}