class Solution {

    // This method will process a list of orders and display them as a table with food item counts.
    public List<List<String>> displayTable(List<List<String>> orders) {
        // Use TreeSet for automatic sorting
        Set<Integer> tableNumbers = new TreeSet<>();
        Set<String> menuItems = new TreeSet<>();

        // This map holds the concatenation of table number and food item as a key, and their count as a value.
        Map<String, Integer> itemCountMap = new HashMap<>();

        // Processing each order to populate sets and the itemCountMap
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);

            // Add the table number and food item to the respective sets
            tableNumbers.add(table);
            menuItems.add(foodItem);

            // Create a unique key for each table-food pair
            String key = table + "." + foodItem;
            itemCountMap.put(key, itemCountMap.getOrDefault(key, 0) + 1);
        }

        // Prepare the result list, starting with the title row
        List<List<String>> result = new ArrayList<>();
        List<String> headers = new ArrayList<>();

        // Adding "Table" as the first column header
        headers.add("Table");
        // Adding the rest of the food items as headers
        headers.addAll(menuItems);
        result.add(headers);

        // Going through each table number and creating a row for the display table
        for (int tableNumber : tableNumbers) {
            List<String> row = new ArrayList<>();
            // First column of the row is the table number
            row.add(String.valueOf(tableNumber));
            // The rest of the columns are the counts of each food item at this table
            for (String menuItem : menuItems) {
                // Forming the key to get the count from the map
                String key = tableNumber + "." + menuItem;
                // Adding the count to the row; if not present, add "0"
                row.add(String.valueOf(itemCountMap.getOrDefault(key, 0)));
            }
            // Add the row to the result list
            result.add(row);
        }

        // Return the fully formed display table
        return result;
    }
}