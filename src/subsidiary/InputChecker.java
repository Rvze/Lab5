package subsidiary;

public interface InputChecker {
    static boolean checkInt(String s) {
        try {
            Integer.parseInt(s);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    static boolean checkLong(String s) {
        try {
            Long.parseLong(s);

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
