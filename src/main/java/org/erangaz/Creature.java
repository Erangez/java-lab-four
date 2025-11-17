package org.erangaz;

// Базовый класс с общими атрибутами и методами
public class Creature {
    // Инкапсуляция полей
    private final int id;
    public String name;
    private int groupID;
    private double health;
    private int level;

    Creature(int id){
        this.id = id;
        name = "Creature";
        health = 1;
        level = 1;
        groupID = 0;
    }
    /**
     * @param name имя.
     * @param id id существа в системе.
     * @param health здоровье. Не может быть не менее нуля.
     * @param groupID группа из enum Groups. Для данного класса значение = 0
     *                Подробнее в перечислении.
     * @param level уровень. Не может быть не менее нуля.
     **/
    Creature(int id, String name, double health, int groupID, int level){
        this.id = id;
        this.name = name;
        this.level = level;
        if (health <= 0)
            this.health = 1;
        else
            this.health = calculateHealthFromLevel(health, 0);
        this.groupID = groupID;
    }
    private double calculateHealthFromLevel(double health, int i){
        if (i < level)
            return calculateHealthFromLevel(health + (health * 0.2), i+1);
        else
            return (int)(health * 100) / 100.0;
    }
    public String getInfo(){
        return String.format("Имя: %s\nЗдоровье: %s\nУровень: %s\nГруппа: %s\n",
                name, health, level, GroupManager.getGroupFromID(groupID));
    }
    public String[] getAttributes(){
        return new String[]{name, Integer.toString(level), Integer.toString(groupID),
                Double.toString(health),};
    }

    // Getters и setters

    public int getId() {
        return id;
    }
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
