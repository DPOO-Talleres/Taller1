package modelo;

public class Combo {

	private String descuento;
	
	private String nombreCombo;
	
	public Combo (String pnombreCombo, String pdescuento)
	{
		descuento=pdescuento;
		
		nombreCombo=pnombreCombo;
	}
	
	public String getDescuento()
	{
		return descuento;
	}
	
	public String getNombreCombo()
	{
		return nombreCombo;
	}
	
}
