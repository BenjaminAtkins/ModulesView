package com.example.modulesview.view_modules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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

        adapter= new ViewCustomAdapater(Modules,this,new ViewCustomAdapater.OnModuleClickListener(){
            @Override
            public void onItemClick(Module module) {
                //Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show();
                Log.d("ItemClickDebug","ItemClicked"+module.getM_Code());
                if(module.isExpanded()){
                    module.setExpanded(false);
                    adapter.notifyDataSetChanged();
                }
                else{
                    module.setExpanded(true);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        recyclerView.setAdapter(adapter);


    }


}
