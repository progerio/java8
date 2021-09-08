package capitulo2;

import java.util.function.Consumer;

import modelo.Usuario;

public class Mostrador implements Consumer<Usuario> {

	@Override
	public void accept(Usuario u) {
		System.out.println(u.getNome());
	}

}
