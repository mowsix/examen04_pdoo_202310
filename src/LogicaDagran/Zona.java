package LogicaDagran;

public class Zona {
    private boolean esRural;
    private boolean esUrbana;
    private boolean esCostera;
    private boolean esMontañosa;
    private int nivelMar;
    private int area;
    private int totalHabitantes;
    private int distanciaRioPrincipal;
    private boolean enRiesgo;
    private String tipoInundacion;

    public Zona(boolean esRural,boolean esUrbana, boolean esCostera, boolean esMontañosa, int nivelMar, int area, int totalHabitantes, int distanciaRioPrincipal) {
        this.esUrbana=esUrbana;
        this.esRural = esRural;
        this.esCostera = esCostera;
        this.esMontañosa = esMontañosa;
        this.nivelMar = nivelMar;
        this.area = area;
        this.totalHabitantes = totalHabitantes;
        this.distanciaRioPrincipal = distanciaRioPrincipal;
        this.enRiesgo = false;
        this.tipoInundacion = "Ninguna";
    }

    public boolean esUrbana(){
        return esUrbana;
    }

    public boolean esRural() {
        return esRural;
    }

    public boolean esCostera() {
        return esCostera;
    }

    public boolean esMontañosa() {
        return esMontañosa;
    }

    public int getNivelMar() {
        return nivelMar;
    }

    public double getArea() {
        return area;
    }

    public int getTotalHabitantes() {
        return totalHabitantes;
    }

    public int getDistanciaRioPrincipal() {
        return distanciaRioPrincipal;
    }

    public boolean estaEnRiesgo() {
        return enRiesgo;
    }

    public String getTipoInundacion() {
        return tipoInundacion;
    }

    public void setEnRiesgo(boolean enRiesgo) {
        this.enRiesgo = enRiesgo;
    }

    public void setTipoInundacion(String tipoInundacion) {
        this.tipoInundacion = tipoInundacion;
    }

    public String toString() {
        String informe = "Tipo: " + (esRural ? "Rural " : "Urbana ") + (esCostera? "Costera " : "Montañosa ")+"\n";
        informe += "Área: " + area + " km2\n";
        informe += "Densidad Poblacional: " + (totalHabitantes / area) + " hab/km2\n";
        informe += "Nivel del Mar: " + (nivelMar) + " mts\n";
        informe += "Distancia a Rio principal: " + (distanciaRioPrincipal) + " mts\n";
        informe += "En riesgo: " + (enRiesgo ? "Sí" : "No") + "\n";
        informe += "Tipo de inundación: " + tipoInundacion + "\n";
        return informe;
    }
}
