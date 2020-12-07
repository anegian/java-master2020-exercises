public class WindowApp {

    public static void main(String[] args) {
        Window w1 = new Window("w1");
        Window w2 = new Window("w2", 15, 10, "blue",2,2);

        w1.printWindow();     // prints window state //
        w2.printWindow();

        w1.move(2, 2);  // moves w1 window until coordinates plane become (2,2) //
        w1.printWindow();

        w2.resize(w2.height/2, w2.width*2);      // changes w2, (height /2), (width *2)
        w2.printWindow();

        System.out.println(w2.isSquare());  // calculates diagonal of square if it is a square //

    }
}