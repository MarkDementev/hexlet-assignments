package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final String reversedString;

    public ReversedSequence(String inputString) {
        StringBuilder reversedStringBuilder = new StringBuilder();

        for (int i = inputString.length() - 1; i >= 0; i--) {
            reversedStringBuilder.append(inputString.charAt(i));
        }
        reversedString = reversedStringBuilder.toString();
    }

    @Override
    public String toString() {
        return reversedString;
    }

    @Override
    public int length() {
        return reversedString.length();
    }

    @Override
    public char charAt(int i) {
        return reversedString.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return reversedString.subSequence(i, i1);
    }
}
// END
