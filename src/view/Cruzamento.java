package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Cruzamento {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCarro = 1; idCarro < 5; idCarro++) {
			ThreadCarro threadCarro = new ThreadCarro(idCarro, semaforo);
			threadCarro.start();
		}
	}

}
