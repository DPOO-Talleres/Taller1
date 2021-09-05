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
	
	private static ArrayList<Producto_Menu> menu;
	
	private static ArrayList<Combo> combos;
	
	private List<Pedido> pedido;
	
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
	
	public void guardarCerrarPedido()
	{
		for (int i = 0; i<=pedido.size(); i++)
		{
			if(pedido.get(i).listo=true) 
			{
				pedido.remove(pedido.get(i));
			}
		}
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
	
	
	public static void cargarInformacionRestaurante (String ArchivoIngrediente, String ArchivoMenu, String ArchivoCombos) throws FileNotFoundException, IOException
	{
		cargarIngredientes(ArchivoIngrediente);
		cargarMenu(ArchivoMenu);
		cargarCombo(ArchivoCombos);
	}
	
	
	
	public static void cargarIngredientes(String nombreArchivo) throws FileNotFoundException, IOException
	{
		Map<String, Ingrediente> ingredientes1 = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			String nombreIngrediente = partes[0];
			int precio = Integer.parseInt(partes[1]);
			linea = br.readLine();
			
			Ingrediente ingrediente = new Ingrediente(nombreIngrediente, precio);
			ingredientes1.put(ingrediente.darNombre(), ingrediente);
		
			ingredientes.add((Ingrediente) ingredientes1);
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
			String[] partes = linea.split(",");
			String nombreMenu = partes[0];
			int precio = Integer.parseInt(partes[1]);
			linea = br.readLine();
			
			Producto_Menu productomenu = new Producto_Menu(nombreMenu, precio);
			menus.put(productomenu.getNombre(), productomenu);
			
			menu.add((Producto_Menu) menus);
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
			String[] partes = linea.split(",");
			String nombreCombo = partes[0];
			double precio = Double.parseDouble(partes[1]);
			linea = br.readLine();
			
			Combo combo = new Combo(nombreCombo, precio);
			combos1.put(combo.getNombreCombo(), combo);
			
			combos.add((Combo) combos1);
		}
		br.close();
	}
	
}