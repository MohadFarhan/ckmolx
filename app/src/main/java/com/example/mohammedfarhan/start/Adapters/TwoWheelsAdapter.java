package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.vehicles_domain.TwoWheel;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class TwoWheelsAdapter extends RecyclerView.Adapter<TwoWheelsAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<TwoWheel> mTwoWheel;
    public TwoWheelsAdapter(Context context, ArrayList<TwoWheel> TwoWheel){

        this.mcontext=context;
        this.mTwoWheel = TwoWheel;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView twoWheelerName, twoWheelerPrice,twoWheelerIdTV;
        ImageView mobileIV;
        public ViewHolder(View itemView) {
            super(itemView);
            twoWheelerIdTV=(TextView)itemView.findViewById(R.id.twoWheelId);
            twoWheelerPrice =(TextView)itemView.findViewById(R.id.twoWheelPrice);
            twoWheelerName =(TextView)itemView.findViewById(R.id.twoWheelName);
           mobileIV=(ImageView)itemView.findViewById(R.id.twoWheelImage);

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
                .inflate(R.layout.two_wheel_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TwoWheel cars = mTwoWheel.get(position);
        holder.twoWheelerIdTV.setText(String.valueOf(cars.getId()));
        holder.twoWheelerName.setText(cars.getTwoWheelname());
        holder.twoWheelerPrice.setText(cars.getTwoWheelprice());
        Picasso.with(mcontext).load(cars.getTwoWheelimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(TwoWheel.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mTwoWheel.size();
    }
}
