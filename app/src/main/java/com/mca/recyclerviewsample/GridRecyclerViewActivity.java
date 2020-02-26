package com.mca.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GridRecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    ;
    private List<GridListItem> listItems;
    GridListItem listItem = null;  // class ListItem to store data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGrid);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        listItems = new ArrayList<>();
        // String url="https://api.androidhive.info/contacts/";
        String url="http://192.168.43.136/RecyclerViewJson.php";



        for (int i = 0; i < 20; i++)
        {


            // tmp hash map for single contact
            listItem = new GridListItem(i);
            listItems.add(listItem);

        }
        adapter = new GridAdapterClass(listItems, GridRecyclerViewActivity.this);

        recyclerView.setAdapter(adapter);






    }
}
