package ProductoSpring.ProductoSpring.Repository;
import ProductoSpring.ProductoSpring.Modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
     @Autowired

     private JdbcTemplate jdbcTemplate;

     private RowMapper<Producto> rowMapper=( rs, rowNum)->{
         Producto p= new Producto();
         p.setId(rs.getInt("id"));
         p.setNombre(rs.getString("nombre"));
         p.setPrecio(rs.getDouble("precio"));
         p.setStock(rs.getInt("stock"));
         return p;
     };
     public List<Producto> listarProducto(){
         return jdbcTemplate.query("EXEC sp_listar_productos",rowMapper);
     }
     public void InsertarProducto(Producto producto){
         jdbcTemplate.update("exec sp_insertar_prododucto ?, ?, ?",
                 producto.getNombre(),
                 producto.getPrecio(),
                 producto.getStock());

     }
    public Producto buscarPorId(int id) {
        return jdbcTemplate.queryForObject(
                "EXEC sp_buscar_producto_por_id ?",rowMapper, id);
    }
    public void eliminarPorNombre(String nombre) {
        jdbcTemplate.update("EXEC sp_eliminar_producto_por_nombre ?", nombre);
    }
    public void actualizarProducto(Producto producto) {
        jdbcTemplate.update(
                "EXEC sp_actualizar_producto ?, ?, ?, ?",
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }


}
