package modelo;

public class Producto_Menu {
	
	private String nombre;
	
	private int precioBase;
	
	private Producto producto;
	
	public Producto_Menu(String pnombre, int pPrecioBase)
	{
		nombre=pnombre;
		
		precioBase=pPrecioBase;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getPrecioBase()
	{
		return precioBase;
	}
	
//	public String generarFactura()
//	{
//		return Producto.generaFactura();
//	}



}
