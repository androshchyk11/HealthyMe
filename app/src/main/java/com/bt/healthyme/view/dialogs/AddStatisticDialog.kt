package com.bt.healthyme.view.dialogs

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.bt.healthyme.R
import com.bt.healthyme.model.StatisticModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_add_statistic.*
import java.text.SimpleDateFormat
import java.util.*

class AddStatisticDialog : BaseBottomSheetDialog(){

    companion object {

        fun show(
            activity: Activity,
            fm: FragmentManager,
            callback: (statistic: StatisticModel) -> Unit
        ) {
            val dialog = AddStatisticDialog()
            dialog.callback = callback
            dialog.show(fm, dialog.tag)
        }
    }
    private var callback: (teachersList: StatisticModel) -> Unit = {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val height = activity?.window?.windowManager?.getWidthAndHeight()?.second
        return inflater.inflate(R.layout.dialog_add_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            (d.findViewById<View>(R.id.design_bottom_sheet))?.let {
                BottomSheetBehavior.from(it)
                    .setState(BottomSheetBehavior.STATE_EXPANDED)

            }
        }


        setupClicks()

    }

    private fun setupClicks(){
        doneButton.setOnClickListener{
            val sdf = SimpleDateFormat("yyyy.MM.dd")
            val currentDate: String = sdf.format(Date())
            callback.invoke(
                StatisticModel(
                    date = currentDate,
                    height = heightEditText.text.toString(),
                    weight = weightEditText.text.toString(),
                    age = ageEditText.text.toString()
                )
            )
            dialog?.dismiss()
        }
    }
}