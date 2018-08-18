/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Builders.AndaluciaBuilder;
import Builders.CocinaInduccionBuilder;
import Builders.LavadoraBuilder;
import Builders.DirectorCocina;
import Builders.DirectorLavadora;
import Builders.DirectorRefrigeradora;
import Builders.GinebraBuilder;
import Builders.LavadoraLMA70200WGAB0Builder;
import Builders.LavadoraLMD75B0Builder;
import Builders.LavadoraWMC1786SXWW3Builder;
import Builders.RDE235UWABBuilder;
import Builders.RDE250FXJBBuilder;
import Builders.RefrigeradoraBuilder;
import Modelo.ArticuloLineaBlanca;
import Modelo.Cliente;
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
    public ObservableList<ArticuloLineaBlanca> consultaArticulos() throws SQLException {
        ObservableList productos = null;
        ArrayList<ArticuloLineaBlanca> c = new ArrayList<>();
        PreparedStatement statement = cnx.getCnx().prepareStatement("select * from articulo");
        ResultSet result = statement.executeQuery();
        
        DirectorCocina dc = new DirectorCocina();
        DirectorRefrigeradora dr = new DirectorRefrigeradora();
        DirectorLavadora dl = new DirectorLavadora();
        
        while(result.next()) {
                     
            if(result.getString("nombre").equals("Cocina de induccion Andalucia")){
                CocinaInduccionBuilder build = new AndaluciaBuilder();
                dc.setCocinaInduccionBuilder(build);
                dc.construirCocina();
                c.add(dc.getCocina());
            }else if(result.getString("nombre").equals("Cocina de induccion Ginebra")){
                CocinaInduccionBuilder build = new GinebraBuilder();
                dc.setCocinaInduccionBuilder(build);
                dc.construirCocina();
                c.add(dc.getCocina());
            }else if(result.getString("nombre").equals("Refrigeradora RDE235UWAB")){
                RefrigeradoraBuilder build = new RDE235UWABBuilder();
                dr.setRefrigeradoraBuilder(build);
                dr.construirRefrigeradora();
                c.add(dr.getRefrigeradora());
            }else if(result.getString("nombre").equals("Refrigeradora RDE250FXJB")){
                RefrigeradoraBuilder build = new RDE250FXJBBuilder();
                dr.setRefrigeradoraBuilder(build);
                dr.construirRefrigeradora();
                c.add(dr.getRefrigeradora());
            }else if(result.getString("nombre").equals("Lavadora LMD75B0")){
                LavadoraBuilder build = new LavadoraLMD75B0Builder();
                dl.setConstructorLavadoras(build);
                dl.construirLavadora();
                c.add(dl.getLavadora());
            }else if(result.getString("nombre").equals("Lavadora LMA70200WGAB0")){
                LavadoraBuilder build = new LavadoraLMA70200WGAB0Builder();
                dl.setConstructorLavadoras(build);
                dl.construirLavadora();
                c.add(dl.getLavadora());
            }else if(result.getString("nombre").equals("Lavadora WMC1786SXWW3")){
                LavadoraBuilder build = new LavadoraWMC1786SXWW3Builder();
                dl.setConstructorLavadoras(build);
                dl.construirLavadora();
                c.add(dl.getLavadora());
            }
        }
        productos = FXCollections.observableArrayList(c);
        return productos;
    }
}
