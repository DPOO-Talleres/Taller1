package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int numeroPedidos;
	
	private int idPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	private List<Producto> productos;
	
	public boolean listo=false;
	
	public Pedido (String pnombreCliente, String pdireccionCliente )
	{
		direccionCliente= pdireccionCliente;
		nombreCliente=pnombreCliente;
	}
	
	public int getId()
	{
		return idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) 
	{
		productos.add(nuevoItem);
	}
	
	public ArrayList<Producto> listaDeProductos()
	{
		return (ArrayList<Producto>) productos;
	}
	
	public int getPrecioNetoPedido()
	{
		int precioNetoPedido=0;
		
		for (int i=0; i<=productos.size(); i++)
		{
			precioNetoPedido+= productos.get(i).getPrecio();
		}

		return precioNetoPedido;
	}
	
	public int getPrecioIVAPedido()
	{
		int precioIVAPedido=0;
		
		for(int i=0; i<=productos.size() ; i++)
		{
			int precioProducto= productos.get(i).getPrecio();
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
	
	public String generarTextoFactura()
	{
		listo=true;
		System.out.println("              +++++++++++++++ FACTURA +++++++++++++++          ");
		System.out.println("Id Pedido: "+idPedido);
		System.out.println("Nombre Cliente: "+nombreCliente);
		System.out.println("Dirección: "+direccionCliente);
		for (int i=0; i<=productos.size(); i++) 
		{
			System.out.println("Nombre producto: "+productos.get(i).getNombre() + "          Precio: "+productos.get(i).getPrecio());
		}
		System.out.println("Precio Neto del pedido: "+getPrecioNetoPedido());
		System.out.println("Precio IVA del pedido: "+getPrecioIVAPedido());
		System.out.println("Precio Total del pedido: "+getPrecioTotalPedido());
		
		return"";
	}

}
