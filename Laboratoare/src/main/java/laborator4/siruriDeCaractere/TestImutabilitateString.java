package main.java.laborator4.siruriDeCaractere;

public class TestImutabilitateString {
    public static void main(String[] args) {
        String s1 = "abc";
        StringBuilder sb1 = new StringBuilder(s1);

        appendString(s1, "cde");
        System.out.println("Append pe String: " + s1);

        appendString(sb1, "cde");
        System.out.println("Append pe StringBuilder: " + sb1);
    }



    private static void appendString(Object existing, String toAppend) {
        if (existing instanceof String) {
            existing = existing + toAppend;
        } else if (existing instanceof StringBuilder) {
            ((StringBuilder) existing).append(toAppend);
        } else {
            throw new IllegalArgumentException("Referinsa nu este de tipul String sau StringBuilder");
        }
    }
}
