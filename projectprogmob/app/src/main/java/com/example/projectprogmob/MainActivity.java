package com.example.projectprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText angka1;
    EditText angka2;
    Button hitung;
    TextView hasil;
    TextView validasi;
    TextView history;
    List<String> historyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1=findViewById(R.id.angka1);
        angka2=findViewById(R.id.angka2);

        hitung=findViewById(R.id.hitung);
        hasil=findViewById(R.id.hasil);
        validasi= findViewById(R.id.validasi);
        history = findViewById(R.id.history);

        historyList = new ArrayList<>();


        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nilaiAngka1 = angka1.getText().toString();
                String nilaiAngka2 = angka2.getText().toString();

                if (TextUtils.isEmpty(nilaiAngka1)){
                    validasi.setText("Angka 1 Belum Diisi");
                    return;
                } else if (TextUtils.isEmpty(nilaiAngka2)) {
                    validasi.setText("Angka 2 Belum Diisi");
                    return;
                } else if (!TextUtils.isDigitsOnly(nilaiAngka1)) {
                    validasi.setText("Angka 1 Harus Berupa Angka");
                    return;
                } else if (!TextUtils.isDigitsOnly(nilaiAngka2)) {
                    validasi.setText("Angka 2 Harus Berupa Angka");
                    return;
                } else {
                    validasi.setText("");
                }

                int intNilaiAngka1 = Integer.valueOf(nilaiAngka1);
                int intNilaiAngka2 = Integer.valueOf(nilaiAngka2);

                int hasilHitung = intNilaiAngka1 + intNilaiAngka2;

                hasil.setText("Hasil: " + String.valueOf(hasilHitung));

                String history = nilaiAngka1 +  " + " + nilaiAngka2 + " = " + hasilHitung;
                historyList.add(history);

                showHistory();

            }
        });

    }

    private void showHistory(){
        StringBuilder stringBuilder = new StringBuilder();
        for (String history: historyList){
            stringBuilder.append(history).append("\n");
        }
        history.setText(stringBuilder.toString());
    }
}

