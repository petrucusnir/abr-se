/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abr.se;

/**
 *
 * @author petrucusnir
 */
import java.util.List;

public class ABR {
    
    Node root;
    
    //construit un arbre vide
    ABR(){
        this.root = null;
    }
    
    public class Node{
        Node child_left_, child_right_;
        int valeur;
        
        //construit un noeud sans fils
        Node(int valeur){
            this.valeur = valeur;
            this.child_left_ = null;
            this.child_right_ = null;
        }
        
        public void build(int value){
            if(value > this.valeur){
                if(this.child_right_ == null){
                    this.child_right_ = new Node(value);
                }else{
                    this.child_right_.build(value);
                }
            }else{
                if(this.child_left_ == null){
                    this.child_left_ = new Node(value);
                }else{
                    this.child_left_.build(value);
                }                
            }
        }
        
        public int compteur(){
            int resultat = 0;
            if(this.child_left_ != null){
                resultat += this.child_left_.compteur();
            }else{
                resultat++;
            }
            if(this.child_right_!= null){
                resultat += this.child_right_.compteur();
            }else{
                resultat++;
            }
            return resultat;
        }
        
        public boolean verif(int value){
            boolean resultat = false;
            if(this.child_left_ != null){
                if(this.child_left_.valeur == value){
                    resultat |= this.child_left_.verif(value);
                }    
            }
            if(this.child_right_!= null){
                if(this.child_right_.valeur == value){
                    resultat |= this.child_right_.verif(value);
                }
            }
            return resultat;
        }
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    
    public void insert(int value){
        if(this.isEmpty()){
            this.root = new Node(value);
        }else{
            this.root.build(value);
        }
    }
    
    public int nbElement(){
        if(this.isEmpty()){
            return 0;
        }else{
            return this.root.compteur() - 1;
        }
    }
    
    public boolean contains(int value){
        if(this.isEmpty()){
            return false;
        }else{
            return this.root.verif(value);
        }
    }
    
    public void toList(java.util.List<java.lang.Integer> l){
        l.clear();
        for(int i = 0; i < this.nbElement(); i++){
            if(this.contains(i)){
                l.add(i);
            }
        }
    }
}
