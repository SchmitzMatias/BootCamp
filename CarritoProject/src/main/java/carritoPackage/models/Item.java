package carritoPackage.models;

public class Item{
    private Producto producto;
    private int unidades;

    public Item(Producto producto, int unidades){
        this.producto= producto;
        this.unidades= unidades;
    }

    public Producto getProducto(){
        return producto;
    }

    public void setProducto(Producto producto){
        this.producto= producto;
    }

    public int getUnidades(){
        return unidades;
    }

    public void setUnidades(int unidades){
        this.unidades= unidades;
    }
}