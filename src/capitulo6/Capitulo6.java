package capitulo6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import modelo.Usuario;

/**
 * Method References
 * 
 * @author paulo
 *
 */
public class Capitulo6 {

	public static void main(String... args) {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);

		// Lista imutavel
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
		Consumer<Usuario> tornarModerador = Usuario::tornarModerador;
		usuarios.forEach(tornarModerador);
		
		//Comparando de uma forma mais enxuta
		usuarios.sort(Comparator.comparing(Usuario::getNome));
		
		usuarios.forEach(Usuario::getNome);
	
		System.out.println("-----------------------------------------");
		
		usuarios.sort( Comparator.comparingInt(Usuario::getPontos)
								 .thenComparing(Usuario::getNome));
		
		usuarios.forEach(Usuario::getNome);
		
		System.out.println("-----------------------------------------");
		
		// A invocação bloco.run() vai fazer com que rodrigo.tornaModerador()
		// seja invocado
		Usuario rodrigo = new Usuario("Rodrigo Turini", 50);
		Runnable bloco = rodrigo::tornarModerador;
		bloco.run();
		//ou
		Usuario rodrigo2 = new Usuario("Rodrigo Turini", 50);
		Consumer<Usuario> consumer = Usuario::tornarModerador;
		consumer.accept(rodrigo2);
		
		System.out.println("-----------------------------------------");
		
		usuarios.forEach(System.out::println);
		
		Function<String, Usuario> criadorDeUsuarios = Usuario::new;
		Usuario rodrigo3 = criadorDeUsuarios.apply("Rodrigo Turini");
		Usuario paulo = criadorDeUsuarios.apply("Paulo Silveira");
		
	}
}
