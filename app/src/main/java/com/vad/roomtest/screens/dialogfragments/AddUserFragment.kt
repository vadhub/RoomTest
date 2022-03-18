package com.vad.roomtest.screens.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.vad.roomtest.R
import com.vad.roomtest.screens.listusersfragment.UsersViewModel

class AddUserFragment(private val viewModel: UsersViewModel) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_add_user, container, false)

        val spinner = v.findViewById<Spinner>(R.id.workListSpinner)
        var works = ArrayList<String>()

        viewModel.getUsers.observe(viewLifecycleOwner) {
            works = it.map { it.work.nameWork } as ArrayList<String>
        }

        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, works.toArray())
        spinner.adapter = arrayAdapter

        v.findViewById<Button>(R.id.addUserAndWorkBtn).setOnClickListener {

        }

        return v
    }
}