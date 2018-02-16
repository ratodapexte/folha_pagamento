
public class CartaoDePonto {

	private String horaEntrada;
	private String horaSaida;
	private double total;
	
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public CartaoDePonto(String horaEntrada, String horaSaida, double total) {
		super();
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.total = total;
	}
			
	

}
