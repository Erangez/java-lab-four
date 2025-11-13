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
}
