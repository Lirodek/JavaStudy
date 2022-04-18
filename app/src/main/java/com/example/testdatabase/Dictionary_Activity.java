package com.example.testdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Dictionary_Activity extends AppCompatActivity implements Dictionary_CustomAdapter.ListBtnClickListener {
    private List<Directory> DirList;
    private List<Directory> clearList = new ArrayList<Directory>();
    private List<Directory> starList = new ArrayList<Directory>();
    private List<Directory> saveList = new ArrayList<Directory>();
    List<Directory> anotherList = new ArrayList<Directory>();
    public List<JapanDirectory> JapanDirList;

    private Dictionary_CustomAdapter adapter;
    private Dictionary_DataBase_Adapter mDbHelper;

    MenuItem diretory, star, graduated;
    List<Directory> tempList; // 현재 사용할 List를 갱신해주는 역활
    OnItemClick listClick = new OnItemClick();
    List<BenPick> benList = new ArrayList<BenPick>();
    EditText edtFilter;
    TextView maintv, subtv;
    ImageButton imageButton;
    ImageButton clear2;
    ListView list;
    boolean language = true;
    public List<Directory> getDirectory(){
        return DirList;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary_activity);
        setTitle("단어장");
        //====================DB 파트====================
        initLoadDB();// database에 값을 가져옵니다
        initListes();
        edtFilter = findViewById(R.id.textFilter);
        String[] word;

        word = new String[DirList.size()]; // List View 안에 적용시킬수있는 단어들을 가져왓습니다.
        for (int i = 0; i < DirList.size(); i++) {
            word[i] = DirList.get(i).getIdx() + ". " + DirList.get(i).getWord(); // 형식은 1.word 방식으로 넣어줄겁니다.
        }
        //====================리스트뷰 파트====================

        ArrayList<ListViewBtnItem> items = new ArrayList<ListViewBtnItem>();
        adapter = new Dictionary_CustomAdapter(this, R.layout.dictionary_make_list_view, items, this, DirList);
        loadItemsFromDB(items);
        list = (ListView) findViewById(R.id.listView1); // activiry_Main에 있는 ListView를 불러와줍니다.

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

    // 메뉴 관련 초기화 함수
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dictionary_menu, menu);
        diretory = menu.findItem(R.id.language_dir);
        star = menu.findItem(R.id.language_star);
        graduated = menu.findItem(R.id.language_ben);
        language = false;
        return true;
    }

    // 메뉴버튼 클릭시 발생하는 이벤트
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        System.out.println(item);
        String getItem = item.toString();
        switch (getItem) {
            case "단어장":
                DirList = checkList(DirList, 0);
                tempList = DirList;
                turnList(tempList);
                settingTitle(0);
                menuVisible(0);
                break;
            case "외운단어":
                clearList = checkList(clearList, 1);
                tempList = clearList;
                turnList(tempList);
                settingTitle(1);
                menuVisible(1);
                // 메뉴 보기 Visible
                break;
            case "중요단어":
                starList = checkList(starList, 2);
                tempList = starList;
                turnList(tempList);
                settingTitle(2);
                menuVisible(2);
                break;
            case "reset":
                listCollect();
                mDbHelper.updateDatabase(anotherList);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    public void listCollect(){
        for(int i = 0; i<DirList.size();i++){
            if(DirList.get(i).clear.compareTo(saveList.get(i).clear) != 0 || DirList.get(i).star.compareTo(saveList.get(i).star) != 0){
                Directory dir = DirList.get(i);
                anotherList.add(dir);
            }
        }
    }

    public List<Directory> checkList(List<Directory> checkList, int list_id) {
        switch (list_id) {
            case 0:
                // 아이디가 0이면 dirList
                for (int i = 0; i < checkList.size(); i++)
                    checkList.get(i).setDirectoryCheck(0);
                break;
            case 1:
                // 아이디가 1이면 clearList
                for (int i = 0; i < checkList.size(); i++)
                    checkList.get(i).setDirectoryCheck(1);
                break;
            case 2:
                // 아이디가 2이면 starList
                for (int i = 0; i < checkList.size(); i++)
                    checkList.get(i).setDirectoryCheck(2);
                break;
        }
        return checkList;
    }

    public int getListID() {
        if (tempList.size() != 0) {
            return tempList.get(0).getDirectoryCheck();
        }
        return -1;
    }

    public boolean resetListView(int cehckNumber) {
        if (cehckNumber == -1) {
            return false;
        }
        tempList = tempReset(cehckNumber);
        turnList(tempList);
        return true;

    }

    public List<Directory> tempReset(int number) {

        switch (number) {
            case 0:
                return DirList;
            case 1:
                return clearList;
            case 2:
                return starList;
        }
        return tempList;

    }

    private void settingTitle(int i) {
        switch (i) {
            case 0:
                setTitle("단어장");
                break;
            case 1:
                setTitle("외운단어");
                break;
            case 2:
                setTitle("중요단어");
                break;
        }
    }

    // 데이터베이스 init 함수
    private void initLoadDB() {
        mDbHelper = new Dictionary_DataBase_Adapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();
        benList = mDbHelper.getBenPick();
        System.out.println(benList.toString());
        if (language == true) {
            DirList = mDbHelper.getTableData();
            saveList = mDbHelper.getTableData();
        } else {
            DirList = mDbHelper.getTable();
        }
        tempList = DirList;
        mDbHelper.close();
    }
    private void initListes(){
        for(int i =0; i<DirList.size();i++){
            if(DirList.get(i).star.equals("yes") && DirList.get(i).clear.equals("학습끝")){
                starList.add(DirList.get(i));
                clearList.add(DirList.get(i));
            } else if(DirList.get(i).star.equals("yes")){
                starList.add(DirList.get(i));
            } else if(DirList.get(i).clear.equals("학습끝")){
                clearList.add(DirList.get(i));
            }
        }
    }

    // ListView에 넣을 item을 초기화해서 변경해주는 함수
    public boolean loadItemsFromDB(ArrayList<ListViewBtnItem> list) {
        ListViewBtnItem item;

        if (list == null) {
            list = new ArrayList<ListViewBtnItem>();
        }

        // 순서를 위한 i 값을 1로 초기화.
        for (int i = 0; i < tempList.size(); i++) {
            // 아이템 생성.
            item = new ListViewBtnItem();
            item.setText(Integer.toString(i) + ". " + tempList.get(i).getWord());
            list.add(item);
        }
        return true;
    }

    // Click한 메뉴에 따라 리스트 뷰를 교체해서 보여지 Activity(ListView)를 변경해주는 함수
    public void turnList(List dictionaryList) {
        ArrayList<ListViewBtnItem> items = new ArrayList<ListViewBtnItem>();
        adapter = new Dictionary_CustomAdapter(this, R.layout.dictionary_make_list_view, items, this, tempList);
        loadItemsFromDB(items);
        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);

    }

    // 메뉴에 Click시 변경해주는 함수
    public void menuVisible(int i) {
        System.out.println(i);
        switch (i) {
            case 0:
                diretory.setVisible(false);
                graduated.setVisible(true);
                star.setVisible(true);
                break;
            case 1:
                graduated.setVisible(false);
                diretory.setVisible(true);
                star.setVisible(true);
                break;
            case 2:
                star.setVisible(false);
                graduated.setVisible(true);
                diretory.setVisible(true);
                break;
        }

    }

    @Override
    public void onListBtnClick(int position) {

    }

    class OnItemClick implements AdapterView.OnItemClickListener {
        List<Directory> tempDictionary;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // dialogView 관련 선언
            View dialogView = (View) View.inflate(Dictionary_Activity.this,
                    R.layout.dictionary_dialog, null);
            maintv = (TextView) dialogView.findViewById(R.id.txtMain);
            subtv = (TextView) dialogView.findViewById(R.id.txt1);
            imageButton = (ImageButton) dialogView.findViewById(R.id.imageBtn);
            clear2 = (ImageButton) dialogView.findViewById(R.id.clearBtn);
            AlertDialog.Builder dlg = new AlertDialog.Builder(Dictionary_Activity.this);
            //idx를 가져오기 위한 vo 선언
            final int pos = position;
            String word = parent.getAdapter().getItem(position).toString();
            word = wordMaker(word);
            Directory dir = dirSrearch(word);
            String vo = (String) parent.getAdapter().getItem(position).toString();
            final int point = getListID();


            int idx = indexMaker(vo) + 1;
            if (dir.getStar().compareTo("yes") == 0) {
                imageButton.setImageResource(R.drawable.starlight);
            }
            if (dir.getClear().compareTo("학습끝") == 0) {
                clear2.setImageResource(R.drawable.study);
            }
            // dialog textBox를 채우는 부분
            maintv.setText(dir.getWord());
            subtv.setText(dir.getMeaning());
            dlg.setView(dialogView);
            //====================리스트뷰 안에 사전 이미지 버튼을 클릭할때 발생하는 이밴트====================
            imageButton.setOnClickListener(new View.OnClickListener() {
                Directory dir;
                @Override
                public void onClick(View v) {
                    dir = dirSrearch(maintv.getText().toString());
                    if (dir.getStar().equals("no")) {
                        imageButton.setImageResource(R.drawable.starlight);
                        dir.setStar("yes");
                        starList.add(dir);
                    } else {
                        imageButton.setImageResource(R.drawable.star);
                        dir.setStar("no");
                        starList.remove(dir);
                    }
                }
            });
            clear2.setOnClickListener(new View.OnClickListener() {
                Directory dir;
                @Override
                public void onClick(View v) {
                    dir = dirSrearch(maintv.getText().toString());
                    if (dir.getClear().equals("학습중")) {
                        clear2.setImageResource(R.drawable.study);
                        dir.setClear("학습끝");
                        clearList.add(dir);
                    } else {
                        clear2.setImageResource(R.drawable.studying);
                        dir.setClear("학습중");
                        clearList.remove(dir);
                    }
                }
            });
            dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    resetListView(point);
                }
            });
            dlg.show();

        }

        // idx를 만들어주기 위한 메서드
        private int indexMaker(String vo) {
            String[] cut = vo.split(". ");
            int idx = Integer.valueOf(cut[0]) - 1;

            return idx;
        }
    }

    private String wordMaker(String vo) {// 숫자랑 문자 원심분리기 ㅋㅋ
        String[] cut = vo.split(". ");
        String word = String.valueOf(cut[1]);

        return word;
    }

    private Directory dirSrearch(String word) { // word값을 가지고 DirList에서 값을 까져옴
        Directory dir = new Directory(word);
        for (int i = 0; i < DirList.size(); i++) {
            if (DirList.get(i).equals(dir)) {
                dir = DirList.get(i);
            }
        }
        return dir;
    }

    private void updateClearList(Directory dir) {
        for (int i = 0; i < clearList.size(); i++) {
            if (clearList.get(i).equals(dir)) {
                clearList.get(i).setStar(dir.getStar());
                clearList.get(i).setClear(dir.getClear());
            }
        }
    }
}