package com.mca.recyclerviewsample;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    Cursor cursor;

    public RecyclerviewAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final ListItem listItem = listItems.get(i);
        viewHolder.screenname.setText(listItem.getScreenName());
        viewHolder.m1.setText(listItem.getScreenM1());
        viewHolder.m2.setText(listItem.getScreenM2());
        viewHolder.m3.setText(listItem.getScreenM3());
        viewHolder.m4.setText(listItem.getScreenM4());
        viewHolder.booking.setText(listItem.getScreenBooking());



        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(context,"you clicked"+ i, Toast.LENGTH_SHORT).show();

                ListItem list=listItems.get(i);
                String ownerid=list.getid();
                Toast.makeText(context,"you clicked"+ ownerid, Toast.LENGTH_SHORT).show();



            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        // initialise card items heree========================
        public TextView textDesc,screenname,m1,m2,m3,m4,booking;
        ImageView imageView;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            screenname=(TextView) itemView.findViewById(R.id.screenname);
            //   textDesc = (TextView) itemView.findViewById(R.id.textView5);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            m1=(TextView) itemView.findViewById(R.id.m1);
            m2=(TextView) itemView.findViewById(R.id.m2);
            m3=(TextView) itemView.findViewById(R.id.m3);
            m4=(TextView) itemView.findViewById(R.id.m4);
            booking=(TextView) itemView.findViewById(R.id.booking);
            imageView=(ImageView) itemView.findViewById(R.id.screenimage);
        }
    }
}