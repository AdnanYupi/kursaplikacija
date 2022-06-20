package com.yupi.kursaplikacija;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_cell, null);

        TextView name = view.findViewById(R.id.studentName);
        TextView city = view.findViewById(R.id.studentCity);

        Student student = students.get(position);
        name.setText(student.getName());
        city.setText(student.getCity());

        return view;
    }
}
