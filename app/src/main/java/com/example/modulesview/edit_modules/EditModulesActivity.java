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
    private  RecyclerView erecyclerView;
    private ArrayList<Module> Modules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_modules);
        Modules= testmeenu.getMoudles();
        for (int i=0;i<Modules.size();i++){
            Modules.get(i).setExpanded(true);
        }
        erecyclerView=findViewById(R.id.R_Edit_View);
        erecyclerView.setHasFixedSize(true);
        elayoutManager= new GridLayoutManager(this,2);
        erecyclerView.setLayoutManager(elayoutManager);
        erecyclerView.setItemAnimator(new DefaultItemAnimator());
        editadapter=new EditCustomAdapater(this, Modules, new EditCustomAdapater.OnModuleEditClickListener() {
            @Override
            public void onItemClick(Module module) {
                if (module.isExpanded()) {
                    module.setExpanded(false);
                    editadapter.notifyDataSetChanged();
                } else {
                    module.setExpanded(true);
                    editadapter.notifyDataSetChanged();
                }
            }
        }, new EditCustomAdapater.UpdateData() {
            @Override
            public ArrayList<Module> UpdateModules(ArrayList<Module> Mod) {
                Modules=Mod;
                return Modules;
            }
        });
        erecyclerView.setAdapter(editadapter);
    }
    public void SaveStudentModules(View view){
        Log.d("SaveDebug",Modules.get(0).getM_Code());
    }
}
