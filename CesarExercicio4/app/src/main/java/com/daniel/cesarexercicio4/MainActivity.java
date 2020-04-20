package com.daniel.cesarexercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    ArrayAdapter<String> adapter;
    String[] database = new String[]{"bake", "find", "list", "patterns", "found", "misspelling"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.seach = findViewById(R.id.search);
        this.mViewHolder.list = findViewById(R.id.list);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.database);

        this.mViewHolder.list.setAdapter(adapter);

        this.mViewHolder.seach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String toSearch = mispelling(s.toString());
                (MainActivity.this).adapter.getFilter().filter(toSearch);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    //ViewHolder
    private static class ViewHolder {
        EditText seach;
        ListView list;
    }

    //check Jubled
    public boolean checkJubled(String orig, String comp) {
        String original = orig;
        String compare = comp;
        Boolean work = true;
        int count = 0;

        if (original.charAt(0) == compare.charAt(0)) {
            if (original.length() > 3) {
                for (int i = 1; i < original.length() && work; i++) {
                    if (original.charAt(i) != compare.charAt(i))
                        count++;
                    if (count >= original.length() * 2 / 3)
                        work = false;
                }
            }
        } else
            work = false;

        return work;
    }

    //check jubled
    public boolean checkTypo(String ori, String comp) {
        String original = ori;
        String compare = comp;
        boolean work = true;

        //check replaced
        if (original.length() == compare.length()) {
            int count = 0;
            for (int i = 0; i < original.length() && work; i++) {
                //check replaced
                if (original.charAt(i) != compare.charAt(i)) {
                    count++;
                }
                if (count >= 2)
                    work = false;
            }
        } else
            //check added
            if (original.length() < compare.length())
                if (compare.length() - original.length() == 1)
                    for (int i = 0; i < compare.length() - 1 && work; i++) {
                        if (compare.charAt(i) != original.charAt(i))
                            if (original.charAt(i) != compare.charAt(i + 1))
                                work = false;
                    }
                else
                    work = false;
            else
                //check removed
                if (original.length() > compare.length())
                    if (original.length() - compare.length() == 1)
                        for (int i = 0; i < original.length() - 1 && work; i++) {
                            if (compare.charAt(i) != original.charAt(i))
                                if (original.charAt(i + 1) != compare.charAt(i))
                                    work = false;
                        }
                    else
                        work = false;

        return work;
    }

    //correct misspelling
    public String mispelling(String in) {
        for (int i = 0; i < this.database.length; i++) {
            if (checkTypo(this.database[i], in))
                return this.database[i];
            else if (this.database[i].length() == in.length()) {
                if (checkJubled(this.database[i], in)) {
                    return this.database[i];
                }
            }
        }
        return in;
    }


}
