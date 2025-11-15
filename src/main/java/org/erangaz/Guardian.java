package org.erangaz;

public class Guardian extends Creature{
    private double damage;
    private double defence;
    private double defenceMultiplier;

    Guardian(){
        name = "Guardian";
        setHealth(1);
        setLevel(1);
        setGroupID(1);
        damage = 1;
        defence = 0;
        defenceMultiplier = 0;
    }
    /**
     * @param name имя стражника.
     * @param health здоровье стражника. Не может быть не менее нуля.
     * @param groupID группа из enum Groups. Для данного класса значение = 1
     *                Подробнее в перечислении.
     * @param level уровень стражника. Не может быть не менее нуля.
     * @param damage урон стражника. Не может быть не менее нуля.
     * @param defence защита стражника. Влияет на параметр множителя защиты,
     *                который имеет кап в 61 единицу защиты. Не может быть не менее нуля.
     **/
    Guardian(String name, double health, int groupID, int level, double damage, double defence){
        super(name, health, groupID, level);
        if (damage <= 0)
            this.damage = 0;
        else
            this.damage = damage;

        if (defence <= 0)
            this.damage = 0;
        else
            this.defence = defence;
        defenceMultiplier = calculateDefenceMultiplier(defence + 10);
    }
    // Приватный класс
    private double calculateDefenceMultiplier(double defence){
        if (defence <= 10){
            defenceMultiplier = 0;
        }
        else if (defence > 10 && defence <= 71){
            defenceMultiplier = (int)(Math.log10(defence / 10) * 100) / 100.0;
        }
        else {
            defenceMultiplier = (int)(Math.log10(7.1) * 100) / 100.0;
        }
        return defenceMultiplier;
    }
    @Override
    public void showInfo(){
        System.out.printf("Имя: %s\nЗдоровье: %s\nУровень: %s\nГруппа: %s\nУрон: %s\nЗащита: %s%%\n",
                name, getHealth(), getLevel(), GroupManager.getGroupFromID(getGroupID()),damage,defenceMultiplier*100);
    }
    @Override
    public String[] getAttributes() {
        return new String[]{
                name, Double.toString(getHealth()),
                Integer.toString(getLevel()), Integer.toString(getGroupID()),
                Double.toString(damage), Double.toString(defence),
                Double.toString(defenceMultiplier)
        };
    }
    // Getters и setters
    public double getDamage() {
        return damage;
    }
    public void setDamage(double damage) {
        if (damage <= 0)
            this.damage = 0;
        else
            this.damage = damage;
    }
    public double getDefence() {
        return defence;
    }
    public void setDefence(double defence) {
        this.defence = defence;
    }
    public double getDefenceMultiplier() {
        return defenceMultiplier;
    }
}
