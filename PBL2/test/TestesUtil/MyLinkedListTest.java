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
package TestesUtil;

import java.time.LocalDate;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import Model.Barco;
import Model.Carro;
import Model.Joia;
import Model.Moto;
import Model.Quadro;
import org.junit.Before;
import org.junit.Test;
import Util.MyLinkedList;

public class MyLinkedListTest {
    private MyLinkedList listaTeste;
    private Carro car1;
    private Moto moto1;
    private Barco boat1;
    private Quadro quadro1;
    private Joia joia1;
    
    /**
     * Este método é executado antes de cada teste. Inicializa os produtos 
     * que serão usados para serem armazenados na lista.
     */
    @Before
    public void setUp(){
        listaTeste = new MyLinkedList();
        car1 = new Carro (123456789, 1234.00, 13.9, 1.56, 1500.9, LocalDate.of(2018,12,5) ,2009, "sedan", "Ford", "alcool");
        moto1 = new Moto(543216789, 234.00, 3.9, 3.56, 500.9, LocalDate.of(2018,11,4) ,2010, "corrida", "kawazaki", "gasolina", "50-cc");
        boat1 = new Barco(123498765, 223.00, 4.9, 1.56, 850.9, LocalDate.of(2018,10,3), 2007, "mar aberto", "iate", "brabo");
        quadro1 = new Quadro(345623463, 5555.9, 56.0, 4.0, 3.87, LocalDate.of(2018,9,2), 1,  30.0, 30.0, "dataPintura", "Ian Zaque");
        joia1 = new Joia(324565656, 4545.9, 67.9, 45.0, 2.9, LocalDate.of(2018,8,1), 3, "Diamante");
    }    
    
    /**
     * Teste que checa se o método de inserção da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeInsere(){
        listaTeste.add(car1);
        listaTeste.add(joia1);
        listaTeste.add(boat1);
        listaTeste.add(moto1);
        
        assertEquals(car1, listaTeste.get(0).getObj());
        assertEquals(joia1, listaTeste.get(1).getObj());
        assertEquals(boat1, listaTeste.get(2).getObj());
        assertEquals(moto1, listaTeste.get(3).getObj());
    }
    
    /**
     * Teste que checa se o método de remoção da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeRemove(){
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        
        assertEquals(null, listaTeste.get(0));
        assertEquals(null, listaTeste.get(1));
        assertEquals(null, listaTeste.get(2));
        assertEquals(null, listaTeste.get(3));
    }
    
    /**
     *  Teste que checa se o método de inserção e remoção consecutivos 
     * da classe MyLinkedList estão funcionando. 
     */
    @Test
    public void testeInsereRemove(){
        listaTeste.add(car1);
        assertEquals(car1, listaTeste.remove());
        
        listaTeste.add(joia1);
        assertEquals(joia1, listaTeste.remove());
        
        listaTeste.add(moto1);
        assertEquals(moto1, listaTeste.remove());       
    } 
    /**
     * Teste que checa se o método de retornar célula da lista 
     * da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeGet(){
        listaTeste.add(car1);
        listaTeste.add(boat1);
        listaTeste.add(joia1);
        listaTeste.add(moto1);
        
        assertEquals(car1, listaTeste.get(0).getObj());     
        assertEquals(boat1, listaTeste.get(1).getObj());
        assertEquals(joia1, listaTeste.get(2).getObj());
        assertEquals(moto1, listaTeste.get(3).getObj());       
    }
    
    /**
     * Teste que checa se o método de ver se a lista está vazia
     * da classe MyLinkedList está funcionando. 
     */
    @Test
    public void testeVazia(){
        listaTeste.add(car1);
        listaTeste.add(boat1);
        listaTeste.add(joia1);
        listaTeste.add(moto1);
        assertFalse(listaTeste.isEmpty());
        
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        listaTeste.remove();
        assertTrue(listaTeste.isEmpty());
    }    
}