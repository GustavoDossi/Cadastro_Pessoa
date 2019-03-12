package components;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

public class FTFCPF extends JFormattedTextField implements ComponentInterface {

    private boolean obrigatorio;
    private String dica;

    public FTFCPF(boolean obrigatorio, String dica) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent fe) {
                setBackground(Color.white);
            }

            public void focusGained(FocusEvent fe) {
                setBackground(Color.yellow);
            }
        });
        setColumns(10);

        /**
         * Formata o campo em uma mascara para CPF
         */
        try {
            this.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void limpar() {
        setText("");
    }

    @Override
    public void habilitar(boolean status) {
        setEnabled(status);
    }

    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }

    @Override
    public boolean eValido() {
        return true;
    }

    @Override
    public boolean eVazio() {
        return getText().trim().isEmpty();
    }

    @Override
    public String getDica() {
        return dica;
    }

}
