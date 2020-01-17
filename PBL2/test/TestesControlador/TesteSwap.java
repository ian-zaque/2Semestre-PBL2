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
package TestesControlador;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import Util.MyLinkedList;
import Util.Swap;


public class TesteSwap {
    private MyLinkedList lista;
    private Swap swap;

    /**
     * Este método é executado antes de cada teste. Inicializa um objeto
     * da classe Armazem e outro da classe Swap.
     */
    @Before
    @SuppressWarnings("empty-statement")
    public void setUp()
    {   lista = new MyLinkedList();
        swap = new Swap(lista);
    }
    
    /**
     * Teste que checa se o método de troca está funcionando.
     */
    @Test
    public void TesteBasicoSwap()
    {   lista.add(0);
        lista.add(1);
        
        assertEquals(0, lista.get(0).getObj());
        assertEquals(1, lista.get(1).getObj());
        
        swap.swap(0, 1);
        
        assertEquals(1, lista.get(0).getObj());
        assertEquals(0, lista.get(1).getObj());
    } 
}