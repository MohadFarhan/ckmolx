package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.home_appliances.Fridges;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class FridgesListAdapter extends RecyclerView.Adapter<FridgesListAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<Fridges> mFridges;
    public FridgesListAdapter(Context context, ArrayList<Fridges> Fridges){

        this.mcontext=context;
        this.mFridges = Fridges;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fridgeName, fridgePrice, fridgeIdTV;
        ImageView mobileIV;
        public ViewHolder(View itemView) {
            super(itemView);
            fridgeIdTV =(TextView)itemView.findViewById(R.id.fridgeId);
            fridgePrice =(TextView)itemView.findViewById(R.id.fridgePrice);
            fridgeName =(TextView)itemView.findViewById(R.id.fridgeName);
           mobileIV=(ImageView)itemView.findViewById(R.id.fridgeImage);

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
                .inflate(R.layout.fridges_list_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Fridges cars = mFridges.get(position);
        holder.fridgeIdTV.setText(String.valueOf(cars.getId()));
        holder.fridgeName.setText(cars.getFridgename());
        holder.fridgePrice.setText(cars.getFridgeprice());
        Picasso.with(mcontext).load(cars.getFridgeimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(Fridges.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mFridges.size();
    }
}
