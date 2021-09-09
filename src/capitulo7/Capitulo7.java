package capitulo7;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import modelo.Usuario;

/**
 * Streams e Collectors
 * 
 * @author paulo
 *
 */
public class Capitulo7 {

	public static void main(String... args) {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 90);

		// Lista imutavel
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

		usuarios.stream().filter(u -> u.getPontos() > 100);

		// Imprime a lista toda
		usuarios.forEach(System.out::println);

		System.out.println("--------------------------------------");

		// imprime a lista filtrada

		Stream<Usuario> stream = usuarios.stream().filter(u -> u.getPontos() > 100);

		stream.forEach(System.out::println);

		System.out.println("--------------------------------------");

		// ou

		usuarios.stream().filter(u -> u.getPontos() > 100).forEach(System.out::println);

		System.out.println("--------------------------------------");

		List<Usuario> maisQue100 = new ArrayList<>();

		usuarios.stream().filter(u -> u.getPontos() > 100).forEach(u -> maisQue100.add(u));

		System.out.println(maisQue100);

		System.out.println("--------------------------------------");

		// limpa lista
		maisQue100.clear();

		// ou
		usuarios.stream().filter(u -> u.getPontos() > 100).forEach(maisQue100::add);

		System.out.println(maisQue100);

		System.out.println("--------------------------------------");

		// Collectors
		Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
		BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
		BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner = ArrayList::addAll;
		
		List<Usuario> maisQue1002 = usuarios.stream()
				.filter(u -> u.getPontos() > 100)
				.collect(supplier, accumulator,	combiner);
		
		System.out.println(maisQue1002);
		
		System.out.println("--------------------------------------");
		//ou
		List<Usuario> maisQue1003 = usuarios.stream()
		.filter(u ->u.getPontos()> 100)
		.collect(Collectors.toList());
		
		System.out.println(maisQue1003);
		
		System.out.println("--------------------------------------");
		
		Set<Usuario> maisQue1004 = usuarios
				.stream()
				.filter(u -> u.getPontos() > 100)
				.collect(toSet());
		
		System.out.println(maisQue1004);
		

		System.out.println("--------------------------------------");
		
		
		// Usando map
		List<Integer> pontos = usuarios.stream()
				.map(u -> u.getPontos())
				.collect(toList());
		System.out.println(pontos);
		
		System.out.println("--------------------------------------");
		IntStream stream3 = usuarios.stream()
				.mapToInt(Usuario::getPontos);
		System.out.println(stream3);
		
		System.out.println("--------------------------------------");

		double pontuacaoMedia = usuarios.stream()
				.mapToInt(Usuario::getPontos)
				.average()
				.getAsDouble();
		System.out.println(pontuacaoMedia);
		
		System.out.println("--------------------------------------");
		
		// Optional
		OptionalDouble media = usuarios.stream()
				.mapToInt(Usuario::getPontos)
				.average();
		
		double pontuacaoMedia2 = media.orElse(0.0);
		
		System.out.println(pontuacaoMedia2);
		
		System.out.println("--------------------------------------");
		
		
		
		
		
	}
	
	
}
