package com.vad.roomtest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.vad.roomtest.R
import com.vad.roomtest.room.dao.Work

class DialogAddFragment: DialogFragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(WorksViewModel::class.java)
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
            viewModel.addWork(Work(0, work.text.toString(), workPrice.text.toString().toDouble()) )
           dialog?.dismiss()
        }
        return v
    }
}