package com.yupi.kursaplikacija.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yupi.kursaplikacija.R;
import com.yupi.kursaplikacija.Student;
import com.yupi.kursaplikacija.StudentAdapter;
import com.yupi.kursaplikacija.UserDetailsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StudentsFragment extends Fragment {

    private List<Student> list = new ArrayList<>();
    private ListView listView;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.students_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        listView = view.findViewById(R.id.listView);
        progressBar = view.findViewById(R.id.progressBar);

       new MyTask().execute("https://jsonplaceholder.typicode.com/users");
    }



    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(strings[0])
                        .build();
                Response result = client.newCall(request).execute();
                return result.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                if (s != null) {
                    JSONArray array = new JSONArray(s);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String username = object.getString("username");
                        String website = object.getString("website");
                        String phone = object.getString("phone");
                        JSONObject addressObject = object.getJSONObject("address");
                        String address = addressObject.getString("city");
                        String zipCode = addressObject.getString("zipcode");
                        JSONObject companyObject = object.getJSONObject("company");
                        String companyName = companyObject.getString("name");


                        Student student = new Student();
                        student.setName(username);
                        student.setCity(address);
                        student.setPhone(phone);
                        student.setWebsite(website);
                        student.setZipCode(zipCode);
                        student.setCompany(companyName);

                        list.add(student);
                    }

                    progressBar.setVisibility(View.GONE);
                    StudentAdapter adapter = new StudentAdapter(list);
                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Student student = list.get(position);
                            Intent intent = new Intent(requireContext(), UserDetailsActivity.class);

                            intent.putExtra("username", student.getName());
                            intent.putExtra("web", student.getWebsite());
                            intent.putExtra("phone", student.getPhone());
                            intent.putExtra("zip", student.getZipCode());
                            intent.putExtra("co", student.getCompany());
                            intent.putExtra("s", "test");
                            startActivity(intent);
                        }
                    });
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
