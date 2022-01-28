import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class AgeCalculator extends JFrame {
    private JButton calculatAgeButtun;
    private JLabel lableOfBirthDate;
    private JTextField birthDate;

    public AgeCalculator(){
        // window title
        super("Simple Age Calculator");
        // flow layout
        setLayout(new FlowLayout());
        // frame color
        getContentPane().setBackground(Color.LIGHT_GRAY);
        lableOfBirthDate = new JLabel("Enter your date of birth");
        lableOfBirthDate.setFont(new Font("Serif", Font.BOLD, 14));
        add(lableOfBirthDate);
        birthDate = new JTextField(20);
        birthDate.setFont(new Font("Serif", Font.BOLD, 14));
        birthDate.setToolTipText("Enter date in  dd-MM-yyyy format");
        add(birthDate);
        calculatAgeButtun = new JButton("Calculate my age");
        calculatAgeButtun.setForeground(Color.LIGHT_GRAY);
        calculatAgeButtun.setBackground(Color.DARK_GRAY);
        add(calculatAgeButtun);
        Handy handy = new Handy();
        calculatAgeButtun.addActionListener(handy);
    }

    private class Handy implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try {
                String birthDay = birthDate.getText();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(birthDay);
                Instant instant = date.toInstant();
                ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
                LocalDate givenDate = zone.toLocalDate();
                Period period = Period.between(givenDate, LocalDate.now());
                // show age in popup window
                JOptionPane.showMessageDialog(null,
                        String.format("your age is %s year %s month and %s days",
                        period.getYears(), period.getMonths(), period.getDays()));
            } catch (ParseException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        }
    }
}
