package pescado.models;

import java.util.Calendar;

public class Cliente extends Usuario{

	private long id;
	private String endereco;
	private String rg;
	private Calendar dataNascimento;
	

	public long getId() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
