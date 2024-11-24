/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Amigo;
import model.Emprestimo;
import dao.AmigoDAO;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;

public class RelatorioDAO {
    private AmigoDAO amigoDAO;
    private EmprestimoDAO emprestimoDAO;
    private FerramentaDAO ferramentaDAO;
    
    public RelatorioDAO(){
        this.amigoDAO = new AmigoDAO();
        this.ferramentaDAO = new FerramentaDAO();
        this.emprestimoDAO = EmprestimoDAO.getInstance();
    }
    
    public ArrayList<int[]> buscaAmigosMaisEmprestimo(){
        return emprestimoDAO.buscaAmigosMaisEmprestimos();
    }
    
    public ArrayList<Amigo> amigosNuncaDevolveram(){
        ArrayList<Amigo> amigos = new ArrayList<>();
        ArrayList<Integer> idAmigosNaoDevolveram = emprestimoDAO.buscaEmprestimoNãoDevolvidos();
        
        for(int i : idAmigosNaoDevolveram){
            amigos.add(amigoDAO.carregaAmigo(i));
        }
        
        return amigos;
    }
    
    public double custoTotal(){
        return ferramentaDAO.custoTotal();
    }
}
