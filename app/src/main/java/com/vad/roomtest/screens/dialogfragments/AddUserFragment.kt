package com.vad.roomtest.screens.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.DialogFragment
import com.vad.roomtest.R
import com.vad.roomtest.room.dao.User
import com.vad.roomtest.screens.listusersfragment.UsersViewModel
import com.vad.roomtest.screens.listworksfragment.WorksViewModel

class AddUserFragment(private val viewModel: UsersViewModel, private val viewModelWorks: WorksViewModel) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dialog_add_user, container, false)
        var idWork = 0
        val spinner = v.findViewById<Spinner>(R.id.workListSpinner)
        val nameText = v.findViewById<EditText>(R.id.nameUser)

        viewModelWorks.getWorks.observe(viewLifecycleOwner) {
            val works = it.map { it.nameWork } as ArrayList<String>

            val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, works.toArray())
            spinner.adapter = arrayAdapter
            spinner.setSelection(1)

            println(works.toString())
            spinner.onItemSelectedListener = object: OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    idWork = p2
                    println(p2)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

            v.findViewById<Button>(R.id.addUserAndWorkBtn).setOnClickListener {
                println(idWork)
                viewModel.addUser(User(0, nameText.text.toString(), idWork))
                dialog?.dismiss()
            }

        }

        return v
    }
}