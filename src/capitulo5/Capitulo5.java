package capitulo5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import modelo.Usuario;

/**
 * Comparators como lambda
 * 
 * @author paulo
 *
 */
public class Capitulo5 {

	public static void main(String... args) {

		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);

		// Lista imutavel
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

		Comparator<Usuario> comparator = new Comparator<Usuario>() {
			public int compare(Usuario u1, Usuario u2) {
				return u1.getNome().compareTo(u2.getNome());
			}
		};
		Collections.sort(usuarios, comparator);
		
		usuarios.forEach(u->System.out.println(u.getNome()));
		
		System.out.println("---------------------------");
		// ou
		
		Comparator<Usuario> comparator2 = (u1,u2)->u1.getNome().compareTo(u2.getNome());
		Collections.sort(usuarios, comparator2);
		usuarios.forEach(u->System.out.println(u.getNome()));
		
		
		System.out.println("---------------------------");
		
		usuarios.sort((u1,u2)-> u1.getNome().compareTo(u2.getNome()));
		usuarios.forEach(u->System.out.println(u.getNome()));

		System.out.println("---------------------------");
		
		Comparator<Usuario> comparator3 = Comparator.comparing(u -> u.getNome());
		usuarios.sort(comparator3);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));

		System.out.println("---------------------------");

		List<String> palavras = Arrays.asList("Casa do Código","Alura", "Caelum");
		
		palavras.sort(Comparator.naturalOrder());
		
		usuarios.forEach(u -> System.out.println(u.getNome()));

		System.out.println("---------------------------");
		
		// Usando Function
		Function<Usuario, String> extrairNome = u -> u.getNome();
		
		Comparator<Usuario> comparator4 = Comparator.comparing(extrairNome);
		usuarios.sort(comparator4);

		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		System.out.println("---------------------------");

		//Problemas de autoboxing
//		Function<Usuario, Integer> extraiPontos = u -> u.getPontos();
		ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
		Comparator<Usuario> comparator5 = Comparator.comparingInt(extraiPontos);
		usuarios.sort(comparator5);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		
	}
}
