/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.namehistoryswing;

/**
 *
 * @author abdulwadudabdulkadir
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */




import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NameHistorySwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Name History App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);

            // Main panel with default alignment
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBackground(new Color(244, 244, 249)); // Soft background color
            mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            frame.add(mainPanel);

            // Title
            JLabel title = new JLabel("Name History");
            title.setFont(new Font("Arial", Font.BOLD, 30));
            title.setForeground(new Color(44, 62, 80)); // Dark color
            mainPanel.add(title);

            // Search bar container
            JPanel searchBarContainer = new JPanel();
            searchBarContainer.setBackground(new Color(244, 244, 249));

            JTextField searchBar = new JTextField(20);
            searchBar.setFont(new Font("Arial", Font.PLAIN, 16));
            searchBar.setText("Enter a name...");
            searchBar.setForeground(Color.GRAY);

            JButton enterButton = new JButton("Enter");
            enterButton.setFont(new Font("Arial", Font.PLAIN, 14));
            enterButton.setBackground(new Color(52, 152, 219));
            enterButton.setForeground(Color.BLACK);

            searchBarContainer.add(searchBar);
            searchBarContainer.add(enterButton);

            mainPanel.add(searchBarContainer);

            // Result container with default layout
            JPanel resultContainer = new JPanel();
            resultContainer.setBackground(Color.WHITE);
            resultContainer.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                    BorderFactory.createEmptyBorder(15, 15, 15, 15)
            ));
            resultContainer.setPreferredSize(new Dimension(400, 200));

            JLabel resultTitle = new JLabel("Name: Default Name");
            resultTitle.setFont(new Font("Arial", Font.BOLD, 18));
            resultTitle.setForeground(new Color(44, 62, 80));

            JLabel resultDescription = new JLabel("<html>Description: A placeholder description. This will display the history and details of the name.</html>");
            resultDescription.setFont(new Font("Arial", Font.PLAIN, 14));
            resultDescription.setForeground(new Color(52, 73, 94));

            resultContainer.add(resultTitle);
            resultContainer.add(resultDescription);

            mainPanel.add(resultContainer);

            // Event handler for Enter button
            enterButton.addActionListener(e -> {
                String enteredName = searchBar.getText().trim();
                if (enteredName.isEmpty() || enteredName.equals("Enter a name...")) {
                    resultTitle.setText("Name: Invalid Entry");
                    resultDescription.setText("<html>Please enter a valid name to fetch details.</html>");
                } else {
                    resultTitle.setText("Name: " + enteredName);
                    resultDescription.setText("<html>Description: Historical and cultural details about " + enteredName + ".</html>");
                }
            });

            frame.setVisible(true);
        });
    }
}

