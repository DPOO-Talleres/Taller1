package modelo;

import java.util.ArrayList;
import java.util.List;

import Logica.Restaurante;

public class Pedido {

	private int numeroPedidos;
	
	private int idPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	private Restaurante restaurante;
	
	private ArrayList<Producto_Menu> productos=new ArrayList<>();
	
	public boolean listo=false;
	
	public Pedido (String pnombreCliente, String pdireccionCliente )
	{
		direccionCliente= pdireccionCliente;
		nombreCliente=pnombreCliente;
	}
	
	public int getId()
	{
//		idPedido=restaurante.pedidos.size();
		return idPedido;
	}
	
	public void agregarProducto(Producto_Menu nuevoItem) 
	{
		if (restaurante.menus1.get(nuevoItem)!=null) 
		{
			productos.add(nuevoItem);
		}
		else
		{
			System.out.println("No se ha encontrado el producto");
		}
		
	}
	
	public ArrayList<Producto_Menu> listaDeProductos()
	{
		return (ArrayList<Producto_Menu>) productos;
	}
	
	public int getPrecioNetoPedido()
	{
		int precioNetoPedido=0;
		
		for (int i=0; i<=productos.size(); i++)
		{
			precioNetoPedido+= Integer.parseInt(productos.get(i).getPrecioBase()) ;
		}

		return precioNetoPedido;
	}
	
	public int getPrecioIVAPedido()
	{
		int precioIVAPedido=0;
		
		for(int i=0; i<=productos.size() ; i++)
		{
			int precioProducto= Integer.parseInt(productos.get(i).getPrecioBase());
			int precioProductoIVA = (int) (0.19*precioProducto); 
			precioIVAPedido+=precioProductoIVA;
		}
		
		return precioIVAPedido;
	}
	
	public int getPrecioTotalPedido() 
	{
		int precioTotalPedido=0;
		
		int precioIVA= getPrecioIVAPedido();
		
		int precioNeto= getPrecioNetoPedido();
		
		precioTotalPedido= precioIVA+precioNeto;
	
		return precioTotalPedido;
	}
	
	public boolean darEstado()
	{
		return listo;
	}
	
	public String generarTextoFactura()
	{
		listo=true;
		System.out.println("              +++++++++++++++ FACTURA +++++++++++++++          ");
		System.out.println("Id Pedido: "+idPedido);
		System.out.println("Nombre Cliente: "+nombreCliente);
		System.out.println("Dirección: "+direccionCliente);
		for (int i=0; i<=productos.size(); i++) 
		{
			System.out.println("Nombre producto: "+productos.get(i).getNombre() + "          Precio: "+productos.get(i).getPrecioBase());
		}
		System.out.println("Precio Neto del pedido: "+getPrecioNetoPedido());
		System.out.println("Precio IVA del pedido: "+getPrecioIVAPedido());
		System.out.println("Precio Total del pedido: "+getPrecioTotalPedido());
		
		return"";
	}
	
	public String consultarInfoPedido()
	{
		System.out.println("              +++++++++++++++ INFO PEDIDO +++++++++++++++          ");
		System.out.println("Id Pedido: "+idPedido);
		System.out.println("Nombre Cliente: "+nombreCliente);
		System.out.println("Dirección: "+direccionCliente);
		for (int i=0; i<=productos.size(); i++) 
		{
			System.out.println("Nombre producto: "+productos.get(i).getNombre() + "          Precio: "+productos.get(i).getPrecioBase());
		}
		System.out.println("Precio Neto del pedido: "+getPrecioNetoPedido());
		System.out.println("Precio IVA del pedido: "+getPrecioIVAPedido());
		System.out.println("Precio Total del pedido: "+getPrecioTotalPedido());
		
		return"";
	}

}
