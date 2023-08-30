package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String SO_teste () {
		String os  = System.getProperty("os.name");
		return os;
	}
	
	public void listaprocessos() {
		String OS = SO_teste();
		
		if(OS.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha!=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			if(OS.contains("Linux")) {
				try {
					Process p = Runtime.getRuntime().exec("ps -ef");
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					
					while(linha!=null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
					
					buffer.close();
					leitor.close();
					fluxo.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void matapid(int pid) {
		String OS = SO_teste();
		
		if(OS.contains("Windows")) {
			try {
				StringBuffer buffer = new StringBuffer();
				buffer.append("TASKKILL /PID ");
				buffer.append(pid);
				Runtime.getRuntime().exec(buffer.toString());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			if(OS.contains("Linux")) {
				try {
					StringBuffer buffer = new StringBuffer();
					buffer.append("kill -9 ");
					buffer.append(pid);
					Runtime.getRuntime().exec(buffer.toString());
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void matanome(String nome) {
		String OS = SO_teste();
		
		if (OS.contains("Windows")) {
			try {
				StringBuffer buffer = new StringBuffer();
				buffer.append("TASKKILL /IM ");
				buffer.append(nome);
				Runtime.getRuntime().exec(buffer.toString());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			if(OS.contains("Linux")) {
				try {
					StringBuffer buffer = new StringBuffer();
					buffer.append("pkill -f ");
					buffer.append(nome);
					Runtime.getRuntime().exec(buffer.toString());
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
