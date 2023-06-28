/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporte;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author HP
 */
// Classe principal que representa a interface gráfica do programa
public class TransporteTerrestre extends JFrame {
    private ArrayList<Transporte> viagens;
    private ArrayList<TransporteLocal>viagensLocal;
    private ArrayList<TransporteInterProvicial>viagensPc;
    private int viagensRealizadas;
    private int viagensCanceladas;

    private JLabel lblViagensRealizadas;
    private JLabel lblViagensCanceladas;
    private JTextArea txtAreaViagens;

    // Construtor da classe TransporteTerrestreGUI
    public TransporteTerrestre() {
        // Inicialização das variáveis
        viagens = new ArrayList<>();
        viagensLocal = new ArrayList<>();
        viagensPc= new ArrayList<>();
        viagensRealizadas = 0;
        viagensCanceladas = 0;

        // Configuração da janela principal
        setTitle("Transporte Terrestre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Criação e configuração do painel do cabeçalho
        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblTitulo = new JLabel("Transporte Terrestre");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        pnlHeader.add(lblTitulo);

        // Criação e configuração do painel de estatísticas
        JPanel pnlStats = new JPanel();
        pnlStats.setLayout(new GridLayout(2, 2));

        JLabel lblViagensRealizadasDesc = new JLabel("Viagens Realizadas:");
        lblViagensRealizadas = new JLabel("0");
        JLabel lblViagensCanceladasDesc = new JLabel("Viagens Canceladas:");
        lblViagensCanceladas = new JLabel("0");

        pnlStats.add(lblViagensRealizadasDesc);
        pnlStats.add(lblViagensRealizadas);
        pnlStats.add(lblViagensCanceladasDesc);
        pnlStats.add(lblViagensCanceladas);

        // Criação e configuração do painel de botões
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(1, 5));

        JButton btnRegistrarViagem = new JButton("Registrar Viagem");
        JButton btnConsultarViagem = new JButton("Consultar Viagem");
        JButton btnAtualizarViagem = new JButton("Atualizar Viagem");
        JButton btnVerListaViagem = new JButton("Ver Lista Viagem");
        JButton btnCancelarViagem = new JButton("Cancelar Viagem");
        JButton btnExibir = new JButton("Exibir estatisticas");

        // Configuração dos ouvintes de evento para os botões
        btnRegistrarViagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarViagem();
            }
        });

        btnConsultarViagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarViagem();
            }
        });

        btnAtualizarViagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarViagem();
            }
        });

        btnVerListaViagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verListaViagem();
            }
        });

        btnCancelarViagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarViagem();
            }
        });
         btnExibir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarEstatisticas();
            }
        });

        pnlButtons.add(btnRegistrarViagem);
        pnlButtons.add(btnConsultarViagem);
        pnlButtons.add(btnAtualizarViagem);
        pnlButtons.add(btnVerListaViagem);
        pnlButtons.add(btnCancelarViagem);
        pnlButtons.add(btnExibir);

        // Criação e configuração da área de texto para exibir as viagens
        txtAreaViagens = new JTextArea();
        txtAreaViagens.setEditable(false);

        // Adiciona os componentes à janela principal
        add(pnlHeader, BorderLayout.NORTH);
        add(pnlStats, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
        add(new JScrollPane(txtAreaViagens), BorderLayout.CENTER);

        // Torna a janela principal visível
        setVisible(true);
    }

    // Método para registrar uma viagem
    private void registrarViagem() {
        // Solicita ao usuário as informações da viagem
  

        // Apresenta ao usuário as opções de tipo de transporte
        String[] opcoes = { "Transporte Local", "Transporte Interprovincial" };
        int escolha = JOptionPane.showOptionDialog(null, "Tipo de Transporte:", "Escolha", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        // Cria uma nova viagem com base na escolha do usuário e adiciona à lista de viagens
        if (escolha == 0) {
            String cidade = JOptionPane.showInputDialog("Cidade:");
        String origem = JOptionPane.showInputDialog("Origem:");
        String destino = JOptionPane.showInputDialog("Destino:");
        String data = JOptionPane.showInputDialog("Data:");

            
            TransporteLocal transporteLocal = new TransporteLocal(origem, destino, data, cidade);
            
            
            viagensLocal.add(transporteLocal);
        } else if (escolha == 1) {
            String provincia = JOptionPane.showInputDialog(" ");
                String origem = JOptionPane.showInputDialog("Provincia Origem:");
        String destino = JOptionPane.showInputDialog("Provincia de Destino:");
        String data = JOptionPane.showInputDialog("Data:");

            TransporteInterProvicial transporteInterProvincial = new TransporteInterProvicial(origem, destino, data);
            viagensPc.add(transporteInterProvincial);
        }

        // Atualiza as estatísticas e exibe uma mensagem de sucesso
        viagensRealizadas++;
        atualizarEstatisticas();
        exibirMensagem("Viagem registrada com sucesso.");
    }

    // Método para consultar uma viagem
    private void consultarViagem() {
        // Solicita ao usuário as informações da viagem a ser consultada
          String[] opcoes = { "Transporte Local", "Transporte Interprovincial" };
        int escolha = JOptionPane.showOptionDialog(null, "Tipo de Transporte:", "Escolha", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        // Cria uma nova viagem com base na escolha do usuário e adiciona à lista de viagens
        if (escolha == 0) {
          String cidade = JOptionPane.showInputDialog("Cidade:");
        String origem = JOptionPane.showInputDialog("Origem:");
        String destino = JOptionPane.showInputDialog("Destino:");
        String data = JOptionPane.showInputDialog("Data:");

            
          
        // Procura a viagem na lista de viagens e exibe suas informações
        for (TransporteLocal viagem : viagensLocal) {
            if (viagem.getOrigem().equals(origem) && viagem.getDestino().equals(destino)
                    && viagem.getData().equals(data)) {
                exibirMensagem("Viagem encontrada:\n" + viagem.toString());
                return;
            }
        }
 }
        else if (escolha == 1) {
        String provincia = JOptionPane.showInputDialog(" ");
        String origem = JOptionPane.showInputDialog("Provincia Origem:");
        String destino = JOptionPane.showInputDialog("Provincia de Destino:");
        String data = JOptionPane.showInputDialog("Data:");
        
        for (TransporteInterProvicial viagem : viagensPc) {
            if (viagem.getOrigem().equals(origem) && viagem.getDestino().equals(destino)
                    && viagem.getData().equals(data)) {
                exibirMensagem("Viagem encontrada:\n" + viagem.toString());
                return;
            }
        }
        }
        // Caso a viagem não seja encontrada, exibe uma mensagem de erro
        exibirMensagem("Viagem não encontrada.");
    }

    // Método para atualizar uma viagem
    private void atualizarViagem() {
        
        // Solicita ao usuário as informações da viagem a ser atualizada
       String[] opcoes = { "Transporte Local", "Transporte Interprovincial" };
        int escolha = JOptionPane.showOptionDialog(null, "Tipo de Transporte:", "Escolha", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        // Cria uma nova viagem com base na escolha do usuário e adiciona à lista de viagens
        if (escolha == 0) {
          String cidade = JOptionPane.showInputDialog("Cidade:");
        String origem = JOptionPane.showInputDialog("Origem:");
        String destino = JOptionPane.showInputDialog("Destino:");
        String data = JOptionPane.showInputDialog("Data:");
        // Procura a viagem na lista de viagens e atualiza o destino se encontrada
        for (TransporteLocal viagem : viagensLocal) {
            if (viagem.getOrigem().equals(origem) && viagem.getDestino().equals(destino)
                    && viagem.getData().equals(data)) {
        String cidade1 = JOptionPane.showInputDialog("Cidade:");
        String origem1 = JOptionPane.showInputDialog("Origem:");
        String destino1 = JOptionPane.showInputDialog("Destino:");
        String data1 = JOptionPane.showInputDialog("Data:");
                viagem.setOrigem(origem1);
                viagem.setData(data1);
                viagem.setDestino(destino1);
               viagem.setCidade(cidade1);
                exibirMensagem("Viagem atualizada com sucesso.");
                return;
            } exibirMensagem("Viagem atualizada com sucesso.");
        } 
          } else if (escolha == 1) {
        String origem = JOptionPane.showInputDialog("Provincia Origem:");
        String destino = JOptionPane.showInputDialog("Provincia de Destino:");
        String data = JOptionPane.showInputDialog("Data:");
        
        for (TransporteInterProvicial viagem : viagensPc) {
            if (viagem.getOrigem().equals(origem) && viagem.getDestino().equals(destino)
                    && viagem.getData().equals(data)) {
        String origem1 = JOptionPane.showInputDialog("Origem:");
        String destino1 = JOptionPane.showInputDialog("Destino:");
        String data1 = JOptionPane.showInputDialog("Data:");
                 viagem.setOrigem(origem1);
                viagem.setData(data1);
                viagem.setDestino(destino1);
                exibirMensagem("Viagem atualizada com sucesso.");
                return;
            }
        }
}
        // Caso a viagem não seja encontrada, exibe uma mensagem de erro
        exibirMensagem("Viagem não encontrada.");
    }

    // Método para exibir a lista de viagens
    private void verListaViagem() {
        String[] opcoes = { "Transporte Local", "Transporte Interprovincial" };
        int escolha = JOptionPane.showOptionDialog(null, "Tipo de Transporte:", "Escolha", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        // Cria uma nova viagem com base na escolha do usuário e adiciona à lista de viagens
        if (escolha == 0) {
        // Limpa a área de texto
        txtAreaViagens.setText("");

        // Percorre a lista de viagens e exibe cada uma delas
        for (TransporteLocal viagem : viagensLocal) {
            txtAreaViagens.append(viagem.toString() + "\n");
            
        }
         }
        else if(escolha==1){
               for (TransporteInterProvicial viagem : viagensPc) {
            txtAreaViagens.append(viagem.toString() + "\n");
          
        }
        }
    }

    // Método para cancelar uma viagem
    private void cancelarViagem() {
        // Solicita ao usuário as informações da viagem a ser cancelada
        
        String[] opcoes = { "Transporte Local", "Transporte Interprovincial" };
        int escolha = JOptionPane.showOptionDialog(null, "Tipo de Transporte:", "Escolha", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        // Cria uma nova viagem com base na escolha do usuário e adiciona à lista de viagens
        if (escolha == 0) {
          String cidade = JOptionPane.showInputDialog("Cidade:");
        String origem = JOptionPane.showInputDialog("Origem:");
        String destino = JOptionPane.showInputDialog("Destino:");
        String data = JOptionPane.showInputDialog("Data:");


        // Procura a viagem na lista de viagens e cancela se encontrada
        for (TransporteLocal viagem : viagensLocal) {
            if (viagem.getOrigem().equals(origem) && viagem.getDestino().equals(destino)
                    && viagem.getData().equals(data)) {
                viagem.cancelarViagem();
                viagensCanceladas++;
                atualizarEstatisticas();
                exibirMensagem("Viagem cancelada com sucesso.");
                return;
            }
        }
         }
        else if(escolha==1){
        String origem = JOptionPane.showInputDialog("Provincia de Origem:");
        String destino = JOptionPane.showInputDialog("Provincia de Destino:");
        String data = JOptionPane.showInputDialog("Data:");


        // Procura a viagem na lista de viagens e cancela se encontrada
        for (TransporteInterProvicial viagem : viagensPc) {
            if (viagem.getOrigem().equals(origem) && viagem.getDestino().equals(destino)
                    && viagem.getData().equals(data)) {
                viagem.cancelarViagem();
                viagensCanceladas++;
                atualizarEstatisticas();
                exibirMensagem("Viagem cancelada com sucesso.");
                return;
            }
                }
         }

        
        // Caso a viagem não seja encontrada, exibe uma mensagem de erro
        exibirMensagem("Viagem não encontrada.");
    }
     

    // Método para atualizar as estatísticas exibidas na interface
    private void atualizarEstatisticas() {
        lblViagensRealizadas.setText(String.valueOf(viagensRealizadas));
        lblViagensCanceladas.setText(String.valueOf(viagensCanceladas));
    }

    // Método para exibir uma mensagem em uma janela de diálogo
    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    // Método principal que inicia o programa
    public static void main(String[] args) {
        // Cria uma instância da classe TransporteTerrestreGUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TransporteTerrestre();
            }
        });
    }
}

