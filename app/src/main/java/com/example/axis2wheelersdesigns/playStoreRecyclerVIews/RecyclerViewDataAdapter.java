package com.example.axis2wheelersdesigns.playStoreRecyclerVIews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.axis2wheelersdesigns.R;

import java.util.ArrayList;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ViewHss>
{
    private ArrayList<SectionDataModel> dataList;
    private Context mContext;

    public RecyclerViewDataAdapter(ArrayList<SectionDataModel> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public RecyclerViewDataAdapter.ViewHss onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        ViewHss mh = new ViewHss(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewDataAdapter.ViewHss holder, int position) {

        final String sectionName = dataList.get(position).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(position).getAllItemsInSection();

        holder.itemTitle.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(itemListDataAdapter);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHss extends RecyclerView.ViewHolder {

        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;
        protected Button btnMore;

        public ViewHss(@NonNull View itemView) {

            super(itemView);
            this.itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) itemView.findViewById(R.id.recycler_view_list);
            this.btnMore= (Button) itemView.findViewById(R.id.btnMore);

        }
    }
}
