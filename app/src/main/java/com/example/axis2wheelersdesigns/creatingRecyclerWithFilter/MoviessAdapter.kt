package com.example.axis2wheelersdesigns.creatingRecyclerWithFilter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.movies_list.view.*

import android.R.attr.name
import com.example.axis2wheelersdesigns.R


class MoviessAdapter(var con:Context,var lists:ArrayList<ModelsMOvie>) :RecyclerView.Adapter<MoviessAdapter.ViewHolderss>(),Filterable
{

    lateinit var acts:RecyclerViewFilters
    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val results = FilterResults()        // Holds the results of a filtering operation in values
                val FilteredArrList = ArrayList<ModelsMOvie>()

                if (lists == null) {
                    lists =
                         ArrayList<ModelsMOvie>() // saves the original data in mOriginalValues
                }

                if (p0 == null || p0.length === 0) {

                    // set the Original result to return
                    results.count = lists.size
                    results.values = lists
                } else {
                    var p0 = p0.toString().toLowerCase()
                    for (i in 0 until lists.size) {
                        val data = lists.get(i).name
                        if (data.toLowerCase().startsWith(p0.toString())) {
                            FilteredArrList.add(
                                ModelsMOvie(
                                    lists.get(i).name,
                                    lists.get(i).mobile
                                )
                            )
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size
                    results.values = FilteredArrList
                }
                return results
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                lists= p1!!.values as ArrayList<ModelsMOvie>
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviessAdapter.ViewHolderss {
        return ViewHolderss(LayoutInflater.from(con).inflate(R.layout.movies_list, parent, false))
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: MoviessAdapter.ViewHolderss, position: Int) {

        val data: ModelsMOvie = lists.get(position)
        holder.one.setText(lists.get(position).name)
        holder.two.setText(lists.get(position).mobile)

        holder.card_view_mlist.tag = data
        holder.card_view_mlist.setOnClickListener({
            acts.clickss(it.tag as ModelsMOvie)
        })
    }

    class ViewHolderss(view:View):RecyclerView.ViewHolder(view){

        val one = view.text_one
        val two = view.text_two
        val card_view_mlist = view.card_view_mlist

    }


    fun callBackMeths(ss:RecyclerViewFilters){
        this.acts=ss
    }

}