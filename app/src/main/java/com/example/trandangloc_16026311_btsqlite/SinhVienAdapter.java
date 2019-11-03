package com.example.trandangloc_16026311_btsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<SinhVien> sinhViens;


    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhViens) {
        this.context = context;
        this.layout = layout;
        this.sinhViens = sinhViens;
    }

    @Override
    public int getCount() {
        return sinhViens.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public class ViewHolder {
        TextView txtName, txtClassName, txtSubject;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_sinhvien_adapter, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtClassName = (TextView) convertView.findViewById(R.id.txtClassName);
            viewHolder.txtSubject = (TextView) convertView.findViewById(R.id.txtSubject);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SinhVien sinhVien = sinhViens.get(position);
        viewHolder.txtName.setText(sinhVien.getName());
        viewHolder.txtClassName.setText(sinhVien.getClassName());
        viewHolder.txtSubject.setText(sinhVien.getSubject());
        return convertView;
    }


}
