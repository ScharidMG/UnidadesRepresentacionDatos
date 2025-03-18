/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidades;

import javax.swing.JOptionPane;

/**
 *
 * @author VALENTINA
 */
public class ControladorUnidades {

    private VistaUnidades vista;

    public ControladorUnidades(VistaUnidades vista) {
        this.vista = vista;

    }

    public void convertir() {
        try {
            String textoValor = vista.getTxtValor().getText();
            if (textoValor.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Queda como duro convertir la nada teacher.");
                return;
            }

            double valor = Double.parseDouble(textoValor);
            String unidad = (String) vista.getCmbUnidad().getSelectedItem();

            System.out.println(valor);
            double bytes = convertirABytes(valor, unidad);
            System.out.println(bytes);

            String resultadoDecimal = generarTextoDecimal(bytes);
            String resultadoBinario = generarTextoBinario(bytes);

            vista.getTxaDecimal().setText(resultadoDecimal);
            vista.getTxaBinario().setText(resultadoBinario);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ese no es un número válido, profe coloque no más el num, no la unidad.");
        }
    }

    private double convertirABytes(double valor, String unidad) {
        if (unidad == null) {
            return 0;
        }

        switch (unidad.trim().toUpperCase()) {
            case "B":
                return valor;
            case "KB":
                return valor * Math.pow(10, 3);
            case "MB":
                return valor * Math.pow(10, 6);
            case "GB":
                return valor * Math.pow(10, 9);
            case "TB":
                return valor * Math.pow(10, 12);
            case "PB":
                return valor * Math.pow(10, 15);
            case "KIB":
                return valor * Math.pow(2, 10);
            case "MIB":
                return valor * Math.pow(2, 20);
            case "GIB":
                return valor * Math.pow(2, 30);
            case "TIB":
                return valor * Math.pow(2, 40);
            case "PIB":
                return valor * Math.pow(2, 50);
            default:
                System.out.println("Profe que le movió, es imposible que le salga esto, no se ni para que lo puse"
                        + "pero ahora no lo quiero quitar asi que aca se queda");
                return 0;
        }
    }

    private String generarTextoDecimal(double bytes) {
        String resultado = "B: " + (long) bytes + "\n";
        resultado += "KB: " + String.format("%.3f", bytes / Math.pow(10, 3)) + "\n";
        resultado += "MB: " + String.format("%.6f", bytes / Math.pow(10, 6)) + "\n";
        resultado += "GB: " + String.format("%.9f", bytes / Math.pow(10, 9)) + "\n";
        resultado += "TB: " + String.format("%.12f", bytes / Math.pow(10, 12)) + "\n";
        resultado += "PB: " + String.format("%.15f", bytes / Math.pow(10, 15)) + "\n";
        return resultado;
    }

    private String generarTextoBinario(double bytes) {
        String resultado = "B: " + (long) bytes + "\n";
        resultado += "KiB: " + String.format("%.3f", bytes / Math.pow(2, 10)) + "\n";
        resultado += "MiB: " + String.format("%.6f", bytes / Math.pow(2, 20)) + "\n";
        resultado += "GiB: " + String.format("%.9f", bytes / Math.pow(2, 30)) + "\n";
        resultado += "TiB: " + String.format("%.12f", bytes / Math.pow(2, 40)) + "\n";
        resultado += "PiB: " + String.format("%.15f", bytes / Math.pow(2, 50)) + "\n";
        return resultado;
    }

}
