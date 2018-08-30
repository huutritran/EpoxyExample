package com.example.trith.epoxysample

import android.util.Log
import com.airbnb.epoxy.TypedEpoxyController
import com.example.trith.epoxysample.model.buttonSingle
import com.example.trith.epoxysample.model.dateInput
import com.example.trith.epoxysample.model.employerImage
import com.example.trith.epoxysample.model.textInput

/**
 * Created by tri.th on 29/08/2018.
 */
class MainController: TypedEpoxyController<List<String>>() {
    var testStr:String ="Demo"
    val TAG = "MainController"

    override fun buildModels(data: List<String>?) {
        employerImage {
            id("employerImage")
            listener {
                Log.d("employerImage: ",it)
            }
        }

        textInput {
            id("TEST INPUT")
            hint("TEST INPUT")
            text("ABC")
            listener { Log.d("TEST INPUT: ",it) }
        }

        buttonSingle {
            id("buttonSingle")
            buttonText("Button Single")
            listener {
                Log.d(TAG,"buttonSingle click")
            }
        }

        dateInput {
            id("dateInput")
            hint("INPUT DATE")
            onDateChange {
                Log.d(TAG,it)
            }
        }
    }
}