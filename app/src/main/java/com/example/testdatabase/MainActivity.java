package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Directory> DirList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLoadDB();
        System.out.println(DirList.size());
        System.out.println(DirList.get(24));
        String[] word = new String[DirList.size()/2];
        for(int i =0;i<DirList.size()/2;i++){
            word[i] = DirList.get(i).getWord();
        }
        ListView list = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, word);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);


    }

    private void initLoadDB(){
        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        DirList = mDbHelper.getTableData();

        System.out.println(DirList);

        mDbHelper.close();


    }
}