package com.mitienda.spring.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.CategoryController;
import com.mitienda.spring.controllers.ProductoController;
import com.mitienda.spring.models.Categoria;
import com.mitienda.spring.models.Producto;

public class MenuProducto {
	ProductoController prodCtrl = ProductoController.getInstance();
	List<Producto> productosLista = new ArrayList<>();
	
	CategoryController ctCtrl = CategoryController.getInstance();
	List<Categoria> categoriasLista = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	public void initMenuProducto() {

		int numero;

		System.out.println("\n");
		System.out.println("===PRODUCTO===\n");

		System.out.println("(1).Crear\n");
		System.out.println("(2).Actualizar\n");
		System.out.println("(3).Borrar\n");
		System.out.println("(4).Listar\n");

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
		}

	}
	
	public void listar() {
		 
		productosLista = prodCtrl.list();

		for (int i = 0; i < productosLista.size(); i++) {

			System.out.println(i + " : " + productosLista.get(i));

		}
	}

	
	public void actualizar() {
		listar();
		System.out.println("\nDime el id del producto que quieres modificar:");		
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		Producto prod =productosLista.get(id);	
		
		System.out.println("Dame los datos que quieres cambiar\n");
		
		System.out.println("Cambiar nombre ? si/no");
		int valor;
		String valores = scan.nextLine();
		if(valores=="si") {
			
			System.out.println("Nombre:");
			valores = scan.nextLine();
			prod.setNombre(valores);
			System.out.println("\n");
			
			
		}
		
		System.out.println("Cambiar precio? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			System.out.println("precio:");
			valor =(int) Integer.parseInt(scan.nextLine());
			prod.setPrecio(valor);
			System.out.println("\n");
		}
		
		System.out.println("Cambiar stock? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			System.out.println("stock:");
			valor =(int) Integer.parseInt(scan.nextLine());
			prod.setStock(valor);
			System.out.println("\n");
		}
		
		System.out.println("Cambiar categoria? si/no");
		valores = scan.nextLine();		
		if(valores=="si") {
				listIdCategoria();
				System.out.println("Categoria:");
				valor =(int) Integer.parseInt(scan.nextLine());				
				prod.setId_categoria(categoriasLista.get(valor).getId());

		}
				
		prodCtrl.save(prod);
	}

	
	public void borrar() {
		listar();		
		System.out.println("\nDime el id del producto que quieres borrar:");
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		Producto cli =productosLista.get(id);
		prodCtrl.delete(cli);

	}

	
	public void crear() {

		Producto prod = new Producto();
		String valores;
		int valor;
		
		System.out.println("Dame los datos del producto \n");
		
		
		System.out.println("Nombre:");
		valores = scan.nextLine();
		prod.setNombre(valores);
		System.out.println("\n");				
		
		System.out.println("precio:");
		valor =(int) Integer.parseInt(scan.nextLine());
		prod.setPrecio(valor);
		System.out.println("\n");			
		
		System.out.println("stock:");
		valor =(int) Integer.parseInt(scan.nextLine());
		prod.setStock(valor);
		System.out.println("\n");	
		
		listIdCategoria();
		System.out.println("Categoria:");
		valor =(int) Integer.parseInt(scan.nextLine());				
		prod.setId_categoria(categoriasLista.get(valor).getId());	
		
		System.out.println("\n");
		
		prodCtrl.save(prod);

	}
	
	public void listIdCategoria() {
		categoriasLista = ctCtrl.list();

		for (int i = 0; i < categoriasLista.size(); i++) {

			System.out.println(i + " : " + categoriasLista.get(i));

		}
	}
}
