package com.vad.roomtest.screens.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.vad.roomtest.R
import com.vad.roomtest.room.dao.Work
import com.vad.roomtest.screens.listworksfragment.WorksViewModel

class AddWorkFragment(private val viewModel: WorksViewModel): DialogFragment() {

    private var isUpdate: Boolean = false
    private var workId: Int = 0

    fun setUpdate(isUpdate: Boolean) {
        this.isUpdate = isUpdate
    }

    fun setWorkId(workId: Int) {
        this.workId = workId
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View = inflater.inflate(R.layout.dialog_add_fragment, container, false)
        val work = v.findViewById<EditText>(R.id.addWorkName)
        val workPrice = v.findViewById<EditText>(R.id.addWorkPrice)
        v.findViewById<Button>(R.id.btnAdd).setOnClickListener {
            if (isUpdate) {
                viewModel.updateWork(Work(workId, work.text.toString(), workPrice.text.toString().toDouble()))
            } else {
                viewModel.addWork(Work(workId, work.text.toString(), workPrice.text.toString().toDouble()) )
            }
            dialog?.dismiss()
        }
        return v
    }


}