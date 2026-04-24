package ni.edu.uam.servicios;

import ni.edu.uam.interfaces.ProductoInterface;
import ni.edu.uam.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoServicio implements ProductoInterface {

    private List<Producto> productos;

    public ProductoServicio() {
        this.productos = new ArrayList<>();
    }

    @Override
    public void agregarProducto(String nombre, double precio, int cantidad) {
        this.productos.add(new Producto(nombre, cantidad, precio));
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public boolean eliminarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productos.remove(producto);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean editarProducto(String nombre, double precio, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscarProducto(String nombre, double precio, int cantidad) {
        Producto miproducto = new Producto(nombre, cantidad, precio);
        return productos.contains(miproducto);
    }

    public boolean buscarProducto(String nombre){
        for (Producto producto : productos){
            if(producto.getNombre().equalsIgnoreCase(nombre)) return true;
        }
        return false;
    }

    public double getMonto(){
        double total = 0, monto = 0;
        for (Producto producto : productos){
            total = producto.getCantidad() * producto.getPrecio();
            monto += total;
        }
        return monto;
    }

    public StringBuilder getFactura(){
        StringBuilder mensaje = new StringBuilder();

        mensaje.append("Factura");
        mensaje.append("\n");
        for (Producto prod : productos){
            mensaje.append(prod.getNombre());
            mensaje.append(" | ");
            mensaje.append(prod.getPrecio());
            mensaje.append(" | ");
            mensaje.append(prod.getCantidad());
            mensaje.append(" | ");
            mensaje.append(prod.getPrecio() * prod.getCantidad());
            mensaje.append("\n");
        }
        mensaje.append(this.getMonto());
        return mensaje;
    }
}
