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

public class CPanelReportes extends JPanel implements IFrameRemisoft, MouseListener {

    private CButtonSelectorPanel reportesButton;

    public CPanelReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(EColorPanel.REPORTES.getColor());
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setReportesButton(new CButtonSelectorPanel(new IPanelFactory() {
            @Override
            public JPanel crearPanel() {
                return new CPanelMenuReportes();
            }
        }, ETextoButton.REPORTES.getTexto(), EToolTipTextTexto.MENUREPORTES.getTexto()));
        this.getReportesButton().setEnabled(false);
        this.getReportesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(getReportesButton())) {
                    // método default de IFrameRemisoft
                    getFrameRemisoft().setearPanelMenu(((CButtonSelectorPanel)e.getSource()).getFactory().crearPanel());
                }
            }
        });
        this.add(getReportesButton());
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this)) {
            getReportesButton().setEnabled(true);
            CDialogLimitadorAcceso.agregarLogin(getReportesButton());
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

    public CButtonSelectorPanel getReportesButton() {
        return this.reportesButton;
    }

    public void setReportesButton(CButtonSelectorPanel reportesButton) {
        this.reportesButton = reportesButton;
    }

}