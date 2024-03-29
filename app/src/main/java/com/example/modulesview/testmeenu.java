package com.example.modulesview;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.modulesview.edit_modules.EditModulesActivity;
import com.example.modulesview.view_modules.ViewModulesActivity;
import java.util.ArrayList;
//
public class testmeenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmeenu);

    }
    public void StartView(View view){
        Intent i = new Intent(this, ViewModulesActivity.class);
        this.startActivity(i);
    }
    public void StartEdit(View view){
        Intent i = new Intent(this, EditModulesActivity.class);
        this.startActivity(i);
    }
    //Will be load Data from Database
    public static ArrayList<Module> getMoudles(){
        ArrayList<Module> Modules= new ArrayList<>();
        Module a=new Module(1,"Info501","Computers stuff","Where you do computers","Level 9","15","Core",1,false);
        Module b=new Module(2,"Info502","People D","Where you do C","Level 5","15","Core",1,false);
        Module c=new Module(3,"Info503","Software stuff","Where you do D","Level 5","15","Software",2,false);
        Module d=new Module(4,"Info504","HardWare stuff","Where you do 1","Level 5","15","Software",2,false);
        Module h=new Module(5,"Info601","Computers stuff","Where you do computers","Level 5","15","Network",3,false);
        Module g=new Module(6,"Info602","People D","Where you do C","Level 5","15","Network",3,false);
        Module f=new Module(7,"Comp601","Software stuff","Where you do D","Level 5","15","Mutimedia",4,false);
        Module e=new Module(8,"Comp602","HardWare stuff","Where you do 1","Level 5","15","Mutimedia",4,false);
        Module z=new Module(9,"Comp701","Software stuff","Where you do D","Level 5","15","Database",5,false);
        Module y=new Module(10,"Info701","HardWare stuff","Where you do 1","5","15","Database",5,false);
        //Settting preReqs for modules
        d.SetPreRequistes(b,a,c);
        a.SetPreRequistes(y,z);
        b.SetPreRequistes(a);
        //Added modules to list
        Modules.add(a);
        Modules.add(b);
        Modules.add(c);
        Modules.add(d);
        Modules.add(h);
        Modules.add(g);
        Modules.add(f);
        Modules.add(e);
        Modules.add(z);
        Modules.add(y);
        FindModule(Modules,"Info501");
        return Modules;
    }
    //For Adding Preregs with the actucal data
    public static Module FindModule(ArrayList<Module> Modules,String M_Code){
        for (int i=0;i<=Modules.size()-1;i++){
            if (Modules.get(i).getM_Code().equals(M_Code)){
                return Modules.get(i);
            }
        }

        return null;
    }
}
