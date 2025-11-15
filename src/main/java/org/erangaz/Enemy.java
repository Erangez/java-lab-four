package org.erangaz;

public class Enemy extends Creature{
    private double damage;
    private double damageMultiplier;

    Enemy(){
        name = "Враг";
        setHealth(1);
        setLevel(1);
        setGroupID(2);
        damage = 1;
        damageMultiplier = 1;
    }
    /**
     * @param name имя врага.
     * @param health здоровье врага. Не может быть не менее нуля.
     * @param groupID группа из enum Groups. Для данного класса значение = 2
     *                Подробнее в перечислении.
     * @param level уровень врага.
     * @param damage урон врага. Не может быть не менее нуля.
     * @param damageMultiplier множитель урона. Влияет на параметр урон. Не может быть не менее нуля.
     **/
    Enemy(String name, double health, int groupID, int level, double damage, double damageMultiplier){
        super(name, health, groupID, level);
        if (damageMultiplier <= 0)
            this.damageMultiplier = 0;
        else
            this.damageMultiplier = damageMultiplier;

        if (damage <= 0)
            this.damage = 0;
        else
            this.damage = damage * damageMultiplier;
    }
    @Override
    public void showInfo(){
        System.out.printf("Имя: %s\nЗдоровье: %s\nУровень: %s\nГруппа: %s\nУрон: %s\nМножитель урона %s\n",
                name, getHealth(), getLevel(), GroupManager.getGroupFromID(getGroupID()),damage,damageMultiplier);
    }
    @Override
    public String[] getAttributes(){
        return new String[]{
                name, Double.toString(getHealth()),
                Integer.toString(getLevel()), Integer.toString(getGroupID()),
                Double.toString(damage), Double.toString(damageMultiplier)
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
    public double getDamageMultiplier() {
        return damageMultiplier;
    }
    public void setDamageMultiplier(double damageMultiplier) {
        if (damageMultiplier <= 0)
            this.damageMultiplier = 0;
        else
            this.damageMultiplier = damageMultiplier;
    }
}
