package com.example.testdatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary_DataBase_Adapter {
    protected static final String TAG = "DataAdapter";

    // TODO : TABLE 이름을 명시해야함
    protected static final String TABLE_NAME = "engword";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private Dictionary_CustomAdapter_DataBase_Helper mDbHelper;

    public Dictionary_DataBase_Adapter(Context context) {
        this.mContext = context;
        mDbHelper = new Dictionary_CustomAdapter_DataBase_Helper(mContext);
    }

    public Dictionary_DataBase_Adapter createDatabase() throws SQLException {
        try {
            mDbHelper.createDataBase();
        } catch (IOException mIOException) {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public Dictionary_DataBase_Adapter open() throws SQLException {
        try {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        } catch (SQLException mSQLException) {
            Log.e(TAG, "open >>" + mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close() {
        mDbHelper.close();
    }
    public void updateDatabase(List<Directory> dirList){
        mDb = mDbHelper.getWritableDatabase();
        for(int i=0; i<dirList.size(); i++){
            mDb.execSQL("UPDATE " + TABLE_NAME + " SET clear = '"
                    + dirList.get(i).clear + "', star = '" + dirList.get(i).star +
                    "' WHERE word = '"
                    + dirList.get(i).getWord() + "';");
//            String sql = "UPDATE " + TABLE_NAME + " SET CLEAR = " +
//                    dirList.get(i).clear +  ", SET STAR = " +
//                    dirList.get(i).star + " WHERE " + dirList.get(i).getWord() + ";";
//            mDb.execSQL(sql);
        }
        mDb.close();

    }

    public List getTableData() {
        try {
            // Table 이름 -> antpool_bitcoin 불러오기
            String sql = "SELECT * FROM " + TABLE_NAME;

            // 모델 넣을 리스트 생성
            List dbList = new ArrayList();

            // TODO : 모델 선언
            Directory db = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur != null) {
                // 칼럼의 마지막까지
                while (mCur.moveToNext()) {

                    // TODO : 커스텀 모델 생성
                    db = new Directory();

                    // TODO : Record 기술
                    // id, name, account, privateKey, secretKey, Comment
                    db.setIdx(mCur.getString(0));
                    db.setDivision(mCur.getString(1));
                    db.setWord(mCur.getString(2));
                    db.setMeaning(mCur.getString(3));
                    db.setClear(mCur.getString(4));
                    db.setStar(mCur.getString(5));

                    // 리스트에 넣기
                    dbList.add(db);
                }
            }
            return dbList;
        } catch (SQLException mSQLException) {
            Log.e(TAG, "getTestData >>" + mSQLException.toString());
            throw mSQLException;
        }
    }

    public List getTable() {
        try {
            // Table 이름 -> antpool_bitcoin 불러오기
            String sql = "SELECT * FROM " + "jpnword";

            // 모델 넣을 리스트 생성
            List dbList = new ArrayList();

            // TODO : 모델 선언
            JapanDirectory jdb = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur != null) {
                // 칼럼의 마지막까지
                while (mCur.moveToNext()) {
                    jdb = new JapanDirectory();

                    jdb.setWord(mCur.getString(0));
                    jdb.setMeaning(mCur.getString(1));


                    dbList.add(jdb);
                }
            }
            return dbList;
        } catch (SQLException mSQLException) {
            Log.e(TAG, "getTestData >>" + mSQLException.toString());
            throw mSQLException;
        }
    }
    public List getBenPick() {
        try {
            // Table 이름 -> antpool_bitcoin 불러오기
            String sql = "SELECT * FROM " + "compleat";

            // 모델 넣을 리스트 생성
            List dbList = new ArrayList();

            // TODO : 모델 선언
            BenPick ben = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur != null) {
                // 칼럼의 마지막까지
                while (mCur.moveToNext()) {
                    ben = new BenPick();

                    ben.setEng(mCur.getString(0));
                    ben.setJapan(mCur.getString(1));


                    dbList.add(ben);
                }
            }
            return dbList;
        } catch (SQLException mSQLException) {
            Log.e(TAG, "getTestData >>" + mSQLException.toString());
            throw mSQLException;
        }
    }
}
