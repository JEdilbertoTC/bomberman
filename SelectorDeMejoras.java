public class SelectorDeMejoras{
    
    private final Mejora mejoraBomba = new MejoraBomba();
    private final Mejora mejoraCalavera = new MejoraCalavera();
    private final Mejora mejoraVida = new MejoraVida();
    
    public Mejora selector(int mejora){
       switch(mejora){
           case 0: return mejoraBomba;
           case 1: return mejoraCalavera;
           case 2: return mejoraVida;
       }
       return null;
    }
}