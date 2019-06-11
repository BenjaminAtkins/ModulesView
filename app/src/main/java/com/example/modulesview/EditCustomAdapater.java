package com.example.modulesview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;


public class EditCustomAdapater extends RecyclerView.Adapter<EditCustomAdapater.ViewHolder>{
    private ArrayList<Module> Modules;
    private Context context;

    public EditCustomAdapater( Context context,ArrayList<Module> modules) {
        Modules = modules;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.module_edit_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        EditText M_Code=viewHolder.M_Code;
        EditText M_name=viewHolder.M_name;
        EditText M_Clevel=viewHolder.M_Clevel;
        EditText M_Desc=viewHolder.M_Desc;
        EditText M_Level=viewHolder.M_Level;
        EditText M_Stream=viewHolder.M_Stream;
        CardView MoudleBox=viewHolder.MoudleBox;


        M_name.setText(Modules.get(i).getM_Name());
        M_Code.setText(Modules.get(i).getM_Code());
        M_Clevel.setText("Credits "+Modules.get(i).getM_CLevel());
        M_Desc.setText(Modules.get(i).getM_Desc());
        M_Stream.setText(Modules.get(i).getStream());
        M_Level.setText(Modules.get(i).getM_Level());

        MoudleBox.setCardBackgroundColor(ContextCompat.getColor(context,Modules.get(i).getBackground()));
    }

    @Override
    public int getItemCount() {
        return Modules.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        EditText M_Code;
        EditText M_name;
        EditText M_Clevel;
        EditText M_Desc;
        EditText M_Level;
        EditText M_Stream;
        CardView MoudleBox;

        public ViewHolder(@NonNull View view) {
            super(view);
            M_Code=view.findViewById(R.id.CodeEdit);
            M_name=view.findViewById(R.id.nameEdit);
            M_Clevel=view.findViewById(R.id.CreditsEdit);
            M_Desc=view.findViewById(R.id.DescEdit);
            M_Level=view.findViewById(R.id.LevelEdit);
            M_Stream=view.findViewById(R.id.StreamEdit);
            MoudleBox=view.findViewById(R.id.card_edit_box);
        }
    }
}
