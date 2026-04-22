package ni.edu.uam;

import ni.edu.uam.modelos.Producto;
import ni.edu.uam.servicios.ProductoServicio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoServicio productos = new ProductoServicio();

        String menu = "Jaguar Coffee \n1. Agregar \n2. Ver \n3. Salir \nOpción: ";
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
                case "3" -> JOptionPane.showMessageDialog(null, "Adiós");
                default ->  JOptionPane.showMessageDialog(null, "Opción Inválida");
            }
        }while(!opcion.equals("3"));
    }
}
