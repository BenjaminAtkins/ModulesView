package com.example.modulesview.view_modules;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.MenuView;
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
    public interface OnModuleClickListener {
        void onItemClick(Module module);
    }
    private final OnModuleClickListener listener;


    public ViewCustomAdapater(ArrayList<Module> Modules, Context context,OnModuleClickListener listener) {
        this.Modules=Modules;
        this.context=context;
        this.listener=listener;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_view_layout, parent, false);
        //view.setOnClickListener();
        Holder holder = new Holder(view, 0);
        return holder;

    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int poss) {
            holder.bind(Modules.get(poss),listener);

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
        CardView MoudleBox;
        TextView HeadCode;

        public Holder(@NonNull View view,int type) {
            super(view);
            M_Code = view.findViewById(R.id.MoudleCodeText);
            M_name = view.findViewById(R.id.NameText);
            M_Clevel = view.findViewById(R.id.CreditsText);
            M_Desc = view.findViewById(R.id.descriptionText);
            M_Level = view.findViewById(R.id.LevelText);
            M_Stream = view.findViewById(R.id.StreamText);
            Completed = view.findViewById(R.id.checkBox);
            MoudleBox = view.findViewById(R.id.card_view);
            PreRegs=view.findViewById(R.id.PreRequistesText);
        }


    public void bind(final Module module, final OnModuleClickListener listener ){
            M_name.setText(module.getM_Name());M_Code.setText(module.getM_Code());
            M_Clevel.setText(module.getM_CLevel());
            M_Desc.setText(module.getM_Desc());
            M_Stream.setText(module.getStream());
            M_Level.setText(module.getM_Level());
            if (module.getPrereqs().size()!=0) {//If Preregs does not = 0
                for (int i=0;i<module.getPrereqs().size();i++) {
                    PreRegs.append(module.getPrereqs().get(i).getM_Code()+" ");
                }
            }
            Completed.setChecked(module.isPassed());
            MoudleBox.setCardBackgroundColor(ContextCompat.getColor(itemView.getContext(), module.getBackground()));
        if (module.isExpanded()){
            M_Level.setVisibility(View.VISIBLE);
            M_Stream.setVisibility(View.VISIBLE);
        }
        else {
            M_Level.setVisibility(View.GONE);
            M_Stream.setVisibility(View.GONE);
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(module);

            }
        });
    }
}

}
