import javax.swing.*;

public class DivisaoFinally {

    public static void main(String[] args) {

        String snum1 = JOptionPane.showInputDialog("Digite o primeiro numero:");
        if (snum1 == null) {
            System.exit(0);
        }

        String snum2 = JOptionPane.showInputDialog("Digite o primeiro numero:");
        if (snum2 == null) {
            System.exit(0);
        }

        try {
            int num1 = Integer.parseInt(snum1);
            int num2 = Integer.parseInt(snum2);
            JOptionPane.showMessageDialog(null, "Divisao = " + (num1 / num2));

        } catch (ArithmeticException erro) {
            JOptionPane.showMessageDialog(null, "Erro de divisão por zero!\n" + erro, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Digite apensa numeros inteiros!\n" + erro, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            JOptionPane.showMessageDialog(null, "Final de execução!");
        }

        System.exit(0);

    }
}
