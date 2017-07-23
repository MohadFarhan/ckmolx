package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import com.example.mohammedfarhan.start.Domains.Data;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<Data> mdata;
    public DataAdapter(Context context,ArrayList<Data> data){

        this.mcontext=context;
        this.mdata=data;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mobileName,mobilePrice,mobileIdTV;
        ImageView mobileIV;
        public ViewHolder(View itemView) {
            super(itemView);
            mobileIdTV=(TextView)itemView.findViewById(R.id.mobileId);
            mobilePrice=(TextView)itemView.findViewById(R.id.mobilePrice);
            mobileName=(TextView)itemView.findViewById(R.id.mobileName);
           mobileIV=(ImageView)itemView.findViewById(R.id.mobileImage);

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
                .inflate(R.layout.data_adapter, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Data data=mdata.get(position);
        holder.mobileIdTV.setText(String.valueOf(data.getId()));
        holder.mobileName.setText(data.getMobilename());
        holder.mobilePrice.setText(data.getMobileprice());
        Picasso.with(mcontext).load(data.getMobileimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(200,200).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(data.getData());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}
