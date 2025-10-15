package uq.avanzada.taller4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uq.avanzada.taller4.entities.Producto;
import uq.avanzada.taller4.services.ProductoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/productos","/Productos", "producto", "/Producto"})
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @GetMapping
    private ResponseEntity<?> getProductos(){

        List<Producto> productos = productoService.getProductos();
        return ResponseEntity.ok(productos);
    }

}
