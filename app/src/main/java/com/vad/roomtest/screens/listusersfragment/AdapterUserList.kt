package com.vad.roomtest.screens.listusersfragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vad.roomtest.R
import com.vad.roomtest.room.dao.User
import com.vad.roomtest.room.dao.UserAndWork

class AdapterUserList: RecyclerView.Adapter<AdapterUserList.ViewHolderUsers>() {

    private var users: List<UserAndWork> = ArrayList<UserAndWork>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(users: List<UserAndWork>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsers {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolderUsers(view)
    }

    override fun onBindViewHolder(holder: ViewHolderUsers, position: Int) {
        holder.userName.text = users.get(position).user.name
        holder.workName.text = users.get(position).work.nameWork
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolderUsers(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName = itemView.findViewById<TextView>(R.id.userNameText)
        val workName = itemView.findViewById<TextView>(R.id.workNameText)
    }
}