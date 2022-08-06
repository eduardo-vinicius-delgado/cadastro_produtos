package aplicacao;

public class FuncionalidadesProdutosCadastrados {
    public static int mostrarProdutosCadastrados() {
		if(FuncionalidadesCadastro.produtos[0]==null) {
			return 0;
		}else if(FuncionalidadesCadastro.produtos[1]==null){
			return 1;
		}else if(FuncionalidadesCadastro.produtos[2]==null){
			return 2;
		}else {
			return 3;
		}
	}
}
