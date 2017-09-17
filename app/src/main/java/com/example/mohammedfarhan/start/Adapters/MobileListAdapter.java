package com.example.mohammedfarhan.start.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Activities.MobileAdDetailsActivity;
import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */

public class MobileListAdapter extends RecyclerView.Adapter<MobileListAdapter.ViewHolder> {


    Context mcontext;
    ArrayList<Mobile> mdata;
    public MobileListAdapter(Context context, ArrayList<Mobile> data){

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

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   long id=Long.valueOf(mobileIdTV.getText().toString());
                   Intent intent=new Intent(mcontext, MobileAdDetailsActivity.class);
                   intent.putExtra("id",id);
                   mcontext.startActivity(intent);
               }
           });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mobile_list_layout, parent, false);
        ViewHolder viewholder=new ViewHolder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Mobile mobile =mdata.get(position);
        holder.mobileIdTV.setText(String.valueOf(mobile.getId()));
        holder.mobileName.setText(mobile.getMobilename());
        holder.mobilePrice.setText(mobile.getMobileprice());
        Picasso.with(mcontext).load(mobile.getMobileimageurl()).placeholder(mcontext.getResources()
                .getDrawable(R.drawable.white)).error(mcontext.getResources().getDrawable(R.drawable.white))
                .resize(100,100).centerCrop().into(holder.mobileIV);


//        holder.t2.setText(mobile.getData());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}
