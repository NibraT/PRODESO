package ar.edu.ub.pcsw.remisoft.controlador.main;

public enum ETablas {

    ARREGLOAUTO(CDataBase.getListaTablas().get(0)),
    CLIENTE(CDataBase.getListaTablas().get(1)),
    CLIENTECUENTA(CDataBase.getListaTablas().get(2)),
    CUENTA(CDataBase.getListaTablas().get(3)),
    EMPLEADO(CDataBase.getListaTablas().get(4)),
    FACTURA(CDataBase.getListaTablas().get(5)),
    RENDICION(CDataBase.getListaTablas().get(6)),
    SUCURSAL(CDataBase.getListaTablas().get(7)),
    TIPOEMPLEADO(CDataBase.getListaTablas().get(8)),
    TIPOFACTURA(CDataBase.getListaTablas().get(9)),
    USUARIO(CDataBase.getListaTablas().get(10)),
    VEHICULO(CDataBase.getListaTablas().get(11)),
    VIAJE(CDataBase.getListaTablas().get(12));

    private String nombreTabla;

    ETablas(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    ETablas() {
        for (int i = 0; i < CDataBase.getListaTablas().size() - 1; i++) {
            for (ETablas tabla : ETablas.values()) {
                tabla.setNombreTabla(CDataBase.getListaTablas().get(i));
            }
        }
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

}
