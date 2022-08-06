package aplicacao;

import java.util.Scanner;
import entidades.Produto;

public class FuncionalidadesCadastro {
    public static int controleQuantidadeProdutos=0; 
	public static int maximoQuantidadeProdutos=3;
	public static int controleSku[]= new int[maximoQuantidadeProdutos];
	public static Produto produtos[]= new Produto [maximoQuantidadeProdutos]; 
	
	public static void cadastro() {
		Scanner sc = new Scanner(System.in);
		criacaoProduto();
		int controleWhileSku=0, sku=0;
		while(controleWhileSku==0) {
			System.out.print("Sku: ");
			sku=sc.nextInt();
			int auxiliarChegarSku=checarSku(sku);
			if(auxiliarChegarSku==0) {
				System.out.println("Não é possível cadastrar o valor 0, por favor escolha outro valor");
			}else if(auxiliarChegarSku==1){
				System.out.println("Valor já cadastrado, por favor digite outro.");
			}else{	
				controleWhileSku=1;
				produtos[controleQuantidadeProdutos].setSku(sku);
			}	
		}	
		System.out.print("Descrição: ");
		String limpeza=sc.nextLine();
		String descricao=sc.nextLine();
		produtos[controleQuantidadeProdutos].setDescricao(descricao);
		System.out.print("Lote mínimo: ");
		int loteMinimo=sc.nextInt();
		produtos[controleQuantidadeProdutos].setLoteMinimo(loteMinimo);
		System.out.print("Cores disponiveis: ");
		String coresDisponiveis[] = new String[3];
		limpeza=sc.nextLine();
		for(int i=0; i<3; i++) {
			coresDisponiveis[i]=sc.nextLine();
	    }
		produtos[controleQuantidadeProdutos].setCoresDisponiveis(coresDisponiveis[0], coresDisponiveis[1], coresDisponiveis[2]);
		System.out.println();
		controleQuantidadeProdutos++;
	}
	
	private static void criacaoProduto() {
		produtos[controleQuantidadeProdutos]= new Produto();
	}
	
	private static int checarSku(int sku) {
			if(sku==0) {
				return 0;
			}else {
				for(int i=0; i<maximoQuantidadeProdutos; i++) {
					if(controleSku[i]==sku) {
						return 1;
					}
				}
			}
			adicionarControleSku(sku);
			return 2;
	}
	
	private static void adicionarControleSku(int sku) {
			for(int i=0; i<maximoQuantidadeProdutos; i++) {
				if(controleSku[i]==0) {
					controleSku[i]=sku;
					i=maximoQuantidadeProdutos;
				}
			}
	}
}
