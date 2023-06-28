/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporte;

/**
 *
 * @author HP
 */
public class TransporteLocal extends Transporte {
    private String cidade;

    // Construtor da classe TransporteLocal
    public TransporteLocal(String origem, String destino, String data, String cidade) {
        super(origem, destino, data);
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "TransporteLocal{"+ super.toString()+ " cidade=" + cidade + '}';
    }

   
    }

  
    


