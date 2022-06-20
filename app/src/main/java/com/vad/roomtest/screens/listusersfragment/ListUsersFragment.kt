package com.vad.roomtest.screens.listusersfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vad.roomtest.R
import com.vad.roomtest.screens.dialogfragments.AddUserFragment
import com.vad.roomtest.screens.listworksfragment.ViewModelFactory
import com.vad.roomtest.screens.listworksfragment.WorksViewModel

class ListUsersFragment : Fragment() {

    private val viewModel by lazy {
        val viewModelFactory = UserViewModelFactory(requireActivity().application)
        ViewModelProvider(requireActivity(), viewModelFactory).get(UsersViewModel::class.java)
    }

    private val adapter by lazy { AdapterUserList() }

    private val viewModelWorks by lazy {
        val viewModelFactory = ViewModelFactory(requireActivity().application)
        ViewModelProvider(requireActivity(), viewModelFactory).get(WorksViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_list_users, container, false)
        val recycle = v.findViewById<RecyclerView>(R.id.recyclerUserList)

        adapter.setOnClickOptionMenu(object : AdapterUserList.ClickOptionMenu {
            override fun onClickOptionMenu(view: View, position: Int) {
                val popupMenu = context?.let { PopupMenu(it, view) }
                popupMenu?.inflate(R.menu.option_menu_items)
                popupMenu?.setOnMenuItemClickListener {
                    return@setOnMenuItemClickListener when (it.itemId) {
                        R.id.optDelete -> {
                            viewModel.deleteUser(adapter.getUsers().get(position).user)
                            true
                        }
                        R.id.optUpdate -> true
                        else -> false
                    }
                }
                popupMenu?.show()
            }
        })

        recycle.layoutManager = LinearLayoutManager(requireContext())
        recycle.adapter = adapter

        viewModel.getUsers.observe(viewLifecycleOwner) {
            adapter.setUsers(it)
        }

        val dialog = AddUserFragment(viewModel, viewModelWorks)

        v.findViewById<FloatingActionButton>(R.id.btnAddUser).setOnClickListener {
            activity?.supportFragmentManager?.let { dialog.show(it, "Add user") }
        }

        return v
    }
}