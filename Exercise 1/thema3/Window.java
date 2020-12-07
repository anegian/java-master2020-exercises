import java.awt.*;

public class Window {

    int height;
    int width;
    String name;
    String color;
    Point point = new Point(0, 0);

    /**
     * - Constructs a window with zero or null values
     * - Name is given as parameter
     */
    protected Window(String name) {

        this.name = name;
    }

    /**
     * - Parameterized constructor for creating windows with values
     */
    protected Window(String name, int height, int width, String color, int point_x, int point_y) {

        this.name = name;
        this.height = height;
        this.width = width;
        this.color = color;
        this.point = new Point(point_x, point_y);
    }

    /**
     * - Returns the name of the window
     *
     * @return String name
     */
    private String getName() {

        return this.name;
    }

    /**
     * - Returns the height of the window
     *
     * @return double
     */
    private int getHeight() {

        return this.height;
    }

    /**
     * - Returns the width of the window
     *
     * @return double
     */
    private int getWidth() {

        return this.width;
    }

    /**
     * - Returns the color of the window
     *
     * @return double
     */
    private String getColor() {

        return this.color;
    }

    /**
     * - Returns the value of the point as String
     *
     * @return String
     */
    private String getPoint() {

        return "(" + (int) this.point.getX() + "," + (int) this.point.getY() + ")";
    }

    /**
     * - Takes 2 new values
     * - Changes height and width values of the windows
     */
    protected void resize(int height, int width) {

        this.height = height;
        this.width = width;
    }

    /**
     * - Moves the point of the windows to other point (x,y)
     */
    protected void move(int x, int y) {

        this.point.move(x, y);     // method .move() of Point class
    }

    /**
     * - Returns the diagonal of square
     * - Returns -1 if the window is not a square
     *
     * @return double
     */
    protected double isSquare() {

        float diagonalSquare = 0;

        // if height and/or width of a window are 0, it is not a square
        if (height == 0 || width == 0) {
            return -1;
        } else {
            // when the height and width values of a window are equal, it is a square
            diagonalSquare = this.height == this.width ? (float) (this.height * Math.sqrt(2)) : -1;
        }

        return diagonalSquare;
    }

    /**
     * Prints out the characteristics of the window
     */
    protected void printWindow() {

        System.out.println("{Window " + "'" + getName() + "'" +
                ", height=" + getHeight() +
                ", width=" + getWidth() +
                ", color='" + getColor() + "'" +
                ", point=" + getPoint() + "}");
    }
}
