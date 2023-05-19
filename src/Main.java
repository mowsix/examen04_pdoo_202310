import LogicaDagran.GestionDeRiesgo;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de zonas: ");
        int cantidadZonas = scanner.nextInt(); // Cantidad de zonas a evaluar

        GestionDeRiesgo deRiesgo = new GestionDeRiesgo(cantidadZonas);
        deRiesgo.setCantidadZonas(cantidadZonas);
        deRiesgo.evaluarRiesgo();
        deRiesgo.mostrarInformeRiesgos();


        deRiesgo.evaluarRiesgo();
        double porcentajeZonasEnRiesgo = deRiesgo.obtenerPorcentajeZonasEnRiesgo();
        double porcentajeZonasRuralesEnRiesgo = deRiesgo.obtenerPorcentajeZonasRuralesEnRiesgo();
        double porcentajeZonasUrbanasEnRiesgo = deRiesgo.obtenerPorcentajeZonasUrbanasEnRiesgo();
        double porcentajeRiesgosFluviales = deRiesgo.obtenerPorcentajeRiesgosFluviales();
        double porcentajeRiesgosCosteros = deRiesgo.obtenerPorcentajeRiesgosCosteros();
        double porcentajeRiesgosUrbanos = deRiesgo.obtenerPorcentajeRiesgosUrbanos();

        System.out.println("Porcentaje de zonas en riesgo: " + df.format(porcentajeZonasEnRiesgo) + "%"+"\n");
        System.out.println("Porcentaje de zonas rurales en riesgo: " + df.format(porcentajeZonasRuralesEnRiesgo) + "%");
        System.out.println("Porcentaje de zonas urbanas en riesgo: " + df.format(porcentajeZonasUrbanasEnRiesgo) + "%"+"\n");
        System.out.println("Porcentaje de riesgos fluviales: " + df.format(porcentajeRiesgosFluviales) + "%");
        System.out.println("Porcentaje de riesgos costeros: " + df.format(porcentajeRiesgosCosteros) + "%");
        System.out.println("Porcentaje de riesgos urbanos: " + df.format(porcentajeRiesgosUrbanos) + "%");
    }


}
