package com.example.trandangloc_16026311_btsqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityUpdate extends AppCompatActivity {
    EditText edName, edSubject, edClassName;
    Button btnUpdate;
    SinhVienDao sinhVienDAO;
    SinhVien sinhVien;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edName = findViewById(R.id.edName);
        edSubject = findViewById(R.id.edSubject);
        edClassName = findViewById(R.id.edClassName);
        btnUpdate = findViewById(R.id.btnSuaSinhVien);
        Intent i = getIntent();
        sinhVien = (SinhVien) i.getSerializableExtra("sinhvien");
        Log.d("kt", sinhVien + "");
        edName.setText(sinhVien.getName());
        edClassName.setText(sinhVien.getClassName());
        edSubject.setText(sinhVien.getSubject());
        sinhVienDAO = new SinhVienDao(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sinhVienUpdate = new SinhVien(sinhVien.getIdSinhVien(), edName.getText().toString(), edClassName.getText().toString(), edSubject.getText().toString());
                boolean check = sinhVienDAO.UpdateSinhVien(sinhVienUpdate);
                Intent intent = new Intent();
                intent.putExtra("ketquathem", check);
                setResult(RESULT_OK, intent);
                finish();

                Log.d("kt", sinhVienUpdate + "");
            }
        });

    }
}
