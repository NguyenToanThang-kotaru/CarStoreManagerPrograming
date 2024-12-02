
public final class HeaderFooter {
    private static String title;

    public static void printHeader(String title) {
        System.out.println("===========================" + title + "===========================");
        HeaderFooter.title = title;
    }

    public static void printFooter() {
        System.out.println("===========================" + "=".repeat(HeaderFooter.title.length()) + "===========================");
    }

    public static void printProductHeader(String type) {
        if(type.equalsIgnoreCase("car")){
            System.out.printf("%-10s | %-15s | %-13s | %-13s | %-17s | %-10s | %-10s | %-10s%n", "ID", "Hãng xe", "Tên xe",
                    "Năm sản xuất", "Giá", "Màu", "Số lượng", "Số chỗ ngồi");
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------");
        } else
        if(type.equalsIgnoreCase("motorbike")){
            System.out.printf("%-10s | %-15s | %-13s | %-13s | %-17s | %-10s | %-10s | %-10s%n", "ID", "Hãng xe", "Tên xe",
                    "Năm sản xuất", "Giá", "Màu", "Số lượng", "Phân khối");
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public static void printCustomerHeader(){
        System.out.printf("%-9s | %-31s | %-51s | %-10s | %-5s\n", "ID", "Họ tên", "Địa chỉ", "SĐT", "Tuổi");
        System.out.println("-".repeat(118));
    }
}
