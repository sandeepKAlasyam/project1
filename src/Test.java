public class Test {
    //Default exception
    public static void main(String[] args) {

        doStuff();

    }
    private static void doStuff() {
        domoreStuff();

    }

    private static void domoreStuff() {
        System.out.println(10/0);
    }
}
