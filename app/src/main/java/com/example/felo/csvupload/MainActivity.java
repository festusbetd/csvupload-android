package com.example.felo.csvupload;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edName, edPhone, edFile;
    private String name,phone, file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName =  findViewById(R.id.nameEditText);
        edPhone = findViewById(R.id.phoneEditText);
        edFile = findViewById(R.id.fileEditText);

        edFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivity(intent);
            }
        });
    }


    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 7:
                if(resultCode==RESULT_OK){

                    String PathHolder = data.getData().getPath();
                    Toast.makeText(MainActivity.this, PathHolder , Toast.LENGTH_LONG).show();
                    edFile.setText(PathHolder);

                }
                else{
                    Toast.makeText(this, "no file", Toast.LENGTH_LONG).show();
                }
        }
    }
}
