public class AccountNumberGenerator {

    private static int savingsSeq = 100;
    private static int currentSeq = 500;
    private static int pfSeq = 2000;

    public static String generateSavingsAccNo() {
        return "SA" + (++savingsSeq);
    }

    public static String generateCurrentAccNo() {
        return "CA" + (++currentSeq);
    }

    public static String generatePfAccNo() {
        return "PF" + (++pfSeq);
    }
}
