class Solution {

    public String validIPAddress(String queryIP) {

        if (queryIP.indexOf('.') >= 0) {

            String[] parts = queryIP.split("\\.", -1);

            if (parts.length != 4)
                return "Neither";

            for (String part : parts) {

                if (part.length() == 0 || part.length() > 3)
                    return "Neither";

                if (part.length() > 1 && part.charAt(0) == '0')
                    return "Neither";

                for (char c : part.toCharArray()) {
                    if (!Character.isDigit(c))
                        return "Neither";
                }

                int num = Integer.parseInt(part);

                if (num < 0 || num > 255)
                    return "Neither";
            }

            return "IPv4";
        }

        if (queryIP.indexOf(':') >= 0) {

            String[] parts = queryIP.split(":", -1);

            if (parts.length != 8)
                return "Neither";

            String hex = "0123456789abcdefABCDEF";

            for (String part : parts) {

                if (part.length() == 0 || part.length() > 4)
                    return "Neither";

                for (char c : part.toCharArray()) {

                    if (hex.indexOf(c) == -1)
                        return "Neither";
                }
            }

            return "IPv6";
        }

        return "Neither";
    }
}