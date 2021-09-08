package capitulo3;

public class Capitulo3 {

	public static void main(String[] args) {

		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 1000; i++) {
					System.out.println(i);
				}
			}
		};

		new Thread(r).start();
		System.out.println("----------------------");

		Runnable r1 = () -> {

			for (int i = 0; i <= 1000; i++) {
				System.out.println(i);
			}
		};

		new Thread(r1).start();
		System.out.println("----------------------");

		new Thread(() -> {

			for (int i = 0; i <= 1000; i++) {
				System.out.println(i);
			}

		}).start();
		System.out.println("----------------------");

		// Classe anonima customizada

		Validador<String> validadorCEP = new Validador<String>() {

			@Override
			public boolean valida(String valor) {
				return valor.matches("[0-9]{5}-[0-9]{3}");
			}
		};

		System.out.println(validadorCEP.valida("04101-300"));

		System.out.println("----------------------");

		Runnable o = () -> {
			System.out.println("O que sou eu?. Que lambda?");
		};

		System.out.println(o);
		System.out.println(o.getClass());

		System.out.println("----------------------");


		// Acesso a variavel externa somente variavel final.Até pode acessar variaveis externas 
		// sem ser final. mas esta variavel não pode ser alterada. Pois ocorre um erro de compilação.
		final int numero = 5;
		
		new Thread(()-> System.out.println(numero)).start();

		System.out.println("----------------------");

		
	}
}
