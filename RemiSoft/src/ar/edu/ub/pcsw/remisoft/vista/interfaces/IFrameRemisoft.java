package ar.edu.ub.pcsw.remisoft.vista.interfaces;

import ar.edu.ub.pcsw.remisoft.vista.frame.CFrameRemisoft;

import javax.swing.*;

public interface IFrameRemisoft {

    default CFrameRemisoft getFrameRemisoft() {
        JPanel panel = (JPanel) this;
        CFrameRemisoft frameRemisoft = (CFrameRemisoft) panel.getParent().getParent().getParent().getParent().
                getParent();
        return frameRemisoft;
    }
}
