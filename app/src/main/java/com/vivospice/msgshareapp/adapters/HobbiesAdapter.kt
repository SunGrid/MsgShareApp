package com.vivospice.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.vivospice.msgshareapp.models.Hobby
import com.vivospice.msgshareapp.R
import com.vivospice.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = HobbiesAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)                               //
    }

    override fun getItemCount(): Int {                  //length of hobbies List
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let{
                    context.showToast(currentHobby!!.title + "Clicked !")
                    //Toast.makeText(context, currentHobby!!.title + "Clicked !", Toast.LENGTH_SHORT).show()
                }
 }

            itemView.imgShare.setOnClickListener {

                currentHobby?.let{
                    val message: String = "My hobby is: " + currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Share to : "))
                    //startActivity is the method of context so must put context word before it
                }
            }
        }

        // Hobby? Allows this reference to hold null eliminating NullPointerExceptions from code
        fun setData(hobby: Hobby?, pos: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title
                //title is from Model.kt, data class Hobby(var title: String)
            }

            this.currentHobby = hobby
            this.currentPosition = pos

        }
    }
}