package ProductoSpring.ProductoSpring.Modelo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class Producto
{
    @Schema (
            description = "identificador de la tabla"
    )
    private int  id;
    @Schema (
            description = "nombre del producto"
    )

    private String nombre;
    @Schema (
            description = "precio del producto"
    )
    private Double precio;
    @Schema (
            description = "cantidad del producto",
            required = true,
            example = "23"

    )
    private int stock;

}
