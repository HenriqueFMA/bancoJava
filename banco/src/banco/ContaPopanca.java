package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ContaPopanca extends Conta {
	
	float porcetagemRendimentoPorDeposito=(float) 0.5;
	 public double depositar(double deposito,float taxa) {
		    double rendimento=(deposito*100)/taxa;
		    double valor=rendimento+deposito;
	        saldo += valor;
	        return saldo;
	    }
 
	 
	 
	 
	 public void mostrarExtrato(String extratoSaque[][], String extratoDeposito[][], Cliente cliente, double saldo) {
		    LocalDateTime dataHoraAtual = LocalDateTime.now();
		    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		    String dataHora = dataHoraAtual.format(formato);

		    System.out.println("///////Extrato Bancario///////\n -Retirado: " + dataHora);
		    System.out.println("Cliente: " + cliente.nome + "\n CPF: ***" + cliente.cpf.charAt(3) + cliente.cpf.charAt(4) + cliente.cpf.charAt(5) + "-" + cliente.cpf.charAt(6) + cliente.cpf.charAt(7) + cliente.cpf.charAt(8) + "-**");

		    System.out.println("-----Saques-----");
		    for (String[] saque : extratoSaque) {
		        System.out.println(Arrays.toString(saque));
		    }

		    System.out.println("-----Depositos-----");
		    for (String[] deposito : extratoDeposito) {
		        System.out.println(Arrays.toString(deposito));
		    }

		    System.out.println("-----Saldo total: " + saldo);
		    System.out.println("Observaçao: cada deposito tem uma valorização de 0.5% em cima do valor depositado");
		}

}
