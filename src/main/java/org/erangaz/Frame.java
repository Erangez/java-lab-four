package org.erangaz;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
            "Имя",
            "Уровень",
            "Группа",
    };
    String[][] data = new String[0][0];
    Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(true);

        // UI

        JLabel levelLabel = new JLabel("Уровень:");
        levelLabel.setForeground(Color.WHITE);
        JTextField levelTextField = new JTextField();

        tableModel = new DefaultTableModel(data, names);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        String[] groupStrings = GroupManager.getGroupArray();
        JComboBox groupList = new JComboBox(groupStrings);

        JButton addButton = new JButton("Добавить");
        JButton deleteButton = new JButton("Удалить");
        JButton infoButton = new JButton("Инфо");

        JTextField infoTextField = new JTextField();
        infoTextField.setEditable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(transparentBorder);

        // Планировщик
        GroupLayout layout = new GroupLayout(mainPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addComponent(levelLabel);
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(levelTextField)
                .addComponent(scrollPane));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(groupList)
                .addComponent(addButton)
                .addComponent(deleteButton)
                .addComponent(infoButton)
                .addComponent(infoTextField));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(levelLabel)
                .addComponent(levelTextField)
                .addComponent(groupList));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addComponent(deleteButton)
                        .addComponent(infoButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infoTextField)));
        layout.setVerticalGroup(vGroup);
        mainPanel.setLayout(layout);

        // Adding
        add(mainPanel);
    }
}
