package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mohammedfarhan.start.DAO.mobiles_dao.MobileDAO;
import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.R;

public class MobileAdDetailsActivity extends AppCompatActivity {

    TextView productPriceTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_details);

        productPriceTV = (TextView) findViewById(R.id.productPrice);
        Long id = getIntent().getLongExtra("id", 0);
        MobileDAO mobileDAO = new MobileDAO(MobileAdDetailsActivity.this);

        Mobile mobile = new Mobile();
        mobile = new MobileDAO(MobileAdDetailsActivity.this).getMobileById(id);

        productPriceTV.setText(mobile.getMobileprice());
    }
}