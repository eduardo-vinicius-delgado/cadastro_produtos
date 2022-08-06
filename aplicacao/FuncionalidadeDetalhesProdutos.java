package aplicacao;

import java.util.Scanner;

public class FuncionalidadeDetalhesProdutos {
    public static void apresentarDetalhes() {
		Scanner sc = new Scanner(System.in);
		int auxiliarDetalhesProdutos = FuncionalidadesProdutosCadastrados.mostrarProdutosCadastrados();
		if (auxiliarDetalhesProdutos == 0) {
			System.out.println("Não há produtos cadastrados\n");
		} else if (auxiliarDetalhesProdutos == 1) {
			System.out.println(FuncionalidadesCadastro.produtos[0]);
			detalhes();
		} else if (auxiliarDetalhesProdutos == 2) {
			System.out.println(FuncionalidadesCadastro.produtos[0] + "\n" + FuncionalidadesCadastro.produtos[1]);
			detalhes();
		} else {
			System.out.println(FuncionalidadesCadastro.produtos[0] + "\n" + FuncionalidadesCadastro.produtos[1] + "\n"
					+ FuncionalidadesCadastro.produtos[2]);
			detalhes();
		}
	}

	private static int checarEscolhaUsuario(int escolhaUsuario) {
		for (int i = 0; i < FuncionalidadesCadastro.controleQuantidadeProdutos; i++) {
			if (FuncionalidadesCadastro.controleSku[i] == escolhaUsuario) {
				return 1;
			}
		}
		return 0;
	}
	
	private static void detalhes(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Digite o SKU que deseja verificar os detalhes: ");
		int escolhaUsuario = sc.nextInt();
		int auxiliarChecarEscolhaUsuario=checarEscolhaUsuario(escolhaUsuario);
		if(auxiliarChecarEscolhaUsuario==0) {
			System.out.println("SKU não identificado. Digite novamente\n");
			apresentarDetalhes();
		}else{
			System.out.println(mostrarDetalhesProdutoSkuEscolhido(escolhaUsuario)+"\n");
		}
	}

	private static String mostrarDetalhesProdutoSkuEscolhido(int escolhaUsuario) {
		for(int i = 0; i < FuncionalidadesCadastro.controleQuantidadeProdutos; i++) {
			if(FuncionalidadesCadastro.produtos[i].getSku()==escolhaUsuario) {
				return  "\n"
						+"Sku: "
						+FuncionalidadesCadastro.produtos[i].getSku()
						+"\n"
						+"Descrição: "
						+FuncionalidadesCadastro.produtos[i].getDescricao()
						+"\n"
						+"Lote mínimo: "
						+FuncionalidadesCadastro.produtos[i].getLoteMinimo()
						+"\n"
						+"Cores disponiveis: "
						+FuncionalidadesCadastro.produtos[i].getCoresDisponiveis();
			}
		}
		return "";
	}
}
