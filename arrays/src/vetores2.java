/*Fa�a um programa que calcule e mostre ao usu�rio 
o Maior n�mero, Menor n�mero, Lista dos N�meros pares 
e �mpares, lista dos n�meros Primos,Soma, M�dia, Moda, 
Mediana, Vari�ncia e Desvio Padr�o de valores inteiros
que ser�o gerados de forma aleat�ria. O usu�rio ao entrar 
no programa escolhe a quantidade de n�meros que ser�o 
gerados. Os n�meros gerados s�o armazenados em um vetor 
e � neste vetor que devem ser feitas as verifica��es
para chegar aos dados solicitados. Ao final al�m de mostrar 
os valores solicitados tamb�m � apresentado o vetor 
contendo os n�meros aleat�rios. 

Exemplo de como gerar n�meros aleat�rios em Java:

import java.util.Random;
Random generator = new Random();
int valor = 10; // Neste caso vai gerar n�umeros 0 e 9
System.out.println(�N�mero: �+ generator.nextInt(valor));

Alguns requisitos do programa:

1. Como padr�o vamos assumir que os n�meros gerados 
ser�o entre 0 e 5000;

2. Use as constantes para colocar os valores que 
s�o imut�veis;

3. O programa deve funcinar com qualquer valor 
inteiro informado pelo usu�rio como quantidade de 
valores que dever�o ser gerados;

4. Caso o usu�rio informe um valor n�o permitido 
(zero ou negativo) o programa deve avisar sobre a 
entrada n�o � v�lida e solicitar novamente
que informe um valor v�lido;

5. Ao mostrar os dados o programa deve permitir 
ao usu�rio iniciar o processo novamente, 
voltando a solicitar a quantidade de n�meros que
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
			System.out.println("n�mero incorreto, digite um valor maior que zero.");
			return;
		} else {
			System.out.print("\nElementos do vetor (Quantidade " + quantN  + "): \n");
			for (i = 0; i < quantN - 1; i++) {
				vet[i] = generator.nextInt(5000); // Gera n�meros aleat�rios entre 0 e 5000
				//valor = generator.nextInt(5000); // salva o n�mero aleat�rio
				// para ser usado nos tratamentos abaixo

				if (i == 0) {
					maior = vet[i];
					menor = vet[i];
				} else if (vet[i] < menor) // menor n�mero
					menor = vet[i];
				else if (vet[i] > maior) // maior n�mero
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

				// aqui vai o Desvio Padr�o

				soma = soma + vet[i];

				System.out.print(vet[i] + "  ");
				
			}
			media = soma / quantN;

			// Vari�ncia
			variancia = (((soma / quantN)^2) - valor)/ quantN;

			pares = new int[contPar];
			impares = new int[contImpar];
			primos = new int[contPrimo];
			moda = new int[contModa];
			contPar = 0;
			contImpar = 0;
			contPrimo = 0;
			contModa = 0;

			// Valida��es
			for (i = 0; i < quantN - 1; i++)
				if (vet[i] % 2 == 0) {// Numeros pares
					pares[contPar] = vet[i];
					contPar++;
				}

			for (i = 0; i < quantN - 1; i++)
				if (vet[i] % 2 != 0) { // Numeros �mpares
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
			System.out.println("n�meros primos: ");
			for (i = 0; i < primos.length - 1; i++)
				System.out.print(primos[i] + "  ");
			
			System.out.println();
			System.out.println("soma = " + soma);
			System.out.println("A m�dia � de: " + media);
			System.out.println("Moda: " + moda[i]);
			
			System.out.println();
			System.out.println("A mediana � de: " + mediana);
			System.out.println();
			System.out.println("vari�ncia = " + variancia);

		}
	}
}