package com.mitienda.spring.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.FacturaController;
import com.mitienda.spring.models.Factura;



public class MenuFactura {
	
	FacturaController clCtrl = FacturaController.getInstance();
	List<Factura> facturasLista = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public void initMenuFactura() {
		int numero;

		System.out.println("\n");
		System.out.println("===FACTURAS===\n");

		System.out.println("(1).Crear\n");
		System.out.println("(2).Actualizar\n");
		System.out.println("(4).Borrar\n");
		System.out.println("(5).Listar\n");

		System.out.println("Escoge una opcion: ");

		numero = (int) Integer.parseInt(scan.nextLine());

		switch (numero) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}

	}
}
