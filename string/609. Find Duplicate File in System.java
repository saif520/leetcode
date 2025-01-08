class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
         // Create a map to hold file content as key and a list of file paths as value
        Map<String, List<String>> contentToPathsMap = new HashMap<>();

        // Loop over each path in the input array
        for (String path : paths) {
            // Split the current path into directory and files with content
            String[] parts = path.split(" ");
          
            // Skip the first part as it is the directory path and iterate over the files
            for (int i = 1; i < parts.length; ++i) {
                // Find the index of the first '(' to separate file name and content
                int contentStartIndex = parts[i].indexOf('(');
                // Extract the content between parentheses
                String content = parts[i].substring(contentStartIndex + 1, parts[i].length() - 1);
                // Construct the full file path using the directory and the file name
                String fullPath = parts[0] + '/' + parts[i].substring(0, contentStartIndex);
                // Add the full file path to the list of paths for the current content
                contentToPathsMap.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
            }
        }

        // Prepare the result list for duplicate files
        List<List<String>> duplicates = new ArrayList<>();
      
        // Loop over the entries in the content to paths map
        for (List<String> pathsList : contentToPathsMap.values()) {
            // Only consider lists with more than one file path (indicating duplicates)
            if (pathsList.size() > 1) {
                duplicates.add(pathsList);
            }
        }

        // Return the list of duplicates
        return duplicates;
    }
}