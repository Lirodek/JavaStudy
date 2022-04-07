package com.example.testdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Directory> DirList;
    public List<JapanDirectory> JapanDirList;
    TextView maintv, subtv;
    ImageButton imageButton;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //====================DB 파트====================
        initLoadDB();// database에 값을 가져옵니다

        String[] word = new String[DirList.size()]; // List View 안에 적용시킬수있는 단어들을 가져왓습니다.
        for(int i =0;i<DirList.size();i++){
            word[i] = (i+1)+". " + DirList.get(i).getWord(); // 형식은 1.word 방식으로 넣어줄겁니다.
        }
        //====================리스트뷰 파트====================
        list = (ListView) findViewById(R.id.listView1); // activiry_Main에 있는 ListView를 불러와줍니다.

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, word); // ListView에 값을 넣어줍니다.
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setAdapter(adapter);
        //====================리스트뷰 클릭시 발생하는 이밴트====================
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View dialogView = (View) View.inflate(MainActivity.this,
                        R.layout.dialog, null);
                maintv = (TextView) dialogView.findViewById(R.id.txtMain);
                subtv = (TextView) dialogView.findViewById(R.id.txt1);
                imageButton = (ImageButton) dialogView.findViewById(R.id.imageBtn);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                System.out.println(position);
                maintv.setText(" " + DirList.get(position).getWord());
                subtv.setText(DirList.get(position).getMeaning());
                dlg.setView(dialogView);
                //====================리스트뷰 안에 사전 이미지 버튼을 클릭할때 발생하는 이밴트====================
                imageButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String url = "https://en.dict.naver.com/#/search?query=";
                        String word = DirList.get(position).getWord();
                        //클릭한 ListView의 값을 가져와줍니다
                        Uri uri = Uri.parse(url + word); //링크와 합성해서
                        //인터넷창에 띄워줍니다.
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();

            }

        });


    }

    private void initLoadDB(){
        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        DirList = mDbHelper.getTableData();
        JapanDirList = mDbHelper.getTable();


        System.out.println(JapanDirList);

        mDbHelper.close();


    }
}