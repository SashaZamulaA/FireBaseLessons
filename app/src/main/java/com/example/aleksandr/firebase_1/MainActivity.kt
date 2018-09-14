package com.example.aleksandr.firebase_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//   lateinit var mRef: DatabaseReference
//    lateinit var mUserList: ListView
    var mUserName: ArrayList<String> = ArrayList()
//    var mKeys: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//mUserList = findViewById(R.id.user_list)
       val mRef= FirebaseDatabase.getInstance().reference
        val arrayAdapter = ArrayAdapter(this, R.layout.item_my_list, mUserName)
        user_list.adapter = arrayAdapter

        mRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                val value = dataSnapshot.value.toString()

                mUserName.add(value)
//                val key = dataSnapshot.key.toString()
//                mKeys.add(key)
                arrayAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, p1: String?) {
//                val value = dataSnapshot.value.toString()
//                val key = dataSnapshot.key
//                val index =  mKeys.indexOf(key)
//                mUserName.set(index, value)
//                arrayAdapter.notifyDataSetChanged()

            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }
        })
    }
}
