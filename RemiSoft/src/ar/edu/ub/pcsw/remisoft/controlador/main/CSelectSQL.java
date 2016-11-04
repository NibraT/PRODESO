package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.lang.*;

public class CSelectSQL extends CDataBase implements ITemporizable{

    public String[] selectAutoDisponibles(int disponible) {
        String sql = "SELECT Patente FROM Vehiculo where disponible = " + disponible;
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");

        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("Patente"));
            }
            String[] resultString = new String[result.size()];
            resultString = result.toArray(resultString);
            return resultString;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            //CLogger.getInstance().logException(e);
            //    dentro: e.getMessage(), e.getStackTrace() (necesita convertirse a String)
        }
        return null;
    }

    public String[] selectAtributoAuto(String atributo) {
        String sql = "SELECT distinct " + atributo + " FROM Vehiculo where fechaBaja is null";
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");

        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString(atributo));
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

    public String[] selectEmpleadoDisponibles(int disponible, int tipoEmpleado) {
        String sql = "SELECT Dni FROM Empleado where disponible = " + disponible + " and tipoEmpleado = " + tipoEmpleado;
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");

        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("Dni"));
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

    public String[] selectCliente(String identificacion) {
        String sql = "SELECT Identificacion FROM Cliente where Identificacion = " + identificacion;
        ArrayList<String> result = new ArrayList<String>();
        result.add(" ");

        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("Identificacion"));
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

    public void verArray(String[] a){
        for (String i : a) {
            System.out.println(i);
        }
    }

    public static void main (String[] args){
        CSelectSQL s = new CSelectSQL();
        //s.verArray(s.selectDisponibles("Patente", "Vehiculo"));
        //s.verArray(s.selectCliente());
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
