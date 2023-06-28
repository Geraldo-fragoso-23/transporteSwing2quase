/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporte;

/**
 *
 * @author HP
 */
public class TransporteInterProvicial extends Transporte {

  

    // Construtor da classe TransporteInterProvincial

    public TransporteInterProvicial(String origem, String destino, String data) {
        super(origem, destino, data);
    }

    

    @Override
    public String toString() {
        return "TransporteInterProvicial{"+super.toString() + '}';
    }
    
    
    
}
