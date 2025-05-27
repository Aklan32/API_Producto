package ProductoSpring.ProductoSpring.Controller;
import ProductoSpring.ProductoSpring.Modelo.Producto;
import ProductoSpring.ProductoSpring.Repository.ProductoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="API CONTROLLER")

public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @Operation (
            summary = "Listar Productos",
            description = "devuelve un listado de todos los productos"
    )
    @GetMapping
    public List<Producto> listarProducto() {
        return productoRepository.listarProducto();
    }
    @Operation (
            summary = "Buscar por Id",
            description = "Nos busca el producto por su ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable int id) {
        Producto producto = productoRepository.buscarPorId(id);
        return ResponseEntity.ok(producto);
    }
    @Operation (
            summary = "InsertarProducto",
            description = "Insertamos dentro de la lista un Producto"
    )
    @PostMapping
    public ResponseEntity<String> InsertarProducto(@RequestBody Producto producto) {
        productoRepository.InsertarProducto(producto);
        return ResponseEntity.ok("EL producto insertado");
    }
    @Operation (
            summary = "EliminaProducto",
            description = "Elimina un producto de la lista"

    )
    @DeleteMapping
    public ResponseEntity<String> EliminarProducto(@RequestBody Producto producto) {
        productoRepository.eliminarPorNombre(producto.getNombre());
        return ResponseEntity.ok("PRODUCTO ELIMINADO");
    }
    @Operation (
            summary = "ActualizaProducto",
            description = "Modifica un producto de la lista"

    )
    @PutMapping
    public ResponseEntity<Map<String, String>> actualizarProducto(@RequestBody Producto producto) {
        productoRepository.actualizarProducto(producto);

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Producto actualizado");

        return ResponseEntity.ok(response);
    }

}
