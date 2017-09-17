package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cycles;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class CyclesAdapter extends RecyclerView.Adapter<CyclesAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<Cycles> mCycles;
    public CyclesAdapter(Context context, ArrayList<Cycles> Cycles){

        this.mcontext=context;
        this.mCycles = Cycles;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cycleName, cyclePrice, cycleIdTV;
        ImageView cycleIV;
        public ViewHolder(View itemView) {
            super(itemView);
            cycleIdTV =(TextView)itemView.findViewById(R.id.cycleId);
            cyclePrice =(TextView)itemView.findViewById(R.id.cyclePrice);
            cycleName =(TextView)itemView.findViewById(R.id.cycleName);
           cycleIV =(ImageView)itemView.findViewById(R.id.cycleImage);

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
                .inflate(R.layout.cycles_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Cycles cyc = mCycles.get(position);
        holder.cycleIdTV.setText(String.valueOf(cyc.getId()));
        holder.cycleName.setText(cyc.getCyclename());
        holder.cyclePrice.setText(cyc.getCycleprice());
        Picasso.with(mcontext).load(cyc.getCycleimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.cycleIV);


//        holder.t2.setText(Cycles.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mCycles.size();
    }
}
