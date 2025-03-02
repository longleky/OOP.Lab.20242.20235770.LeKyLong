import javax.swing.JOptionPane;
public class bai226_3{
    public static void main(String[] args){
        String strA, strB, strC;
        String strNotification = "Quadratic Equation: ax^2 + bx + c = 0\n";

        strA = JOptionPane.showInputDialog(null,"Input a","ax^2+bx+c=0",JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);

        if (a == 0) {
                JOptionPane.showMessageDialog(null, "Invalid input: a must be different from 0!", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        strB = JOptionPane.showInputDialog(null,"Input b","ax^2+bx+c=0",JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strB);

        strC = JOptionPane.showInputDialog(null,"Input c","ax^2+bx+c=0",JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(strC); 
        String result;
        double delta = b*b - 4*a*c;
        if(delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2*a);
            result = "two distinct solution: x1 = " + String.format("%.2f",x1) + ", x2 = " + String.format("%.2f",x2);
        }
        else if(delta == 0){
            double x = -b/(2*a);
            result = "Double solution: x = " + String.format("%.2f", x);
        }
        else result = "No solution";
        strNotification += result;
            JOptionPane.showMessageDialog(null,strNotification,"result",JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);
    }
}