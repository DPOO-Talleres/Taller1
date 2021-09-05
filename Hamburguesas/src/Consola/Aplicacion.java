package Consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;


import Logica.Restaurante;

public class Aplicacion {

private Restaurante restaurante;

private Restaurante menu;
	
	public void ejecutarAplicacion()
	{
		System.out.println("Bienvenido al restaurante");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					cargarMenu();
//				else if (opcion_seleccionada == 2 && calculadora != null)
//					ejecutarAtletasPorAnio();
//				else if (opcion_seleccionada == 3 && calculadora != null)
//					ejecutarMedallasEnRango();
//				else if (opcion_seleccionada == 4 && calculadora != null)
//					ejecutarAtletasPorPais();
//				else if (opcion_seleccionada == 5 && calculadora != null)
//					ejecutarPaisConMasMedallistas();
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
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
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

	public void cargarMenu()
	{
		System.out.println("\n" + "Cargar menu" + "\n");
		
//		String archivoIngrediente = input("Por favor ingrese el nombre del archivo CSV con el menu");
//		String archivoCombos = input("Por favor ingrese el nombre del archivo CSV con el menu");
		String archivoMenu = input("Por favor ingrese el nombre del archivo CSV con el menu");
		try
		{
			Restaurante.cargarMenu(archivoMenu);
			System.out.println("se cargo el archivo");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
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
	
	public static void main(String[] args)
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}
}
