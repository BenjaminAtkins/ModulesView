package com.example.modulesview.edit_modules;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.example.modulesview.Module;
import com.example.modulesview.R;
import com.example.modulesview.testmeenu;
import com.example.modulesview.view_modules.ViewCustomAdapater;


import java.util.ArrayList;

import static com.example.modulesview.testmeenu.FindModule;


public class EditCustomAdapater extends RecyclerView.Adapter<EditCustomAdapater.ViewHolder>{
    private static ArrayList<Module> Modules;
    private static Context context;
    private static int Semestor;
    public interface OnModuleEditClickListener {

        void onItemClick(Module module);
    }
    public interface UpdateData {
        int onUpdate();
        ArrayList<Module> UpdateModules(ArrayList<Module> Modules);

    }
    public interface TextChanged{
        void afterTextChanged(Module module,String Text, EditText TextTochange,String Thingtochange);//IE Module,Text that has been inputted,Thing that has been changed,The Moudle thing to change
    }
    private final OnModuleEditClickListener listener;
    private static UpdateData Update;
    private final  TextChanged textChangedListener;
    public EditCustomAdapater( Context context,ArrayList<Module> modules,OnModuleEditClickListener listener,UpdateData update,TextChanged textChangedListener) {
        Modules = modules;
        this.context = context;
        this.listener=listener;
        this.Update=update;
        this.textChangedListener=textChangedListener;
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
        Modules=Update.UpdateModules(Modules);
        viewHolder.bind(Modules.get(i),listener,textChangedListener);

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
        EditText M_Preg1;
        EditText M_Preg2;
        EditText M_Preg3;
        CardView MoudleBox;

        private ViewHolder(@NonNull View view) {
            super(view);
            M_Code = view.findViewById(R.id.CodeEdit);
            M_name = view.findViewById(R.id.nameEdit);
            M_Clevel = view.findViewById(R.id.CreditsEdit);
            M_Desc = view.findViewById(R.id.DescEdit);
            M_Level = view.findViewById(R.id.LevelEdit);
            M_Stream = view.findViewById(R.id.StreamEdit);
            M_Preg1=view.findViewById(R.id.preReg);
            M_Preg2=view.findViewById(R.id.PreReg1);
            M_Preg3=view.findViewById(R.id.preReg2);
            MoudleBox = view.findViewById(R.id.card_edit_box);
        }


            public void bind(final Module module, final OnModuleEditClickListener listener,TextChanged textChanged ){
                M_Code.setText(module.getM_Code());
                M_name.setText(module.getM_Name());
                M_Clevel.setText(module.getM_CLevel());
                M_Desc.setText(module.getM_Desc());
                M_Stream.setText(module.getStream());
                M_Level.setText(module.getM_Level());
                //setting the prereg text
                if (module.getPrereqs().size()!=0) {
                        M_Preg1.setText(module.getPrereqs().get(0).getM_Code());
                        if (module.getPrereqs().size()>1){
                            M_Preg2.setText(module.getPrereqs().get(1).getM_Code());
                        }
                        else {
                            M_Preg2.setText("PreReg");
                        }
                        if (module.getPrereqs().size()==3){
                            M_Preg3.setText(module.getPrereqs().get(2).getM_Code());
                        }
                        else{
                            M_Preg3.setText("PreReg");
                        }
                }
                else{
                    M_Preg1.setText("PreReg");
                    M_Preg2.setText("PreReg");
                    M_Preg3.setText("PreReg");
                }
                //Expanding the module if needed
                if (module.isExpanded()){
                    M_Level.setVisibility(View.VISIBLE);
                    M_Stream.setVisibility(View.VISIBLE);
                }
                else {
                    M_Level.setVisibility(View.GONE);
                    M_Stream.setVisibility(View.GONE);
                }
                Semestor=Update.onUpdate();
                if (module.getSemestor()!=Semestor&&Semestor!=0){
                    MoudleBox.setVisibility(View.GONE);
                }
                else {
                    MoudleBox.setVisibility(View.VISIBLE);
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(module);
                    }
                });
                //All the text watchs so it can be saved
                M_Code.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            module.setM_Code(M_Code.getText().toString());
                        }
                    }
                });
                M_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            module.setM_Name(M_name.getText().toString());
                        }
                    }
                });
                M_Clevel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            module.setM_CLevel(M_Clevel.getText().toString());
                        }
                    }
                });
                M_Desc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            module.setM_Desc(M_Desc.getText().toString());
                        }
                    }
                });
                M_Stream.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            module.setStream(M_Stream.getText().toString());
                        }
                    }
                });
                M_Level.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            module.setM_Level(M_Level.getText().toString());
                        }
                    }
                });
                M_Preg1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        Module editedprereg=testmeenu.FindModule(Modules,M_Preg1.getText().toString());
                        if (!hasFocus){
                            if (editedprereg!=null) {
                                if (module.getPrereqs().size() != 0) {
                                    if(module.getPrereqs().size() == 1) {
                                        module.SetPreRequistes(editedprereg);
                                    }
                                    if (module.getPrereqs().size() == 2) {
                                        module.SetPreRequistes(editedprereg,module.getPrereqs().get(1));
                                    }
                                    if (module.getPrereqs().size() == 3) {
                                        module.SetPreRequistes(editedprereg,module.getPrereqs().get(1),module.getPrereqs().get(2));
                                    }
                                }
                                else {
                                    module.SetPreRequistes(editedprereg);
                                }
                            }
                            else {
                                Toast.makeText(context,"Module Does Not Exitst",Toast.LENGTH_LONG);
                            }
                        }
                    }
                });
                M_Preg2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        Module editedprereg=testmeenu.FindModule(Modules,M_Preg2.getText().toString());
                        if (!hasFocus){
                            if (editedprereg!=null) {
                                if (module.getPrereqs().size() != 0) {
                                    if(module.getPrereqs().size() == 1) {
                                        module.SetPreRequistes(editedprereg);
                                    }
                                    if (module.getPrereqs().size() == 2) {
                                        module.SetPreRequistes(editedprereg,module.getPrereqs().get(1));
                                    }
                                    if (module.getPrereqs().size() == 3) {
                                        module.SetPreRequistes(editedprereg,module.getPrereqs().get(1),module.getPrereqs().get(2));
                                    }
                                }
                                else {
                                    module.SetPreRequistes(editedprereg);
                                }
                            }
                            else {
                                Toast.makeText(context,"Module Does Not Exitst",Toast.LENGTH_LONG);
                            }
                        }
                    }
                });
                M_Preg3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        Module editedprereg=testmeenu.FindModule(Modules,M_Preg3.getText().toString());
                        if (!hasFocus){
                            if (editedprereg!=null) {
                                if (module.getPrereqs().size() != 0) {
                                    if(module.getPrereqs().size() == 1) {
                                        module.SetPreRequistes(editedprereg);
                                    }
                                    if (module.getPrereqs().size() == 2) {
                                        module.SetPreRequistes(editedprereg,module.getPrereqs().get(1));
                                    }
                                    if (module.getPrereqs().size() == 3) {
                                        module.SetPreRequistes(editedprereg,module.getPrereqs().get(1),module.getPrereqs().get(2));
                                    }
                                }
                                else {
                                    module.SetPreRequistes(editedprereg);
                                }
                            }
                            else {
                                Toast.makeText(context,"Module Does Not Exitst",Toast.LENGTH_LONG);
                            }
                        }
                    }
                });
                MoudleBox.setCardBackgroundColor(ContextCompat.getColor(itemView.getContext(), module.getBackground()));
            }
    }

}
