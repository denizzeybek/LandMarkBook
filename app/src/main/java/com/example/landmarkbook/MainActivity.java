package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // static Bitmap selectedImages;    static yolu ile resim yollama

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);


        //Data
        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Pisa"); //index0
        landmarkNames.add("Eifel");//idx 1
        landmarkNames.add("Coleseum");//idx 2
        landmarkNames.add("London Bridge");

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("Paris");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colesseum = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colesseum);
        Bitmap london = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.london);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colesseum);
        landmarkImages.add(london);

        //listView
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);//arrayadapter ile listview u
        // birbirine bağlamnaya çalıştım
        listView.setAdapter(arrayAdapter);// birbirine tamamen bağladım!!!


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //listView da 1.ye tıklayınca index yani i 0 olur anlamına geliyor bu metod.
                // Yani kullanıcının kaçıncı indexe tıkladığını anlıyoruz

                System.out.println(landmarkNames.get(i));
                System.out.println(countryNames.get(i));

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);//main den main 2 ya gidiyor.
                intent.putExtra("name",landmarkNames.get(i));//   ||||isimleri koydum||||
                intent.putExtra("country" , countryNames.get(i));

                // selectedImages = landmarkImages.get(i); static yolu ile resim yollama

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(i));

                startActivity(intent);//intenti çalıştırır
            }
        });


    }

}
