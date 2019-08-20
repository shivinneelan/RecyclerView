package com.mca.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        listItems = new ArrayList<>();
        ListItem listItem = null;

        for(int i=0;i<10;i++)
        {
            listItem = new ListItem(
                    "1","","","","","","","" );
            listItems.add(listItem);
        }

        listItems.add(listItem);
        adapter = new RecyclerviewAdapter(listItems, RecyclerViewActivity.this);
        recyclerView.setAdapter(adapter);
    }
}
