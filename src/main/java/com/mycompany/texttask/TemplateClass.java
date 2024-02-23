/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texttask;

import java.util.List;

public class TemplateClass<T> {
    
    private List<T> list;
    private String prefix;
    
    {
        setPrefix("");
    }
    
    TemplateClass(List<T> list, String flagP){
        this.list = list;
        this.prefix = flagP;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    @Override
    public String toString(){
        return getPrefix() + getList().get(0).getClass().getSimpleName().toLowerCase() + ".txt:\n"
                + "Количество элементов: " + getList().size();
    }
}
