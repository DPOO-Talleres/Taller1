package modelo;

public class Ingrediente {
	
	private String nombre;
	
	private int costoAdicional;
	
	public Ingrediente(String pnombre, int pcostoAdicional) 
	{
		nombre = pnombre;
		costoAdicional=pcostoAdicional;
	}
	
	public String darNombre() 
	{
		return nombre;
	}
	
	public int darCostoAdicional()
	{
		return costoAdicional;
	}

}
