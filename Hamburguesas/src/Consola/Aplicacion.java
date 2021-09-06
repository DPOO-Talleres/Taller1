package Consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;


import Logica.Restaurante;
import modelo.Pedido;
import modelo.Producto_Menu;

public class Aplicacion {

private Restaurante restaurante;

private ArrayList<Producto_Menu> menu;


private ArrayList<Restaurante> restaurantes;
	
	public void ejecutarAplicacion() throws FileNotFoundException, IOException
	{
		System.out.println("Bienvenido al restaurante");

		boolean continuar = true;
		while (continuar)
		{
//			try
//			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion "));
				if (opcion_seleccionada == 1)
					cargarMenu();
				else if (opcion_seleccionada == 2 && restaurante != null)
					iniciarPedido();
				else if (opcion_seleccionada == 3 && restaurante != null)
					agregarElementoAlPedido();
				else if (opcion_seleccionada == 4 && restaurante != null)
					CerrarPedido();
				else if (opcion_seleccionada == 5 && restaurante != null)
					consultarInfoPedido();
//				else if (opcion_seleccionada == 6 && calculadora != null)
//					ejecutarMedallistasPorEvento();
//				else if (opcion_seleccionada == 7 && calculadora != null)
//					ejecutarAtletasConMasMedallasQue();
//				else if (opcion_seleccionada == 8 && calculadora != null)
//					ejecutarAtletaEstrella();
//				else if (opcion_seleccionada == 9 && calculadora != null)
//					ejecutarMejorPaisEnUnEvento();
//				else if (opcion_seleccionada == 10 && calculadora != null)
//					ejecutarTodoterreno();
//				else if (opcion_seleccionada == 11 && calculadora != null)
//					ejecutarMedallistasPorNacionYGenero();
//				else if (opcion_seleccionada == 12 && calculadora != null)
//					ejecutarPorcentajeMedallistas();
//				else if (opcion_seleccionada == 13 && calculadora != null)
//					paisQueRepresentaElAtleta();
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
//				else if (calculadora == null)
//				{
//					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
//				}
//				else
//				{
//					System.out.println("Por favor seleccione una opción válida.");
//				}
//			}
//			catch (NumberFormatException e)
//			{
//				System.out.println("Debe seleccionar uno de los números de las opciones.");
//			}
		}
		
		}
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar menu");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guargar la factura");
		System.out.println("5. Consultar la informacion del pedido");
		System.out.println("6. Salir de la aplicación\n");
	}

	public void cargarMenu() throws FileNotFoundException, IOException
	{
		System.out.println("\n" + "Cargar menu" + "\n");
		
		String archivoIngrediente = input("Por favor ingrese el nombre del archivo CSV con el menu");
		String archivoCombos = input("Por favor ingrese el nombre del archivo CSV con el menu");
		String archivoMenu = input("Por favor ingrese el nombre del archivo CSV con el menu");
		restaurante = Restaurante.cargarInformacionRestaurante(archivoIngrediente, archivoMenu, archivoCombos);
		
		System.out.println("se cargo el archivo");
		
//		try
//		{
//			
//			menu = Restaurante.menu;
//			
//			System.out.println("se cargo el archivo");
//		}
//		catch (FileNotFoundException e)
//		{
//			System.out.println("ERROR: el archivo indicado no se encontró.");
//		}
//		catch (IOException e)
//		{
//			System.out.println("ERROR: hubo un problema leyendo el archivo.");
//			System.out.println(e.getMessage());
//		}
	}
	
	public void iniciarPedido() 
	{
		System.out.println("\n" + "Iniciar pedido" + "\n");
		
		String nombreCliente = input("Ingrese su nombre");
		String direccionCliente = input("Ingrese su Direccion");
		int id=Restaurante.crearPedido(nombreCliente, direccionCliente);
		
		
		System.out.println("\n" + "Pedido creado" + "\n");
		System.out.println("\n" + "El id del pedido es: " + id + "\n");
	}
	
	public void agregarElementoAlPedido()
	{
		System.out.println("\n" + "Agregar elemento al pedido" + "\n");
		
		Pedido pedido1= new Pedido(null,null);
		int id =Integer.parseInt(input("Ingrese el id del pedido"));
		String producto = input("Ingrese el producto");
		Restaurante.agregarProductoAlPedido(id, producto);
		
		System.out.println("\n" + "El producto: " + producto+ "\n"+"Ha sido agregado al pedido: "+id+"\n");
	}
	
	public void CerrarPedido()
	{
		System.out.println("\n" + "Cerrar pedido" + "\n");
		Pedido pedido1= new Pedido(null,null);
		int id =Integer.parseInt(input("Ingrese el id del pedido"));
		pedido1=Restaurante.buscarPedido(id);
		pedido1.generarTextoFactura();
		if(pedido1.darEstado()==true)
		{
			restaurante.pedidosTerminados.put(pedido1.getId(), pedido1);
			restaurante.pedidos.remove(pedido1.getId());
		}
		
	}
	
	public void consultarInfoPedido()
	{
		System.out.println("\n" + "Consultar info pedido" + "\n");
		Pedido pedido1= new Pedido(null,null);
		int id =Integer.parseInt(input("Ingrese el id del pedido"));
		pedido1=Restaurante.buscarPedido(id);
		pedido1.consultarInfoPedido();
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
}
