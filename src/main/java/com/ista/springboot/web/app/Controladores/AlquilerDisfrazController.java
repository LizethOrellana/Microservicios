package com.ista.springboot.web.app.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ista.springboot.web.app.Modelo.AlquilerDisfraz;
import com.ista.springboot.web.app.Services.IAlquilerDisfrazService;


public class AlquilerDisfrazController {
	 @Autowired
	    private IAlquilerDisfrazService usuarioService;
	    @GetMapping("/listardisfraz")
	    public List<AlquilerDisfraz> indext(){
	        return usuarioService.findAll();
	    }

	    @PostMapping("/creardisfraz")
	    @ResponseStatus(HttpStatus.CREATED)
	    public AlquilerDisfraz save(@RequestBody AlquilerDisfraz usuario){
	        return usuarioService.save(usuario);
	    }

	    @GetMapping("/disfraz/{id}")
	    public AlquilerDisfraz findById(@PathVariable Integer id){
	        return usuarioService.findById(id);
	    }

	    @PutMapping("/editardisfraz/{id}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public AlquilerDisfraz editar(@RequestBody AlquilerDisfraz usuario, @PathVariable Integer id){
	    	AlquilerDisfraz usuarioactual=usuarioService.findById(id);
	        usuarioactual.setCantidad_disfraces(usuario.getCantidad_disfraces());
	        usuarioactual.setComentarios_alquiler(usuario.getComentarios_alquiler());
	        usuarioactual.setFecha_devolucion(usuario.getFecha_devolucion());
	        usuarioactual.setFecha_prestamo(usuario.getFecha_prestamo());
	        usuarioactual.setTotal_alquiler(usuario.getTotal_alquiler());

	        return usuarioService.save(usuarioactual);
	    }

	    @DeleteMapping("/eliminardisfraz/{id}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public void eliminar(@PathVariable int id){
	        usuarioService.delete(id);
	    }
}
