package org.erangaz;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Frame extends JFrame {
    // Constants
    final int FRAME_WIDTH = 1280, FRAME_HEIGHT = 720;
    final Color BACKGROUND_COLOR = new Color(25, 26, 28);
    final Color PANEL_COLOR = new Color(37, 39, 42);
    final Border transparentBorder = BorderFactory.createLineBorder(new Color(0,0,0,0));
    final Font FONT_14pt = new Font("fonts/airborne.ttf", Font.PLAIN, 14);
    final Font FONT_16pt = new Font("fonts/airborne.ttf", Font.PLAIN, 16);

    // Fields
    JScrollPane scrollPane;
    JTable table;
    DefaultTableModel tableModel;
    String[] names = {
            "ID",
            "Название",
            "Тип",
            "Цена",
            "Рейтинг"
    };
    String[][] data = new String[0][0];
    Frame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(true);

        // GUI

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(transparentBorder);

        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JTextField attributesTextField = new JTextField();
        attributesTextField.setFont(FONT_14pt);
        attributesTextField.setBackground(Color.BLUE);


//        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
//        hGroup.addGroup(layout.createParallelGroup().
//                addComponent(label1).addComponent(label2));
//        hGroup.addGroup(layout.createParallelGroup().
//                addComponent(textField1).addComponent(textField2));
//        layout.setHorizontalGroup(hGroup);
//
//        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
//        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
//                addComponent(label1).addComponent(textField1));
//        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
//                addComponent(label2).addComponent(textField2));
//        layout.setVerticalGroup(vGroup);
        // Adding
        add(mainPanel);



    }
}
