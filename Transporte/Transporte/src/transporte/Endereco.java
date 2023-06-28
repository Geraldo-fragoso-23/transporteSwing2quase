/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporte;

/**
 *
 * @author HP
 */
public class Endereco {
    private String rua;
    private String cidade;
    private String Provincia;

    public Endereco(String rua, String cidade, String Provincia) {
        this.rua = rua;
        this.cidade = cidade;
        this.Provincia = Provincia;
        
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setEstado(String Provincia) {
        this.Provincia = Provincia;
    }

 
    
    
    
    
}
