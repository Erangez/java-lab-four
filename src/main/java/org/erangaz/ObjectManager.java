package org.erangaz;

import java.util.Arrays;

public class ObjectManager{
    public Creature[] objectsData;

    ObjectManager(){
        objectsData = new Creature[0];
    }
    public void add(Creature object){
        objectsData = Arrays.copyOf(objectsData, objectsData.length+1);
        objectsData[objectsData.length - 1] = object;
    }
    public void delete(int idToRemove){
        Creature[] buffer_objectsData = Arrays.copyOf(objectsData, objectsData.length-1);
        int buffer_i = 0;
        for (Creature object : objectsData){
            try{
                if (object.getId() != idToRemove){
                    buffer_objectsData[buffer_i] = object;
                    buffer_i++;
                }
            } catch (ArrayIndexOutOfBoundsException exception){
                System.out.printf("Элемент с индексом %d не найден. Удаление невозможно!\n", idToRemove);
                return;
            }
        }
        objectsData = buffer_objectsData;
    }
    public void showData(){
        for (Creature object : objectsData){
            System.out.printf("ID: %d\n", object.getId());
            System.out.println(object.getInfo());
            System.out.println();
        }
    }
    public Creature getObject(int id) {
        for (Creature object : objectsData) {
            if (object.getId() == id)
                return object;
        }
        return null;
    }
}
