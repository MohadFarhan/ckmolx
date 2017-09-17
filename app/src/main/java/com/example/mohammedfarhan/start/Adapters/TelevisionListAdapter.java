package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.home_appliances.Television;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class TelevisionListAdapter extends RecyclerView.Adapter<TelevisionListAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<Television> mTelevision;
    public TelevisionListAdapter(Context context, ArrayList<Television> Television){

        this.mcontext=context;
        this.mTelevision = Television;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView televisionName, televisionPrice, televisionIdTV;
        ImageView mobileIV;
        public ViewHolder(View itemView) {
            super(itemView);
            televisionIdTV =(TextView)itemView.findViewById(R.id.televisionId);
            televisionPrice =(TextView)itemView.findViewById(R.id.televisionPrice);
            televisionName =(TextView)itemView.findViewById(R.id.televisionName);
           mobileIV=(ImageView)itemView.findViewById(R.id.televisionImage);

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
                .inflate(R.layout.television_list_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Television cars = mTelevision.get(position);
        holder.televisionIdTV.setText(String.valueOf(cars.getId()));
        holder.televisionName.setText(cars.getTelevisionname());
        holder.televisionPrice.setText(cars.getTelevisionprice());
        Picasso.with(mcontext).load(cars.getTelevisionimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(Television.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mTelevision.size();
    }
}
