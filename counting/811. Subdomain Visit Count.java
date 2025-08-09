class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
             // Create a map to store subdomain visit counts.
        Map<String, Integer> visitCounts = new HashMap<>();
      
        // Iterate over each combined domain visit count entry.
        for (String domainInfo : cpdomains) {
            // Find the index of the first space to separate number of visits from the domain.
            int spaceIndex = domainInfo.indexOf(" ");
            // Parse the number of visits using the substring before the space.
            int visitCount = Integer.parseInt(domainInfo.substring(0, spaceIndex));
          
            // Start iterating characters at the space to check for subdomains.
            for (int i = spaceIndex; i < domainInfo.length(); ++i) {
                // Check for boundaries of subdomains.
                if (domainInfo.charAt(i) == ' ' || domainInfo.charAt(i) == '.') {
                    // Extract the subdomain using substring.
                    String subdomain = domainInfo.substring(i + 1);
                    // Update the visit count for the current subdomain.
                    visitCounts.put(subdomain, visitCounts.getOrDefault(subdomain, 0) + visitCount);
                }
            }
        }
      
        // Prepare the answer list containing formatted results.
        List<String> results = new ArrayList<>();
        // Iterate through the entry set of the visitCounts map.
        for (Map.Entry<String, Integer> entry : visitCounts.entrySet()) {
            // Format the entry as "visit_count domain" and add it to the results list.
            results.add(entry.getValue() + " " + entry.getKey());
        }
      
        return results;
    }
}