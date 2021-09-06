package Logica;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;

import modelo.Ingrediente;
import modelo.Pedido;
import modelo.Producto;
import modelo.Combo;
import modelo.Producto_Menu;


public class Restaurante 
{
	// ************************
	// Atributos
	// ************************
	private static ArrayList<Ingrediente> ingredientes;
	
	public static ArrayList<Producto_Menu> menu;
	
	private static ArrayList<Combo> combos;
	
	private List<Pedido> pedido;
	
	private ArrayList<Restaurante> restaurante = null;
	
	public static Map<String, Producto_Menu> menus1= new HashMap<>();
	
	public static Map<String, Combo> combos2= new HashMap<>();
	
	public static Map<String, Ingrediente> ingredientes2 = new HashMap<>();
	
	public static Map<Integer, Pedido> pedidos = new HashMap<>();
	
	public static Map<Integer, Pedido> pedidosTerminados = new HashMap<>();
	
	
	
	
	public Restaurante(Map<String, Ingrediente> ingredientes, Map<String, Producto_Menu> menu, Map<String, Combo> combos)
	{
		this.ingredientes = new ArrayList<Ingrediente>(ingredientes.values());
		this.menu = new ArrayList<Producto_Menu>(menu.values());
		this.combos = new ArrayList<Combo>(combos.values());
	}
	
	public void iniciarPedido(String nombreCliente, String Direccion) 
	{
		Pedido pedidos = new Pedido(nombreCliente,Direccion);
		pedido.add(pedidos);
	}
	
	
	public Pedido getPedidoEnCurso()
	{
		return pedido.get(0);
	}
	
	public ArrayList<Producto_Menu> getMenuBase()
	{
		return menu;
	}
	
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}
	
	public boolean pedidoEnCurso(Pedido pedidos)
	{
		boolean enCurso=false;
		
		for (int i = 0; i<=pedido.size(); i++)
		{
			if (pedido.get(i).equals(pedidos)) 
			{
				enCurso=true;
			}
			else
			{
				enCurso=false;
			}
		}
		
		return enCurso;
	}
	
	
	public static Restaurante cargarInformacionRestaurante (String ArchivoIngrediente, String ArchivoMenu, String ArchivoCombos) throws FileNotFoundException, IOException
	{
		cargarIngredientes(ArchivoIngrediente);
		cargarMenu(ArchivoMenu);
		cargarCombo(ArchivoCombos);
		Restaurante restaura= new Restaurante(ingredientes2,menus1,combos2);
		return restaura;
	}
	
	
	
	public static void cargarIngredientes(String nombreArchivo) throws FileNotFoundException, IOException
	{
		Map<String, Ingrediente> ingredientes1 = new HashMap<>();

		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			String precio = partes[1];
			linea = br.readLine();
			
			Ingrediente ingrediente = new Ingrediente(nombreIngrediente, precio);
			ingredientes1.put(ingrediente.darNombre(), ingrediente);
			
			ingredientes2.put(ingrediente.darNombre(), ingrediente);
		
		}
			
		br.close();
	}
	
	public static void cargarMenu(String nombreArchivo) throws FileNotFoundException, IOException
	{
		Map<String, Producto_Menu> menus = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreMenu = partes[0];
			String precio = partes[1];
			linea = br.readLine();
			
			Producto_Menu productomenu = new Producto_Menu(nombreMenu, precio);
			menus.put(productomenu.getNombre(), productomenu);

			menus1.put(productomenu.getNombre(), productomenu);
		}
		
		br.close();
		
	}
	
	public static void cargarCombo(String nombreArchivo) throws FileNotFoundException, IOException
	{
		Map<String, Combo> combos1 = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String precio = partes[1];
			linea = br.readLine();
			
			Combo combo = new Combo(nombreCombo, precio);
			combos1.put(combo.getNombreCombo(), combo);
			
			combos2.put(combo.getNombreCombo(), combo);
		}
		br.close();
	}
	
	public static int crearPedido(String pNombreCliente, String pDireccionCliente)
	{
		Pedido pedido1 = new Pedido(pNombreCliente, pDireccionCliente);
		
		pedidos.put(pedido1.getId(), pedido1);
		
		return pedido1.getId();
	}
	
	public static Pedido buscarPedido(int idPedido)
	{
		Pedido pedido1 = new Pedido(null, null);
		pedido1= pedidos.get(idPedido);
		return pedido1;
	}
	
	public static void agregarProductoAlPedido(int idPedido, String Producto)
	{
		Pedido pedido1 = new Pedido(null, null);
		pedido1=buscarPedido(idPedido);
		Producto_Menu producto1= new Producto_Menu(null,null);
		producto1=menus1.get(Producto);
		pedido1.agregarProducto(producto1);
		
	}
	
	public static void generarFactura(int id)
	{
		Pedido pedido1=buscarPedido(id);
		pedido1.generarTextoFactura();
	}
	
	public void guardarCerrarPedido()
	{
		this.pedidos.put(pedidos.get(pedidos).getId(),(Pedido) pedidos );
		this.pedidos.remove(pedidos);
		
//		for (int i = 0; i<=pedido.size(); i++)
//		{
//			if(pedido.get(i).listo=true) 
//			{
//				pedido.remove(pedido.get(i));
//			}
//		}
	}
	public static int validaInt(String number){
	    int result = 0;
	    try{
	        if(number != null){
	            result = Integer.parseInt(number);
	        }
	    }catch(NumberFormatException nfe){
	        nfe.printStackTrace();
	    }
	    return result;
	}
	
}