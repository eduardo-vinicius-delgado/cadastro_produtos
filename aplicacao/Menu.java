package aplicacao;

import java.util.Scanner;
import entidades.Produto;

public class Menu {
    static int auxiliarProdutosCadastrados;
	
	public static void menuProdutos() {
		Scanner sc= new Scanner(System.in);
		int escolhaUsuario=0;
		while(escolhaUsuario!=4){
			System.out.print(opcoesMenuProduto());
			escolhaUsuario=sc.nextInt();
			System.out.println();
			switch(escolhaUsuario){
			case 1:
				int auxiliarchecarMaximoProdutos=checarMaximoProdutos();
				if(auxiliarchecarMaximoProdutos==0) {
					System.out.println("Valor máximo de produtos cadatrados atingidos! Em breve implementaremos melhorias.");
				}else {
					FuncionalidadesCadastro.cadastro();
				}
				break;
			case 2:
				auxiliarProdutosCadastrados=FuncionalidadesProdutosCadastrados.mostrarProdutosCadastrados();
				apresentacaoProdutos();
				break;
			case 3:
				FuncionalidadeDetalhesProdutos.apresentarDetalhes();
				break;
			case 4:
				System.out.println("Saindo");
				break;
			default:
					System.out.println("Escolha inválida, por favor escolha outra opção");
			}
		}
		sc.close();
	}
	
	private static String opcoesMenuProduto() {
		return "1-Cadastro Novo Produto\n"
				+"2-Produtos Cadastrados\n"
				+"3-Detalhes Produtos Cadastrados\n"
				+"4-Sair\n";
	}
	
	public static int checarMaximoProdutos() {
		if(FuncionalidadesCadastro.controleQuantidadeProdutos>=FuncionalidadesCadastro.maximoQuantidadeProdutos) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public static void apresentacaoProdutos() {
		if(auxiliarProdutosCadastrados==0) {
			System.out.println("0/3");
			System.out.println("Não há produtos cadastrados");
		}else if(auxiliarProdutosCadastrados==1){
			System.out.println("1/3");
			System.out.println(FuncionalidadesCadastro.produtos[0]);
		}else if(auxiliarProdutosCadastrados==2){
			System.out.println("2/3");
			System.out.println(FuncionalidadesCadastro.produtos[0]
					+"\n"
					+FuncionalidadesCadastro.produtos[1]);
		}else {
			System.out.println("3/3");
			System.out.println(FuncionalidadesCadastro.produtos[0]
					+"\n"
					+FuncionalidadesCadastro.produtos[1]
					+"\n"
					+FuncionalidadesCadastro.produtos[2]);
		}
		System.out.println();
	} 
}
