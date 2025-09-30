public interface Input {
    String isLine(String prompt);
    int isInt(String prompt);
    int intInRange(String prompt, int lo, int hi);
    int intAtLeast(String prompt, int lo);
}
