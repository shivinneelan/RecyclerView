package com.mca.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RecyclerViewActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    ListItem listItem = null;  // class ListItem to store data

    Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        listItems = new ArrayList<>();
       // String url="https://api.androidhive.info/contacts/";
        String url="http://192.168.43.136/RecyclerViewJson.php";


        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        try{
             final JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            Toast.makeText(RecyclerViewActivity.this,response.toString(),Toast.LENGTH_LONG).show();

                            if (response != null) {
                                try {
                                    JSONObject jsonObj = response;
                                    Toast.makeText(RecyclerViewActivity.this,response.toString(),Toast.LENGTH_LONG).show();

                                    // Getting JSON Array node
                                    JSONArray contacts = jsonObj.getJSONArray("contacts");

                                    // looping through All Contacts
                                    for (int i = 0; i < contacts.length(); i++)
                                    {

                                        JSONObject c = contacts.getJSONObject(i);
                                        String id = c.getString("id");
                                        String name = c.getString("name");
                                        String email = c.getString("email");
                                        String address = c.getString("address");
                                        String gender = c.getString("gender");

                                        // Phone node is JSON Object
                                        //JSONObject phone = c.getJSONObject("phone");
                                        String mobile = c.getString("mobile");
                                        String home = c.getString("home");
                                        String office = c.getString("office");

                                        // tmp hash map for single contact
                                        listItem = new ListItem(id,name,email,address,gender,mobile,home,office );
                                        listItems.add(listItem);

                                    }
                                    adapter = new AdapterClass(listItems, RecyclerViewActivity.this);

                                    recyclerView.setAdapter(adapter);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                            else
                            {
                                Toast.makeText(RecyclerViewActivity.this,"JSON Null",Toast.LENGTH_LONG).show();

                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(RecyclerViewActivity.this,error.toString(),Toast.LENGTH_LONG).show();

                        }
                    }
            );

        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}
