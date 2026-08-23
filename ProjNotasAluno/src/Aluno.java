
public class Aluno {

   public double nota1;
   public double nota2;
   
   public double CalcularMedia(){
       double media=(this.nota1+this.nota2)/2;
       return media;
   }
    
   public void ExibirMedia(double media){
       System.out.println("Nota 1: "+this.nota1);
       System.out.println("Nota 2: "+this.nota2);
       System.out.println("Media: "+media);
   }
}
