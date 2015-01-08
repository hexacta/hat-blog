package controllers;

import java.util.List;

import models.Articulo;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Articulos extends Controller{
	
	@Transactional(readOnly=true)
    public static Result getArticulo(int codigo) {
    	
    	Articulo articulo = Articulo.findById(codigo);
    	
        return ok(Json.toJson(articulo));       
    }
	
	@Transactional(readOnly=true)
    public static Result getArticulos() {
		
        List<Articulo> articulos = Articulo.getAll();
                
		return ok(Json.toJson(articulos));       
    }
}
