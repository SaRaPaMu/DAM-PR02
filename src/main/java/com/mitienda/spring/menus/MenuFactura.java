package com.mitienda.spring.menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.FacturaController;
import com.mitienda.spring.models.Factura;



public class MenuFactura {
	
	FacturaController fCtrl = FacturaController.getInstance();
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
		 
		facturasLista = fCtrl.list();

		for (int i = 0; i < facturasLista.size(); i++) {

			System.out.println(i + " : " + facturasLista.get(i));

		}
	}

	
	public void actualizar() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		listar();
		System.out.println("\nDime el id de la factura que quieres modificar:");		
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		Factura fac =facturasLista.get(id);
		 
		System.out.println("Dame los datos que quieres cambiar\n");
		
		System.out.println("Cambiar Fecha ? si/no");
		int valor;
		String valores = scan.nextLine();
		if(valores=="si") {
			boolean correcto=true;
			do {
			System.out.println("fecha(aaaa/MM/dd):");
			valores = scan.nextLine();
			try {
				fac.setFecha(sdf.parse(valores));
			} catch (ParseException e) {
				correcto=false;
				System.out.println("fecha invalida");
			}
			}while(correcto);
			System.out.println("\n");			
		}
		
		System.out.println("Cambiar idCliente? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			System.out.println("idCliente:");
			valor = Integer.parseInt(scan.nextLine());
			fac.setId_cliente(valor);
			System.out.println("\n");			
		}
		
		System.out.println("Cambiar serie? si/no");
		valores = scan.nextLine();
		if(valores=="si") {
			System.out.println("Serie:");
			valor = Integer.parseInt(scan.nextLine());
			fac.setSerie(valor);
			System.out.println("\n");
		}
				
		fCtrl.save(fac);
	}

	
	public void borrar() {
		listar();		
		System.out.println("\nDime el id de la factura que quieres borrar:");
		String leeido;
		leeido = scan.nextLine();
		int id = Integer.parseInt(leeido);
		Factura fac =facturasLista.get(id);
		fCtrl.delete(fac);

	}

	
	public void crear() {

		Factura fac = new Factura();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		 
		System.out.println("Dame los datos de la nueva factura\n");
		String valores;
		int valor;
			boolean correcto=true;
			do {
			System.out.println("fecha(aaaa/MM/dd):");
			valores = scan.nextLine();
			try {
				fac.setFecha(sdf.parse(valores));
			} catch (ParseException e) {
				correcto=false;
				System.out.println("fecha invalida");
			}
			}while(correcto);
			System.out.println("\n");		
		
			System.out.println("idCliente:");
			valor = Integer.parseInt(scan.nextLine());
			fac.setId_cliente(valor);
			System.out.println("\n");			
		
			System.out.println("Serie:");
			valor = Integer.parseInt(scan.nextLine());
			fac.setSerie(valor);
			System.out.println("\n");
		
				
		fCtrl.save(fac);

	}
	
}
