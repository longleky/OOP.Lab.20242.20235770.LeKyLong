import javax.swing.JOptionPane;
public class bai226_1{
    public static void main (String[] args) {
        String strA, strB;
        String strNotification = "Equation: ax + b = 0\n";
        strA = JOptionPane.showInputDialog(null,"please input a","ax + b = 0",JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);
        strB = JOptionPane.showInputDialog(null,"please input b","ax + b = 0",JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strB);
        String result;
        if (a==0) {
            if(b==0) result = "Infinite solution";
            else result = "No solution";
        }
        else {
            double x = -b/a;
            result = "solution: x = " + String.format("%.2f", x);
        }
        strNotification += "a = " + a + ", b = " + b + "\n" + result;
        JOptionPane.showMessageDialog(null,strNotification,"result",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}