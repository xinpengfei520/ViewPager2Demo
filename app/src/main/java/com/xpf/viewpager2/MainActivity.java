package com.xpf.viewpager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private static final String HORIZONTAL = "horizontal";
    private static final String VERTICAL = "vertical";
    private ViewPager2 viewPager2;
    private Spinner itemSpinner;
    private List<String> list = new ArrayList<>();
    private String[] item = {"horizontal", "vertical"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemSpinner = findViewById(R.id.itemSpinner);
        viewPager2 = findViewById(R.id.viewPager2);

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        MyAdapter adapter = new MyAdapter(this, list);
        viewPager2.setAdapter(adapter);

        spinnerSettings();
    }

    private void spinnerSettings() {
        itemSpinner.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return item.length;
            }

            @Override
            public Object getItem(int position) {
                return item[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = new TextView(parent.getContext());
                textView.setText(item[position]);
                textView.setTextSize(20);
                return textView;
            }
        });

        itemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    setOrientation(HORIZONTAL);
                } else if (position == 1) {
                    setOrientation(VERTICAL);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setOrientation(String orientation) {
        if (HORIZONTAL.equals(orientation)) {
            viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        } else if (VERTICAL.equals(orientation)) {
            viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        }
    }
}
