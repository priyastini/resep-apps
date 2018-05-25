package com.example.dessy.resepmamake;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Priyastini Dessy on 01/05/2018.
 */

public class AdapterMinuman extends RecyclerView.Adapter<AdapterMinuman.MyViewHolder> {

    private Context mContext;
    private List<Constactor> constactorList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public CardView cardView;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.tv_title);
            thumbnail = (ImageView) view.findViewById(R.id.im_thumbnail);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }

    public AdapterMinuman(Context mContext, List<Constactor> constactorList){
        this.mContext = mContext;
        this.constactorList = constactorList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (final MyViewHolder holder, final int position){
        Constactor constactor = constactorList.get(position);
        holder.title.setText(constactor.getName());
        Glide.with(mContext).load(constactor.getThumbnail()).into(holder.thumbnail);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DetailResepMinuman.class);

                // passing data to the constactor activity
                intent.putExtra("Title", constactorList.get(position).getName());
                intent.putExtra("Thumbnail", constactorList.get(position).getThumbnail());
                intent.putExtra("Penjelasan", constactorList.get(position).getPenjelasan());
                mContext.startActivities(new Intent[]{intent});
            }
        });

        // Set Click Listener
    }

    @Override
    public int getItemCount() {
        return constactorList.size();
    }

}
