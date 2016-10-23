package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.lang.*;

/**
 * Created by Pulpo1 on 10/21/16.
 */
public class CSelectSQL extends CDataBase implements ITemporizable{

    public String[] selectDisponibles(String select, String from) {
        String sql = "SELECT " + select + " FROM " + from +  " where disponible = 1";
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");

        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString(select));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main (String[] args){
        CSelectSQL s = new CSelectSQL();
        //s.verArray(s.selectVehiculosDisponibles());
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
    public String setHoraString(Calendar hora) {
        return null;
    }
}