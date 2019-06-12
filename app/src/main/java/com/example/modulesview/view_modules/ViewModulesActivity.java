package com.example.modulesview.view_modules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.modulesview.Module;
import com.example.modulesview.R;
import com.example.modulesview.testmeenu;

import java.util.ArrayList;

public class ViewModulesActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private ArrayList<Module> Modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Modules=testmeenu.getMoudles();
        setContentView(R.layout.viewmodules_activity);
        recyclerView =findViewById(R.id.R_View_View);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator( new DefaultItemAnimator());



        adapter= new ViewCustomAdapater(Modules,this);
        recyclerView.setAdapter(adapter);


    }
    public void CardClicked(View view){
        TextView M_Level=view.findViewById(R.id.LevelText);
        TextView M_Stream =view.findViewById(R.id.StreamText);
        if(M_Level.getVisibility()==View.GONE){
            M_Level.setVisibility(View.VISIBLE);
            M_Stream.setVisibility(View.VISIBLE);
            adapter.notifyDataSetChanged();
        }
        else{
            M_Level.setVisibility(View.GONE);
            M_Stream.setVisibility(View.GONE);
        }
    }

}
