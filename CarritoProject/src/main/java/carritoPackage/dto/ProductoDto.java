package carritoPackage.dto;

public class ProductoDto{
    private Long id;
    private String nombre;
    private Double costo;

    public ProductoDto(){

    }

    public ProductoDto(Long id, String nombre, Double costo){
        this.id= id;
        this.nombre= nombre;
        this.costo= costo;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id= id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    public Double getCosto(){
        return costo;
    }

    public void setCosto(Double precio){
        this.costo= precio;
    }
}