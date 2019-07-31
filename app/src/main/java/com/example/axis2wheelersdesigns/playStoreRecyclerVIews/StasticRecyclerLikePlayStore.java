package com.example.axis2wheelersdesigns.playStoreRecyclerVIews;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.axis2wheelersdesigns.R;

import java.util.ArrayList;

public class StasticRecyclerLikePlayStore extends AppCompatActivity {
    RecyclerView recycler_view;
    ArrayList<SectionDataModel> allSampleData;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stastic_recycler_like_play_store);
        recycler_view=findViewById(R.id.recycler_view);

        allSampleData = new ArrayList<SectionDataModel>();

        createDummyData();


        recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter( allSampleData,this);

        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recycler_view.setAdapter(adapter);
    }
    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }
}
