package com.example.modulesview;

import java.util.ArrayList;
import java.util.Arrays;

public class Module {
    private long   M_ID;
    private String M_Code;
    private String M_Name;
    private String M_Desc;
    private String M_Level;
    private String M_CLevel;
    private ArrayList<Module> preRequistes;
    private boolean Passed=false;//chance later
    private String Stream;
    private int Background;
    private boolean expaneded=false;
    //For headers
    private boolean header;
    private String semestor;


    public Module(long M_ID,String m_Code, String m_Name, String m_Desc, String m_Level, String m_CLevel, String stream,String semestor,boolean head) {
        this.M_ID=M_ID;
        M_Code = m_Code;
        M_Name = m_Name;
        M_Desc = m_Desc;
        M_Level = m_Level;
        M_CLevel = m_CLevel;
        Stream = stream;
        this.semestor=semestor;
        this.header=head;
        SetColor();
    }
    public void SetPreRequistes(Module...args){
        if (args!=null) {
            preRequistes.addAll(Arrays.asList(args));
        }
    }
    public void SetColor(){
        if (Stream.equals("Soft")){
            Background=R.color.SoftBackgrondColor;
        }
        else {
            Background=R.color.CoreBackgrondColor;
        }
    }


    //Getters

    public boolean isExpaneded() {
        return expaneded;
    }
    public boolean isPassed() {
        return Passed;
    }
    public int getBackground() {
        return Background;
    }
    public long getM_ID() {
        return M_ID;
    }
    public String getM_Code() {
        return M_Code;
    }
    public String getM_Name() {
        return M_Name;
    }
    public String getM_Desc() {
        return M_Desc;
    }
    public String getM_Level() {
        return M_Level;
    }
    public String getM_CLevel() {
        return M_CLevel;
    }
    public ArrayList<Module> getPrereqs() {
        return preRequistes;
    }
    public String getStream() {
        return Stream;
    }

    public boolean isHeader() {
        return header;
    }

    public String getSemestor() {
        return semestor;
    }
    //Setters

    public void setM_Code(String m_Code) {
        M_Code = m_Code;
    }

    public void setExpaneded(boolean expaneded) {
        this.expaneded = expaneded;
    }

    public void setPassed(boolean passed) {
        Passed = passed;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }


}
