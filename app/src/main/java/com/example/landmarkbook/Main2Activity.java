package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.example.landmarkbook.MainActivity.selectedImages;


public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    TextView landmarkNameText;
    TextView countryNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.imageView);
        landmarkNameText = findViewById(R.id.landmarkNameText);
        countryNameText = findViewById(R.id.countryNameText);

        Intent intent = getIntent();//intenti karşıladım.
        String landmarkName = intent.getStringExtra("name");   //   |||| isimleri karşıladım||||
        landmarkNameText.setText(landmarkName);
        String countryName = intent.getStringExtra("country");
        countryNameText.setText(countryName);

        //imageView.setImageBitmap(selectedImages); static yolu ile resim yollama

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
        
    }
}
