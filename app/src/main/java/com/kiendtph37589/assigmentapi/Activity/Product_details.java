package com.kiendtph37589.assigmentapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.kiendtph37589.assigmentapi.Fragment.HomeFrag;
import com.kiendtph37589.assigmentapi.R;
import com.squareup.picasso.Picasso;

public class Product_details extends AppCompatActivity {
    ImageView img_back_pro_details,img_image_sp,img_add_sp,img_minus_sp;
    TextView tv_title_sp,tv_name_sp,tv_price_sp,tv_weight_sp,tv_Describe_sp,tv_quantity_sp;
    Button btn_add_cart;
    private int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.products_details);
        img_back_pro_details = findViewById(R.id.img_back_pro_details);
        img_image_sp = findViewById(R.id.img_image_sp);
        img_add_sp = findViewById(R.id.img_add);
        img_minus_sp = findViewById(R.id.img_minus_sp);
        tv_title_sp = findViewById(R.id.tv_title_sp);
        tv_name_sp = findViewById(R.id.tv_name_sp);
        tv_price_sp = findViewById(R.id.tv_price_sp);
        tv_weight_sp = findViewById(R.id.tv_weight_sp);
        tv_Describe_sp = findViewById(R.id.tv_describe_sp);
        tv_quantity_sp = findViewById(R.id.tv_tv_quantity_sp);
        btn_add_cart = findViewById(R.id.btn_add_cart);

        img_back_pro_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_add_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                tv_quantity_sp.setText(String.valueOf(quantity));
            }
        });
        img_minus_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity>0){
                    quantity--;
                    tv_quantity_sp.setText(String.valueOf(quantity));
                }
            }
        });
        Intent intent = getIntent();
        if (intent != null){
            String productId = intent.getStringExtra("product_id");
            String productImage = intent.getStringExtra("product_image");
            String productName = intent.getStringExtra("product_name");
            String productPrice = intent.getStringExtra("product_price");
            String productWeight = intent.getStringExtra("product_weight");
            String productDescribe = intent.getStringExtra("product_describe");

            tv_title_sp.setText(productName);
            Picasso.get().load(productImage).into(img_image_sp);
            // Hiển thị thông tin sản phẩm
            tv_name_sp.setText(productName);
            tv_price_sp.setText(productPrice);
            tv_weight_sp.setText(productWeight);
            tv_Describe_sp.setText(productDescribe);
        }

    }
}