import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TarefaColecoes {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Parte 1: Ler nomes, separar, ordenar e imprimir
        System.out.println("Parte 1: Digite os nomes separados por vírgulas:");
        String inputNomes = scanner.nextLine();
        
        // Usando split para separar os nomes por vírgula
        String[] nomesArray = inputNomes.split(",");
        
        // Remover espaços em branco ao redor dos nomes
        for (int i = 0; i < nomesArray.length; i++) {
            nomesArray[i] = nomesArray[i].trim();
        }

        // Converter o array para uma lista e ordenar
        ArrayList<String> listaNomes = new ArrayList<>(Arrays.asList(nomesArray));
        Collections.sort(listaNomes);
        
        // Imprimir nomes ordenados
        System.out.println("\nNomes ordenados alfabeticamente:");
        for (String nome : listaNomes) {
            System.out.println(nome);
        }
        
        // Parte 2: Ler nome e sexo, separar por grupos
        Map<String, ArrayList<String>> grupos = new HashMap<>();
        grupos.put("Masculino", new ArrayList<>());
        grupos.put("Feminino", new ArrayList<>());
        
        System.out.println("\nParte 2: Digite o nome e o sexo (M/F) separados por vírgula (Ex.: João,M ou Maria,F):");
        
        String escolha = "s";
        
        // Loop para ler vários nomes e sexos
        while (escolha.equalsIgnoreCase("s")) {
            System.out.println("Digite o nome e o sexo (M/F):");
            String inputPessoa = scanner.nextLine();
            
            // Usando split para separar o nome e o sexo
            String[] pessoaArray = inputPessoa.split(",");
            
            // Verifica se a entrada contém nome e sexo
            if (pessoaArray.length != 2) {
                System.out.println("Entrada inválida. Certifique-se de que digitou no formato 'nome, sexo'.");
                continue;
            }
            
            String nome = pessoaArray[0].trim();
            String sexo = pessoaArray[1].trim().toUpperCase();
            
            // Verifica o sexo e adiciona ao grupo correto no formato Nome-Sexo
            if (sexo.equals("M")) {
                grupos.get("Masculino").add(nome + "-M");
            } else if (sexo.equals("F")) {
                grupos.get("Feminino").add(nome + "-F");
            } else {
                System.out.println("Sexo inválido. Use 'M' para Masculino ou 'F' para Feminino.");
                continue;
            }
            
            System.out.println("Deseja adicionar mais uma pessoa? (s/n): ");
            escolha = scanner.nextLine();
        }
        
        System.out.println("\nGrupo Masculino:");
        for (String masculino : grupos.get("Masculino")) {
            System.out.println(masculino);
        }
        
        System.out.println("\nGrupo Feminino:");
        for (String feminino : grupos.get("Feminino")) {
            System.out.println(feminino);
        }
        
        scanner.close();
    }
}
