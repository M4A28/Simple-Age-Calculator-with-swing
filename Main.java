import javax.swing.JFrame;
public class Main extends JFrame {
    public static void main(String...args) {
        AgeCalculator ageCalculator = new AgeCalculator();
        ageCalculator.setSize(300, 150);
        ageCalculator.setVisible(true);
        ageCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
