
import javax.swing.JFrame;

/**
 * @author Julie Greger
 * Homework 4 - Dog Groomer
 */

/** This program allows users to choose determine dog grooming 
 * prices based on the choices they pick.
 */
public class DogGroomingQuote {
    public static void main(String[]args){
        JFrame frame = new DogGroomingChoice();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dog Grooming Services");
        frame.setVisible(true);
    }
}

