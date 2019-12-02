package com.mitienda.spring.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.FacturaController;
import com.mitienda.spring.controllers.FacturaLineaController;
import com.mitienda.spring.models.Factura;
import com.mitienda.spring.models.FacturaLinea;

public class MenuFacturaLinea {
	FacturaLineaController flCtrl = FacturaLineaController.getInstance();
	List<FacturaLinea> facturaLineaLista = new ArrayList<>();

	FacturaController fCtrl = FacturaController.getInstance();
	List<Factura> facturasLista = new ArrayList<>();

	Scanner scan = new Scanner(System.in);

	public void initMenuFacturaLinea() {
		int numero;

		System.out.println("\n");
		System.out.println("===FACTURALINEA===\n");

		System.out.println("(1).Crear\n");
		System.out.println("(2).Actualizar\n");
		System.out.println("(4).Borrar\n");
		System.out.println("(5).Listar\n");

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

		facturaLineaLista = flCtrl.list();

		for (int i = 0; i < facturaLineaLista.size(); i++) {

			System.out.println(i + " : " + facturaLineaLista.get(i));

		}
	}

	public void actualizar() {
		listar();
		System.out.println("\nDime el id de la facturaLinea que quieres modificar:");
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		FacturaLinea facL = facturaLineaLista.get(id);

		System.out.println("Dame los datos que quieres cambiar\n");

		System.out.println("Cambiar Nombre? si/no");
		int valor;
		String valores = scan.nextLine();
		if (valores == "si") {
			System.out.println("Nombre:");
			valores = scan.nextLine();
			facL.setNombre(valores);
			System.out.println("\n");
		}

		System.out.println("Cambiar idFactura? si/no");
		valores = scan.nextLine();
		if (valores == "si") {
			listIdFactura();
			System.out.println("idFactura:");
			valor = Integer.parseInt(scan.nextLine());
			facL.setId_factura(facturasLista.get(valor).getId());
			System.out.println("\n");
		}

		System.out.println("Cambiar precio? si/no");
		valores = scan.nextLine();
		if (valores == "si") {
			System.out.println("Precio:");
			valor = Integer.parseInt(scan.nextLine());
			facL.setPrecio(valor);
			System.out.println("\n");
		}

		flCtrl.save(facL);
	}

	public void borrar() {
		listar();
		System.out.println("\nDime el id de la facturaLinea que quieres borrar:");
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		FacturaLinea facL = facturaLineaLista.get(id);
		flCtrl.delete(facL);

	}

	public void crear() {

		FacturaLinea facL = new FacturaLinea();

		System.out.println("Dame los datos de la nueva facturaLinea\n");
		String valores;
		int valor;

		System.out.println("Nombre:");
		valores = scan.nextLine();
		facL.setNombre(valores);
		System.out.println("\n");

		listIdFactura();
		System.out.println("idFactura:");
		valor = Integer.parseInt(scan.nextLine());
		facL.setId_factura(facturasLista.get(valor).getId());
		System.out.println("\n");

		System.out.println("Precio:");
		valor = Integer.parseInt(scan.nextLine());
		facL.setPrecio(valor);
		System.out.println("\n");

		flCtrl.save(facL);

	}

	public void listIdFactura() {

		facturasLista = fCtrl.list();

		for (int i = 0; i < facturasLista.size(); i++) {

			System.out.println(i + " : " + facturasLista.get(i));

		}

	}
}
