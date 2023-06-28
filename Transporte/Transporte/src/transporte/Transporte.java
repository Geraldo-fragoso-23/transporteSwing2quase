/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transporte;

/**
 *
 * @author HP
 */
public class Transporte {

      private String origem;
    private String destino;
    private String data;
    private boolean cancelada;

    // Construtor da classe Transporte
    public Transporte(String origem, String destino, String data) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.cancelada = false;
    }

    // Métodos de acesso aos atributos
    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getData() {
        return data;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    // Método para cancelar a viagem
    public void cancelarViagem() {
        cancelada = true;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
    
    

    @Override
    public String toString() {
        return " " + "origem=" + origem + ", destino=" + destino + ", data=" + data + ", cancelada=" + cancelada + '}';
    }

    void setDestino(String novoDestino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
