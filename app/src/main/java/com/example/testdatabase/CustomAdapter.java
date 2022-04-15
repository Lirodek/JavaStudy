package com.example.testdatabase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter implements View.OnClickListener, AdapterView.OnItemClickListener {
    @Override
    public String toString() {
        return "";
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }


    public interface ListBtnClickListener{ void onListBtnClick(int position); }
    int resourceId;
    ListBtnClickListener listBtnClickListener;
    Context context;

    public CustomAdapter(Context context, int resource, ArrayList<ListViewBtnItem> list,
                         ListBtnClickListener clickListener){
        super(context, resource, list);
        this.context = context;
        resourceId =resource;
        this.listBtnClickListener = clickListener;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        final ViewHolder holder;
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
        final TextView textView = (TextView) converView.findViewById(R.id.wordName);
        holder = new ViewHolder(textView);


        final ListViewBtnItem listViewItem = (ListViewBtnItem) getItem(position);

        holder.word.setText(listViewItem.getText());

        iconImageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = indexMaker(textView.getText().toString());
                Uri uri = uriMake(word);
                //인터넷창에 띄워줍니다.
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        return converView;
    }



    @Override
    public void onClick(View v) {

    }
    private String indexMaker(String vo) {
        String[] cut = vo.split(". ");
        String idx = String.valueOf(cut[1]);

        return idx;
    }
    private Uri uriMake(String word) {
        String url = "https://en.dict.naver.com/#/search?query=";
        //클릭한 ListView의 값을 가져와줍니다
        return Uri.parse(url + word); //링크와 합성해서

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView word;
        boolean check;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            word = (TextView) itemView;
            check = true;
        }
    }

}
class ListViewBtnItem{
    public String textStr;
    public void setText(String text){ textStr = text; }
    public String getText() { return  this.textStr; }

    @Override
    public String toString() {
        return  textStr;
    }
}
