package PruebasGenerales;

import java.sql.*;
/**
 *
 * @author Supre
 */
public final class PruebasGenerales {

    private Connection conexion = null;

    /**
     * @throws java.sql.SQLException
     */
    
    public PruebasGenerales() throws SQLException {
        try {
           conectar();
           consulta();
        } finally {
            cerrar();
        }
    }

    public void conectar() throws SQLException {
        String jdbc = "jdbc:mysql://localhost:3306/tarea1";
        conexion = DriverManager.getConnection(jdbc, "root", "slifer@Klk2020");
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    public void consulta()throws SQLException{
        try (Statement statement = conexion.createStatement(); 
                var set = statement.executeQuery("select * from estudiante where IDEstudiante = 3")) {
            while(set.next()){
                int idEstudiante = set.getInt("IDEstudiante");
                String nombre  = set.getString("Nombre");
                String apellido = set.getString("apellido");
                Date fecha = set.getDate("fechaNacimiento");
                System.out.println(idEstudiante +" "+ nombre +" " + apellido+" "+ fecha);
            }
        }
        conexion.close();
    }
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        try{
            new PruebasGenerales();
        }catch(SQLException e){
            System.out.println( e);;
        }
    }
}
