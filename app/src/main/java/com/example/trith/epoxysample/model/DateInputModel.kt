package com.example.trith.epoxysample.model

import android.app.DatePickerDialog
import android.support.design.widget.TextInputLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.trith.epoxysample.KotlinHolder
import com.example.trith.epoxysample.R
import java.util.*

/**
 * Created by tri.th on 30/08/2018.
 */
@EpoxyModelClass(layout = R.layout.item_input_date)
abstract class DateInputModel : EpoxyModelWithHolder<DateInputModel.Holder>() {
    @EpoxyAttribute
    var hint: String = ""
    @EpoxyAttribute
    var date: String = ""
    @EpoxyAttribute
    var onDateChange: (String) -> Unit = {}

    override fun bind(holder: Holder) {
        holder.tvDateInput.hint = hint
        holder.tvDateInput.editText?.setText(date)
        holder.tvDateInput.editText?.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(it.context,
                    { datePicker, tempYear, tempMon, tempDate ->
                        val string = "$tempDate/$tempMon/$tempYear"
                        holder.tvDateInput.editText?.setText(string)
                        onDateChange(string)
                    }, year, month, day)
            datePickerDialog.show()
        }
    }

    class Holder : KotlinHolder() {
        val tvDateInput by bind<TextInputLayout>(R.id.tvInputDate)
    }

}