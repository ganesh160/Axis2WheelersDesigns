package com.example.axis2wheelersdesigns.creatingRecyclerWithFilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.axis2wheelersdesigns.R
import kotlinx.android.synthetic.main.activity_recycler_view_filters.*

class RecyclerViewFilters : AppCompatActivity() ,ListenerClickss {

    override fun clickss(movieModel: ModelsMOvie) {
        //adapter.callBackMeths(this)
        Toast.makeText(this,"clicked"+movieModel.mobile,Toast.LENGTH_SHORT).show()
    }

    private lateinit var adapter:MoviessAdapter
    lateinit var movieList:ArrayList<ModelsMOvie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_filters)
        initParameters()
        listeners()
    }
    fun initParameters(){
        movieList=ArrayList()


        movieList.add(ModelsMOvie("Sample","MaghaDheera"))
        movieList.add(ModelsMOvie("sample2","Super"))
        movieList.add(ModelsMOvie("varak","Chennai Shopping Mall"))

         adapter=MoviessAdapter(this,movieList)
        adapter.callBackMeths(this)
        recycler_view_movies.adapter=adapter
        recycler_view_movies.layoutManager=GridLayoutManager(this,2)


        image_view_search.setOnClickListener({
            edit_text.visibility= View.VISIBLE
        })

        //edit_text
        //image_view_search
        //recycler_view
    }

    override fun onStart() {
        super.onStart()
        initParameters()
        listeners()
    }
    fun listeners(){

        edit_text.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if (p0!!.toString().equals("",ignoreCase = true)||p0!!.toString().equals("null",ignoreCase = true)) {
                    adapter=MoviessAdapter(this@RecyclerViewFilters,movieList)
                    adapter.callBackMeths(this@RecyclerViewFilters)
                    recycler_view_movies.adapter=adapter
                    recycler_view_movies.layoutManager=GridLayoutManager(this@RecyclerViewFilters,2)

                }else{
                    adapter.filter.filter(p0!!.toString())
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }
}
