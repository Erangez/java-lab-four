package org.erangaz;

// Базовый класс с общими атрибутами и методами
public class Creature {
    // Инкапсуляция полей
    public String name;
    private int groupID;
    private double health;
    private int level;

    Creature(){
        name = "Creature";
        health = 1;
        level = 1;
        groupID = 0;
    }
    Creature(String name, double health, int groupID, int level){
        this.name = name;
        this.health = health;
        this.groupID = groupID;
        this.level = level;
    }
    public void showInfo(){
        System.out.printf("Имя: %s\nЗдоровье: %s\nУровень: %s\nГруппа: %s\n",
                name, health, level, GroupManager.getGroupFromID(groupID));
    }
    public String[] getAttributes(){
        return new String[]{name, Double.toString(health),
                Integer.toString(level), Integer.toString(groupID)};
    }

    // Getters и setters
    public int getGroupID(){
        return groupID;
    }
    public void setGroupID(int groupID){
        this.groupID = groupID;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        if (level <= 0)
            this.level = 1;
        else
            this.level = level;
    }

    public double getHealth() {
        return health;
    }
    public void setHealth(double health) {
        if (health <= 0)
            this.health = 0;
        else
            this.health = health;
    }

}
