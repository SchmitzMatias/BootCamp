package carritoPackage.dto;

import java.util.HashMap;
import java.util.Map;

import carritoPackage.models.Producto;

public class CarritoDto{

    public Long id;
    public String user;
    public HashMap<ProductoDto,Integer> productos; //<Producto, unidades>

    public CarritoDto(Long id,String user,HashMap<ProductoDto,Integer> productos){
        this.id=id;
        this.user=user;
        this.productos=productos;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getId(){
        return this.id;
    }

    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

    public void setProductos(HashMap<ProductoDto,Integer> productos){
        this.productos=productos;
    }
    
    public HashMap<ProductoDto,Integer> getProductos(){
        return productos;
    }

    public int getUnidadesProducto(ProductoDto Producto){
        if (productos.get(Producto)!=null)
            return productos.get(Producto);
        return 0;
    }

    public Double getTotalAPagar() {
		Double temporal=0D;
		for(Map.Entry<ProductoDto, Integer> entry: productos.entrySet()) {
			temporal+=entry.getKey().getCosto()*entry.getValue();
		}
		return temporal;
	}
}