package com.example.axis2wheelersdesigns.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.axis2wheelersdesigns.R
import com.example.axis2wheelersdesigns.Utlis.InsertModl
import com.example.axis2wheelersdesigns.intentsAnimation.SecondIntentAct
import kotlinx.android.synthetic.main.animal_list_item.view.*

class SampleRecycless(val items : ArrayList<InsertModl>,val mcontext:Context) : RecyclerView.Adapter<SampleRecycless.ViewHss>() {

    lateinit var second :SecondIntentAct
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHss {
        return ViewHss(LayoutInflater.from(mcontext).inflate(R.layout.animal_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHss, position: Int) {
        holder?.one.text=items.get(position).one
        holder?.two.text=items.get(position).two
        holder?.three.text=items.get(position).three
        holder!!.linear_lyt.setOnClickListener( {
            second.Update(items as InsertModl)
        })
    }

    fun setCallBack(second :SecondIntentAct) {
        this.second = second
    }
    class ViewHss (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val one = view.mtext1
        val two = view.mtext2
        val three = view.mtext3
        val linear_lyt = view.linear_lyt
    }
}