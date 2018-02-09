
public class Empregado {

	private String nome;
	private String endereco;
	private String tipo;
	private double hora;
	private double mensal;
	private double comissao;
	private int id;
	
	
	
	public Empregado(String nome, String endereco, String tipo, double hora,
			double mensal, double comissao, int id) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		this.hora = hora;
		this.mensal = mensal;
		this.comissao = comissao;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Empregado [nome=" + nome + ", endereco=" + endereco + ", tipo="
				+ tipo + ", hora=" + hora + ", mensal=" + mensal
				+ ", comissao=" + comissao + ", id=" + id + "]\n";
	}
	public double getHora() {
		return hora;
	}
	public void setHora(long hora) {
		this.hora = hora;
	}
	public double getMensal() {
		return mensal;
	}
	public void setMensal(long mensal) {
		this.mensal = mensal;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(long comissao) {
		this.comissao = comissao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	

}
