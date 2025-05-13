package com.example.umc8th

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val context: Context, private val userList:ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>(){


    // 화면 설정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.user_layout, parent, false)

        return UserViewHolder(view)
    }

    // 값 갯수 리턴
    override fun getItemCount(): Int { return userList.size }

    // 데이터 설정
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user: User = userList[position]

        holder.nameText.text = user.userName
        holder.ageText.text = user.userAge
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val nameText: TextView = itemView.findViewById(R.id.name_text)
        val ageText: TextView = itemView.findViewById(R.id.age_text)
    }
}