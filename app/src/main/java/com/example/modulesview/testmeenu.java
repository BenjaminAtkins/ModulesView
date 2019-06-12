package com.example.modulesview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.modulesview.view_modules.ViewModulesActivity;

import java.util.ArrayList;

public class testmeenu extends AppCompatActivity {
    public static ArrayList<Module> Modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmeenu);
        Modules=getMoudles();
    }
    public void StartView(View view){
        Intent i = new Intent(this, ViewModulesActivity.class);
        this.startActivity(i);
    }
    public void StartEdit(View view){
        Intent i = new Intent(this, EditModulesActivity.class);
        this.startActivity(i);
    }
    public static ArrayList<Module> getMoudles(){
        ArrayList<Module> Modules= new ArrayList<>();
        Module a=new Module(1,"Info501","Computers stuff","Where you do computers","Level 9","15","BOy","1",false);
        Modules.add(a);
        Module b=new Module(2,"Info502","People D","Where you do C","Level 5","15","Core","1",false);
        Modules.add(b);
        Module c=new Module(3,"Info503","Software stuff","Where you do D","Level 5","15","Core","1",false);
        Modules.add(c);
        Module d=new Module(4,"Info504","HardWare stuff","Where you do 1","Level 5","15","Soft","1",false);
        d.SetPreRequistes(a,b,c);
        Modules.add(d);
        Module h=new Module(5,"Info601","Computers stuff","Where you do computers","Level 5","15","Core","2",false);
        Modules.add(h);
        Module g=new Module(6,"Info602","People D","Where you do C","Level 5","15","Core","2",false);
        //g.SetColor();
        Modules.add(g);
        Module f=new Module(7,"Comp601","Software stuff","Where you do D","Level 5","15","Core","2",false);
        //f.SetColor();
        Modules.add(f);
        Module e=new Module(8,"Comp602","HardWare stuff","Where you do 1","Level 5","15","Soft","2",false);
        //e.SetColor();
        Modules.add(e);
        Module z=new Module(9,"Comp701","Software stuff","Where you do D","Level 5","15","Core","3",false);
        //z.SetColor();
        Modules.add(z);
        Module y=new Module(10,"Info701","HardWare stuff","Where you do 1","5","15","Soft","4",false);
        //y.SetColor();
        Modules.add(y);
        return Modules;
    }
}
