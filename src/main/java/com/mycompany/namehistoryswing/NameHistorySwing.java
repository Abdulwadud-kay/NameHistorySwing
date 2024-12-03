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
import java.io.IOException;

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
            resultContainer.setLayout(new BorderLayout());

            JLabel resultTitle = new JLabel("Name: _________");
            resultTitle.setFont(new Font("Arial", Font.BOLD, 18));
            resultTitle.setForeground(new Color(44, 62, 80));
            resultContainer.add(resultTitle, BorderLayout.NORTH);

            JTextArea resultDescription = new JTextArea("");
            resultDescription.setFont(new Font("Arial", Font.PLAIN, 20));
            resultDescription.setForeground(new Color(52, 73, 94));
            resultDescription.setLineWrap(true); // Enable line wrapping
            resultDescription.setWrapStyleWord(true); // Wrap at word boundaries
            resultDescription.setEditable(false); // Make it non-editable
            resultDescription.setBackground(Color.WHITE); // Match the background
            resultDescription.setBorder(null);

//            resultContainer.add(resultDescription);

            JScrollPane scrollPane = new JScrollPane(resultDescription);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            resultContainer.add(scrollPane, BorderLayout.CENTER);

            mainPanel.add(resultContainer);

            // Event handler for Enter button
            enterButton.addActionListener(e -> {
                String enteredName = searchBar.getText().trim();
                if (enteredName.isEmpty()) {
                    resultTitle.setText("Name: Invalid Entry");
                    resultDescription.setText("Please enter a valid name to fetch details.");
                } else {
                    try {
                        // Make API call to fetch name history

                        String apiResponse = NameInfoClient.getNameInfo(enteredName);
//                        String[] contents = NameInfoParser.parseNameInfo(apiResponse);
                        System.out.println(apiResponse);

                        if (apiResponse != null) {
                            // If API response is valid, update UI
                            resultTitle.setText("Name: " + enteredName);
                            resultDescription.setText(apiResponse);
                            
                        } else {
                            // If API fails, show default message
                            resultTitle.setText("Name: " + enteredName);
                            resultDescription.setText("Description: Failed to fetch details. Please try again later.");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        // Handle the exception, e.g., show an error message
                        resultTitle.setText("Name: " + enteredName);
                        resultDescription.setText("Description: An error occurred while fetching details.");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        // Handle the exception, e.g., show an error message
                        resultTitle.setText("Name: " + enteredName);
                        resultDescription.setText("Description: An error occurred while fetching details.");
                    }
                }
            });

            frame.setVisible(true);
        });
    }
}
