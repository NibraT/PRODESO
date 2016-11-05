package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by Pulpo1 on 10/31/16.
 */
public class CDeleteSQL extends CDataBase implements ITemporizable {

    public void deleteViaje (int numero) {
        String sql = "DELETE FROM Viaje WHERE Numero = ?";

        try (Connection conn = super.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numero);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args){
        CDeleteSQL d = new CDeleteSQL();
        //d.deleteViaje(5);
    }

    @Override
    public Calendar calcularTiempo() {
        return null;
    }

    @Override
    public String setFechaYHora() {
        return null;
    }

    @Override
    public Calendar setFechaCalendar(String fecha) {
        return null;
    }

    @Override
    public Calendar setHoraCalendar(String hora) {
        return null;
    }

    @Override
    public String setFechaString(Calendar fecha) {
        return null;
    }

    @Override
    public String setFechaString() {
        return null;
    }

    @Override
    public String setHoraString(Calendar hora) {
        return null;
    }
}
