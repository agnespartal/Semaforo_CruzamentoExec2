package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private String sentido;
	private Semaphore semaforo;

	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		sentido();
		System.out.println("#"+idCarro+ " está aguardando sua vez");
		// Inicio secão critica 
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println("#"+idCarro+ " passou");
		}
		// Fim secão critica 
	}

	private void sentido() {

		switch (idCarro) {
		case 1: {
			sentido = "para cima";
		}
			break;
		case 2: {
			sentido = "para baixo";
		}
			break;
		case 3: {
			sentido = "para esquerda";
		}
			break;
		case 4: {
			sentido = "para direita";
		}
			break;
		}
	}

	private void cruzamento() {
		System.out.println("#" + idCarro + " esta indo " + sentido);
			
	}

}
