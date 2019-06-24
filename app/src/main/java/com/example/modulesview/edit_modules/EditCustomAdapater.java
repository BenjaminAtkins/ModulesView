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


import com.example.modulesview.Module;
import com.example.modulesview.R;
import com.example.modulesview.testmeenu;
import com.example.modulesview.view_modules.ViewCustomAdapater;


import java.util.ArrayList;

import static com.example.modulesview.testmeenu.FindModule;


public class EditCustomAdapater extends RecyclerView.Adapter<EditCustomAdapater.ViewHolder>{
    private static ArrayList<Module> Modules;
    private Context context;
    private static int Semestor;
    public interface OnModuleEditClickListener {

        void onItemClick(Module module);
    }
    public interface UpdateData {
        int onUpdate();
        ArrayList<Module> UpdateModules(ArrayList<Module> Modules);

    }
    private final OnModuleEditClickListener listener;
    private static UpdateData Update;
    public EditCustomAdapater( Context context,ArrayList<Module> modules,OnModuleEditClickListener listener,UpdateData update) {
        Modules = modules;
        this.context = context;
        this.listener=listener;
        this.Update=update;
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
        viewHolder.bind(Modules.get(i),listener);

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


            public void bind(final Module module, final OnModuleEditClickListener listener ){
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

                MoudleBox.setCardBackgroundColor(ContextCompat.getColor(itemView.getContext(), module.getBackground()));
                //Expanding the module if needed
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
                Semestor=Update.onUpdate();
                if (module.getSemestor()!=Semestor&&Semestor!=0){
                    MoudleBox.setVisibility(View.GONE);
                }
                else {
                    MoudleBox.setVisibility(View.VISIBLE);
                }
                //All the text watchs so it can be saved
                M_Code.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        module.setM_Code(editable.toString());
                    }
                });
                M_name.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        module.setM_Name(editable.toString());
                    }
                });
                M_Clevel.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        module.setM_CLevel(editable.toString());
                    }
                });
                M_Desc.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        module.setM_Desc(editable.toString());
                    }
                });
                M_Stream.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        module.setStream(editable.toString());
                    }
                });
                M_Level.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        module.setM_Level(editable.toString());
                    }
                });
                M_Preg1.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        Module editedprereg= testmeenu.FindModule(Modules,editable.toString());
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
                    }
                });
                M_Preg2.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }
                    @Override
                    public void afterTextChanged(Editable editable) {
                        Module editedprereg= testmeenu.FindModule(Modules,editable.toString());
                        if (editedprereg!=null) {
                            if (module.getPrereqs().size() != 0) {
                                if(module.getPrereqs().size() == 1) {
                                    module.SetPreRequistes(editedprereg);
                                }
                                if (module.getPrereqs().size() == 2) {
                                    module.SetPreRequistes(module.getPrereqs().get(0),editedprereg);
                                }
                                if (module.getPrereqs().size() == 3) {
                                    module.SetPreRequistes(module.getPrereqs().get(0),editedprereg,module.getPrereqs().get(1));
                                }
                            }
                            else {
                                module.SetPreRequistes(editedprereg);
                            }
                        }
                    }
                });
                M_Preg3.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }
                    @Override
                    public void afterTextChanged(Editable editable) {
                        Module editedprereg= testmeenu.FindModule(Modules,editable.toString());
                        if (editedprereg!=null) {
                            if (module.getPrereqs().size() != 0) {
                                if(module.getPrereqs().size() == 1) {
                                    module.SetPreRequistes(editedprereg);
                                }
                                if (module.getPrereqs().size() == 2) {
                                    module.SetPreRequistes(module.getPrereqs().get(0),editedprereg);
                                }
                                if (module.getPrereqs().size() == 3) {
                                    module.SetPreRequistes(module.getPrereqs().get(0),module.getPrereqs().get(1),editedprereg);
                                }
                            }
                            else {
                                module.SetPreRequistes(editedprereg);
                            }
                        }
                    }
                });
            }
    }
}
