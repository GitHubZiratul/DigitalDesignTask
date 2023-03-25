package com.digdes.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaSchoolStarter {
    public JavaSchoolStarter() {

    }

    private List<Map<String, Object>> data = new ArrayList<>();


    public List<Map<String, Object>> execute(String request) throws Exception {
        String requestParts[] = request.split("\\s+");
        String operation = requestParts[0].toUpperCase();

        switch (operation) {
            case "INSERT":
                String insertValues = request.substring(request.toUpperCase().indexOf("VALUES") + 6);
                if (insertValues.trim().isEmpty()) {
                    throw new IllegalArgumentException("Значения для вставки не найдены");
                }
                insertCollection(insertValues);
                System.out.println(data);
                break;
            case "UPDATE":
                break;
            case "DELETE":
                break;
            case "SELECT":
                break;
            default:
                throw new IllegalArgumentException("Неизвестная комманда " + operation);
        }


        return new ArrayList<>();

    }

    private void insertCollection(String values) {
        Map<String, Object> newRow = new HashMap<>();
        String[] parts = values.split(",");
        for (String part : parts) {
            String[] columnValue = part.trim().split("=");
            newRow.put(columnValue[0].toLowerCase().replace("'", "").replaceAll("[\\s'\"]", ""),checkValues(columnValue));
        }
        data.add(newRow);


    }

    private Object checkValues(String[] columnAndValue) {
        String column = columnAndValue[0].trim().replace("'", "").toLowerCase();
        String value = columnAndValue[1].trim().replace("'", "");
        Map<String, Object> checkValue = new HashMap<>();
        switch (column) {
            case ("id"):
                try {
                    long id = Long.parseLong(value);
                    return id;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid value for ID: " + value, e);
                }

            case ("lastname"):
                return value;

            case ("age"):
                try {
                    long age = Long.parseLong(value);
                    return age;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid value for age:" + value, e);
                }

            case ("cost"):
                try {
                    double cost = Double.parseDouble(value);
                    return cost;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid value for cost:" + value, e);
                }

            case ("active"):
                try {
                    boolean active = Boolean.parseBoolean(value);
                    return active;
                } catch (IllegalAccessError e) {
                    throw new IllegalArgumentException("Invalid value for active:" + value, e);
                }

            default:
                throw new IllegalArgumentException("Unknown command: " + column);
        }
    }

}

