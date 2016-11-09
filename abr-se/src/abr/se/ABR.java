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
}
