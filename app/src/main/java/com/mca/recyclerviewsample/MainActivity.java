package com.mca.recyclerviewsample;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button, gridButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        gridButton = (Button) findViewById(R.id.buttonGrid);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number = Integer.parseInt(editText.getText().toString());
                if (editText.toString().isEmpty() || number == 0 || number > 20) {
                    Toast.makeText(MainActivity.this, "enter number 1 - 20", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    intent.putExtra("count", number);
                    startActivity(intent);
                }
            }
        });


        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number = Integer.parseInt(editText.getText().toString());
                if (editText.toString().isEmpty() || number == 0 || number > 20) {
                    Toast.makeText(MainActivity.this, "enter number 1 - 20", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(MainActivity.this, GridRecyclerViewActivity.class);
                    intent.putExtra("count", number);
                    startActivity(intent);
                }
            }
        });
    }
}
