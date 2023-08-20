package com.example.ordercockstore.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordercockstore.Adapter.MenuListAdapter;
import com.example.ordercockstore.R;

public class MenuListFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menulist,container,false);

        recyclerView = (RecyclerView) root.findViewById(R.id.menulist_recycle);
        linearLayoutManager = new GridLayoutManager(root.getContext(),1,GridLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        //MenuListAdapter adapter = new MenuListAdapter(root.getContext(), list);
        //recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);

        return root;
    }


}