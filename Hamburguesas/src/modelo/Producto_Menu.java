package modelo;

public class Producto_Menu {
	
	private String nombre;
	
	private String precioBase;
	
	private Producto producto;
	
	public Producto_Menu(String pnombre, String pPrecioBase)
	{
		nombre=pnombre;
		
		precioBase=pPrecioBase;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getPrecioBase()
	{
		return precioBase;
	}

	
//	public String generarFactura()
//	{
//		return Producto.generaFactura();
//	}



}
