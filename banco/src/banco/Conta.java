package banco;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

    public class Conta {
    	protected double saldo;
    	protected double saque;
    	protected double deposito;
    	String extratoSaque[][] = new String[10][2];
    	protected String extratoDeposito[][] = new String[10][2];
    	Cliente clienteX;

        public double sacar(double saque) {
            saldo -= saque;
            return saldo;
        }

        public double depositar(double deposito) {
            saldo += deposito;
            return saldo;
        }

        public void preencherExtratoSaque(double sacar) {
            LocalDateTime dataHoraAtual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHora = dataHoraAtual.format(formato);
            double valor = sacar;
            String palavra = "Saque";

            extratoSaque[0][0] = palavra;
            extratoSaque[0][1] = String.valueOf(valor);
            extratoSaque[1][0] = dataHora;

           
            }
        
        public void preencherExtratoDeposito(double depositar) {
            LocalDateTime dataHoraAtual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHora = dataHoraAtual.format(formato);
            double valor = depositar;
            String palavra = "Depósito";

            extratoDeposito[0][0] = palavra;
            extratoDeposito[0][1] = String.valueOf(valor);
            extratoDeposito[1][0] = dataHora;

        }
///////////////////////
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
    	}
	


    }



