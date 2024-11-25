public class HeaderFooter {
    private static String title;
    public static void printHeader(String title){
        System.out.println("=========" + title + "=========");
        HeaderFooter.title = title;
    }

    public static void printFooter(){
        System.out.println("=========" + "=".repeat(HeaderFooter.title.length()) + "=========");
    }
}
