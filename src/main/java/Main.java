public class Main {
    public static void main( String[] args ) throws InterruptedException {
        /*Main demo = new Main();
        while (true) {
            demo.sayHello();
            demo.sayBye();
            System.out.println("-------------------");
            Thread.sleep(1000);
        }*/
         final char NAME_VALUE_SEPARATOR = '\u0001';
         final char PROPERTY_SEPARATOR = '\u0002';
        System.out.println(NAME_VALUE_SEPARATOR);
        System.out.println(PROPERTY_SEPARATOR);
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }

    public void sayBye() {
        System.out.println("Bye Bye");
        System.out.println("fix good Bye!!");
    }
}
