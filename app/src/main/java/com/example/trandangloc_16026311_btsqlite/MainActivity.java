package com.example.trandangloc_16026311_btsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<SinhVien> sinhViens;
    SinhVienAdapter sinhVienAdapter;
    public static int REQUEST_CODE_THEM = 1;
    SinhVienDao sinhVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        Database database = new Database(this);
        //database.open();


        Lop lop = new Lop("DHPM");
        final SinhVien sinhVien = new SinhVien("Loc", "DHKTPM12A", "Android");

        //Add Lop
        LopDao lopDAO = new LopDao(this);
        lopDAO.AddLop(lop);
        sinhVienDAO = new SinhVienDao(this);
        sinhVienDAO.AddSinhVien(sinhVien);
        HienThiSinhVien();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien sv = sinhViens.get(position);
                Intent intentThemSinhVien = new Intent(MainActivity.this, ActivityUpdate.class);
                intentThemSinhVien.putExtra("sinhvien", sv);
                startActivityForResult(intentThemSinhVien, REQUEST_CODE_THEM);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien sv = sinhViens.get(position);
                boolean check = sinhVienDAO.DeleteSinhVien(sv.getIdSinhVien());
                if (check == true) {
                    sinhViens.remove(position);
                    Toast.makeText(MainActivity.this, "Xoá thành công ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Xoá thất bại", Toast.LENGTH_SHORT).show();
                }
                sinhVienAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void HienThiSinhVien() {
        SinhVienDao sinhVienDAO = new SinhVienDao(this);
        sinhViens = sinhVienDAO.GetAllSinhVien();
        sinhVienAdapter = new SinhVienAdapter(this, R.layout.custom_sinhvien_adapter, sinhViens);
        listView.setAdapter(sinhVienAdapter);
        sinhVienAdapter.notifyDataSetChanged();
        listView.invalidateViews();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_THEM) {
            if (resultCode == Activity.RESULT_OK) {
                Intent intent = data;
                boolean kiemtra = intent.getBooleanExtra("ketquathem", false);
                Log.d("kiemtra", kiemtra + "");
                if (kiemtra == true) {
                    HienThiSinhVien();
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
