package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.CButtonSelectorPanel;
import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;
import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLimitadorAcceso;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IFrameRemisoft;
import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CPanelAutos extends JPanel implements IFrameRemisoft, MouseListener {

    private CButtonSelectorPanel autosButton;

    public CPanelAutos() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.AUTOS.getColor());
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setAutosButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelMenuAutos();
            }
        }, ETextoButton.AUTOS.getTexto(), EToolTipTextTexto.MENUAUTOS.getTexto()));
        this.getAutosButton().setEnabled(false);
        this.getAutosButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(getAutosButton())) {
                    // método default de IFrameRemisoft
                    getFrameRemisoft().setearPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
                }
            }
        });
        this.add(getAutosButton());
        this.addMouseListener(this);
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

    public CButtonSelectorPanel getAutosButton() { return this.autosButton; }

    public void setAutosButton(CButtonSelectorPanel autosButton) { this.autosButton = autosButton; }

}