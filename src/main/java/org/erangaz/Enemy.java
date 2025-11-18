package org.erangaz;

public class Enemy extends Creature{
    private double damage;
    private double damageMultiplier;

    Enemy(int id){
        super(id);
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
    Enemy(int id, String name, double health, int groupID, int level, double damage, double damageMultiplier){
        super(id, name, health, groupID, level);
        if (damageMultiplier <= 0)
            this.damageMultiplier = 0;
        else
            this.damageMultiplier = damageMultiplier;

        if (damage <= 0)
            this.damage = 0;
        else
            this.damage = (int)(calculateDamageFromLevel(damage, 0) * damageMultiplier * 100) / 100.0;
    }
    private double calculateDamageFromLevel(double damage, int i){
        if (i < 30 && i < getLevel())
            return calculateDamageFromLevel(damage + (damage * 0.1), i+1);
        else
            return (int)(damage * 100) / 100.0;
    }
    @Override
    public String getInfo(boolean htmlIsNeeded){
        if (htmlIsNeeded)
            return String.format("<html>Имя: %s<br>Здоровье: %s<br>Уровень: %s<br>Группа: %s<br>Урон: %s<br>Множитель урона %s<br></html>",
                    name, getHealth(), getLevel(), GroupManager.getGroupFromID(getGroupID()),damage,damageMultiplier);
        else
            return String.format("Имя: %s\nЗдоровье: %s\nУровень: %s\nГруппа: %s\nУрон: %s\nМножитель урона %s\n",
                    name, getHealth(), getLevel(), GroupManager.getGroupFromID(getGroupID()),damage,damageMultiplier);
    }

    @Override
    public String[] getAttributes(){
        return new String[]{
                name,Integer.toString(getLevel()), Integer.toString(getGroupID()),
                Double.toString(getHealth()),Double.toString(damage),
                Double.toString(damageMultiplier)
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
