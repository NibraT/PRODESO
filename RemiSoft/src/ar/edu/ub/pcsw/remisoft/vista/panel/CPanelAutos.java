package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLimitadorAcceso;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CPanelAutos extends JPanel implements ActionListener, IFrameRemisoft, MouseListener {

    private CButtonSelectorPanel autosButton;

    public CPanelAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setAutosButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelMenuAutos();
            }
        }, ETextoButton.AUTOS.getTexto(), "Habilita Menú Autos"));
        this.getAutosButton().setEnabled(false);
        this.getAutosButton().addActionListener(this);
        this.add(getAutosButton());
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getAutosButton())) {
            getFrameRemisoft().setPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this)) {
            getAutosButton().setEnabled(true);
            CDialogLimitadorAcceso.agregarLogin(getAutosButton());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public CButtonSelectorPanel getAutosButton() {
        return this.autosButton;
    }

    public void setAutosButton(CButtonSelectorPanel autosButton) {
        this.autosButton = autosButton;
    }

}
