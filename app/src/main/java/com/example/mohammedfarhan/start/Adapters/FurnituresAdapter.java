package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.home_appliances.Furnitures;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class FurnituresAdapter extends RecyclerView.Adapter<FurnituresAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<Furnitures> mFurnitures;
    public FurnituresAdapter(Context context, ArrayList<Furnitures> Furnitures){

        this.mcontext=context;
        this.mFurnitures = Furnitures;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView furnitureName, furniturePrice, furnitureIdTV;
        ImageView mobileIV;
        public ViewHolder(View itemView) {
            super(itemView);
            furnitureIdTV =(TextView)itemView.findViewById(R.id.furnitureId);
            furniturePrice =(TextView)itemView.findViewById(R.id.furniturePrice);
            furnitureName =(TextView)itemView.findViewById(R.id.furnitureName);
           mobileIV=(ImageView)itemView.findViewById(R.id.furnitureImage);

//           itemView.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View view) {
//                   long id=Long.valueOf(mobileIdTV.getText().toString());
//
//               }
//           });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.furniture_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Furnitures cars = mFurnitures.get(position);
        holder.furnitureIdTV.setText(String.valueOf(cars.getId()));
        holder.furnitureName.setText(cars.getFurniturename());
        holder.furniturePrice.setText(cars.getFurnitureprice());
        Picasso.with(mcontext).load(cars.getFurnitureimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(Furnitures.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mFurnitures.size();
    }
}
