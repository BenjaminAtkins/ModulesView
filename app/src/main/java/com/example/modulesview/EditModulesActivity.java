package com.example.modulesview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EditModulesActivity extends AppCompatActivity {
    private static RecyclerView.Adapter editadapter;
    private RecyclerView.LayoutManager elayoutManager;
    private static RecyclerView erecyclerView;
    private ArrayList<Module> Modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_modules);
        Modules=testmeenu.getMoudles();

        erecyclerView=findViewById(R.id.R_Edit_View);
        erecyclerView.setHasFixedSize(true);
        elayoutManager= new GridLayoutManager(this,2);
        erecyclerView.setLayoutManager(elayoutManager);
        erecyclerView.setItemAnimator(new DefaultItemAnimator());
        editadapter=new EditCustomAdapater(this,Modules);

        erecyclerView.setAdapter(editadapter);
    }
}
