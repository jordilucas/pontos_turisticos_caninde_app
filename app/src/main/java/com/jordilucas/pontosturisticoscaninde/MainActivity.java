package com.jordilucas.pontosturisticoscaninde;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descricao);
        imageView = findViewById(R.id.imgView);
        Picasso.get().load("http://blogs.opovo.com.br/c4noticias/wp-content/uploads/sites/15/2015/06/M1Q4539.jpg").into(imageView);
    }
}
