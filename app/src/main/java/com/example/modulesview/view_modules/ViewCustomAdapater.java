package com.example.modulesview.view_modules;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


import com.example.modulesview.Module;
import com.example.modulesview.R;

import java.util.ArrayList;


public class ViewCustomAdapater extends RecyclerView.Adapter<ViewCustomAdapater.Holder>{
    private ArrayList<Module> Modules;
    private Context context;
    public static class Holder extends RecyclerView.ViewHolder
    {
        TextView M_Code;
        TextView M_name;
        TextView M_Clevel;
        TextView M_Desc;
        TextView M_Level;
        TextView M_Stream;
        CheckBox Completed;
        CardView MoudleBox;
        TextView HeadCode;
        int Type;




        public Holder(@NonNull View view,int type) {
            super(view);
            this.Type=type;
            if (type==0) {
                M_Code = view.findViewById(R.id.MoudleCodeText);
                M_name = view.findViewById(R.id.NameText);
                M_Clevel = view.findViewById(R.id.CreditsText);
                M_Desc = view.findViewById(R.id.descriptionText);
                M_Level = view.findViewById(R.id.LevelText);
                M_Stream = view.findViewById(R.id.StreamText);
                Completed = view.findViewById(R.id.checkBox);
                MoudleBox = view.findViewById(R.id.card_view);
            }
            else{
                HeadCode=view.findViewById(R.id.SemestorText);
            }

        }
    }

    public ViewCustomAdapater(ArrayList<Module> Modules, Context context) {
        this.Modules=Modules;
        this.context=context;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (Modules.get(i).isHeader()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.headerlayout, parent, false);
            //view.setOnClickListener();
            Holder holder = new Holder(view, 1);
            return holder;
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_view_layout, parent, false);
            //view.setOnClickListener();
            Holder holder = new Holder(view, 0);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int poss) {
        if (holder.Type==0) {
            TextView M_Code = holder.M_Code;
            TextView M_name = holder.M_name;
            TextView M_Clevel = holder.M_Clevel;
            TextView M_Desc = holder.M_Desc;
            TextView M_Level = holder.M_Level;
            TextView M_Stream = holder.M_Stream;
            CheckBox Completed = holder.Completed;
            CardView MoudleBox = holder.MoudleBox;

            M_name.setText(Modules.get(poss).getM_Name());
            M_Code.setText(Modules.get(poss).getM_Code());
            M_Clevel.setText(Modules.get(poss).getM_CLevel());
            M_Desc.setText(Modules.get(poss).getM_Desc());
            M_Stream.setText(Modules.get(poss).getStream());
            M_Level.setText(Modules.get(poss).getM_Level());
            Completed.setChecked(Modules.get(poss).isPassed());
            MoudleBox.setCardBackgroundColor(ContextCompat.getColor(context, Modules.get(poss).getBackground()));
        }
        else {
            TextView SemCode=holder.HeadCode;
            SemCode.setText("Semestor "+Modules.get(poss).getSemestor());
        }
    }
    @Override
    public int getItemCount() {
        return Modules.size();
    }

}
