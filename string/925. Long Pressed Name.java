int nameLength = name.length();
        int typedLength = typed.length();
        int nameIndex = 0, typedIndex = 0;

        // Iterate over each character in both strings
        while (nameIndex < nameLength && typedIndex < typedLength) {
            // If the current characters don't match, return false
            if (name.charAt(nameIndex) != typed.charAt(typedIndex)) {
                return false;
            }

            // Count consecutive characters in the original name
            int nameCharCount = 0;
            char currentChar = name.charAt(nameIndex);
            while (nameIndex + 1 < nameLength && name.charAt(nameIndex + 1) == currentChar) {
                nameIndex++;
                nameCharCount++;
            }

            // Count consecutive characters in the typed string
            int typedCharCount = 0;
            while (typedIndex + 1 < typedLength && typed.charAt(typedIndex + 1) == currentChar) {
                typedIndex++;
                typedCharCount++;
            }

            // If the original name has more consecutive characters than the typed one, return false
            if (nameCharCount > typedCharCount) {
                return false;
            }

            // Move to the next character
            nameIndex++;
            typedIndex++;
        }

        // If we have reached the end of both strings, the name is correctly typed
        return nameIndex == nameLength && typedIndex == typedLength;