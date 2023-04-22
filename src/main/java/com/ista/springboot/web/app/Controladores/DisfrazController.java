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

import com.ista.springboot.web.app.Modelo.Disfraz;
import com.ista.springboot.web.app.Services.IDisfrazService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DisfrazController {

    @Autowired
    private IDisfrazService usuarioService;
    @GetMapping("/listardisfraz")
    public List<Disfraz> indext(){
        return usuarioService.findAll();
    }

    @PostMapping("/creardisfraz")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz save(@RequestBody Disfraz usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping("/disfraz/{id}")
    public Disfraz findById(@PathVariable Integer id){
        return usuarioService.findById(id);
    }

    @PutMapping("/editardisfraz/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz editar(@RequestBody Disfraz usuario, @PathVariable Integer id){
    	Disfraz usuarioactual=usuarioService.findById(id);
        usuarioactual.setDescripcion(usuario.getDescripcion());
        usuarioactual.setPrecio(usuario.getPrecio());
        usuarioactual.setTipo(usuario.getTipo());

        return usuarioService.save(usuarioactual);
    }

    @DeleteMapping("/eliminardisfraz/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminar(@PathVariable int id){
        usuarioService.delete(id);
    }
}
