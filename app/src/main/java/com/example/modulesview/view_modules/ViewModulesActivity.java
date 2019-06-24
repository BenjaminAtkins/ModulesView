package com.example.modulesview.view_modules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.modulesview.Module;
import com.example.modulesview.R;
import com.example.modulesview.testmeenu;

import java.util.ArrayList;

public class ViewModulesActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private  RecyclerView recyclerView;
    private ArrayList<Module> Modules;
    private int Semestor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmodules_activity);

        Modules=testmeenu.getMoudles();
        //Spinner to Select the semestor to display
        //Spinner Stuff Items are in string Values
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinneradapter =ArrayAdapter.createFromResource(this,R.array.semesters_Array,android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinneradapter);
        //Spinner Listener


        //Display all the modules
        recyclerView =findViewById(R.id.R_View_View);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        //On Click for the the action ie expand
        adapter= new ViewCustomAdapater(Modules, this, Semestor, new ViewCustomAdapater.OnModuleClickListener() {
            @Override
            public void onItemClick(Module module) {
                if (module.isExpanded()) {
                    module.setExpanded(false);
                    adapter.notifyDataSetChanged();
                } else {
                    module.setExpanded(true);
                    adapter.notifyDataSetChanged();
                }
            }
        }, new ViewCustomAdapater.UpdateData() {
            @Override
            public int onUpdate(int Semestor) {
                Semestor=getSemestor();
                return Semestor;
            }

            @Override
            public ArrayList<Module> UpdateModules(ArrayList<Module> Modules) {
                setModules(Modules);
                return getModules();
            }
        },new ViewCustomAdapater.OnCheckBoxClickListener(){
            @Override
            public void onClick(Module module) {
                if (module.isUnlocked()) {
                    if (module.isPassed()) {
                        module.setPassed(false);
                    } else {
                        module.setPassed(true);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        recyclerView.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                Semestor=i;
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public int getSemestor() {
        return Semestor;
    }

    public ArrayList<Module> getModules() {
        return Modules;
    }

    public void SaveStudentModules(View view){
        //get Modules for here and save to databse

    }

    public void setModules(ArrayList<Module> modules) {
        Modules = modules;
    }
}//end of view modules class
