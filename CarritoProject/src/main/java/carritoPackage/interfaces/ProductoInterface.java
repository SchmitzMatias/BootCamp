package carritoPackage.interfaces;

import java.util.List;

import carritoPackage.models.Producto;

public interface ProductoInterface {

	public Producto add(Producto product);

    public void remove(long id);
    
    public Producto get(long id);

	public List<Producto> getAll();
}