package modelo;

public class Combo {

	private double descuento;
	
	private String nombreCombo;
	
	public Combo (String pnombreCombo, double pdescuento)
	{
		descuento=pdescuento;
		
		nombreCombo=pnombreCombo;
	}
	
	public double getDescuento()
	{
		return descuento;
	}
	
	public String getNombreCombo()
	{
		return nombreCombo;
	}
	
}
