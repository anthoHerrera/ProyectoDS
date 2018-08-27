/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FactoryMethod.Articulo;
import Modelo.FactoryMethod.ArticuloGenerico;
import Modelo.FactoryMethod.CocinaInduccionFactory;
import Modelo.FactoryMethod.LavadoraFactory;
import Modelo.FactoryMethod.RefrigeradoraFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

        while (result.next()) {

            if (result.getString("nombre").startsWith("Cocina de induccion")) {
                CocinaInduccionFactory cocina = new CocinaInduccionFactory();
                Articulo coc = cocina.createCocina(result.getString("idarticulo"), result.getString("nombre"), result.getString("descripcion"), result.getString("marca"),
                        result.getDouble("precio"), result.getString("tamano"), result.getString("potenciatotal"), result.getInt("inductores"), result.getString("voltaje"));
                c.add(coc);

            }else if (result.getString("nombre").startsWith("Refrigeradora")) {
                RefrigeradoraFactory refrigeradora = new RefrigeradoraFactory();
                Articulo refri = refrigeradora.createRefrigeradora(result.getString("idarticulo"), result.getString("nombre"), result.getString("descripcion"),
                        result.getString("marca"), result.getDouble("precio"), result.getInt("cantidadpuertas"), result.getInt("capacidad"), result.getString("filtroagua"));
                c.add(refri);
 
            }else if (result.getString("nombre").startsWith("Lavadora")) {

                LavadoraFactory lavadora = new LavadoraFactory();
                Articulo lav = lavadora.createLavadora(result.getString("idarticulo"), result.getString("nombre"), result.getString("descripcion"), result.getString("marca"),
                        result.getDouble("precio"), result.getInt("capacidad"), result.getInt("nivelestemperatura"));
                c.add(lav);
                
            }else if(result.getString("idarticulo").startsWith("otro")){
                Articulo generico = new ArticuloGenerico(result.getString("idarticulo"), result.getString("nombre"), result.getString("descripcion"), 
                        result.getString("marca"), result.getDouble("precio"), result.getString("tamano"),result.getString("potenciatotal"), 
                        result.getInt("inductores"), result.getString("voltaje"), result.getInt("cantidadpuertas"), result.getInt("capacidad"), 
                        result.getString("filtroagua"), result.getInt("nivelestemperatura"));
                c.add(generico);
            }

        }
        productos = FXCollections.observableArrayList(c);
        return productos;
    }
    
    public String cuentaArticulos(String comando) throws SQLException{
        PreparedStatement statement = cnx.getCnx().prepareStatement(comando);
        ResultSet a = statement.executeQuery();
        int conteo = 0;
        while (a.next()) {
            conteo = a.getInt("count")+1;
        }
        return String.valueOf(conteo);
    }

    public void agregaArticulo(List<String> atributos, String id) throws SQLException {
        try (PreparedStatement statement = cnx.getCnx().prepareStatement("INSERT INTO articulo(idarticulo, nombre, descripcion, marca, precio, "
                + "tamano, potenciatotal, inductores, voltaje, cantidadpuertas, capacidad, filtroagua, nivelestemperatura, isvisible) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1,id);
            statement.setString(2, atributos.get(0));
            statement.setString(3, atributos.get(1));
            statement.setString(4, atributos.get(2));
            if(atributos.get(3).isEmpty())
                statement.setDouble(5, 0);
            else
                statement.setDouble(5, Double.parseDouble(atributos.get(3)));
            statement.setString(6, atributos.get(4));
            statement.setString(7, atributos.get(5));
            if(atributos.get(6).isEmpty())
                statement.setInt(8, 0);
            else
                statement.setInt(8, Integer.parseInt(atributos.get(6)));
            statement.setString(9, atributos.get(7));
            if(atributos.get(8).isEmpty())
                statement.setInt(10, 0);
            else
                statement.setInt(10, Integer.parseInt(atributos.get(8)));
            if(atributos.get(9).isEmpty())
                statement.setInt(11, 0);
            else
                statement.setInt(11, Integer.parseInt(atributos.get(9)));
            statement.setString(12, atributos.get(10));
            if(atributos.get(11).isEmpty())
                statement.setInt(13,0);
            else
                statement.setInt(13, Integer.parseInt(atributos.get(11)));
            statement.setBoolean(14,true);
            statement.executeUpdate();
        }
    }

}

