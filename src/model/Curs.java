/*
5)  Fes una classe Curs que tingui un conjunt d'alumnes. 
Aquests alumnes a més del nom i dni guardaran la seva nota final de Curs. 
Fes que aquesta classe curs tingui, a més dels mètodes habituals, 
un mètode mostrar que mostri tots els alumnes ordenats per nota i per nom.
 */
package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author judit
 */
public class Curs {

    private TreeSet<Alumne> alumnes = new TreeSet();

    public Curs() {
    }

    public boolean add(Alumne alu) {
        return alumnes.add(alu);
    }

    public boolean isEmpty() {
        return alumnes.isEmpty();
    }

    public Set<Alumne> getAlumnes() {
        return alumnes;
    }
    
    public boolean existeixAlumne(String codi){
       return alumnes.contains(new Alumne("", codi, 0));
//        return codi.equalsIgnoreCase("1234");
    }
    public void mostrar() {
        for (Alumne alu : alumnes) {
            System.out.println(alu.dades());
        }
    }
}
