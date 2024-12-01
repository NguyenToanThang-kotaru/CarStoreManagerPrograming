public class Validation {
    public static boolean isInteger(String key){
        if(key == null || key.isEmpty()){
            return false;
        }

        try {
            Integer.parseInt(key);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
