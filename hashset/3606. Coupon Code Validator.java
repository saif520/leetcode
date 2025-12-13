class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Coupon> validCoupons = new ArrayList<>();

        Set<String> validBusinessLines = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));
        Map<String, Integer> businessLineOrder = new HashMap<>();
        businessLineOrder.put("electronics", 0);
        businessLineOrder.put("grocery", 1);
        businessLineOrder.put("pharmacy", 2);
        businessLineOrder.put("restaurant", 3);

        for (int i = 0; i < n; i++) {
            if (isActive[i] &&
                code[i] != null && !code[i].isEmpty() &&
                code[i].matches("^[a-zA-Z0-9_]+$") &&
                validBusinessLines.contains(businessLine[i])) {
                
                validCoupons.add(new Coupon(code[i], businessLine[i]));
            }
        }

        // Sort the coupons based on businessLine order and code lexicographically
        Collections.sort(validCoupons, (a, b) -> {
            int cmp = Integer.compare(businessLineOrder.get(a.businessLine), businessLineOrder.get(b.businessLine));
            if (cmp == 0) {
                return a.code.compareTo(b.code);
            }
            return cmp;
        });

        // Extract sorted coupon codes
        List<String> result = new ArrayList<>();
        for (Coupon c : validCoupons) {
            result.add(c.code);
        }

        return result;
    }

    // Helper class to store coupon info
    class Coupon {
        String code;
        String businessLine;

        public Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}