package com.daniel.cesaexercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.seach = findViewById(R.id.search);
        this.mViewHolder.list = findViewById(R.id.list);

        String[] date = new String[] {"bake", "find", "list", "patterns", "found", "misspelling"};

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, date);

        this.mViewHolder.list.setAdapter(adapter);

    }

    private static class ViewHolder {
        EditText seach;
        ListView list;
    }


}
