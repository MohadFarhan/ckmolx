package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Domains.home_appliances.WashingMachine;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class WashingMachineAdapter extends RecyclerView.Adapter<WashingMachineAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<WashingMachine> mWashingMachine;
    public WashingMachineAdapter(Context context, ArrayList<WashingMachine> WashingMachine){

        this.mcontext=context;
        this.mWashingMachine = WashingMachine;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView washingMachineName, washingMachinePrice, washingMachineIdTV;
        ImageView mobileIV;
        public ViewHolder(View itemView) {
            super(itemView);
            washingMachineIdTV =(TextView)itemView.findViewById(R.id.washingMachineId);
            washingMachinePrice =(TextView)itemView.findViewById(R.id.washingMachinePrice);
            washingMachineName =(TextView)itemView.findViewById(R.id.washingMachineName);
           mobileIV=(ImageView)itemView.findViewById(R.id.washingMachineImage);

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
                .inflate(R.layout.washingmachine_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        WashingMachine cars = mWashingMachine.get(position);
        holder.washingMachineIdTV.setText(String.valueOf(cars.getId()));
        holder.washingMachineName.setText(cars.getWashingMachinename());
        holder.washingMachinePrice.setText(cars.getWashingMachineprice());
        Picasso.with(mcontext).load(cars.getWashingMachineimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(WashingMachine.getTwoWheeler());
    }

    @Override
    public int getItemCount() {
        return mWashingMachine.size();
    }
}
