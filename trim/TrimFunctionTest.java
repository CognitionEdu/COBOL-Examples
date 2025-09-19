public class TrimFunctionTest {
    public static void main(String[] args) {
        String testString1 = "    hello Devin               ";
        
        System.out.println("--" + testString1 + "--");
        System.out.println("--" + testString1.trim() + "--");
        System.out.println("--" + testString1.stripLeading() + "--");
        System.out.println("--" + testString1.stripTrailing() + "--");
        
        String testString2;
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = padRight(testString1, 30);
        System.out.println(testString2);
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = padRight(testString1.trim(), 30);
        System.out.println(testString2);
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = padRight(testString1.stripLeading(), 30);
        System.out.println(testString2);
        
        testString2 = "******************************";
        System.out.println(testString2);
        testString2 = padRight(testString1.stripTrailing(), 30);
        System.out.println(testString2);
        
        System.out.println("--" + "    String literal    " + "--");
        System.out.println("--" + "   String literal    ".trim() + "--");
        System.out.println("--" + "     String literal   ".stripLeading() + "--");
        System.out.println("--" + "   String literal    ".stripTrailing() + "--");
    }
    
    private static String padRight(String str, int length) {
        if (str.length() >= length) {
            return str.substring(0, length);
        }
        return str + " ".repeat(length - str.length());
    }
}
