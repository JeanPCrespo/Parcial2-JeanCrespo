package com.example.parcial2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivCharacterDetail;
    private TextView tvNameDetail, tvStatusDetail, tvSpeciesDetail, tvLocationDetail, tvGenderDetail;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivCharacterDetail = findViewById(R.id.ivCharacterDetail);
        tvNameDetail = findViewById(R.id.tvNameDetail);
        tvStatusDetail = findViewById(R.id.tvStatusDetail);
        tvSpeciesDetail = findViewById(R.id.tvSpeciesDetail);
        tvLocationDetail = findViewById(R.id.tvLocationDetail);
        tvGenderDetail = findViewById(R.id.tvGenderDetail);
        btnLogout = findViewById(R.id.btnLogout);

        String name = getIntent().getStringExtra("name");
        String status = getIntent().getStringExtra("status");
        String species = getIntent().getStringExtra("species");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        String location = getIntent().getStringExtra("location");
        String gender = getIntent().getStringExtra("gender");

        tvNameDetail.setText(name);
        tvStatusDetail.setText(status);
        tvSpeciesDetail.setText(species);
        tvLocationDetail.setText(location);
        tvGenderDetail.setText(gender);

        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(ivCharacterDetail);

        btnLogout.setOnClickListener(v -> logout());
    }

    private void logout() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(DetailActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
