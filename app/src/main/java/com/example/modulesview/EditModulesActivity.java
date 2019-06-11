package com.example.modulesview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    public void EditCardClicked(View view){
        EditText M_Level=view.findViewById(R.id.LevelEdit);
        EditText M_Stream =view.findViewById(R.id.StreamEdit);
        if(M_Level.getVisibility()==View.GONE){
            M_Level.setVisibility(View.VISIBLE);
            M_Stream.setVisibility(View.VISIBLE);
            editadapter.notifyDataSetChanged();
        }
        else{
            M_Level.setVisibility(View.GONE);
            M_Stream.setVisibility(View.GONE);
        }
    }
}
