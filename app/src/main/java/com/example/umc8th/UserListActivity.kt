package com.example.umc8th

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc8th.databinding.ActivityUserListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserListActivity : AppCompatActivity() {

    lateinit var binding: ActivityUserListBinding
    lateinit var dao: UserDao
    lateinit var adapter: UserAdapter
    lateinit var userList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // userList 초기화
        userList = ArrayList()

        // dao 초기화
        dao = UserDao()

        // adapter 초기화
        adapter = UserAdapter(this, userList)

        // recyclerView 초기화
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // 사용자 정보 가져오기
        getUserList()
    }

    private fun getUserList(){

        dao.getUserList()?.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for(dataSnapshot in snapshot.children){

                    val user = dataSnapshot.getValue(User::class.java)

                    // 키값 가져오기
                    val key = dataSnapshot.key

                    // 사용자 정보에 키 값 담기
                    user?.userKey = key.toString()

                    // 리스트에 담기
                    if(user != null){
                        userList.add(user)
                    }
                }

                // 데이터 적용
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}