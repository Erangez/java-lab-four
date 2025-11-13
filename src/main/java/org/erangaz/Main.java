package org.erangaz;

import java.util.ArrayList;
import java.util.List;
public class Main{
    public static void main(String[] args) {
        ArrayList<Creature> creatures = new ArrayList<>();

        Creature creature1 = new Creature();
        Creature creature2 = new Creature("Нечто", 10, 0, 1);

        Guardian guardian1 = new Guardian();
        Guardian guardian2 = new Guardian("Арнольд", 1000, 1, 5, 50, 50);

        creatures.add(creature1);
        creatures.add(creature2);
        creatures.add(guardian1);
        creatures.add(guardian2);
        for (Creature creature : creatures){
            creature.showInfo();
            System.out.println();
        }

//        Frame mainFrame = new Frame();
//        mainFrame.setVisible(true);

    }
}