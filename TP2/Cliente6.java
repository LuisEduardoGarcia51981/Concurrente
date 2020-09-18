package TP2;

public class Cliente6 
{
    private String nombre;
    private int [] carroCompra;
// Constructor y métodos de acceso
    Cliente6(String nombre, int [] carroCompra)
    {
        this.nombre=nombre;
        this.carroCompra= carroCompra;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public int [] getCarroCompra()
    {
        return this.carroCompra;
    }
}