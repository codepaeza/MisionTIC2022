package model.dao;


//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.LideresProyectosEmblematicos;

public class LideresProyectosEmblematicosDao {

    public ArrayList<LideresProyectosEmblematicos> rankingProyectosEmblematicos() throws SQLException {
        //Consulta de proyectos emblemáticos en la base de datos
        ArrayList<LideresProyectosEmblematicos> respuesta = new ArrayList<LideresProyectosEmblematicos>();
        Connection conexion = JDBCUtilities.getConnection();
        try{

            String consulta =   "SELECT ID_Lider, ID_Proyecto, ID_Tipo "+
                    "FROM Proyecto "+
                    "WHERE ID_Proyecto >= 130 AND ID_Proyecto < 135 "+
                    "GROUP BY ID_Lider "+
                    "ORDER BY ID_Lider ";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                LideresProyectosEmblematicos lideresProyectosEmblematicos = new LideresProyectosEmblematicos();
                lideresProyectosEmblematicos.setIdLider(resultSet.getInt("Id_Lider"));
                lideresProyectosEmblematicos.setIdProyecto(resultSet.getInt("Id_Proyecto"));
                lideresProyectosEmblematicos.setIdTipo(resultSet.getInt("Id_Tipo"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(lideresProyectosEmblematicos);
            }
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los líderes por proyectos emblemáticos: " + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }

}