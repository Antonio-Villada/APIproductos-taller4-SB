package uq.avanzada.taller4.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import uq.avanzada.taller4.entities.Producto;
import uq.avanzada.taller4.services.ProductoService;

import java.io.IOException;
import java.util.List;

@Lazy
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "jsonResourceService")
public class ProductoServiceImpl  implements ProductoService {

//    private final ProductoRepository productoRepository;
//
//    public ProductoServiceImpl(ProductoRepository productoRepository) {
//        this.productoRepository = productoRepository;
//    }
//    @Override
//    public List<Producto> getProductos() {
//        return productoRepository.findAll();
//    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos;
        try {
            productos = new ObjectMapper().
                            readValue(this.getClass().getResourceAsStream("/productos.json"),
                            new TypeReference<List<Producto>>() {});
            return productos;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
