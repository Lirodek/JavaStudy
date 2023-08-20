package com.example.ordercockstore.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ordercockstore.R;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView storeorder_name;
        public Button storeorder_accept;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            storeorder_name = (TextView) itemLayoutView.findViewById(R.id.storeorder_name);
            storeorder_accept = (Button) itemLayoutView.findViewById(R.id.storeorder_accept);
        }

    }

    Context context;

    public MenuListAdapter(Context context) {
        super();

        this.context = context;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        //viewHolder.storeorder_name.setText(itemList.get(position).getMarket());

//        int pos = position;
//        viewHolder.storeorder_accept.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity)context).fragmentStore(itemList.get(pos).getMarket());
//
//            }
//        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.fragment_menulist_list, null);

        return new ViewHolder(itemView);
    }


}
