
public class Usuario {
	
	private double altura;
	private double peso;
	public double getAltura() {
		return altura;
	}
	public void setAltura(double valor) {
		this.altura = valor;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double calcularIMC(double peso, double altura) {
		double multAltura = altura*altura;
		double IMC = peso/multAltura;
		return IMC;
	}
	
	
}
