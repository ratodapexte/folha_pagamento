import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	/**
	 * @param args
	 */
	
	private static Empregado cadastro(int ID) 
	{
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Preencha todas as informacoes solicitadas");
		System.out.print("Nome:");
		String nome = ler.nextLine();
		System.out.print("Endereco:");
		String endereco = ler.nextLine();
		System.out.print("Tipo(horista, assalariado, comissao):");
		String tipo = ler.nextLine();
		//ler.nextLine();
		System.out.print("Valor por hora de trabalho: ");
		double hora = ler.nextDouble();
		System.out.print("Salario mensal: ");
		double mensal = ler.nextDouble();
		System.out.print("Comissao(utilize a notacao de casa decimal): ");
		double comissao = ler.nextDouble();
		Empregado auxEmpregado = new Empregado(nome, endereco, tipo, hora, mensal, comissao, ID);
				
		return auxEmpregado;
	}
	
	private static ArrayList<Empregado> recadastro(ArrayList<Empregado> entrada)
	{
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o ID do empregado para ter o cadastro alterado: ");
		int id = ler.nextInt();
		ler.nextLine();
		int tam = entrada.size();
		Empregado auxEmpregado;
		
		for (int j = 0; j < tam; j++) 
		{
			auxEmpregado = entrada.get(j);
			if (id == auxEmpregado.getId())
			{
				System.out.println("Preencha todas as informacoes solicitadas");
				System.out.print("Nome:");
				String nome = ler.nextLine();
				System.out.print("Endereco:");
				String endereco = ler.nextLine();
				System.out.print("Tipo(horista, assalariado, comissao):");
				String tipo = ler.nextLine();
				System.out.print("Valor por hora de trabalho: ");
				double hora = ler.nextDouble();
				System.out.print("Salario mensal: ");
				double mensal = ler.nextDouble();
				System.out.print("Comissao(utilize a notacao de casa decimal): ");
				double comissao = ler.nextDouble();
				auxEmpregado = new Empregado(nome, endereco, tipo, hora, mensal, comissao, id);
				
				entrada.set(j, auxEmpregado);
				
				break;
			}
		}	
		return entrada;
	}
	
	private static ArrayList<Empregado> remocao(ArrayList<Empregado> entrada)
	{
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o ID do empregado a ser removido: ");
		int ID = ler.nextInt();
		ler.nextLine();
		int tam = entrada.size();
		for (int i = 0; i < tam; i++) {
			Empregado auxEmpregado = entrada.get(i);
			
			if (ID == auxEmpregado.getId()) 
			{
					entrada.remove(i);										
				break;
			}
		}
		return entrada;
	}
	
	private static ArrayList<Empregado> copiarListaEmpregado(ArrayList<Empregado> entrada)
	{
		ArrayList<Empregado> copia = new ArrayList<Empregado>();
		int tam = entrada.size();
		Empregado auxEmpregado;
		for (int i = 0; i < tam; i++) {
			auxEmpregado = entrada.get(i);
			copia.add(auxEmpregado);
		}
		return copia;
	}
	
	private static ArrayList<Empregado> lancarCartao(ArrayList<Empregado> entrada)
	{
		Scanner ler = new Scanner(System.in);
		System.out.println("Lancar cartao de ponto");
		System.out.print("Digite o ID do empregado: ");
		int id = ler.nextInt();
		ler.nextLine();
		int tam = entrada.size();
		double extra=0;
		Empregado auxEmpregado;
		ArrayList<CartaoDePonto> listaDeCartoes = new ArrayList<CartaoDePonto>();
		
		for (int j = 0; j < tam; j++) 
		{
			auxEmpregado = entrada.get(j);
			if (id == auxEmpregado.getId())
			{
				System.out.print("Digite a hora de entrada(HH:mm, 0h - 24h): ");
				String hora1 = ler.next();
				System.out.println("Digite a hora de saída(HH:mm, 0h - 24h): ");
				String hora2 = ler.next();
				
				String[] parts = hora1.split(":");
				String part1 = parts[0]; // 004
				String part2 = parts[1]; // 034556
			    int hh = Integer.parseInt(part1);
			    int mm = Integer.parseInt(part2);
			    
			    parts = hora2.split(":");
				part1 = parts[0]; // 004
				part2 = parts[1]; // 034556
			    int HH = Integer.parseInt(part1);
			    int MM = Integer.parseInt(part2);
			    	
				double total = (HH + ((MM*1.0)/60.0)) - (hh + ((mm*1.0)/60.0));
				
				if(total > 8.0)
				{
					extra = (total - 8.0) * 1.5;
				}
				
				total = total + extra;
				
				CartaoDePonto auxCartao = new CartaoDePonto(hora1, hora2, total);
				listaDeCartoes = auxEmpregado.getListaDeCartoes();
				listaDeCartoes.add(auxCartao);
				auxEmpregado.setListaDeCartoes(listaDeCartoes);
				
				entrada.set(j, auxEmpregado);
				
				break;
			}
		}
		return entrada;
	}
	
	private static ArrayList<Empregado> lancarCartaoVenda(ArrayList<Empregado> entrada)
	{
		Scanner ler = new Scanner(System.in);
		System.out.println("Lancar cartao de venda");
		System.out.print("Digite o ID do empregado: ");
		int id = ler.nextInt();
		ler.nextLine();
		int tam = entrada.size();
		Empregado auxEmpregado;
		ArrayList<Venda> listaDeVenda = new ArrayList<Venda>();
		
		for (int j = 0; j < tam; j++) 
		{
			auxEmpregado = entrada.get(j);
			if (id == auxEmpregado.getId())
			{
				System.out.print("Digite a data da venda(dd/mm/aaaa): ");
				String data = ler.next();
				System.out.println("Digite o valor da venda: ");
				double valor = ler.nextDouble();
				
				Venda auxVenda = new Venda(valor, data);
				listaDeVenda = auxEmpregado.getListaDeVendas();
				listaDeVenda.add(auxVenda);
				auxEmpregado.setListaDeVendas(listaDeVenda);
				
				entrada.set(j, auxEmpregado);
				break;
			}
		}
		return entrada;
	}
	
	private static ArrayList<Empregado> lancarTaxa(ArrayList<Empregado> entrada)
	{
		Scanner ler = new Scanner(System.in);
		System.out.println("Lancar taxa de servico");
		System.out.print("Digite o ID do empregado: ");
		int  id = ler.nextInt();
		ler.nextLine();
		int tam = entrada.size();
		Empregado auxEmpregado;
		
		for (int j = 0; j < tam; j++) 
		{
			auxEmpregado = entrada.get(j);
			if (id == auxEmpregado.getId())
			{
				System.out.print("Digite a porcentagem da taxa (Ex: 0,1 = 10%): ");
				double taxa = ler.nextDouble();
				
				auxEmpregado.setListaDeTaxas(taxa);
				
				entrada.set(j, auxEmpregado);
				break;
			}
		}
		return entrada;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		
		
		
		ArrayList<Empregado> listaDeEmpregados = new ArrayList<Empregado>();
		ArrayList<Empregado> copialistaDeEmpregados = new ArrayList<Empregado>();
		ArrayList<CartaoDePonto> listaDeCartoes = new ArrayList<CartaoDePonto>();
		ArrayList<Venda> listaDeVenda = new ArrayList<Venda>();
//		ArrayList<Double> listaDeTaxa = new ArrayList<Double>();
		
		int op, ID=0, i, j, tam, dia1, mes1, ano1, pagamento, OP;
		double taxa, receber=0;
		String data;
		Empregado auxEmpregado;
		CartaoDePonto auxCartao;
		Venda auxVenda;
		
		auxEmpregado = new Empregado("Victor hugo", "rua", "horista", 1.0, 1.0, 1.0, 99);				
		listaDeEmpregados.add(auxEmpregado);
		
		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);
		auxEmpregado = listaDeEmpregados.get(0);
		auxCartao = new CartaoDePonto("", "", 8.0);
		listaDeCartoes = auxEmpregado.getListaDeCartoes();
		listaDeCartoes.add(auxCartao);
		auxEmpregado.setListaDeCartoes(listaDeCartoes);
		
		listaDeEmpregados.set(0, auxEmpregado);

		
		System.out.print("SISTEMA DE FOLHA DE PAGAMENTO\n\n");
		
		while(true)
		{
			System.out.println("Escolha uma das operacaos abaixo:");
			System.out.println("1 - Adicao de um empregado;");
			System.out.println("2 - Remocao de empregado;");
			System.out.println("3 - lancar cartao de ponto;");
			System.out.println("4 - lancar resultado de venda;");
			System.out.println("5 - lancar taxa de servico;");
			System.out.println("6 - alterar detalhes de um empregado;");
			System.out.println("7 - rodar folha de pagamento para hoje;");
			System.out.println("Qualquer outro numero para encerrar;");
			System.out.println("99 - Debugg lista de empregados");
			op = ler.nextInt();
			
			
			if(op == 1)//CADASTRO DE EMPREGADO
			{
				
				auxEmpregado = cadastro(ID);
				

				System.out.println("As informações estão prestes a ser confirmadas.");
				System.out.print("Digite 1 para refazer, 2 para continuar ou 3 para cancelar: ");
				OP = ler.nextInt();
				
				if(OP == 1)
				{
					listaDeEmpregados.add(cadastro(ID));
					System.out.printf("Novo empregado de ID = " + ID +"\n");
					System.out.println("Cadastro realizado com sucesso!\n");
					ID++;
				}
					
				if(OP == 2)
				{
					listaDeEmpregados.add(auxEmpregado);
					System.out.printf("Novo empregado de ID = " + ID +"\n");
					System.out.println("Cadastro realizado com sucesso!\n");
					ID++;
				}
					

			}//FIM DO CADASTRO
			
			else if(op == 2)//REMOÇÃO DE EMPREGADO
			{
				copialistaDeEmpregados = copiarListaEmpregado(listaDeEmpregados);
				listaDeEmpregados = remocao(listaDeEmpregados);
				
				System.out.println("As informações estão prestes a ser confirmadas.");
				System.out.print("Digite 1 para refazer, 2 para continuar ou 3 para cancelar: ");
				OP = ler.nextInt();
				
				if(OP == 1)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					listaDeEmpregados = remocao(listaDeEmpregados);
					System.out.println("Remocao realizado com sucesso!\n");
				}
					
				if(OP == 2)
					System.out.println("Remocao realizado com sucesso!\n");
				if(OP == 3)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					System.out.println("Remocao cancelada!");
				}
					
			}
			
			else if(op == 3)
			{
				copialistaDeEmpregados = copiarListaEmpregado(listaDeEmpregados);
				listaDeEmpregados = lancarCartao(listaDeEmpregados);
				

				System.out.println("As informações estão prestes a ser confirmadas.");
				System.out.print("Digite 1 para refazer, 2 para continuar ou 3 para cancelar: ");
				OP = ler.nextInt();
				
				if(OP == 1)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					listaDeEmpregados = lancarCartao(listaDeEmpregados);
					System.out.println("Lamcamento realizado com sucesso!\n");
				}
					
				if(OP == 2)
					System.out.println("Lamcamento realizado com sucesso!\n");
				if(OP == 3)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					System.out.println("lancamento cancelado!");
				}								
			}

			else if(op == 4)
			{

				copialistaDeEmpregados = copiarListaEmpregado(listaDeEmpregados);
				listaDeEmpregados = lancarCartaoVenda(listaDeEmpregados);
				

				System.out.println("As informações estão prestes a ser confirmadas.");
				System.out.print("Digite 1 para refazer, 2 para continuar ou 3 para cancelar: ");
				OP = ler.nextInt();
				
				if(OP == 1)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					listaDeEmpregados = lancarCartaoVenda(listaDeEmpregados);
					System.out.println("Lamcamento realizado com sucesso!\n");
				}
					
				if(OP == 2)
					System.out.println("Lamcamento realizado com sucesso!\n");
				if(OP == 3)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					System.out.println("lancamento cancelado!");
				}
			}
			
			else if(op == 5)
			{
				copialistaDeEmpregados = copiarListaEmpregado(listaDeEmpregados);
				listaDeEmpregados = lancarTaxa(listaDeEmpregados);
				

				System.out.println("As informações estão prestes a ser confirmadas.");
				System.out.print("Digite 1 para refazer, 2 para continuar ou 3 para cancelar: ");
				OP = ler.nextInt();
				
				if(OP == 1)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					listaDeEmpregados = lancarTaxa(listaDeEmpregados);
					System.out.println("Lamcamento realizado com sucesso!\n");
				}
					
				if(OP == 2)
					System.out.println("Lamcamento realizado com sucesso!\n");
				if(OP == 3)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					System.out.println("lancamento cancelado!");
				}
			}
			
			else if(op == 6)
			{
				copialistaDeEmpregados = copiarListaEmpregado(listaDeEmpregados);
				listaDeEmpregados = recadastro(listaDeEmpregados);

				System.out.println("As informações estão prestes a ser confirmadas.");
				System.out.print("Digite 1 para refazer, 2 para continuar ou 3 para cancelar: ");
				OP = ler.nextInt();
				
				if(OP == 1)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					listaDeEmpregados = recadastro(listaDeEmpregados);
					System.out.println("Atualizacao realizado com sucesso!\n");
				}
					
				if(OP == 2)
					System.out.println("Atualizacao realizado com sucesso!\n");
				if(OP == 3)
				{
					listaDeEmpregados = copialistaDeEmpregados;
					System.out.println("Atualizacao cancelada!");
				}
			}
			
			else if(op == 7)
			{
				System.out.print("Digite a data do dia de hoje(dd/mm/aaaa): ");
				data = ler.next();
				
				System.out.println("As informações estão prestes a ser confirmadas.");
				System.out.print("Digite 1 para refazer, 2 para continuar ou 3 para cancelar: ");
				OP = ler.nextInt();
				
				if(OP == 1)
				{
					System.out.print("Digite a data do dia de hoje(dd/mm/aaaa): ");
					data = ler.next();
				}
				if(OP == 2)
				{
				String[] data1 = data.split("/");
				String part1 = data1[0]; // 004
				String part2 = data1[1]; // 034556
				String part3 = data1[2];
				
			    dia1 = Integer.parseInt(part1);
			    mes1 = Integer.parseInt(part2);
				ano1 = Integer.parseInt(part3);
				
				mes1 = mes1 * 30;
				ano1 = ano1 *365;

				int anot =  ano1 - (2018 * 365);
				int mest = mes1 - 30;
				int diat = dia1 - 1;

				int totaldias = anot + mest + diat;

				tam = listaDeEmpregados.size();
				
				for (j = 0; j < tam; j++) 
				{
					auxEmpregado = listaDeEmpregados.get(j);
					listaDeVenda = auxEmpregado.getListaDeVendas();
					listaDeCartoes = auxEmpregado.getListaDeCartoes();
					taxa = auxEmpregado.getListaDeTaxas();
					
					if(auxEmpregado.getTipo() == "horista")
					{
						pagamento = totaldias / 7;
						
						for (int k = 0; k < pagamento; k++)
						{
							
							for (int k2 = 0; k2 < 7; k2++) {
								if(listaDeCartoes.isEmpty() == true) 
								{
									System.out.println("Lista de cartoes de ponto vazia!");
									break;
								}
								else
								{
									auxCartao = listaDeCartoes.get(0);
									listaDeCartoes.remove(0);
									receber += auxCartao.getTotal() * auxEmpregado.getHora();
									if(listaDeVenda.isEmpty() != true ) 
									{
										auxVenda = listaDeVenda.get(0);
										listaDeVenda.remove(0);
										receber += auxVenda.getValor() * auxEmpregado.getComissao();
									} 
								}									
							}
							receber -= receber * taxa;
							System.out.printf("Empregado" + auxEmpregado.getNome() + ", esta recebendo R$" + receber +  " por sua semana " + k + ".\n");
							receber = 0.0;
						}
					}
					
					else if(auxEmpregado.getTipo() == "assalariado")
					{
						pagamento = totaldias / 30;
						
						for (int k = 0; k < pagamento; k++)
						{
							
							for (int k2 = 0; k2 < 30; k2++) {
								if(listaDeCartoes.isEmpty() == true) 
								{
									System.out.println("Lista de cartoes de ponto vazia!");
									break;
								}
								else
								{
									auxCartao = listaDeCartoes.get(0);
									listaDeCartoes.remove(0);
									receber += auxCartao.getTotal() * auxEmpregado.getHora();
									if(listaDeVenda.isEmpty() != true ) 
									{
										auxVenda = listaDeVenda.get(0);
										listaDeVenda.remove(0);
										receber += auxVenda.getValor() * auxEmpregado.getComissao();
									} 

								}
							}
							receber -= receber * taxa;
							System.out.printf("Empregado" + auxEmpregado.getNome() + ", esta recebendo R$" + receber +  " por seu mes " + k + ".\n");
							receber = 0.0;
						}
					}
					else
					{
						pagamento = totaldias / 15;
						
						for (int k = 0; k < pagamento; k++)
						{
							
							for (int k2 = 0; k2 < 15; k2++) {
								if(listaDeCartoes.isEmpty() == true) 
								{
									System.out.println("Lista de cartoes de ponto vazia!");
									break;
								}
								else
								{
									auxCartao = listaDeCartoes.get(0);
									listaDeCartoes.remove(0);
									receber += auxCartao.getTotal() * auxEmpregado.getHora();
									if(listaDeVenda.isEmpty() != true ) 
									{
										auxVenda = listaDeVenda.get(0);
										listaDeVenda.remove(0);
										receber += auxVenda.getValor() * auxEmpregado.getComissao();
									} 
								}
									
							}
							receber -= receber * taxa;
							System.out.printf("Empregado" + auxEmpregado.getNome() + ", esta recebendo R$" + receber +  " por sua quinzena " + k + ".\n");
							receber = 0.0;
						}
					}
				}
				}
				
				if(OP == 3)
					System.out.println("Operacao cancelada com sucesso!");
			}
			
			else if(op == 99)//DEBUGG DA LISTA DE EMPREGADOS
			{
				System.out.println("lista atual de empregados: ");
				tam = listaDeEmpregados.size();
				
				for (i = 0; i < tam; i++) {
					auxEmpregado = listaDeEmpregados.get(i);
					System.out.printf("[Nome: " + auxEmpregado.getNome() + ", Endereço: " + auxEmpregado.getEndereco() + ", Tipo: " + auxEmpregado.getTipo() + ", Hora: " + 
							auxEmpregado.getHora() + ", Mensal: " + auxEmpregado.getMensal() + ", Comissão: " + auxEmpregado.getComissao() + ", ID: " + auxEmpregado.getId() + "]\n");		
				}
			}
			else
				break;
		}
		
		
	}

}
