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
    Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        listItems = new ArrayList<>();
        ListItem listItem = null;  // class ListItem to store data

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            count=bundle.getInt("count");
            for(int i=1;i<=count;i++)
            {
                listItem = new ListItem(
                        i );
                listItems.add(listItem);
            }
        }



        adapter = new AdapterClass(listItems, RecyclerViewActivity.this);

        recyclerView.setAdapter(adapter);
    }
}
