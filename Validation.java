public class Validation {
    public static boolean isInteger(String key) {
        if (key == null || key.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(key);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isShort(String key) {
        if (key == null || key.isEmpty()) {
            return false;
        }

        try {
            Short.parseShort(key);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isByte(String key) {
        if (key == null || key.isEmpty()) {
            return false;
        }

        try {
            Byte.parseByte(key);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean isPhoneNumber(String key) {
        if (key == null || key.isEmpty()) {
            return false;
        }
        else if (isInteger(key) == true && key.length() == 10)
            return true;
        return false;
    }
}
