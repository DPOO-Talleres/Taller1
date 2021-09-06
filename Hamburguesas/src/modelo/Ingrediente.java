package modelo;

public class Ingrediente {
	
	private String nombre;
	
	private String costoAdicional;
	
	public Ingrediente(String pnombre, String pcostoAdicional) 
	{
		nombre = pnombre;
		costoAdicional=pcostoAdicional;
	}
	
	public String darNombre() 
	{
		return nombre;
	}
	
	public String darCostoAdicional()
	{
		return costoAdicional;
	}

}
