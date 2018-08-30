package com.example.trith.epoxysample

import android.widget.TextView
import com.airbnb.epoxy.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by tri.th on 29/08/2018.
 */
@EpoxyModelClass(layout = R.layout.layout_demo)
abstract class TextModel :EpoxyModelWithHolder<TextModel.Holder>(){
    @EpoxyAttribute lateinit var text:String

    override fun bind(holder: Holder) {
        holder.titleView.text = text
        holder.titleView.onClick {
           it?.context?.alert {
               title = "TEST DIALOG"
               message = "THIS IS MESSAGE"
               positiveButton("OK",{
                   holder.titleView.text = "TEST CHANGED"
               })
           }?.show()
        }
    }
    class Holder : KotlinHolder(){
        val titleView by bind<TextView>(R.id.tvTitle)
    }

}