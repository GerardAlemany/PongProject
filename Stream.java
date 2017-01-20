/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comms;

/**
 *
 * @author alejandro
 * @param <T>
 */
public interface Stream{
    
    public void send (int t);
    public void receive ();
    
}
