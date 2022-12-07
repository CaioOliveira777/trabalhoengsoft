package com.mata62.projetofinal;

import java.util.List;
import java.util.HashMap;

public class Console {

	public HashMap<String, Comando> comandos = new HashMap<String, Comando>();

	public Console() {
		this.inicializarComandos();
	}

	public void inicializarComandos() {

		comandos.put("usu", new ComandoUsu());
		comandos.put("emp", new ComandoEmp());
		comandos.put("liv", new ComandoLiv());
		comandos.put("sai", new ComandoSai());
		comandos.put("obs", new ComandoObs());
		comandos.put("nft", new ComandoNft());
		comandos.put("dev", new ComandoDev());
		comandos.put("res", new ComandoRes());
	}

	public void service(List<String> input, String instru) {
		Comando comando = comandos.get(instru);
		comando.execute(input);
	}

}
