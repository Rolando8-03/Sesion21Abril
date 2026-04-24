package ni.edu.uam;

import ni.edu.uam.modelos.Producto;
import ni.edu.uam.servicios.ProductoServicio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoServicio productos = new ProductoServicio();

        String menu = "Jaguar Coffee \n1. Agregar \n2. Ver \n3. Buscar Producto " +
                "\n4. Buscar por Nombre \n5. Editar Producto \n6. Eliminar Producto \n7. Salir \nOpción: ";
        String nombre, precio, cantidad, opcion = "0";

        do{
            opcion = JOptionPane.showInputDialog(menu);
            switch (opcion){
                case "1" ->{
                    nombre = JOptionPane.showInputDialog("Nombre del producto");
                    precio = JOptionPane.showInputDialog("Precio del producto");
                    cantidad = JOptionPane.showInputDialog("Cantidad del producto");
                    productos.agregarProducto(nombre, Double.parseDouble(precio), Integer.parseInt(cantidad));
                }
                case "2" -> JOptionPane.showMessageDialog(null, productos.getFactura());
                case "3" -> {
                    nombre = JOptionPane.showInputDialog("Nombre del producto");
                    precio = JOptionPane.showInputDialog("Precio del producto");
                    cantidad = JOptionPane.showInputDialog("Cantidad del producto");
                    JOptionPane.showMessageDialog(null, productos.buscarProducto(
                            nombre, Double.parseDouble(precio), Integer.parseInt(cantidad)));
                }
                case "4" -> {
                    nombre = JOptionPane.showInputDialog("Nombre del producto");
                    JOptionPane.showMessageDialog(null, productos.buscarProducto(nombre));
                }
                case "5" ->{
                    nombre = JOptionPane.showInputDialog("Nombre del producto: ");
                    precio = JOptionPane.showInputDialog("Nuevo precio: ");
                    cantidad = JOptionPane.showInputDialog("Nueva cantidad: ");

                    boolean editado = productos.editarProducto(
                            nombre,
                            Double.parseDouble(precio),
                            Integer.parseInt(cantidad)
                    );

                    if (editado) {
                        JOptionPane.showMessageDialog(null, "Producto editado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                    }
                }
                case "6" -> {
                    nombre = JOptionPane.showInputDialog("Nombre del producto: ");

                    boolean eliminado = productos.eliminarProducto(nombre);

                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                    }
                }
                case "7" -> JOptionPane.showMessageDialog(null, "Adiós");
                default ->  JOptionPane.showMessageDialog(null, "Opción Inválida");
            }
        }while(!opcion.equals("7"));
    }
}
