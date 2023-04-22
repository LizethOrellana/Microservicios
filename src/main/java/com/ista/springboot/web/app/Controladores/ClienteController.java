package com.ista.springboot.web.app.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.web.app.Modelo.Cliente;
import com.ista.springboot.web.app.Services.IClienteService;

@RestController
public class ClienteController {
	
	    @Autowired(required = true)
	    private IClienteService usuarioService;
	    @GetMapping("/listarcliente")
	    public List<Cliente> indext(){
	        return usuarioService.findAll();
	    }

	    @PostMapping("/crearcliente")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Cliente save(@RequestBody Cliente usuario){
	        return usuarioService.save(usuario);
	    }

	    @GetMapping("/cliente/{id}")
	    public Cliente findById(@PathVariable Integer id){
	        return usuarioService.findById(id);
	    }

	    @PutMapping("/editarcliente/{id}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Cliente editar(@RequestBody Cliente usuario, @PathVariable Integer id){
	        Cliente usuarioactual=usuarioService.findById(id);
	        usuarioactual.setNombres(usuario.getNombres());
	        usuarioactual.setApellidos(usuario.getApellidos());
	        usuarioactual.setDireccion(usuario.getDireccion());
	        usuarioactual.setEstado(usuario.getEstado());

	        return usuarioService.save(usuarioactual);
	    }

	    @DeleteMapping("/eliminarusuario/{id}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public void eliminar(@PathVariable int id){
	        usuarioService.delete(id);
	    }


}
