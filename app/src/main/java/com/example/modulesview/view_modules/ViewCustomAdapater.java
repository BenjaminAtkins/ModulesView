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
import android.widget.ImageView;
import android.widget.TextView;


import com.example.modulesview.Module;
import com.example.modulesview.R;
import com.example.modulesview.R.color;

import java.util.ArrayList;


public class ViewCustomAdapater extends RecyclerView.Adapter<ViewCustomAdapater.Holder>{
    private ArrayList<Module> Modules;
    private static Context context;
    private static int Semestor;
    public interface OnCheckBoxClickListener{
        void onClick(Module module);
    }
    public interface OnModuleClickListener {
        void onItemClick(Module module);
    }
    public interface UpdateData {
        int onUpdate(int Semestor);
        ArrayList<Module> UpdateModules(ArrayList<Module> Modules);

    }
    private final OnModuleClickListener listener;
    private final OnCheckBoxClickListener checkBoxlistener;
    private static UpdateData Update;
    public ViewCustomAdapater(ArrayList<Module> Modules, Context context, int Semestor, OnModuleClickListener listener, UpdateData Update, OnCheckBoxClickListener checkBoxlistener) {
        this.Modules=Modules;
        this.context=context;
        this.listener=listener;
        ViewCustomAdapater.Update =Update;
        this.checkBoxlistener=checkBoxlistener;
    }
    public ArrayList<Module> getModules() {
        return Modules;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_view_layout, parent, false);
        //view.setOnClickListener();
        Holder holder = new Holder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int poss) {
            Modules=Update.UpdateModules(Modules);
            holder.bind(Modules.get(poss),listener,checkBoxlistener);

    }
    @Override
    public int getItemCount() {
        return Modules.size();
    }
    public static class Holder extends RecyclerView.ViewHolder
    {
        TextView M_Code;
        TextView M_name;
        TextView M_Clevel;
        TextView M_Desc;
        TextView M_Level;
        TextView M_Stream;
        TextView PreRegs;
        CheckBox Completed;
        CardView CardView;
        ImageView LockIcon;
        TextView HeadCode;
        public Holder(@NonNull View view) {
            super(view);
            M_Code = view.findViewById(R.id.MoudleCodeText);
            M_name = view.findViewById(R.id.NameText);
            M_Clevel = view.findViewById(R.id.CreditsText);
            M_Desc = view.findViewById(R.id.descriptionText);
            M_Level = view.findViewById(R.id.LevelText);
            M_Stream = view.findViewById(R.id.StreamText);
            Completed = view.findViewById(R.id.checkBox);
            CardView = view.findViewById(R.id.card_view);
            LockIcon= view.findViewById(R.id.LockIcon);
            PreRegs=view.findViewById(R.id.PreRequistesText);
        }
    public void bind(final Module module, final OnModuleClickListener listener,final OnCheckBoxClickListener checkBoxlistener ){
            M_name.setText(module.getM_Name());M_Code.setText(module.getM_Code());
            M_Clevel.setText(module.getM_CLevel());
            M_Desc.setText(module.getM_Desc());
            M_Stream.setText(module.getStream());
            M_Level.setText(module.getM_Level());
            Completed.setChecked(module.isPassed());
            PreRegs.setText(module.getPreRegsText());
            Completed.setChecked(module.isPassed());
            module.setUnlocked(true);
            if (module.getPrereqs().size()>0) {//If Preregs does not = 0
                    for (int i=0;i<module.getPrereqs().size();i++){
                        if (!module.getPrereqs().get(i).isPassed()){
                            module.setUnlocked(false);
                        }
                    }
            }
        if (module.isExpanded()){
            M_Level.setVisibility(View.VISIBLE);
            M_Stream.setVisibility(View.VISIBLE);
        }
        else {
            M_Level.setVisibility(View.GONE);
            M_Stream.setVisibility(View.GONE);
        }

        //Get Semstor Value from act
        Semestor=Update.onUpdate(Semestor);
        //If The module is not in the selected semestor and we arent displaying all
        if (module.getSemestor()!=Semestor&&Semestor!=0){
            CardView.setVisibility(View.GONE);

        }
        else {
            CardView.setVisibility(View.VISIBLE);
        }
        //Card Expand Click Listener
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(module);

            }

        });
        //CheckBOx listener
        Completed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkBoxlistener.onClick(module);
            }
        });
        if (module.isUnlocked()) {
            CardView.setCardBackgroundColor(ContextCompat.getColor(context, module.getBackground()));
            LockIcon.setVisibility(View.GONE);

        }
        else {
            CardView.setCardBackgroundColor(ContextCompat.getColor(context,color.CardViewLockedBackground));
            LockIcon.setVisibility(View.VISIBLE);
        }
    }
}//end of holderclass


}//end of class
