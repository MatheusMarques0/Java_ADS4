/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author renat
 */
public class Funcionario {
     public String Nome;
    public String Cargo;
    public Double SalBruto;
    public int Faltas;

    public Double DescontoINSS() {
        return this.SalBruto * 0.05;
    }

    public Double DescontoIR() {
        if (this.SalBruto > 10000) {
            return this.SalBruto * 0.275;
        } else if (this.SalBruto >= 5000) {
            return this.SalBruto * 0.12;
        } else {
            return 0.0;
        }
    }

    public Double DescontoFaltas() {
        return (this.SalBruto / 30 / 8) * this.Faltas;
    }

    public Double CalSalLiquido() {
        return this.SalBruto
                - this.DescontoINSS()
                - this.DescontoIR()
                - this.DescontoFaltas();
    }
}
