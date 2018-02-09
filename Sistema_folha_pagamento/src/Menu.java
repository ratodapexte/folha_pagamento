import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		
		ArrayList<Empregado> listaDeEmpregados = new ArrayList<Empregado>();
		int op, id=0, i, buscaid, tam;
		double hora, mensal, comissao;
		String nome, endereco, tipo;
		Empregado auxEmpregado;
		
		
		System.out.print("SISTEMA DE FOLHA DE PAGAMENTO\n\n");
		
		while(true)
		{
			System.out.println("Escolha uma das opções abaixo:");
			System.out.println("1 - Adição de um empregado;");
			System.out.println("2 - Remoção de empregado;");
			System.out.println("99 - Debugg lista de empregados");
			op = ler.nextInt();
			
			
			if(op == 1)//CADASTRO DE EMPREGADO
			{
				System.out.println("Preencha todas as informações solicitadas");
				
				System.out.print("Nome:");
				nome = ler.next();
				System.out.print("Endereço:");
				endereco = ler.next();
				System.out.print("Tipo(horista, assalariado, comissao):");
				tipo = ler.next();
				ler.nextLine();
				System.out.print("Salário por horário: ");
				hora = ler.nextDouble();
				System.out.print("Salário mensal: ");
				mensal = ler.nextDouble();
				System.out.print("Comissão(utilize a notação de casa decimal): ");
				comissao = ler.nextDouble();
				
				auxEmpregado = new Empregado(nome, endereco, tipo, hora, mensal, comissao, id);
				id++;			
				
				listaDeEmpregados.add(auxEmpregado);
				System.out.println("Cadastro realizado com sucesso!\n");
			}//FIM DO CADASTRO
			
			else if(op == 2)//REMOÇÃO DE EMPREGADO
			{
				System.out.println("Digite o ID do empregado a ser removido: ");
				buscaid = ler.nextInt();
				
				tam = listaDeEmpregados.size();
				for (i = 0; i < tam; i++) {
					auxEmpregado = listaDeEmpregados.get(i);
					
					if (buscaid == auxEmpregado.getId()) 
					{
						listaDeEmpregados.remove(i);
						break;
					}
				}
				System.out.println("Empregado removido com sucesso!\n");
			}//FIM DA REMOÇÃO DE EMPREGADO
			
			else if(op == 99)//DEBUGG DA LISTA DE EMPREGADOS
			{
				System.out.println("lista atual de empregados: ");
				tam = listaDeEmpregados.size();
				
				for (i = 0; i < tam; i++) {
					auxEmpregado = listaDeEmpregados.get(i);
					System.out.printf("[Nome: " + auxEmpregado.getNome() + ", Endereço: " + auxEmpregado.getEndereco() + ", Tipo: " + auxEmpregado.getTipo() + ", Hora: " + 
							auxEmpregado.getHora() + ", Mensal: " + auxEmpregado.getMensal() + ", Comissão: " + auxEmpregado.getComissao() + ", ID: " + auxEmpregado.getId() + "]");		
				}
			}
			else
				break;
		}
		
		
	}

}
