/*Faça um programa que calcule e mostre ao usuário 
o Maior número, Menor número, Lista dos Números pares 
e ímpares, lista dos números Primos,Soma, Média, Moda, 
Mediana, Variância e Desvio Padrão de valores inteiros
que serão gerados de forma aleatória. O usuário ao entrar 
no programa escolhe a quantidade de números que serão 
gerados. Os números gerados são armazenados em um vetor 
e é neste vetor que devem ser feitas as verificações
para chegar aos dados solicitados. Ao final além de mostrar 
os valores solicitados também é apresentado o vetor 
contendo os números aleatórios. 

Exemplo de como gerar números aleatórios em Java:

import java.util.Random;
Random generator = new Random();
int valor = 10; // Neste caso vai gerar n´umeros 0 e 9
System.out.println(”Número: ”+ generator.nextInt(valor));

Alguns requisitos do programa:

1. Como padrão vamos assumir que os números gerados 
serão entre 0 e 5000;

2. Use as constantes para colocar os valores que 
são imutáveis;

3. O programa deve funcinar com qualquer valor 
inteiro informado pelo usuário como quantidade de 
valores que deverão ser gerados;

4. Caso o usuário informe um valor não permitido 
(zero ou negativo) o programa deve avisar sobre a 
entrada não é válida e solicitar novamente
que informe um valor válido;

5. Ao mostrar os dados o programa deve permitir 
ao usuário iniciar o processo novamente, 
voltando a solicitar a quantidade de números que
devem ser gerados.
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;;

public class vetores2 {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner entrada = new Scanner(System.in);
		int quantN;

		System.out.print("informe a quantidade de elementos do vetor: ");
		quantN = entrada.nextInt();
		entrada.close();
		
		int maior = 0;
		int menor = 0;
		int soma = 0;
		int contModa = 0;
		int i = 0;
		int valor = 0;
		int contPar = 0;
		int contImpar = 0;
		int contPrimo = 0;

		boolean repetiu = false;
		
		float variancia = 0.0f;
		float media = 0.0f;
		float mediana = 0.0f;

		int vet[] = new int[quantN];
		int primos[];
		int pares[];
		int impares[];
		int moda[];

		Random generator = new Random();

		if (quantN <= 0) {
			System.out.println("número incorreto, digite um valor maior que zero.");
			return;
		} else {
			System.out.print("\nElementos do vetor (Quantidade " + quantN  + "): \n");
			for (i = 0; i < quantN - 1; i++) {
				vet[i] = generator.nextInt(5000); // Gera números aleatórios entre 0 e 5000
				//valor = generator.nextInt(5000); // salva o número aleatório
				// para ser usado nos tratamentos abaixo

				if (i == 0) {
					maior = vet[i];
					menor = vet[i];
				} else if (vet[i] < menor) // menor número
					menor = vet[i];
				else if (vet[i] > maior) // maior número
					maior = vet[i];

				// Validando par/impar/primos e demais
				if (vet[i] % 2 == 0) {
					contPar++;
				}else 
					contImpar++;
				
				if (vet[i] % 2 != 0) {
					if (vet[i] % 1 == vet[i]) // primos
					contPrimo++;
				}
				if (vet[i] == vet[i]) { // moda
					contModa++;
				}

				// aqui vai a mediana

				if (vet.length % 2 == 0)
					mediana = (vet[(i - 1) / 2] + vet[(i + 1) / 2]) / 2;
				else
					mediana = (vet[i / 2]);

				// aqui vai o Desvio Padrão

				soma = soma + vet[i];

				System.out.print(vet[i] + "  ");
				
			}
			media = soma / quantN;

			// Variância
			variancia = (((soma / quantN)^2) - valor)/ quantN;

			pares = new int[contPar];
			impares = new int[contImpar];
			primos = new int[contPrimo];
			moda = new int[contModa];
			contPar = 0;
			contImpar = 0;
			contPrimo = 0;
			contModa = 0;

			// Validações
			for (i = 0; i < quantN - 1; i++)
				if (vet[i] % 2 == 0) {// Numeros pares
					pares[contPar] = vet[i];
					contPar++;
				}

			for (i = 0; i < quantN - 1; i++)
				if (vet[i] % 2 != 0) { // Numeros ímpares
					impares[contImpar] = vet[i];
					contImpar++;
					if (vet[i] % 1 == vet[i]) {
						primos[contPrimo] = vet[i];
						contPrimo++;
					}
				}

			for (i = 0; i < quantN - 1; i++)
				if (vet.length == vet[i]) {		// moda
					moda[i] = vet[i];
				}
			
			Arrays.sort(vet);
			
			int last = vet[0] + 1;
			for (i = 1; i < vet.length; i++) {
				if (vet[i] == vet[i-1] && last != vet[i-1]) {
					repetiu = true;
					last = vet[i];
					System.out.println();
					System.out.println("Moda: " + last);
				}
			}
			
			
			System.out.println("\n");
			System.out.println("Maior valor = " + maior);
			System.out.println("Menor valor = " + menor);

			System.out.print("pares = ");
			for (i = 0; i < pares.length - 1; i++)
				System.out.print(pares[i] + "  ");

			System.out.println();
			System.out.print("impares = ");
			for (i = 0; i < impares.length - 1; i++)
				System.out.print(impares[i] + "  ");

			System.out.println();
			System.out.println("números primos: ");
			for (i = 0; i < primos.length - 1; i++)
				System.out.print(primos[i] + "  ");
			
			System.out.println();
			System.out.println("soma = " + soma);
			System.out.println("A média é de: " + media);
			System.out.println("Moda: " + moda[i]);
			
			System.out.println();
			System.out.println("A mediana é de: " + mediana);
			System.out.println();
			System.out.println("variância = " + variancia);

		}
	}
}