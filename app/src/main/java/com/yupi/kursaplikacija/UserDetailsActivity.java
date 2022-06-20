package com.yupi.kursaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView username, website, phoneNumber, zipCode, company;
    private ImageView profileImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        username = findViewById(R.id.username);
        website = findViewById(R.id.website);
        phoneNumber = findViewById(R.id.phone);
        zipCode = findViewById(R.id.zipCode);
        profileImg = findViewById(R.id.profileImage);
        company = findViewById(R.id.company);


        Glide
                .with(this)
                .load("https://lh6.ggpht.com/9SZhHdv4URtBzRmXpnWxZcYhkgTQurFuuQ8OR7WZ3R7fyTmha77dYkVvcuqMu3DLvMQ=w300")
                .into(profileImg);

        if (getIntent() != null) {

            String name = getIntent().getStringExtra("username");
            String phone = getIntent().getStringExtra("phone");
            String web = getIntent().getStringExtra("web");
            String code = getIntent().getStringExtra("zip");
            String co = getIntent().getStringExtra("co");

            if (name != null)
                username.setText(name);

            if (web != null)
                website.setText(web);

            if (phone != null)
                phoneNumber.setText(phone);

            if (code != null)
                zipCode.setText(code);

            if (co != null)
                company.setText(co);
        }
    }
}