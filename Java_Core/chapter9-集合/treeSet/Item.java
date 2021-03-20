package treeSet;

import java.util.Objects;

public class Item {
    private String description;
    private int partNumer;

    public Item(String aDescription,int aPartNumber){
        description=aDescription;
        partNumer=aPartNumber;
    }

    public String getDescription(){
        return description;
    }
    public String toString(){
        return "[desciption"+description+", partNumer="+partNumer+"]";
    }
    @Override
    public boolean equals(Object otherObject){
        if(this==otherObject){
            return true;
        }
        if(otherObject==null){
            return false;
        }
        if(getClass()!=otherObject.getClass()){
            return false;
        }
        var other=(Item)otherObject;
        return Objects.equals(description,other.description)&&partNumer==other.partNumer;
    }
}
