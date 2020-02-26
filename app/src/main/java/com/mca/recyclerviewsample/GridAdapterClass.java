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

public class GridAdapterClass extends RecyclerView.Adapter<GridAdapterClass.ViewHolder> {

    private List<GridListItem> listItems;
    private Context context;

    public GridAdapterClass(List<GridListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_card_view,viewGroup,false);
        return new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {

        final GridListItem listItem = listItems.get(i);
        viewHolder.id.setText("ID : "+listItem.getId());


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


            id = (TextView) itemView.findViewById(R.id.Gridid);
            cardView = (CardView) itemView.findViewById(R.id.Grid_card_view);
        }
    }
}
