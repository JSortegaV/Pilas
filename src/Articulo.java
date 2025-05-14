public class Articulo {
    private int codigo;
    private String nombre;
    private String detalle;
    private float precio;

    public Articulo(int codigo, String nombre, String detalle, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
