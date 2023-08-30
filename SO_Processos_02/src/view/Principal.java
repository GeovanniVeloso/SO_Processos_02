package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Principal {

	public static void main(String[] args) {
		KillController kc = new KillController();
		
		int c = 0;
				
		do {
			c = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para listar os processos, 2 para matar os processos por PID e 3 para matar os processos por nome."));
			switch(c) {
			case 1:
				kc.listaprocessos();
				break;
			case 2:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do PID"));
				kc.matapid(pid);
				break;
			case 3:
				String nome = JOptionPane.showInputDialog("Insira o nome do processo");
				kc.matanome(nome);
				break;
			case 9:
				System.out.println("Encerrando");
				break;
			default:
				System.out.println("Opção Inválida");
			}
		}while(c!=9);

	}

}
