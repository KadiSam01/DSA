/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playingcard;

/**
 *
 * @author theonesammy
 */
public class PlayingCard {
    private String suit;
    private String value;
    
    public PlayingCard(){
        this.suit = "";
        this.value = "";
    }
    public PlayingCard(String suit, String value){
    this.suit = suit;
    this.value = value;
    }
    public void setValue(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
    public void setSuit(String suit){
        this.suit = suit;
    }
    public String getSuit(){
        return suit;
    }
    @Override
    public String toString(){
        return "suit" + " "  + suit + " " + value + " "+ "value";
    }
}
