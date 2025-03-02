import javax.swing.JOptionPane;
public class Bai61ChoosingOption {
	public static void main(String[] args){
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticker?");
		JOptionPane.showMessageDialog(null,"you've choose: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}