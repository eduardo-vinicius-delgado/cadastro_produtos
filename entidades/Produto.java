package entidades;

public class Produto {
    private static int maximoCores=3;
	private int sku=0;
	private String descricao="";
	private int loteMinimo=0;
	private String coresDisponiveis[]=new String[maximoCores];
	
	public int getSku() {
		return sku;
	}
	
	public void setSku(int sku) {
		this.sku=sku;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao=descricao;
	}
	
	public int getLoteMinimo() {
		return loteMinimo;
	}
	
	public void setLoteMinimo(int loteMinimo) {
		this.loteMinimo=loteMinimo;
	}
	
	public String getCoresDisponiveis() {
		return coresDisponiveis[0]
				+" "
				+coresDisponiveis[1]
				+" "
				+coresDisponiveis[2];
	}
	
	public void setCoresDisponiveis(String cor1, String cor2, String cor3) {
		coresDisponiveis[0]=cor1;
		coresDisponiveis[1]=cor2;
		coresDisponiveis[2]=cor3;
	}
	
	public String toString() {
		return 	+ sku
				+"-"
				+descricao;
	}
}
