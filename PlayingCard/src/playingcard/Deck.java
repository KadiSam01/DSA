/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playingcard;
import java.util.ArrayList;
/**
 *
 * @author theonesammy
 */
public class Deck {
    private ArrayList<PlayingCard> drawdeck;
    private ArrayList<PlayingCard> discardPile;
    
    public Deck(){
        this.drawdeck = new ArrayList<>();
        this.discardPile = new ArrayList<>();
    }
    
    public PlayingCard drawOneCard(){
        if(drawdeck.isEmpty()){
            return null;
        }
        return drawdeck.remove(0);
    }
    
    public ArrayList<PlayingCard> drawXCards(int num){
        ArrayList<PlayingCard> drawnCards = new ArrayList<>();
        for(int i = 0; i<drawnCards.size(); i++){
            drawnCards.add(drawdeck.remove(0));
        }
        return drawnCards;
    }
    
    public void discard(PlayingCard cards){
        if(cards!=null){
            discardPile.add(cards);
        }
    }
    
    public void discard(ArrayList<PlayingCard> cards){
        for(int i = 0; i<cards.size(); i++){
           discardPile.add(cards.get(i));
        }
    }
    
    public void shuffle(){
        int shuffle = 3000;
        for(int i = 0; i<shuffle; i++){
           int first = (int)(Math.random() * drawdeck.size());
           int second = (int)(Math.random() * drawdeck.size());
           swap(first,second);
        }
    }
    
    public void swap(int first, int second){
        
    }
    
    public ArrayList<PlayingCard> getDrawdeck(){
        return drawdeck;
    }
 }
