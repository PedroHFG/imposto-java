import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double salarioAnual, salarioMensal, prestacaoDeServico, ganhoDeCapital, gastosmedico, gastosEducacao;
		double impostoSalarioAnual, impostoSalarioMensal, impostoPrestacaoDeServico, impostoGanhoDeCapital;
		
		System.out.print("Renda anual com salário: ");
		salarioAnual = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		prestacaoDeServico = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		ganhoDeCapital = sc.nextDouble();
		System.out.print("Gastos médicos: ");
		gastosmedico = sc.nextDouble();
		System.out.print("Gastos Educacionais: ");
		gastosEducacao = sc.nextDouble();
		
		// Cálculo de impostos sobre o salário
		salarioMensal = salarioAnual / 12;
		
		if (salarioMensal < 3000) {
			impostoSalarioMensal = 0.00;
		}
		else if (salarioMensal < 5000) {
			impostoSalarioMensal = salarioMensal * 0.10;
		}
		else {
			impostoSalarioMensal = salarioMensal * 0.20;
		}
		
		impostoSalarioAnual = impostoSalarioMensal * 12;
		
		// Cálculo de impostos sobre prestação de serviços
		impostoPrestacaoDeServico = (prestacaoDeServico > 0) ? prestacaoDeServico * 0.15 : 0.00;
		
		// Cálculo de impostos sobre ganho de capital
		impostoGanhoDeCapital = (ganhoDeCapital > 0) ? ganhoDeCapital * 0.20 : 0.00;
		
		double impostoTotal = impostoSalarioAnual + impostoPrestacaoDeServico + impostoGanhoDeCapital;
		double maximoDedutivel = impostoTotal * 0.30;
		double totalGastos = gastosmedico + gastosEducacao;
		double abatimento, impostoDevido;
		
		if (totalGastos < maximoDedutivel) {
			abatimento = totalGastos;
		}
		else {
			abatimento = maximoDedutivel;
		}
		
		impostoDevido = impostoTotal - abatimento;
		
		System.out.println();
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println();
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f%n", impostoSalarioAnual);
		System.out.printf("Imposto sobre serviços: %.2f%n", impostoPrestacaoDeServico);
		System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoGanhoDeCapital);
		System.out.println();
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f%n", totalGastos);
		System.out.println();
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f%n", impostoTotal);
		System.out.printf("Abatimento: %.2f%n", abatimento);
		System.out.printf("Imposto devido: %.2f%n", impostoDevido);
		
		sc.close();

	}

}
