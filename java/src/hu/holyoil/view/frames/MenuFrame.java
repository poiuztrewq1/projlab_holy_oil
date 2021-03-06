package hu.holyoil.view.frames;

import hu.holyoil.controller.GameController;
import hu.holyoil.controller.TurnController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * A játékot indító menüt kijelző panelt implementáló osztály. Itt lehet kiválasztani a játékosok számát, amivel a játék elindul.
 */
public class MenuFrame extends JFrame {
    private JButton playBtn;
    private JSlider slider;
    private int playerCount = TurnController.GetInstance().NUM_OF_PLAYERS_MIN;

    private void InitComponents() {
        // setting background
        JLabel background = new JLabel(new ImageIcon("assets/bg.gif"));
        setContentPane(background);
        setLayout(new FlowLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // setting title
        JLabel title = new JLabel("Holy Oil Game");
        title.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 24));
        title.setForeground(Color.white);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // setting credits
        JLabel credits = new JLabel("Credits: Holy Oil Team     Copyright (c) 2021");
        credits.setForeground(Color.black);
        credits.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel creditPanel = new JPanel();
        creditPanel.setOpaque(false);
        creditPanel.add(credits);
        creditPanel.setBorder(new EmptyBorder(120, 0, 0, 0));

        // setting slider
        JLabel sliderLabel = new JLabel("Number of players:");
        sliderLabel.setForeground(Color.white);

        slider = new JSlider(JSlider.HORIZONTAL,
                TurnController.GetInstance().NUM_OF_PLAYERS_MIN,
                TurnController.GetInstance().NUM_OF_PLAYERS_MAX,
                TurnController.GetInstance().NUM_OF_PLAYERS_MIN);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setOpaque(false);
        slider.setForeground(Color.white);

        // setting btn
        playBtn = new JButton("Play");

        // setting center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new EmptyBorder(20, 30, 30, 30));

        // add elements to layout
        GridLayout layout = new GridLayout(6, 1);
        centerPanel.setLayout(layout);
        centerPanel.add(title);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 50))); // margin
        centerPanel.add(sliderLabel);
        centerPanel.add(slider);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 50))); // margin
        centerPanel.add(playBtn);
        centerPanel.setBackground(new Color(4, 4, 13, 180));

        // adding these to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(creditPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(new EmptyBorder(100, 30, 50, 30));

        // adding main panel to frame
        mainPanel.setOpaque(false);
        add(mainPanel);

        // setting default enter action to button
        getRootPane().setDefaultButton(playBtn);
    }

    private void InitListeners() {
        slider.addChangeListener(e -> playerCount = slider.getValue());

        playBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.GetInstance().StartGame(playerCount);
            }
        });
    }

    public MenuFrame() {
        super();
        setTitle("Holy Oil Game - welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InitComponents();
        InitListeners();
        pack();
        setLocationRelativeTo(null);
    }


}
