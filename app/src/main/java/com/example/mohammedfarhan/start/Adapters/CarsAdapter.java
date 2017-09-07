package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cars;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<Cars> mCars;
    public CarsAdapter(Context context, ArrayList<Cars> Cars){

        this.mcontext=context;
        this.mCars = Cars;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView twoWheelerName, twoWheelerPrice,twoWheelerIdTV;
        ImageView mobileIV;
        public ViewHolder(View itemView) {
            super(itemView);
            twoWheelerIdTV=(TextView)itemView.findViewById(R.id.twoWheelerId);
            twoWheelerPrice =(TextView)itemView.findViewById(R.id.twoWheelerPrice);
            twoWheelerName =(TextView)itemView.findViewById(R.id.twoWheelerName);
           mobileIV=(ImageView)itemView.findViewById(R.id.twoWheelerImage);

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
                .inflate(R.layout.cars_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Cars cars = mCars.get(position);
        holder.twoWheelerIdTV.setText(String.valueOf(cars.getId()));
        holder.twoWheelerName.setText(cars.getCarName());
        holder.twoWheelerPrice.setText(cars.getCarPrice());
        Picasso.with(mcontext).load(cars.getCarImageUrl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(Cars.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }
}
