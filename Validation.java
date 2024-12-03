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

    public static boolean isDate(String date) {
        if (date == null || date.isEmpty())
            return false;
        else{
            // Tách chuỗi ngày theo dấu "/"
            String[] parts = date.split("/");

            // Đảm bảo chuỗi có đúng 3 phần
            if (parts.length != 3) {
                return false;
            }

            try {
                // Chuyển đổi các phần sang số nguyên
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                // Kiểm tra giá trị hợp lệ của tháng
                if (month < 1 || month > 12) {
                    return false;
                }

                // Số ngày tối đa trong mỗi tháng
                int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                // Nếu là năm nhuận, tháng 2 có 29 ngày
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    daysInMonth[1] = 29;
                }

                // Kiểm tra giá trị hợp lệ của ngày
                if (day < 1 || day > daysInMonth[month - 1]) {
                    return false;
                }

                return true;

            } catch (NumberFormatException e) {
                // Nếu không thể chuyển đổi sang số nguyên, chuỗi không hợp lệ
                return false;
            }
        }
    }
}
