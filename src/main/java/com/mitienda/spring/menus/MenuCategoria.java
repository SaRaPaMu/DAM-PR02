package com.mitienda.spring.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.CategoryController;
import com.mitienda.spring.models.Categoria;

public class MenuCategoria {

	CategoryController ctCtrl = CategoryController.getInstance();
	List<Categoria> categoriasLista = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public void initMenuCategoria() {

		Scanner scan = new Scanner(System.in);
		int numero;

		System.out.println("\n");
		System.out.println("===CATEGORIA===\n");

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
		 
		categoriasLista = ctCtrl.list();

		for (int i = 0; i < categoriasLista.size(); i++) {

			System.out.println(i + " : " + categoriasLista.get(i));

		}
	}

	
	public void actualizar() {
		listar();
		System.out.println("\nDime el id de la categoria que quieres modificar:");		
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		Categoria cat = categoriasLista.get(id);		

		System.out.println("\nNuevo nombre:");
		String nombre = scan.nextLine();		
		cat.setNombre(nombre); 
		ctCtrl.save(cat);		

	}

	
	public void borrar() {
		listar();
		
		System.out.println("\nDime el id de la categoria que quieres borrar:");
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		
		long catID =  categoriasLista.get(id).getId();

		Categoria cat =ctCtrl.findById(catID);
		ctCtrl.delete(cat);

	}

	
	public void crear() {

		System.out.println("\nDime el nombre del la nueva categoria:");		

		String nombre = scan.nextLine();
		Categoria cat = new Categoria();
		cat.setNombre(nombre);
		ctCtrl.save(cat);

	}
}
