/**
 *
 * @author alunocmc
 */
public class Veiculo {
    public String marca;
    public String modelo;
    public int ano;
    public Double valor;
    
    //Construtores
    public Veiculo(){
        this("Rolls-Royce","Rolls-Royce La Rose Noire Droptail", 2023, 300000.00);
    }
    
    public Veiculo(String marc, String model, int year, Double vl){
        this.marca=marc;
        this.modelo=model;
        this.ano=year;
        this.valor=vl;
    }
    
    //metodos
    public Double CalcularVista(){
        return this.valor * 0.9;
    }
    
    public Double CalularCredito(){
        return this.valor * 1.1;
    }
}
