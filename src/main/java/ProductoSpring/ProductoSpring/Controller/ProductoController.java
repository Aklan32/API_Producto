package ProductoSpring.ProductoSpring.Controller;
import ProductoSpring.ProductoSpring.Modelo.Producto;
import ProductoSpring.ProductoSpring.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    @GetMapping
    public List<Producto> listarProducto() {
        return productoRepository.listarProducto();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable int id) {
        Producto producto = productoRepository.buscarPorId(id);
        return ResponseEntity.ok(producto);
    }
    @PostMapping
    public ResponseEntity<String> InsertarProducto(@RequestBody Producto producto) {
        productoRepository.InsertarProducto(producto);
        return ResponseEntity.ok("EL producto insertado");
    }
    @DeleteMapping
    public ResponseEntity<String> EliminarProducto(@RequestBody Producto producto) {
        productoRepository.eliminarPorNombre(producto.getNombre());
        return ResponseEntity.ok("PRODUCTO ELIMINADO");
    }
    @PutMapping
    public ResponseEntity<Map<String, String>> actualizarProducto(@RequestBody Producto producto) {
        productoRepository.actualizarProducto(producto);

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Producto actualizado");

        return ResponseEntity.ok(response);
    }
}
