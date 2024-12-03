/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.namehistoryswing;

/**
 *
 * @author cait
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class NameInfoParser {

    public static String parseNameInfo(String jsonResponseString) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Parse the top-level JSON response
//        JsonNode rootNode = objectMapper.readTree(jsonResponseString);
//
//        // Extract the "name_info" field (which is a string)
//        String nameInfoString = rootNode.get("name_info").asText();
//
//        // Parse the "name_info" string into a JSON array
//        JsonNode nameInfoArray = objectMapper.readTree(nameInfoString);
//
//        // Create an array to store the six categories
//        String[] categoriesArray = new String[6];
//
//        // Iterate over the array and store each category content into the array
//        int index = 0;
//        for (JsonNode categoryNode : nameInfoArray) {
//            // Each categoryNode is an object with one key (the category name)
//            // and its corresponding content
//
//            // Get the first field (there should be only one per categoryNode)
//            Map.Entry<String, JsonNode> field = categoryNode.fields().next();
//            String categoryName = field.getKey();
//            JsonNode contentNode = field.getValue();
//
//            // Convert the contentNode to a string (you can adjust this as needed)
//            String content = contentNode.toString();
//
//            // Store the content in the array
//            categoriesArray[index] = content;
//            index++;
//        }

        return jsonResponseString;
    }
}

