package com.mitienda.spring.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.ClienteController;
import com.mitienda.spring.models.Clientes;



public class MenuCliente {

	ClienteController clCtrl = ClienteController.getInstance();
	List<Clientes> clientesLista = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public void initMenuCliente() {

		
		int numero;

		System.out.println("\n");
		System.out.println("===CLIENTES===\n");

		System.out.println("(1).Crear\n");
		System.out.println("(2).Actualizar\n");
		System.out.println("(3).Borrar\n");
		System.out.println("(4).Listar\n");
		System.out.println("(5).Volver\n");

		System.out.println("Escoge una opcion: ");

		numero = (int) Integer.parseInt(scan.nextLine());

		switch (numero) {
		case 1:
			crear();
			break;
		case 2:
			actualizar();
			break;
		case 3:
			borrar();
			break;
		case 4:
			listar();
			break;
		case 5:
			break;
		}

	}

	public void listar() {
		 
		clientesLista = clCtrl.list();

		for (int i = 0; i < clientesLista.size(); i++) {

			System.out.println(i + " : " + clientesLista.get(i));

		}
	}

	
	public void actualizar() {
		listar();
		System.out.println("\nDime el id del cliente que quieres modificar:");		
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		Clientes cli =clientesLista.get(id);
		 
		System.out.println("Dame los datos que quieres cambiar\n");
		
		System.out.println("Cambiar nombre ? si/no");
		String valores = scan.nextLine();
		if(valores=="si") {
			System.out.println("Nombre:");
			valores = scan.nextLine();
			cli.setNombre(valores);
			System.out.println("\n");			
		}
		
		System.out.println("Cambiar Dni? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			do {
			System.out.println("Dni:");
			valores = scan.nextLine();
			cli.setDni(valores);
			System.out.println("\n");
			}while(valores.matches("^[0-9]{8}[a-zA-Z]{1}$"));
		}
		
		System.out.println("Cambiar direccion? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			System.out.println("Direccion:");
			valores = scan.nextLine();
			cli.setDireccion(valores);
			System.out.println("\n");
		}
		
		System.out.println("Cambiar telefono? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			do {
			System.out.println("Telefono:");
			valores = scan.nextLine();
			cli.setTelefono(valores);
			System.out.println("\n");
			}while(valores.matches("[0-9]*"));
		}
		
		System.out.println("Cambiar email? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			do {
			System.out.println("Email:");
			valores = scan.nextLine();		
			cli.setEmail(valores);
			System.out.println("\n");
			}while(valores.matches("[^A-Za-z0-9.@_-~#]+"));
		}
		
		clCtrl.save(cli);
	}

	
	public void borrar() {
		listar();		
		System.out.println("\nDime el id del cliente que quieres borrar:");
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		Clientes cli =clientesLista.get(id);
		clCtrl.delete(cli);

	}

	
	public void crear() {

		Clientes cli = new Clientes();
		String valores;
		
		System.out.println("Dame los datos del cliente \n");
		
		do {
		System.out.println("Nombre:");
		valores = scan.nextLine();
		cli.setNombre(valores);
		System.out.println("\n");
		}while(valores.matches("[a-zA-Z]*|\\s*"));
		
		do {
		System.out.println("Dni:");
		valores = scan.nextLine();
		cli.setDni(valores);
		System.out.println("\n");
		}while(valores.matches("^[0-9]{8}[a-zA-Z]{1}$"));
		
		System.out.println("Direccion:");
		valores = scan.nextLine();
		cli.setDireccion(valores);
		System.out.println("\n");
		
		
		do {
		System.out.println("Telefono:");
		valores = scan.nextLine();
		cli.setTelefono(valores);
		System.out.println("\n");
		}while(valores.matches("[0-9]*"));
		
		
		do {
		System.out.println("Email:");
		valores = scan.nextLine();		
		cli.setEmail(valores);
		}while(valores.matches("[^A-Za-z0-9.@_-~#]+"));
		
		System.out.println("\n");		

		clCtrl.save(cli);

	}
	
}
