package com.example.zocnutassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farmserv.RecyclerContactAdapter
import com.example.zocnutassignment1.databinding.ActivityAllContactsBinding

class AllContactsActivity : AppCompatActivity(), ItemViewClick {
    lateinit var binding: ActivityAllContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAllContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }

        val contatctArray = ArrayList<ContactModal>()



        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"Aaditya Kumar Verma"))
        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"Saurabh Shukla"))
        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"CarryMinati"))
        contatctArray.add(ContactModal(R.drawable.aaditya_pic,"Irfan Khan"))

        val recyclerContactAdapter = RecyclerContactAdapter(this,contatctArray,this)
        binding.rvContactList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvContactList.adapter = recyclerContactAdapter
    }

    override fun viewItems(name: String, type: String, price: Int) {

    }
}