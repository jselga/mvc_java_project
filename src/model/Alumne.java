/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author
 */
public class Alumne implements Comparable {

    protected String nom;
    protected String dni;
    protected int notaFinal;

    public Alumne(String nom, String dni, int nota) {
        this.nom = nom;
        this.dni = dni;
        this.notaFinal = nota;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String dades() {
        return "Persona: " + " nom: " + nom + ", dni: " + dni + ", notaFinal: " + notaFinal;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int edad) {
        this.notaFinal = edad;
    }

    @Override
    public int compareTo(Object o) {
            return this.dni.compareTo(((Alumne) o).dni);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Alumne) {
            return this.dni.equals(((Alumne) o).getDni());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }
        
    @Override
    public String toString() {
        return "Alumne{" + "nom=" + nom + ", dni=" + dni + ", notaFinal=" + notaFinal + '}';
    }

}
