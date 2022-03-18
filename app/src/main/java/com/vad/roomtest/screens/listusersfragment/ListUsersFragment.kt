package com.vad.roomtest.screens.listusersfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vad.roomtest.R
import com.vad.roomtest.screens.dialogfragments.AddUserFragment

class ListUsersFragment : Fragment() {

    private val viewModel by lazy {
        val viewModelFactory = UserViewModelFactory(requireActivity().application)
        ViewModelProvider(requireActivity(), viewModelFactory).get(UsersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_list_users, container, false)
        val recycle = v.findViewById<RecyclerView>(R.id.recyclerUserList)
        val adapter = AdapterUserList()

        recycle.layoutManager = LinearLayoutManager(requireContext())
        recycle.adapter = adapter

        viewModel.getUsers.observe(viewLifecycleOwner) {
            adapter.setUsers(it)
        }

        val dialog = AddUserFragment(viewModel)
        return v
    }
}