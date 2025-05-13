package com.example.umc8th

import android.graphics.Canvas
import android.os.Bundle
import android.widget.Toast
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umc8th.databinding.ActivityUserListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

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

        // 사용자 삭제 기능
        ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                // 해당 위치 값 변수에 담기
                val position = viewHolder.bindingAdapterPosition

                when(direction){

                    ItemTouchHelper.LEFT ->{
                        val key = userList[position].userKey

                        dao.userDelete(key).addOnSuccessListener { // 성공 이벤트
                            Toast.makeText(this@UserListActivity, "삭제 성공",
                                    Toast.LENGTH_SHORT).show()
                        }.addOnFailureListener { // 삭제 이벤트
                            Toast.makeText(this@UserListActivity, "삭제 실패: ${it.message}",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                }//when
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                // 스와이프 꾸미기
                RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder,
                    dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(Color.RED)
                    .addSwipeLeftActionIcon(R.drawable.ic_delete)
                    .addSwipeLeftLabel("삭제")
                    .setSwipeLeftLabelColor(Color.WHITE)
                    .create()
                    .decorate()


                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }

        }).attachToRecyclerView(binding.recyclerView)
    }

    private fun getUserList(){

        dao.getUserList()?.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                // 리스트 초기화
                userList.clear()

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