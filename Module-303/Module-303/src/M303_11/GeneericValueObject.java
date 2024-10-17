package M303_11;

public class GeneericValueObject<T> {
    private T typeT;
    //private K typeK;

    public T getT() {
        return typeT;
    }
    public void setT(T typeT) {
        this.typeT = typeT;

    }

    public static void main(String[] args) {
        GeneericValueObject<String> str = new GeneericValueObject<>();
        str.setT("String");
        String s1 = str.getT();

        GeneericValueObject<Integer> value = new GeneericValueObject<>();
        value.setT(10);
        Integer i = value.getT();
    }
}
