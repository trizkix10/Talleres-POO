package Taller11;

import java.io.*;
import java.util.*;

public class App {
	
	//primera lectura
	private static ArrayList<String> ExperimentoID = new ArrayList<>();
	private static ArrayList<String> ExperimentoDescripcion = new ArrayList<>();	
	
	//segunda lectura

	private static ArrayList<String> metricaslista = new ArrayList<>();
	//tercera lectura

	private static ArrayList<String> predExpID = new ArrayList<>();
	private static ArrayList<Integer> predValorReal = new ArrayList<>();
	private static ArrayList<Integer> predValorPredicho = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		leerarchivo();
		menu();		
		
	}
	private static void menu() {

		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("---- Menú Principal ----");
			System.out.println("1. Usuario");
			System.out.println("2. Administrador");
			System.out.println("0. Salir");
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();

			switch(opcion) {
				case 1:
		        	menuUsuario(sc);
		        	break;
		        case 2:
		            menuAdminn(sc);
		            break;
		        case 0:
		            System.out.println("Saliendo...");
		            break;
		        default:
		            System.out.println("Opción inválida.");
		    }
		} while(opcion != 0);
		
		
		
	}
	private static void menuAdminn(Scanner sc) {

	}
	private static void menuUsuario(Scanner sc) {
	    int opcion;
	    do {
	        System.out.println("---- Menú Usuario ----");
	        System.out.println("1. Listar experimentos");
	        System.out.println("2. Mostrar matriz de confusión de un experimento");
	        System.out.println("3. Mostrar métricas de un experimento");
	        System.out.println("4. Promedio de Accuracy de todos los modelos");
	        System.out.println("0. Volver al menú principal");
	        System.out.print("Elige una opción: ");
	        opcion = sc.nextInt();

	        switch(opcion) {
	            case 1:
	                listarExperimentos();
	                break;
	            case 2:
	                mostrarMatrizConfusion(sc);
	                break;
	            case 3:
	                mostrarMetricas(sc);
	                break;
	            case 4:
	                promedioAccuracy();
	                break;
	            case 0:
	                break;
	            default:
	                System.out.println("Opción inválida.");
	        }
	    } while(opcion != 0);
	}

	private static void promedioAccuracy() {
		// TODO Auto-generated method stub
		
	}
	private static void mostrarMetricas(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void mostrarMatrizConfusion(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void listarExperimentos() {

		for(int i = 0 ; i < ExperimentoID .size() ; i++) {
			
			System.out.println("El Experimento " + ExperimentoID.get(i) + " y su descripcion: " +  ExperimentoDescripcion.get(i));
			
			
		}
		
		System.out.println();
		
	}
	private static void leerarchivo() throws FileNotFoundException {

		Scanner s = new Scanner(new File("experimentos.txt"));
		
		
		while(s.hasNextLine()) {
			
			String l = s.nextLine();
			String [] p = l.split(";"); 
			String Id = p[0];
			String Descripcion = p[1];
			
			ExperimentoID.add(Id);
			ExperimentoDescripcion .add(Descripcion);
			System.out.println("Hola diego");
			
			
		}
		
		s.close();
		
		s = new Scanner(new File("metricas.txt"));
		
		
		while(s.hasNextLine()) {
			
			String l = s.nextLine().trim();
			
			if(!l.isEmpty()) {
				metricaslista.add(l);
				
			}

		}
		
		s.close();
		
		s = new Scanner(new File("predicciones.txt"));
	
		while(s.hasNextLine()) {
			
			String l = s.nextLine().trim();
			
			String [] p = l.split(";");
			String IdExperimento = p[0];
			int Valor1 = Integer.parseInt(p[1]);
			int Valor2 = Integer.parseInt(p[2]);
			
		    predExpID.add(IdExperimento);
		    predValorReal.add(Valor1);
		    predValorPredicho.add(Valor2);
			
		}
	}
		
}
