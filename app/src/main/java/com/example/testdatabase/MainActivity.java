package com.example.testdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomAdapter.ListBtnClickListener {
    public List<Directory> DirList;
    public List<JapanDirectory> JapanDirList;
    Button fclrear;
    OnItemClick listClick = new OnItemClick();
    List<BenPick> benList = new ArrayList<BenPick>();
    EditText edtFilter;
    TextView maintv, subtv;
    ImageButton imageButton;
    ListView list;
    boolean language = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //====================DB 파트====================
        initLoadDB();// database에 값을 가져옵니다
        edtFilter = findViewById(R.id.textFilter);
        String[] word;

        word = new String[DirList.size()]; // List View 안에 적용시킬수있는 단어들을 가져왓습니다.
        for (int i = 0; i < DirList.size(); i++) {
            word[i] = (i + 1) + ". " + DirList.get(i).getWord(); // 형식은 1.word 방식으로 넣어줄겁니다.
        }

        fclrear = (Button) findViewById(R.id.filterClrear);
        fclrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                edtFilter.setText("");
            }
        });
        //====================리스트뷰 파트====================
        CustomAdapter adapter;
        ArrayList<ListViewBtnItem> items = new ArrayList<ListViewBtnItem>();
        adapter = new CustomAdapter(this, R.layout.make_list_view, items, this);
        loadItemsFromDB(items);
        list = (ListView) findViewById(R.id.listView1); // activiry_Main에 있는 ListView를 불러와줍니다.

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, word); // ListView에 값을 넣어줍니다.
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setAdapter(adapter);

        //====================리스트뷰 클릭시 발생하는 이밴트====================
        list.setOnItemClickListener(listClick);

        edtFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString();
                if (filterText.length() > 0) {
                    list.setFilterText(filterText);
                } else
                    list.clearTextFilter();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        language = false;
        return true;
    }

    private void initLoadDB() {
        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();
        benList = mDbHelper.getBenPick();
        System.out.println(benList.toString());
        if (language == true) {
            DirList = mDbHelper.getTableData();
        } else {
            DirList = mDbHelper.getTable();
        }


        System.out.println(JapanDirList);

        mDbHelper.close();


    }
    public boolean loadItemsFromDB(ArrayList<ListViewBtnItem> list) {
        ListViewBtnItem item ;


        if (list == null) {
            list = new ArrayList<ListViewBtnItem>() ;
        }

        // 순서를 위한 i 값을 1로 초기화.
        for(int i=0;i<DirList.size();i++) {
            // 아이템 생성.
            item = new ListViewBtnItem();
            item.setText(Integer.toString(i) + ". "+DirList.get(i).getWord());
            list.add(item);
        }

        return true ;
    }

    @Override
    public void onListBtnClick(int position) {

    }

    class OnItemClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // dialogView 관련 선언
            View dialogView = (View) View.inflate(MainActivity.this,
                    R.layout.dialog, null);
            maintv = (TextView) dialogView.findViewById(R.id.txtMain);
            subtv = (TextView) dialogView.findViewById(R.id.txt1);
            imageButton = (ImageButton) dialogView.findViewById(R.id.imageBtn);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            //idx를 가져오기 위한 vo 선언
            final int pos = position;
            System.out.println(pos +", "+parent.getAdapter().getItem(position).toString());
            String vo = (String) parent.getAdapter().getItem(position).toString();


            int idx = indexMaker(vo)+1;
            // dialog textBox를 채우는 부분
            maintv.setText(DirList.get(idx).getWord());
            subtv.setText(DirList.get(idx).getMeaning());
            dlg.setView(dialogView);
            //====================리스트뷰 안에 사전 이미지 버튼을 클릭할때 발생하는 이밴트====================
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String word = DirList.get(idx).getWord();
                    Uri uri = uriMake(word);
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

        // url을 만들어주기 위한 매서드
        private Uri uriMake(String word) {
            String url = "https://en.dict.naver.com/#/search?query=";
            //클릭한 ListView의 값을 가져와줍니다
            return Uri.parse(url + word); //링크와 합성해서

        }

        // idx를 만들어주기 위한 메서드
        private int indexMaker(String vo) {
            String[] cut = vo.split(". ");
            int idx = Integer.valueOf(cut[0]) - 1;

            return idx;
        }
    }
}