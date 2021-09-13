package capitulo9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import modelo.Usuario;

public class Capitulo9 {

	public static void main(String... args) throws IOException {
		Map<Object, Object> lines = Files.list(Paths.get("./src/capitulo8/files"))
				.filter(p -> p.toString().endsWith(".txt")).collect(Collectors.toMap(p -> p, p -> {
					try {
						return Files.lines(p).count();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return 0;
				}));
		System.out.println(lines);

		System.out.println("------------------------------------------------");
		

		Usuario user1 = new Usuario("Paulo Silveira", 150, true);
		Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
		Usuario user3 = new Usuario("Guilherme Silveira", 90);
		Usuario user4 = new Usuario("Sergio Lopes", 120);
		Usuario user5 = new Usuario("Adriano Almeida", 100);
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

		Map<Integer, List<Usuario>> pontuacao = new HashMap<>();
		for (Usuario u : usuarios) {
			if (!pontuacao.containsKey(u.getPontos())) {
				pontuacao.put(u.getPontos(), new ArrayList<>());
			}
			pontuacao.get(u.getPontos()).add(u);

			System.out.println(pontuacao);

		}

		System.out.println("------------------------------------------------");
		

		Map<Integer, List<Usuario>> pontuacao2 = new HashMap<>();
		for (Usuario u : usuarios) {
			pontuacao2.computeIfAbsent(u.getPontos(), user -> new ArrayList<>()).add(u);
		}
		
		System.out.println(pontuacao2);
		
		System.out.println("------------------------------------------------");
		
		
		Map<Boolean, List<String>> nomesPorTipo2 = usuarios
				.stream()
				.collect(
				Collectors.partitioningBy(
				Usuario::isModerador,
				Collectors.mapping(Usuario::getNome,
				Collectors.toList())));
		
		System.out.println(nomesPorTipo2);
		System.out.println("------------------------------------------------");
		
		Map<Boolean, Integer> pontuacaoPorTipo = usuarios
				.stream()
				.collect(
				Collectors.partitioningBy(
				Usuario::isModerador,
				Collectors.summingInt(Usuario::getPontos)));
				System.out.println(pontuacaoPorTipo);
				
				System.out.println("------------------------------------------------");
				
				String nomes = usuarios
						.stream()
						.map(Usuario::getNome)
						.collect(Collectors.joining(", "));
				
				System.out.println(nomes);
				System.out.println("------------------------------------------------");
				
	
				List<Usuario> filtradosOrdenados = usuarios.parallelStream()
						.filter(u -> u.getPontos() > 100)
						.sorted(Comparator.comparing(Usuario::getNome))
						.collect(Collectors.toList());
				
				System.out.println(filtradosOrdenados);
				
				System.out.println("------------------------------------------------");
				
				long sum =
						LongStream.range(0, 1_000_000_000)
						.parallel()
						.filter(x -> x % 2 == 0)
						.sum();
						System.out.println(sum);
						System.out.println("------------------------------------------------");
						
						
						
	}
}
