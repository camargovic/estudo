import javax.swing.*;

public class ExemploThrow {

    public static void main(String[] args) {
        float nota1 = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota 1 (entre 0 e 10"));
        float nota2 = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota 2 (entre 0 e 10"));

        try {
            if (nota1 < 0 || nota1 > 10) {
                throw new LimiteUltrapasadoException("Nota1: valor fora dos limites permitidos");
            }

            if (nota2 < 0 || nota2 > 10) {
                throw new LimiteUltrapasadoException("Nota2: valor fora dos limites permitidos");
            }
            JOptionPane.showMessageDialog(null, "Média = " + (nota1 + nota2) / 2);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        System.exit(0);

    }


}
