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
System.out.println(�N�umero: �+ generator.nextInt(valor));

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
		int valor = 0; //salva o n�mero sorteado pela randomiza��o
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
				System.out.println("n�mero incorreto, digite um valor maior que zero.");
				return;
			}
			else {
				while (i < quantN){
					vet[i] = generator.nextInt(5000); // Gera n�meros aleat�rios entre 0 e 5000
					maior = generator.nextInt(5000);
					valor = generator.nextInt(5000); // salva o n�mero aleat�rio 
													// para ser usado nos  tratamentos abaixo
					for(int k = 0; k < quantN - 1; k++) {
					    if(vet[i] < menor){       // menor n�mero
							menor = vet[i]; 
					    }
					    if (vet[i] > maior) {     // maior n�mero
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
				                
				              // aqui vai o Desvio Padr�o


				    soma = soma + vet[i];
				    media = soma / quantN;
				    System.out.print("Elementos do vetor: "+ vet[i] + "\t");
					System.out.println();
					i++;
				}
				
				            
				// Vari�ncia
                variancia = (((soma / quantN)^2) - valor)/ quantN;
					
				System.out.print("quantidade de posi��es do vetor: "+ quantN);
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
				System.out.print("A m�dia � de: "+ media);
				System.out.println();
				System.out.print("moda = "+ moda + " , quantos n�meros se repetiram? " + contModa);
				System.out.println();
				System.out.print("A mediana � de: "+ mediana);
				System.out.println();
				System.out.print("vari�ncia = "+ variancia);
				
				}
			//entrada.close();
	}		
}