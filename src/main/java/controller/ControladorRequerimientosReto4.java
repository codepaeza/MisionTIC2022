package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.LideresMayorSalarioDao;
import model.dao.LideresProyectosEmblematicosDao;
import model.dao.MaterialRankeadoImportadoDao;
import model.vo.LideresMayorSalario;
import model.vo.LideresProyectosEmblematicos;
import model.vo.MaterialRankeadoImportado;


//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {

    private final LideresProyectosEmblematicosDao lideresProyectosEmblematicosDao;
    private final MaterialRankeadoImportadoDao materialRankeadoImportadoDao;
    private final LideresMayorSalarioDao lideresMayorSalarioDao;

    public ControladorRequerimientosReto4(){
        this.lideresProyectosEmblematicosDao = new LideresProyectosEmblematicosDao();
        this.lideresMayorSalarioDao = new LideresMayorSalarioDao();
        this.materialRankeadoImportadoDao = new MaterialRankeadoImportadoDao();

    }

    public ArrayList<LideresMayorSalario> consultarLideresMayorSalarios() throws SQLException {
        return this.lideresMayorSalarioDao.rankingLideresMayorSalario();
    }

    public ArrayList<LideresProyectosEmblematicos> consultarLideresProyectosEmblematicos() throws SQLException {
        return this.lideresProyectosEmblematicosDao.rankingProyectosEmblematicos();
    }

    public ArrayList<MaterialRankeadoImportado> consultarMaterialesRankeadosImportados() throws SQLException {
        return this.materialRankeadoImportadoDao.rankingMaterialesImportados();
    }

}