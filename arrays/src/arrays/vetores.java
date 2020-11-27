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
System.out.println(”N´umero: ”+ generator.nextInt(valor));

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

package arrays;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class vetores {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws java.lang.Exception
	{
		Scanner entrada = new Scanner(System.in);
		int quantN; 
		
		System.out.print("informe a quantidade de elementos do vetor: ");
		quantN = entrada.nextInt();
		
		int maior = Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;
		int valor = 0; //salva o número sorteado pela randomização
		int soma = 0;
		int contModa = 0;
		int i = 0;

		float moda = 0.0f;
		float variancia = 0.0f;
		double media = 0.0;
		float mediana = 0.0f;
		
		int vet[] = new int [quantN];
		int pares[] = new int [quantN];;
		int impares[] = new int [quantN];;
		int primos[] = new int[quantN];
		
		
			
		Random generator = new Random();
		
			if (quantN <= 0) {
				System.out.println("número incorreto, digite um valor maior que zero.");
				return;
			}
			else {
				while (i < quantN){
					vet[i] = generator.nextInt(5000); // Gera números aleatórios entre 0 e 5000
					maior = generator.nextInt(5000);
					valor = generator.nextInt(5000); // salva o número aleatório 
													// para ser usado nos  tratamentos abaixo
					for(int k = 0; k < quantN - 1; k++) {
					    if(vet[i] < menor){       // menor número
							menor = vet[i]; 
					    }
					    if (vet[i] > maior) {     // maior número
					    	maior = vet[i];
					    }
					}
					
					if (vet[i] % 2 == 0) { //Numeros pares
			             pares[i]= vet[i];
			        }
			        else {
			             impares[i]= vet[i]; //Numeros impares
			        }
				    
				    if (valor % 2 != 0 && valor % 1 == valor) {  //primos
				        primos[i] = valor;
				    }
				    if(valor == vet[i]) {          // moda
				        moda = valor;
				        contModa = contModa + 1;
				    }
				    
				              //aqui vai a mediana
				     
				    if (vet.length % 2 == 0) {
		                mediana = (vet[(i - 1) / 2] + vet[(i + 1) / 2]) / 2;
		            } else {
		            	mediana = (vet[i / 2]);
		            }            
				                
				              // aqui vai o Desvio Padrão


				    soma = soma + vet[i];
				    media = soma / quantN;
				    System.out.print("Elementos do vetor: "+ vet[i] + "\t");
					System.out.println();
					i++;
				}
				
				            
				// Variância
                variancia = (((soma / quantN)^2) - valor)/ quantN;
					
				System.out.print("quantidade de posições do vetor: "+ quantN);
				System.out.println();
				System.out.print("Maior valor = "+ maior);
				System.out.println();
				System.out.print("Menor valor = "+ menor);
				
				System.out.println();
				
				
				for (i=0; i < pares.length; i++) {
					if (vet[i] % 2 == 0 ) {
						System.out.print("pares = ");
						System.out.print(pares[i]);
						System.out.println();
					    }
					else {
						System.out.print("impares = ");
						System.out.print(impares[i]);
						System.out.println();
					    }
			     }
				System.out.println();
				System.out.print("soma = "+ soma);
				System.out.println();
				System.out.print("A média é de: "+ media);
				System.out.println();
				System.out.print("moda = "+ moda + " , quantos números se repetiram? " + contModa);
				System.out.println();
				System.out.print("A mediana é de: "+ mediana);
				System.out.println();
				System.out.print("variância = "+ variancia);
				
				}
			//entrada.close();
	}		
}