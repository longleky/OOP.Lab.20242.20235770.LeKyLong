import javax.swing.JOptionPane;
public class bai226_2{
    public static void main(String[] args){
        String strA11, strA12, strA21, strA22, strB1, strB2;
        String strNotification = "equation: a11x + a12y = b1\n a21x +a22y = b2\n";

        strA11 = JOptionPane.showInputDialog(null,"Input a11","equation",JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(strA11);

        strA12 = JOptionPane.showInputDialog(null,"Input a12","equation",JOptionPane.INFORMATION_MESSAGE);
        double a12 = Double.parseDouble(strA12);

        strB1 = JOptionPane.showInputDialog(null,"Input b1","equation",JOptionPane.INFORMATION_MESSAGE);
        double b1 = Double.parseDouble(strB1);

        strA21 = JOptionPane.showInputDialog(null,"Input a21","equation",JOptionPane.INFORMATION_MESSAGE);
        double a21 = Double.parseDouble(strA21);

        strA22 = JOptionPane.showInputDialog(null,"Input a22","equation",JOptionPane.INFORMATION_MESSAGE);
        double a22 = Double.parseDouble(strA22);

        strB2  = JOptionPane.showInputDialog(null,"Input b2","equation",JOptionPane.INFORMATION_MESSAGE);
        double b2 = Double.parseDouble(strB2);

        double D  = a11*a22 - a21*a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = a11*b2 - a21*b1;
        String result;
        if(D==0){
            if(a11 * b2 == a21 * b1 && a12 * b2 == a22 * b1) result = "infinite solution";
            else result = "No solution";
        }
        else{
            double x = D1/D;
            double y = D2/D;
            result = "x = " + String.format("%.2f", x) + ", y = " + String.format("%.2f", y);
        }
        strNotification +="solution: " + result;
        JOptionPane.showMessageDialog(null,strNotification,"result",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }   
}