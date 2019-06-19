package com.example.modulesview.edit_modules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.modulesview.Module;
import com.example.modulesview.R;
import com.example.modulesview.testmeenu;

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
        Modules= testmeenu.getMoudles();

        erecyclerView=findViewById(R.id.R_Edit_View);
        erecyclerView.setHasFixedSize(true);
        elayoutManager= new GridLayoutManager(this,2);
        erecyclerView.setLayoutManager(elayoutManager);
        erecyclerView.setItemAnimator(new DefaultItemAnimator());
        editadapter=new EditCustomAdapater(this,Modules,new EditCustomAdapater.OnModuleEditClickListener(){
            @Override
            public void onItemClick(Module module) {
                //Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show();
                Log.d("ItemClickDebug","ItemClicked"+module.getM_Code());
                if(module.isExpanded()){
                    module.setExpanded(false);
                    editadapter.notifyDataSetChanged();
                }
                else{
                    module.setExpanded(true);
                    editadapter.notifyDataSetChanged();
                }
            }
        });

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
