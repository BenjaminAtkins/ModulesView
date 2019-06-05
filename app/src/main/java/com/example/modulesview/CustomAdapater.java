package com.example.modulesview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapater extends RecyclerView.Adapter<CustomAdapater.Holder>{
    private ArrayList<Module> Modules;
    public static class Holder extends RecyclerView.ViewHolder
    {
        TextView M_Code;
        TextView M_name;
        TextView M_Clevel;
        TextView M_Desc;
        TextView M_Level;
        TextView M_Stream;
        CheckBox Completed;

        public Holder(@NonNull View view) {
            super(view);
            M_Code=view.findViewById(R.id.MoudleCode);
            M_name=view.findViewById(R.id.NameText);
            M_Clevel=view.findViewById(R.id.CreditsText);
            M_Desc=view.findViewById(R.id.descriptionText);
            M_Level=view.findViewById(R.id.LevelText);
            M_Stream=view.findViewById(R.id.StreamText);
            Completed=view.findViewById(R.id.checkBox);


        }
    }

    public CustomAdapater(ArrayList<Module> Modules) {
        this.Modules=Modules;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.modulelayout,parent,false);
        //view.setOnClickListener();
        Holder holder= new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int poss) {
        TextView M_Code = holder.M_Code;
        TextView M_name= holder.M_name;
        TextView M_Clevel= holder.M_Clevel;
        TextView M_Desc= holder.M_Desc;
        TextView M_Level= holder.M_Level;
        TextView M_Stream= holder.M_Stream;
        CheckBox Completed= holder.Completed;

        M_name.setText(Modules.get(poss).getM_Name());
        M_Code.setText(Modules.get(poss).getM_Code());
        M_Clevel.setText(Modules.get(poss).getM_CLevel());
        M_Desc.setText(Modules.get(poss).getM_Desc());
        M_Stream.setText(Modules.get(poss).getStream());
        M_Level.setText(Modules.get(poss).getM_Level());
        Completed.setChecked(Modules.get(poss).isPassed());

    }

    @Override
    public int getItemCount() {
        return Modules.size();
    }

}