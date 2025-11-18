package org.erangaz;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Frame extends JFrame implements ActionListener {
    // Constants
    final int FRAME_WIDTH = 1280, FRAME_HEIGHT = 720;
    final Color BACKGROUND_COLOR = new Color(25, 26, 28);
    final Color PANEL_COLOR = new Color(37, 39, 42);
    final Color PANEL_COLOR_BLUE = Color.decode("#3daee9");
    final Border transparentBorder = BorderFactory.createLineBorder(new Color(0,0,0,0), 2);
    final Border blueBorder = BorderFactory.createLineBorder(PANEL_COLOR_BLUE, 2);
    final Font FONT_14pt = new Font("fonts/airborne.ttf", Font.PLAIN, 14);
    final Font FONT_16pt = new Font("fonts/airborne.ttf", Font.PLAIN, 16);

    final String[] randomCreatureNames = {"Существо", "Сущность", "Нечто", "Null", "Оно"};
    final String[] randomGuardianNames = {"Матильда", "Сесилия ", "Гильда", "Уинифред",
            "Осберт", "Иоханн", "Генрих", "Ральф"};
    final String[] randomGuardianSubNames = {"де Рос", "де Монтермар", "де Ольстер", "Болдуин",
            "Чилхем", "Вигмор", "де Монфор", "Типтофт"};
    final String[] randomEnemyNames = {"Драмор","Брактул","Боргмайр","Дратар",
            "Гритбит","Вексрокс","Уксбор","Цунхан"};
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
    int id;
    JTextField levelTextField;
    JTextArea infoTextArea;
    JButton addButton, deleteButton, infoButton;
    JComboBox groupList;
    String[][] data = new String[0][0];
    ObjectManager objectManager = new ObjectManager();
    Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(750, 400));
        setResizable(true);


        // Элементы интерфейса
        JLabel levelLabel = new JLabel("Уровень:");
        levelTextField = new JTextField();

        tableModel = new DefaultTableModel(data, names){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        String[] groupStrings = GroupManager.getGroupArray();
        groupList = new JComboBox(groupStrings);

        addButton = new JButton("Добавить");
        addButton.addActionListener(this);
        deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(this);
        infoButton = new JButton("Инфо");
        infoButton.addActionListener(this);


        infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(transparentBorder);

        // Визуал элементов интерфейса
        levelLabel.setForeground(Color.WHITE);
        levelLabel.setFont(FONT_16pt);
        levelTextField.setFont(FONT_14pt);
        levelTextField.setBackground(PANEL_COLOR);
        levelTextField.setBorder(transparentBorder);
        levelTextField.setForeground(Color.WHITE);
        levelTextField.setMinimumSize(new Dimension(levelTextField.getWidth(), 30));
        groupList.setBackground(PANEL_COLOR);
        groupList.setForeground(Color.WHITE);
        groupList.setFont(FONT_14pt);
        groupList.setBorder(transparentBorder);
        groupList.setMinimumSize(new Dimension(groupList.getWidth(), 30));
        groupList.setUI(new BasicComboBoxUI(){
            @Override
            protected ComboPopup createPopup(){
                return new BasicComboPopup(groupList){
                    {
                        this.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR, 2));
                    }
                };
            }
            @Override
            protected JButton createArrowButton(){
                JButton button = new JButton();
                button.setBackground(PANEL_COLOR_BLUE);
                button.setBorder(transparentBorder);
                return button;
            }
        });
        groupList.setRenderer(new ListCellRenderer<String>(){
            @Override
            public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel(value);
                label.setOpaque(true);
                label.setBackground(isSelected ? PANEL_COLOR_BLUE : PANEL_COLOR);
                label.setFont(FONT_14pt);
                label.setForeground(Color.WHITE);
                return label;
            }
        });
        addButton.setFont(FONT_14pt);
        addButton.setBackground(PANEL_COLOR);
        addButton.setBorder(transparentBorder);
        addButton.setForeground(Color.WHITE);
        addButton.setMinimumSize(new Dimension(200, 30));
        addButton.setMaximumSize(new Dimension(500, 40));
        deleteButton.setFont(FONT_14pt);
        deleteButton.setBackground(PANEL_COLOR);
        deleteButton.setBorder(transparentBorder);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setMinimumSize(new Dimension(200, 30));
        deleteButton.setMaximumSize(new Dimension(500, 40));
        infoButton.setFont(FONT_14pt);
        infoButton.setBackground(PANEL_COLOR);
        infoButton.setBorder(transparentBorder);
        infoButton.setForeground(Color.WHITE);
        infoButton.setMinimumSize(new Dimension(200, 30));
        infoButton.setMaximumSize(new Dimension(500, 40));
        infoTextArea.setFont(FONT_14pt);
        infoTextArea.setBorder(transparentBorder);
        infoTextArea.setBackground(PANEL_COLOR);
        infoTextArea.setForeground(Color.WHITE);
        table.setBackground(PANEL_COLOR);
        table.setFont(FONT_14pt);
        table.setForeground(Color.WHITE);
        table.setGridColor(BACKGROUND_COLOR);
        table.getTableHeader().setBackground(PANEL_COLOR_BLUE);
        table.getTableHeader().setFont(FONT_16pt);
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBorder(blueBorder);
        table.setBorder(transparentBorder);
        scrollPane.setBorder(BorderFactory.createLineBorder(PANEL_COLOR, 2));
        scrollPane.getViewport().setBackground(PANEL_COLOR);

        // Планировщик
        GroupLayout layout = new GroupLayout(mainPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addComponent(levelLabel);
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(levelTextField)
                .addComponent(scrollPane));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(groupList)
                .addComponent(addButton)
                .addComponent(deleteButton)
                .addComponent(infoButton)
                .addComponent(infoTextArea));
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
                        .addComponent(infoTextArea)));
        layout.setVerticalGroup(vGroup);
        mainPanel.setLayout(layout);

        // Adding
        add(mainPanel);
    }
    // Функционал
    public void actionPerformed(ActionEvent event){
        int diceNumber;
        int rowsAmount = table.getRowCount();
        if (!checkStringToInteger(levelTextField.getText()) || Integer.parseInt(levelTextField.getText()) < 1){
            JOptionPane.showMessageDialog(this,
                    "Неправильный ввод уровня!",
                    "Ошибка ввода",
                    JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (event.getSource() == addButton){
                diceNumber = new Random().nextInt(10);
                switch (groupList.getSelectedIndex()){
                    case 0:
                        if (diceNumber % 2 == 0){
                            objectManager.add(new Creature(id));
                        }
                        else{
                            objectManager.add(new Creature(
                                    id,
                                    randomCreatureNames[new Random().nextInt(randomCreatureNames.length)],
                                    100,
                                    0,
                                    Integer.parseInt(levelTextField.getText())
                            ));
                        }
                        data = Arrays.copyOf(data, rowsAmount + 1);
                        data[rowsAmount] = new String[]{
                                Integer.toString(id),
                                objectManager.getObject(id).name,
                                Integer.toString(objectManager.getObject(id).getLevel()),
                                Integer.toString(objectManager.getObject(id).getGroupID())
                        };
                        break;
                    case 1:
                        if (diceNumber % 2 == 0){
                            objectManager.add(new Guardian(id));
                        }
                        else{
                            objectManager.add(new Guardian(
                                    id,
                                    randomGuardianNames[new Random().nextInt(randomGuardianNames.length)] + " " +
                                            randomGuardianSubNames[new Random().nextInt(randomGuardianSubNames.length)],
                                    200,
                                    1,
                                    Integer.parseInt(levelTextField.getText()),
                                    100,
                                    new Random().nextInt(61+1)
                            ));
                        }
                        data = Arrays.copyOf(data, rowsAmount + 1);
                        data[rowsAmount] = new String[]{
                                Integer.toString(id),
                                objectManager.getObject(id).name,
                                Integer.toString(objectManager.getObject(id).getLevel()),
                                Integer.toString(objectManager.getObject(id).getGroupID())
                        };
                        break;
                    case 2:
                        if (diceNumber % 2 == 0){
                            objectManager.add(new Enemy(id));
                        }
                        else{
                            objectManager.add(new Enemy(
                                    id,
                                    randomEnemyNames[new Random().nextInt(randomEnemyNames.length)],
                                    200,
                                    1,
                                    Integer.parseInt(levelTextField.getText()),
                                    100,
                                    1 + (int)(Math.random() * 2 * 10) / 10d
                            ));
                        }
                        data = Arrays.copyOf(data, rowsAmount + 1);
                        data[rowsAmount] = new String[]{
                                Integer.toString(id),
                                objectManager.getObject(id).name,
                                Integer.toString(objectManager.getObject(id).getLevel()),
                                Integer.toString(objectManager.getObject(id).getGroupID())
                        };
                        break;
                    }
                    tableModel.addRow(data[rowsAmount]);
                    id++;
                }
            }
        if (event.getSource() == deleteButton){
            int selectedRowId = table.getSelectedRow();
            if (selectedRowId != -1){
                tableModel.removeRow(selectedRowId);
                objectManager.delete(Integer.parseInt(data[selectedRowId][0]));
                data = deleteDataElement(data, Integer.parseInt(data[selectedRowId][0]));
            }
            scrollPane.setViewportView(table);
        }
        if (event.getSource() == infoButton){
            int selectedRowID = table.getSelectedRow();
            String attributes;
            if (selectedRowID != -1){
                attributes = objectManager.getObject(Integer.parseInt(data[selectedRowID][0])).getInfo(false);
                infoTextArea.setText(String.format("ID: %s\n%s", objectManager.getObject(Integer.parseInt(data[selectedRowID][0])).getId(), attributes));
            }
        }
    }

    // Остальные методы
    public static boolean checkStringToInteger(String string){
        if (string == null){return false;}
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException exception){
            return false;
        }
    }
    public String[][] deleteDataElement(String[][] data, int indexToRemove) {
        String[][] buffer_data = new String[data.length - 1][5];
        int buffer_i = 0;
        for (String[] obj : data) {
            if (Integer.parseInt(obj[0]) != indexToRemove) {
                buffer_data[buffer_i] = obj;
                buffer_i++;
            }
        }
        return buffer_data;
    }
}