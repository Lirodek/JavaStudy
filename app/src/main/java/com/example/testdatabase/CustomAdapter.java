package com.example.testdatabase;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter implements View.OnClickListener{
    public interface ListBtnClickListener{ void onListBtnClick(int position); }
    int resourceId;

    ListBtnClickListener listBtnClickListener;

    public CustomAdapter(Context context, int resource, ArrayList<ListViewBtnItem> list,
                         ListBtnClickListener clickListener){
        super(context, resource, list);

        resourceId =resource;
        this.listBtnClickListener = clickListener;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        // 생성자로 부터 저장된 resourceId(Listview_btn_item) 에
        // 해당하는 Layout을 inflate하여 convertView참조 획득
        if(converView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            converView = inflater.inflate(this.resourceId/*R.Layout.listview_btn_item*/, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)로 부터 위젯에 대한 참조 획득
        final ImageView iconImageViewRight = (ImageView) converView.findViewById(R.id.imageRight);
        final ImageView iconImageViewLeft = (ImageView) converView.findViewById(R.id.imageLeft);
        final TextView textView = (TextView) converView.findViewById(R.id.wordName);

        final ListViewBtnItem listViewItem = (ListViewBtnItem) getItem(position);

        textView.setText(listViewItem.getText());

        iconImageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iconImageViewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return converView;
    }


    @Override
    public void onClick(View v) {

    }
}
class ListViewBtnItem{
    private String textStr;
    public void setText(String text){ textStr = text; }
    public String getText() { return  this.textStr; }
}

