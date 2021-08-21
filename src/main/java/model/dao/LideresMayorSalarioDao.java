package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para la conexión con la base de datos
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.LideresMayorSalario;

public class LideresMayorSalarioDao {
    //Obtener los líderes con mayor salario en la ciudad consultada
    public ArrayList<LideresMayorSalario> rankingLideresMayorSalario() throws SQLException {

        ArrayList<LideresMayorSalario> respuesta = new ArrayList<LideresMayorSalario>();
        Connection conexion = JDBCUtilities.getConnection();

        try{

            String consulta =   "SELECT ID_Lider, Nombre, Primer_Apellido "+
                    "FROM Lider "+
                    "WHERE Salario >= 300000 AND Ciudad_Residencia = 'Barranquilla' "+
                    "ORDER BY ID_Lider ";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                LideresMayorSalario lideresMayorSalario = new LideresMayorSalario();
                lideresMayorSalario.setIdLider(resultSet.getInt("ID_Lider"));
                lideresMayorSalario.setNombre(resultSet.getString("Nombre"));
                lideresMayorSalario.setPrimerApellido(resultSet.getString("Primer_Apellido"));


                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(lideresMayorSalario);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los líderes con mayor salario en Barranquilla: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
    }
}