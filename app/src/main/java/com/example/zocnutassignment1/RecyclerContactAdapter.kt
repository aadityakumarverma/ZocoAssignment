package com.example.farmserv

import java.util.ArrayList
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zocnutassignment1.CardViewerActivity
import com.example.zocnutassignment1.ContactModal
import com.example.zocnutassignment1.ItemViewClick
import com.example.zocnutassignment1.R
import com.example.zocnutassignment1.databinding.ContactLayoutBinding

class RecyclerContactAdapter(val context: Context, val arrContact: ArrayList<ContactModal>, val click: ItemViewClick) : RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>(){

    /*var onItemClick : ((ProductModel) -> Unit)? = null*/
    lateinit var binding : ContactLayoutBinding

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgContact = itemView.findViewById<ImageView>(R.id.ivContactPic)
        val txtContactName = itemView.findViewById<TextView>(R.id.tvContactName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrContact[position].apply {
            holder.imgContact.setImageResource(img)
            holder.txtContactName.text = name
        }

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,CardViewerActivity::class.java))
        }

    }


}