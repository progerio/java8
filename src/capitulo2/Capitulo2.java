package capitulo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import modelo.Usuario;

public class Capitulo2 {

	public static void main(String... args) {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);

		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

		for (Usuario u : usuarios) {
			System.out.println(u.getNome());
		}

		System.out.println("----------------------");

		Mostrador mostrador = new Mostrador();

		usuarios.forEach(mostrador);

		System.out.println("----------------------");

		// Exemplo loop com variavel consumer
		Consumer<Usuario> mostrador1 = new Consumer<Usuario>() {

			@Override
			public void accept(Usuario u) {
				System.out.println(u.getNome());
			}
		};
		usuarios.forEach(mostrador1);
		System.out.println("----------------------");

		// Exemplo loop criando consumer direto
		usuarios.forEach(new Consumer<Usuario>() {
			@Override
			public void accept(Usuario u) {
				System.out.println(u.getNome());
			}
		});
		System.out.println("----------------------");

		// Outro exemplo
		Consumer<Usuario> mostrador2 = (Usuario u) -> {
			System.out.println(u.getNome());
		};
		usuarios.forEach(mostrador2);
		System.out.println("----------------------");

		// Outro exemplo
		Consumer<Usuario> mostrador3 = (Usuario u) -> System.out.println(u.getNome());

		usuarios.forEach(mostrador3);
		System.out.println("----------------------");

		// Outro exemplo mais customizado
		usuarios.forEach(u -> System.out.println(u.getNome()));

	}
}
