package com.mca.recyclerviewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public AdapterClass(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view,viewGroup,false);
        return new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {

        final ListItem listItem = listItems.get(i);
        viewHolder.id.setText("ID : "+listItem.getId());
        viewHolder.name.setText("Name : "+listItem.getName());
        viewHolder.email.setText("Email : "+listItem.getEmail());
        viewHolder.address.setText("Address : "+listItem.getAddress());
        viewHolder.gender.setText("Gender : "+listItem.getGender());
        viewHolder.mobile.setText("Mobile : "+listItem.getMobile());
        viewHolder.home.setText("Home Contact : "+listItem.getHome());
        viewHolder.office.setText("Office Contact : "+listItem.getOffice());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"you clicked"+ i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // initialise card items heree========================
        public TextView name,id,email,address,gender,mobile,home,office;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            id = (TextView) itemView.findViewById(R.id.id);
            name= (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
            address = (TextView) itemView.findViewById(R.id.address);
            gender = (TextView) itemView.findViewById(R.id.gender);
            mobile = (TextView) itemView.findViewById(R.id.mobile);
            home = (TextView) itemView.findViewById(R.id.home);
            office = (TextView) itemView.findViewById(R.id.office);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
