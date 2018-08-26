/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FactoryMethod.Articulo;
import Modelo.FactoryMethod.CocinaInduccionFactory;
import Modelo.FactoryMethod.LavadoraFactory;
import Modelo.FactoryMethod.RefrigeradoraFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author JuanJose FS
 */
public class ControllerAdmin {
    private final ConexionPostgresql cnx;

    public ControllerAdmin() {
        this.cnx = new ConexionPostgresql();
    }
    public ObservableList<Articulo> consultaArticulos(String comando) throws SQLException {
        ObservableList productos = null;
        ArrayList<Articulo> c = new ArrayList<>();
        PreparedStatement statement = cnx.getCnx().prepareStatement(comando);
        ResultSet result = statement.executeQuery();
        
        while(result.next()) {
                     
            if(result.getString("nombre").startsWith("Cocina de induccion")){
                CocinaInduccionFactory cocina = new CocinaInduccionFactory();
                Articulo coc = cocina.createCocina(result.getString("idarticulo"),result.getString("nombre"), result.getString("descripcion"), result.getString("marca"), 
                        result.getDouble("precio"),result.getString("tamano"),result.getString("potenciatotal"),result.getInt("inductores"), result.getString("voltaje"));
                c.add(coc);
            }
//            else if(result.getString("nombre").equals("Cocina de induccion Ginebra")){
//                CocinaInduccionFactory build = new Ginebra();
//                dc.setCocinaInduccionBuilder(build);
//                dc.construirCocina();
//                c.add(dc.getCocina());
//            }
            else if(result.getString("nombre").startsWith("Refrigeradora")){
                RefrigeradoraFactory refrigeradora = new RefrigeradoraFactory();
                Articulo refri = refrigeradora.createRefrigeradora(result.getString("idarticulo"),result.getString("nombre"), result.getString("descripcion"), 
                        result.getString("marca"), result.getDouble("precio"), result.getInt("cantidadpuertas"), result.getInt("capacidad"), result.getString("filtroagua"));
                c.add(refri);
            }
//            else if(result.getString("nombre").equals("Refrigeradora RDE250FXJB")){
//                RefrigeradoraFactory build = new RDE250FXJB();
//                dr.setRefrigeradoraBuilder(build);
//                dr.construirRefrigeradora();
//                c.add(dr.getRefrigeradora());
//            }
            else if(result.getString("nombre").startsWith("Lavadora")){
                LavadoraFactory lavadora = new LavadoraFactory();
                Articulo lav = lavadora.createLavadora(result.getString("idarticulo"),result.getString("nombre"), result.getString("descripcion"), result.getString("marca"),
                        result.getDouble("precio"), result.getInt("capacidad"), result.getInt("nivelestemperatura"));
                c.add(lav);
            }
//            else if(result.getString("nombre").equals("Lavadora LMA70200WGAB0")){
//                LavadoraFactory build = new LMA70200WGAB0();
//                dl.setConstructorLavadoras(build);
//                dl.construirLavadora();
//                c.add(dl.getLavadora());
//            }else if(result.getString("nombre").equals("Lavadora WMC1786SXWW3")){
//                LavadoraFactory build = new WMC1786SXWW3();
//                dl.setConstructorLavadoras(build);
//                dl.construirLavadora();
//                c.add(dl.getLavadora());
//            }
        }
        productos = FXCollections.observableArrayList(c);
        return productos;
    }
    
//    public void agregaArticulos(String comando) throws SQLException{
//        PreparedStatement statement = cnx.getCnx().prepareStatement("INSERT INTO articulo(idarticulo, nombre, descripcion, marca, precio, tamano, potenciatotal, inductores, voltaje, cantidadpuertas, capacidad, filtroagua, nivelestemperatura, isvisible) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//        ResultSet result = statement.executeQuery();
//        
//        try {
//            PreparedStatement st = conexion.getCnx().prepareStatement("INSERT INTO cliente (cedula, nombre, telefono, isvisible) VALUES (?, ?, ?, ?)");
//            st.setString(1, cliente.getCedula());
//            st.setString(2, cliente.getNombre());
//            st.setString(3, cliente.getTelefono());
//            st.setBoolean(4, cliente.isIsVisible());
//            st.executeUpdate();
//            st.close();
//            crearCliente.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public ObservableList<ArticuloLineaBlanca> consultaLavadoras() throws SQLException {
//        ObservableList productos = null;
//        ArrayList<ArticuloLineaBlanca> c = new ArrayList<>();
//        PreparedStatement statement = cnx.getCnx().prepareStatement("select * from articulo where nombre like 'Cocina%'");
//        ResultSet result = statement.executeQuery();
//        
//        DirectorCocina dc = new DirectorCocina();
//        RefrigeradoraFactory dr = new RefrigeradoraFactory();
//        DirectorLavadora dl = new DirectorLavadora();
//        
//        while(result.next()) {
//                     
//            if(result.getString("nombre").equals("Cocina de induccion Andalucia")){
//                CocinaInduccionFactory build = new Andalucia();
//                dc.setCocinaInduccionBuilder(build);
//                dc.construirCocina();
//                c.add(dc.getCocina());
//            }else if(result.getString("nombre").equals("Cocina de induccion Ginebra")){
//                CocinaInduccionFactory build = new Ginebra();
//                dc.setCocinaInduccionBuilder(build);
//                dc.construirCocina();
//                c.add(dc.getCocina());
//            }
}
