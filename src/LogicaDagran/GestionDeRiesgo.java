package LogicaDagran;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestionDeRiesgo {
    private List<Zona> zonas;

    private int cantidadZonas;

    public void setCantidadZonas(int value) {
        this.cantidadZonas = value;
    }

    public GestionDeRiesgo(int cantidadZonas) {
        zonas = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < cantidadZonas; i++) {
            boolean esUrbana= rand.nextBoolean();
            boolean esRural = rand.nextBoolean();
            boolean esCostera = rand.nextBoolean();
            boolean esMontañosa = rand.nextBoolean();
            int nivelMar = rand.nextInt(3000 + 1);
            int area = rand.nextInt(50- 1 +1)+1;
            //int area = rand.nextInt(50);
            int totalHabitantes = rand.nextInt(1_000_001 - 1_000) + 1_000;
            int distanciaRioPrincipal = rand.nextInt(2001);

            Zona zona = new Zona(esRural, esUrbana, esCostera, esMontañosa, nivelMar, area, totalHabitantes, distanciaRioPrincipal);
            zonas.add(zona);
        }
    }

    public void evaluarRiesgo() {
        for (Zona zona : zonas) {
            if (zona.esCostera() && zona.getNivelMar() < 10) {
                zona.setEnRiesgo(true);
                zona.setTipoInundacion("Inundación costera");
            }
            if (zona.esMontañosa() && zona.getDistanciaRioPrincipal() < 50) {
                zona.setEnRiesgo(true);
                zona.setTipoInundacion("Inundación fluvial");
            }
            if (!zona.esRural() && ((zona.getTotalHabitantes() / zona.getArea()) > 100)) {
                zona.setEnRiesgo(true);
                zona.setTipoInundacion("Inundación urbana");
            }
        }
    }

    public double obtenerPorcentajeZonasEnRiesgo() {
        double zonasEnRiesgo=0;
        for (Zona zona : zonas) {
           if (zona.estaEnRiesgo()){
               zonasEnRiesgo++;
            }
        }
        return (zonasEnRiesgo/cantidadZonas)*100;
    }


    public double obtenerPorcentajeZonasRuralesEnRiesgo() {
        double zonasRuralesEnRiesgo = 0;
        for (Zona zona : zonas) {
            if (zona.estaEnRiesgo() && zona.esRural()) {
                zonasRuralesEnRiesgo++;
            }
        }
        return ((zonasRuralesEnRiesgo) / (cantidadZonas) * 100);
    }
    public double obtenerPorcentajeZonasUrbanasEnRiesgo() {
        double zonasUrbanasEnRiesgo = 0;
        for (Zona zona : zonas) {
            if (zona.estaEnRiesgo() && !zona.esRural()) {
                zonasUrbanasEnRiesgo++;
            }
        }
        return (zonasUrbanasEnRiesgo /cantidadZonas)  * 100;
    }

    public double obtenerPorcentajeRiesgosFluviales() {
        double totalRiesgos = 0;
        double riesgosFluviales = 0;

        for (Zona zona : zonas) {
            if (zona.estaEnRiesgo() && zona.getTipoInundacion().equals("Inundación fluvial")) {
                riesgosFluviales++;
                totalRiesgos++;
            } else if (zona.estaEnRiesgo()) {
                totalRiesgos++;
            }
        }

        return  (riesgosFluviales /totalRiesgos)  * 100;
    }

    public double obtenerPorcentajeRiesgosCosteros() {
        double totalRiesgos = 0;
        double riesgosCosteros = 0;

        for (Zona zona : zonas) {
            if (zona.estaEnRiesgo() && zona.getTipoInundacion().equals("Inundación costera")) {
                riesgosCosteros++;
                totalRiesgos++;
            } else if (zona.estaEnRiesgo()) {
                totalRiesgos++;
            }
        }

        return  (riesgosCosteros / totalRiesgos) * 100;
    }

    public double obtenerPorcentajeRiesgosUrbanos() {
        double totalRiesgos = 0;
        double riesgosUrbanos = 0;

        for (Zona zona : zonas) {
            if (zona.estaEnRiesgo() && zona.getTipoInundacion().equals("Inundación urbana")) {
                riesgosUrbanos++;
                totalRiesgos++;
            } else if (zona.estaEnRiesgo()) {
                totalRiesgos++;
            }
        }

        return (riesgosUrbanos / totalRiesgos) * 100;
    }


    public void mostrarInformeRiesgos() {
        for (Zona zona : zonas) {
            System.out.println(zona.toString());
        }
    }

}
