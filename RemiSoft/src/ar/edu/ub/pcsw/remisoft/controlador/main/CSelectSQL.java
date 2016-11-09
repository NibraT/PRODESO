package ar.edu.ub.pcsw.remisoft.controlador.main;

import ar.edu.ub.pcsw.remisoft.modelo.interfaces.ITemporizable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

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
        }
        return null;
    }

    public String[] selectAtributoAuto(String atributo) {
        String sql = "SELECT distinct " + atributo + " FROM Vehiculo where disponible = 1";
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
        String sql = "SELECT Dni FROM Empleado where disponible = " + disponible + " and tipoEmpleado = " +
                tipoEmpleado;
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

    public String[] selectViajesNumero (String identificacion) {
        String sql = "SELECT Numero FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("Numero"));
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

    public String[] selectViajesChofer (String identificacion) {
        String sql = "SELECT Numero, dni FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("dni"));
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

    public String[] selectViajesAuto (String identificacion) {
        String sql = "SELECT Numero, patente FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("patente"));
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

    public String[] selectViajesFecha (String identificacion) {
        String sql = "SELECT Numero, fecha FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("fecha"));
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

    public String[] selectViajesHora (String identificacion) {
        String sql = "SELECT Numero, horaInicio FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("horaInicio"));
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

    public String[] selectViajesOrigen (String identificacion) {
        String sql = "SELECT Numero, origen FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("origen"));
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

    public String[] selectViajesDestino (String identificacion) {
        String sql = "SELECT Numero, destino FROM Viaje where identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                result.add(rs.getString("destino"));
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
        String sql = "SELECT Numero, Identificacion FROM Cliente where Identificacion = " + identificacion +
                " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
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

    public String selectCantidadFilasRendicion() {
        String sql = "SELECT count() as cont from Rendicion";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                return Integer.toString(rs.getInt("cont") + 1);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String selectCostoTestigoViaje(String viaje) {
        String sql = "SELECT Numero, horaInicio FROM Viaje where Numero = " + viaje + " order by Numero desc limit 1";
        ArrayList<String> result = new ArrayList<String>();
        try (Connection conn = super.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                return Integer.toString(rs.getInt("cont") + 1);
            }
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
        s.selectCantidadFilasRendicion();
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
