/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleemprestimo.model;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Emprestimo {
    
    private ArrayList<Ferramenta> ferramentas = new ArrayList<>();
   private int id;
   private int idamigo;

    public Emprestimo(int id, int idamigo) {
        this.id = id;
        this.idamigo = idamigo;
    }

    public ArrayList<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(ArrayList<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdamigo() {
        return idamigo;
    }

    public void setIdamigo(int idamigo) {
        this.idamigo = idamigo;
    }
   
   
    
            
    
    
}
