package pescado.models;

import java.util.Calendar;

public class Vendas {

	private long id;
	private long Cliente;
	private long Peixe;
	private Calendar dataVenda;
	
	public long getId() {
		return id;
	}
	
	public long getCliente() {
		return Cliente;
	}
	public void setCliente(long cliente) {
		Cliente = cliente;
	}
	public long getPeixe() {
		return Peixe;
	}
	public void setPeixe(long peixe) {
		Peixe = peixe;
	}
	public Calendar getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
}
