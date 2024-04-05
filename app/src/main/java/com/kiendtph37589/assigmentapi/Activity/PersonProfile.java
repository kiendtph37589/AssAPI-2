package com.kiendtph37589.assigmentapi.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kiendtph37589.assigmentapi.R;

public class PersonProfile extends AppCompatActivity {
    ImageView img_back_profile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.complete_your_profile);
        img_back_profile = findViewById(R.id.img_back_profile);
        img_back_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
