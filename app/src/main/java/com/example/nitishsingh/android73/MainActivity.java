package com.example.nitishsingh.android73;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // declaration
    private ImageView imageView;
    private Button galleryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//here we are creating the main method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galleryButton = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//here we are creating the on click method
                // here we are creating the intent
                Intent intent = new Intent();
                //here we are setting the type of intent which
                //we will pass to the another screen
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 50);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //here we are creating the onactivityresult method
        super.onActivityResult(requestCode, resultCode, data);
        //here we are applying the condition
        if(requestCode==50 && resultCode==RESULT_OK){
            //here it will Get the url from data
            Uri selectedImageUri = data.getData();
            if (null != selectedImageUri) {
                imageView.setImageURI(selectedImageUri);
            }
        }
    }
}
