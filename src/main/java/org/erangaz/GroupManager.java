package org.erangaz;

public class GroupManager {
    public static String getGroupFromID(int id){
        try {
            return Groups.values()[id].getGroup();
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Не удалось вывести группу. Ошибка в индексе.");
            return "Error";
        }
    }
    public static String[] getGroupArray(){
        String[] groupArray = new String[Groups.values().length];
        for (int i = 0; i < groupArray.length; i++){
            groupArray[i] = Groups.values()[i].getGroup();
        }
        return groupArray;
    }
}
