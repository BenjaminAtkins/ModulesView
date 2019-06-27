package com.example.modulesview;

import android.util.Log;

import java.util.ArrayList;

public class Module {
    private int M_ID;
    private String M_Code;
    private String M_Name;
    private String M_Desc;
    private String M_Level;
    private String M_CLevel;
    private ArrayList<Module> preRequistes= new ArrayList<>();
    private String PreRegsText="PreRegs";
    private boolean Passed=false;
    private String Stream;
    private int Background;
    private boolean Unlocked=true;
    private boolean expanded =false;
    private int semestor;
    private boolean visable=false;
    //For headers
    private boolean header;
    public Module(int M_ID,String m_Code, String m_Name, String m_Desc, String m_Level, String m_CLevel, String stream,int semestor,boolean head) {
        M_Code = m_Code;
        M_Name = m_Name;
        M_Desc = m_Desc;
        M_Level = m_Level;
        M_CLevel = m_CLevel;
        Stream = stream;
        this.semestor=semestor;
        this.header=head;
        this.M_ID=M_ID;
        SetColor();
    }
    public void SetPreRequistes(Module...Modules){
        preRequistes.clear();//Clear for makes editing nicer
       for (Module Module:Modules){
           if (Module!=null) {
               preRequistes.add(Module);
               this.PreRegsText += " " + Module.getM_Code();
           }
       }
    }
    private void SetColor(){
        if (Stream.equals("Network")){
            Background=R.color.NetCardViewColor;
        }
        else if (Stream.equals("Mutimedia")){
            Background=R.color.MutliCardViewColor;
        }
        else if (Stream.equals("Database")){
            Background=R.color.DataCardViewColor;
        }
        else if (Stream.equals("Software")){
            Background=R.color.SoftCardViewColor;
        }
        else if (Stream.equals("Core")){
            Background=R.color.CoreCardViewColor;
        }
    }
    //Getters

    public boolean isUnlocked() {
        return Unlocked;
    }

    public String getPreRegsText() {
        return PreRegsText;
    }

    public boolean isVisable() {
        return visable;
    }

    public boolean isExpanded() {
        return expanded;
    }
    public boolean isPassed() {
        return Passed;
    }
    public int getBackground() {
        return Background;
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

    public void setVisable(boolean visable) {
        this.visable = visable;
    }

    public boolean isHeader() {
        return header;
    }

    public int getSemestor() {
        return semestor;
    }
    //Setters
    public void setM_Code(String m_Code) {
        M_Code = m_Code;
    }
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    public void setPassed(boolean passed) {
        Passed = passed;
    }
    public void setHeader(boolean header) {
        this.header = header;
    }
    public void setUnlocked(boolean unlocked) {
        Unlocked = unlocked;
    }
    public void setM_Name(String m_Name) {
        M_Name = m_Name;
    }
    public void setM_Desc(String m_Desc) {
        M_Desc = m_Desc;
    }
    public void setM_Level(String m_Level) {
        M_Level = m_Level;
    }
    public void setM_CLevel(String m_CLevel) {
        M_CLevel = m_CLevel;
    }
    public void setPreRequistes(ArrayList<Module> preRequistes) {
        this.preRequistes = preRequistes;
    }
    public void setStream(String stream) {
        Stream = stream;
    }
    public void setSemestor(int semestor) {
        this.semestor = semestor;
    }
}
