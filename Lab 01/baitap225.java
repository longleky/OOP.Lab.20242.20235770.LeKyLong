import javax.swing.JOptionPane;
public class baitap225{
    public static void main(String[] args){
        String strNum1,strNum2;
        String strNotification = "Sum: ";

        strNum1 = JOptionPane.showInputDialog(null,"Please input the first number : ","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number : ","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String divisionResult;
        if (num2 == 0) {
            divisionResult = "Cannot divide by zero!";
        } else {
            double quotient = num1 / num2;
            divisionResult = "Quotient: " + quotient;
        }
        strNotification += sum + "\n"
                         + "Difference: " + difference + "\n"
                         + "Product: " + product + "\n"
                         + divisionResult; 
        JOptionPane.showMessageDialog(null,strNotification,"quotient", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
