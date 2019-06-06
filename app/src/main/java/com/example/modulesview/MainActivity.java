package com.example.modulesview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private ArrayList<Module> Modules= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator( new DefaultItemAnimator());

        getMoudles();

        adapter= new CustomAdapater(Modules,this);
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
    private void getMoudles(){
        Module a=new Module(1,"Info501","Computers stuff","Where you do computers","Level 9","15","BOy");
 //       a.SetColor();
        Modules.add(a);
        Module b=new Module(2,"Info502","People D","Where you do C","Level 5","15","Core");
//        b.SetColor();
        Modules.add(b);
        Module c=new Module(3,"Info503","Software stuff","Where you do D","Level 5","15","Core");
  //      c.SetColor();
        Modules.add(c);
        Module d=new Module(4,"Info504","HardWare stuff","Where you do 1","Level 5","15","Soft");
    //    d.SetColor();
        Modules.add(d);
        Module h=new Module(5,"Info501","Computers stuff","Where you do computers","Level 5","15","Core");
      //  h.SetColor();
        Modules.add(h);
        Module g=new Module(6,"Info502","People D","Where you do C","Level 5","15","Core");
        //g.SetColor();
        Modules.add(g);
        Module f=new Module(7,"Comp501","Software stuff","Where you do D","Level 5","15","Core");
        //f.SetColor();
        Modules.add(f);
        Module e=new Module(8,"Comp502","HardWare stuff","Where you do 1","Level 5","15","Soft");
        //e.SetColor();
        Modules.add(e);
        Module z=new Module(9,"Comp601","Software stuff","Where you do D","Level 5","15","Core");
        //z.SetColor();
        Modules.add(z);
        Module y=new Module(10,"Info601","HardWare stuff","Where you do 1","5","15","Soft");
        //y.SetColor();
        Modules.add(y);
    }
}
