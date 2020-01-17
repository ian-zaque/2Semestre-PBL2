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
package Util;

public class Swap {
    private MyLinkedList lista;
    
    /**
     * Construtor da classe 'Swap'. Inicializa o atributo único da classe sendo 
     * agora a lista passada por parâmetro.    
     * @param lista - lista encadeada que será usada como lista para troca 
     * dos objetos de posição no método 'swap'
     * @see MyLinkedList
     */
    public Swap(MyLinkedList lista)
    {  this.lista = lista;  }

    /**
     * Método que realiza a troca dos objetos de posição de uma lista encadeada
     * passada por parâmetro no construtor.
     * @param prim - índice do primeiro objeto a ser trocado
     * @param segun - índice do segundo objeto a ser trocado 
     */
    public void swap(int prim, int segun)
    {   Object obj1 = lista.get(segun).getObj();
        Object obj2 = lista.get(prim).getObj();
        lista.get(segun).setObj(obj2);
        lista.get(prim).setObj(obj1);
    }
}