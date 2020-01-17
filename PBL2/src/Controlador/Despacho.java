/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autor: <Ian Zaque Pereira de Jesus dos Santos>
 * Data:  <12/11/2018>
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package Controlador;

import Util.MyLinkedList;

public class Despacho {
    private MyLinkedList listaDespacho;
    private int idTransporte;
    private double somaFrete, somaValor, somaPeso;
    
    /**
     * Construtor da classe Despacho. Instancia o atributo lista encadeada e um objeto desta classe.
     */
    public Despacho()
    {   listaDespacho = new MyLinkedList();  }

    /**
     * Método que retorna o Id do tipo de transporte.
     * @return retorna o Id do tipo de transporte.
     */
    public int getIdTransporte() 
    {  return idTransporte;  }

    /**
     * Método que retorna a soma dos fretes dos itens da lista de despachados.
     * @return retorna a soma dos fretes dos itens da lista de despachados.
     */
    public double getSomaFrete() 
    { return somaFrete;  }

    /**
     * Método que retorna a soma dos valores dos itens da lista de despachados.
     * @return retorna a soma dos valores dos itens da lista de despachados.
     */
    public double getSomaValor()
    { return somaValor;  }

    /**
     * Método que retorna a soma dos pesos dos itens da lista de despachados.
     * @return retorna a soma dos pesos dos itens da lista de despachados.
     */
    public double getSomaPeso()
    { return somaPeso;  }   
    
    /**
     * Método que soma ao atributo 'somaFrete' o valor passado por parâmetro.
     * @param somaFrete - valor a ser adicionado.
     */
    public void addSomaFrete(double somaFrete) 
    {  this.somaFrete += somaFrete;  }

    /**
     * Método que soma ao atributo 'somaValor' o valor passado por parâmetro.
     * @param somaValor - valor a ser adicionado.
     */
    public void addSomaValor(double somaValor)
    {  this.somaValor += somaValor;  }

    /**
     * Método que soma ao atributo 'somaPeso' o valor passado por parâmetro.
     * @param somaPeso - valor a ser adicionado.
     */
    public void addSomaPeso(double somaPeso)
    {  this.somaPeso += somaPeso;  }
    
    /**
     * Método que atualiza o id do transporte que foi despachado.
     * @param id - novo id do transporte que foi despachado. 
     */
    public void setIdTransporte(int id)
    { this.idTransporte = id;  }

    /**
     * Método que atualiza a lista do transporte que foi despachado.
     * @param despacho - nova lista do transporte que foi despachado. 
     * @see MyLinkedList
     */
    public void setListaDespacho(MyLinkedList despacho) 
    { this.listaDespacho = despacho; }   
    
    /**
     * Método que retorna a lista de itens despachados.
     * @return retorna a lista de itens despachados. 
     */
    public MyLinkedList getListaDespacho()
    { return this.listaDespacho;  }   
}