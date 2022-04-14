package suanfa.com.regex;

public class AppleComparator {
    public int compareByWeight(Apple a1, Apple a2) {
        double diff = a1.getWeight() - a2.getWeight();
        return new Double(diff).intValue();
    }
}
