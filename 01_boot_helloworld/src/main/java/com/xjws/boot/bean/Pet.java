package com.xjws.boot.bean;

/**
 * @author xujian
 * @create 2023-01-29 14:51
 */
public class Pet {
    private String name;
    public Pet(){}
    public Pet(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
