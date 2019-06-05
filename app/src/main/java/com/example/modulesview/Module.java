package com.example.modulesview;

import java.util.ArrayList;

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
    private int TextColor;
    private boolean expaneded=false;

    public Module(long M_ID,String m_Code, String m_Name, String m_Desc, String m_Level, String m_CLevel, String stream) {
        this.M_ID=M_ID;
        M_Code = m_Code;
        M_Name = m_Name;
        M_Desc = m_Desc;
        M_Level = m_Level;
        M_CLevel = m_CLevel;
        Stream = stream;


    }
    public void SetPreRequistes(ArrayList<Module>preRequistes){
        this.preRequistes =preRequistes;
    }
    /*public void SetColor(){
        if (Stream.equals("Soft")){
            Background =R.drawable.modulesoftware;
            TextColor=R.color.SoftwareTextCol;
        }
        else {
            Background =R.drawable.modulecore;
            TextColor=R.color.MoudleTop;
        }
    }*/


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
    public int getTextColor() {
        return TextColor;
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
}
