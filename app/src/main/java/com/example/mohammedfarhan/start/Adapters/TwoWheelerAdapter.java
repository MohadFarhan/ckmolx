package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.TwoWheeler;
import com.example.mohammedfarhan.start.Domains.TwoWheeler;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class TwoWheelerAdapter extends RecyclerView.Adapter<TwoWheelerAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<TwoWheeler> mTwoWheeler;
    public TwoWheelerAdapter(Context context, ArrayList<TwoWheeler> TwoWheeler){

        this.mcontext=context;
        this.mTwoWheeler=TwoWheeler;
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
                .inflate(R.layout.towheeler_adapter, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TwoWheeler twoWheeler=mTwoWheeler.get(position);
        holder.twoWheelerIdTV.setText(String.valueOf(twoWheeler.getId()));
        holder.twoWheelerName.setText(twoWheeler.getVehiclename());
        holder.twoWheelerPrice.setText(twoWheeler.getVehicleprice());
        Picasso.with(mcontext).load(twoWheeler.getVehicleimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(200,200).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(TwoWheeler.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mTwoWheeler.size();
    }
}
