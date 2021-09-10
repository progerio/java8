package capitulo8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import modelo.Usuario;

/**
 * Mais operações com Streams
 * @author paulo
 *
 */
public class Capitulo8 {

	public static void main(String... args) throws IOException {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 90);

		// Lista imutavel
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
	
		List<Usuario> filtradosOrdenados = usuarios.stream()
				.filter(u -> u.getPontos() > 100)
				.sorted(Comparator.comparing(Usuario::getNome))
				.collect(Collectors.toList());
		
		System.out.println(filtradosOrdenados);
		
		System.out.println("-----------------------------------------");
		
		Usuario maisDe100 = usuarios.stream()
				.filter(u -> u.getPontos() > 100)
				.collect(Collectors.toList())
				.get(0);
		
		System.out.println(maisDe100);
		
		System.out.println("-----------------------------------------");

		Optional<Usuario> usuarioOptional = usuarios.stream()
				.filter(u -> u.getPontos() > 100)
				.findAny();
		System.out.println(usuarioOptional);
		
		System.out.println("-----------------------------------------");

		usuarios.stream()
		.filter(u -> u.getPontos() > 100)
		.peek(System.out::println)
		.findAny();
		
		System.out.println("-----------------------------------------");
	
		//Operações de redução
		double pontuacaoMedia = usuarios.stream()
				.mapToInt(Usuario::getPontos)
				.average()
				.getAsDouble();
		
		System.out.println(pontuacaoMedia);
		
		Optional<Usuario> max = usuarios.stream()
				.max(Comparator.comparing(Usuario::getPontos));
				Usuario maximaPontuacao = max.get();
				
				System.out.println(maximaPontuacao);
		
		
		int total = usuarios.stream()
						.mapToInt(Usuario::getPontos)
						.sum();
		System.out.println(total);
		
		System.out.println("-----------------------------------------");

		//Streams infinitos
		Random random = new Random(0);
		IntStream stream = IntStream.generate(()-> random.nextInt());
//		System.out.println(stream);
		
		List<Integer> list = stream
				.limit(100)
				.boxed()
				.collect(Collectors.toList());
		System.out.println(list);
		
		
		Random random2 = new Random(0);
		
		List<Integer> list2 = IntStream
		.generate(() -> random2.nextInt())
		.limit(100)
		.boxed()
		.collect(Collectors.toList());
		
		System.out.println(list2);
		System.out.println("-----------------------------------------");
		
		//Operações de curto circuito
		
		IntStream.generate(new Fibonacci())
		.limit(10)
		.forEach(System.out::println);
		
		int maiorQue100 = IntStream
				.generate(new Fibonacci())
				.filter(f -> f > 100)
				.findFirst()
				.getAsInt();
				System.out.println(maiorQue100);
		
		IntStream.iterate(0, x -> x + 1)
				.limit(10)
				.forEach(System.out::println);		
		System.out.println("-----------------------------------------");
		
		//Listando arquivos com Stream
		Files.list(Paths.get("./src/capitulo8/files"))
		.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		// Filtrando arquivos com extensão .csv
		
		Files.list(Paths.get("./src/capitulo8/files"))
		.filter(p -> p.toString().endsWith(".csv"))
		.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		// Ler todo conteudo dos arquivos
		
		Files.list(Paths.get("./src/capitulo8/files"))
		.filter(p -> p.toString().endsWith(".csv"))
		.map(p -> {
			try {
				return Files.lines(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		})
		.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		//FlatMap
		Grupo englishSpeakers = new Grupo();
		englishSpeakers.add(user1);
		englishSpeakers.add(user2);
		
		Grupo spanishSpeakers = new Grupo();
		spanishSpeakers.add(user2);
		spanishSpeakers.add(user3);
		
		List<Grupo> groups = Arrays.asList(englishSpeakers, spanishSpeakers);
		
		groups.stream()
		.flatMap(g -> g.getUsuarios().stream())
		.distinct()
		.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
	}
}
