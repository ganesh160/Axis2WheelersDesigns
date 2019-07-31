package com.example.axis2wheelersdesigns.playStoreRecyclerVIews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.axis2wheelersdesigns.R;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.ViewHrs> {
    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context mContext,ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SectionListDataAdapter.ViewHrs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card, null);
        ViewHrs mh = new ViewHrs(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull SectionListDataAdapter.ViewHrs holder, int position) {
        SingleItemModel singleItem = itemsList.get(position);
        holder.tvTitle.setText(singleItem.getName());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHrs extends RecyclerView.ViewHolder {
        protected TextView tvTitle;

        protected ImageView itemImage;

        public ViewHrs(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
        }
    }
}
