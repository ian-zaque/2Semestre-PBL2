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
import Model.Barco;
import Model.Carro;
import Model.Joia;
import Model.Moto;
import Model.Quadro;
import org.junit.Before;
import org.junit.Test;
import Util.Armazem;
import Util.MyLinkedList;
import static junit.framework.Assert.assertTrue;

public class ArmazemTeste {
    private Armazem armazemTeste;
    private Carro car1; Moto moto1; Barco boat1; Quadro quadro1; Joia joia1;
        
    /**
     * Este método é executado antes de cada teste. Inicializa os produtos 
     * que serão usados para serem armazenados na lista. Inicializa um objeto
     * da classe Armazem.
     */
    @Before
    public void setUp(){
        armazemTeste = new Armazem();
        car1 = new Carro (123456789, 40.00, 40.0, 40.0, 40.0, LocalDate.of(2018,12,5), 2009, "sedan", "Ford", "alcool");
        moto1 = new Moto(543216789, 30.0, 30.0, 30.0, 30.0, LocalDate.of(2018,11,4) , 2010, "corrida", "kawazaki", "gasolina", "50-cc");
        boat1 = new Barco(123498765, 50.0, 50.0, 50.0, 50.0, LocalDate.of(2018,10,3), 2007, "mar aberto", "iate", "brabo");
        quadro1 = new Quadro(345623463, 20.0, 20.0, 20.0, 20.0, LocalDate.of(2018,9,2), 1, 30.0, 30.0, "dataPintura", "Ian Zaque");
        joia1 = new Joia(324565656, 10.0, 10.0, 10.0, 10.0, LocalDate.of(2018,8,1), 3, "Diamante");
    }    
    
    /**
     * Teste que checa se o método de cadastrar item da classe Armazem está funcionando. 
     */
    @Test
    public void testeCadastraProduto()
    {   armazemTeste.cadastraProduto(car1);
        armazemTeste.cadastraProduto(joia1);
        armazemTeste.cadastraProduto(quadro1);
        armazemTeste.cadastraProduto(boat1);
        armazemTeste.cadastraProduto(moto1);
    
        assertEquals(car1, armazemTeste.getInventario().get(0).getObj());
        assertEquals(joia1, armazemTeste.getInventario().get(1).getObj());
        assertEquals(quadro1, armazemTeste.getInventario().get(2).getObj());
        assertEquals(boat1, armazemTeste.getInventario().get(3).getObj());
        assertEquals(moto1, armazemTeste.getInventario().get(4).getObj());        
    }
    
    /**
     * Teste que checa se o método de remover item da classe Armazem está funcionando. 
     */
    @Test
    public void testeRemoveProduto()
    {   armazemTeste.cadastraProduto(car1);
        armazemTeste.cadastraProduto(joia1);
        armazemTeste.cadastraProduto(quadro1);
        armazemTeste.cadastraProduto(boat1);
        armazemTeste.cadastraProduto(moto1);
        
        assertEquals(moto1, armazemTeste.removeProduto());
        assertEquals(boat1, armazemTeste.removeProduto());
        assertEquals(quadro1, armazemTeste.removeProduto());
        assertEquals(joia1, armazemTeste.removeProduto());
        assertEquals(car1, armazemTeste.removeProduto());
    }
    
    /**
     * Teste que checa se o método de pegar item da classe Armazem está funcionando. 
     */
    @Test
    public void testeGetProduto()
    {   armazemTeste.cadastraProduto(joia1);
        armazemTeste.cadastraProduto(car1);
        armazemTeste.cadastraProduto(moto1);
        armazemTeste.cadastraProduto(boat1);
        armazemTeste.cadastraProduto(quadro1);
        
        assertEquals(quadro1, armazemTeste.getProduto(4));
        assertEquals(boat1, armazemTeste.getProduto(3));
        assertEquals(moto1, armazemTeste.getProduto(2));
        assertEquals(car1, armazemTeste.getProduto(1));
        assertEquals(joia1, armazemTeste.getProduto(0));  
    }   
    
    /**
     * Teste que checa se o método de fazer o relatório de tributação 
     * da classe Armazem está funcionando. 
     */
    @Test
    public void testeRelatorioTributacao()
    {   armazemTeste.cadastraProduto(joia1);
        armazemTeste.cadastraProduto(car1);
        armazemTeste.cadastraProduto(moto1);
        armazemTeste.cadastraProduto(boat1);
        armazemTeste.cadastraProduto(quadro1);        
              
        assertEquals(5, armazemTeste.getInventario().size());
        assertEquals(quadro1, armazemTeste.getProduto(4));
        assertEquals(boat1, armazemTeste.getProduto(3));
        assertEquals(moto1, armazemTeste.getProduto(2));
        assertEquals(car1, armazemTeste.getProduto(1));
        assertEquals(joia1, armazemTeste.getProduto(0)); 
        
        MyLinkedList listaTributo = armazemTeste.relatorioTributo(); 
                                
        assertEquals(boat1, listaTributo.get(0).getObj());
        assertEquals(car1, listaTributo.get(1).getObj());
        assertEquals(moto1, listaTributo.get(2).getObj());        
        assertEquals(quadro1, listaTributo.get(3).getObj()); 
        assertEquals(joia1, listaTributo.get(4).getObj());        
    }
    
    /**
     * Teste que checa se o método de fazer o relatório de tributação 
     * da classe Armazem está funcionando quando o armazem está vazio. 
     */
    @Test
    public void testeRelatorioTributacaoVazio()
    {   assertEquals(0, armazemTeste.getInventario().size());
        
        MyLinkedList listaTributo = armazemTeste.relatorioTributo();
        
        assertEquals(0, listaTributo.size());
        assertTrue(listaTributo.isEmpty());
    }
    
    /**
     * Teste que checa se o método de fazer o relatório de tributação 
     * da classe Armazem está funcionando quando o armazem tem apenas 1item. 
     */
    @Test
    public void testeRelatorioTributacaoUmElemento()
    {   armazemTeste.cadastraProduto(joia1);
        assertEquals(1, armazemTeste.getInventario().size());
        
        MyLinkedList listaTributo = armazemTeste.relatorioTributo();
        assertEquals(1, listaTributo.size());
        assertEquals(joia1, listaTributo.get(0).getObj());
    }
    
    /**
     * Teste que checa se o método de fazer o ordenar o armazem pela data   
     * da classe Armazem está funcionando. 
     */
    @Test
    public void testeInventarioItensData()
    {   armazemTeste.cadastraProduto(joia1);
        armazemTeste.cadastraProduto(car1);
        armazemTeste.cadastraProduto(quadro1);
        armazemTeste.cadastraProduto(boat1);
        armazemTeste.cadastraProduto(moto1);      
                
        assertEquals(5, armazemTeste.getInventario().size());
        assertEquals(quadro1, armazemTeste.getProduto(2));
        assertEquals(boat1, armazemTeste.getProduto(3));
        assertEquals(moto1, armazemTeste.getProduto(4));
        assertEquals(car1, armazemTeste.getProduto(1));
        assertEquals(joia1, armazemTeste.getProduto(0)); 
        
        MyLinkedList listaInventario = armazemTeste.inventarioItensData();
        
        assertEquals(5, listaInventario.size());
        assertEquals(car1, listaInventario.get(4).getObj());
        assertEquals(moto1, listaInventario.get(3).getObj());
        assertEquals(boat1, listaInventario.get(2).getObj());
        assertEquals(quadro1, listaInventario.get(1).getObj());
        assertEquals(joia1, listaInventario.get(0).getObj());        
    }
    
    /**
     * Teste que checa se o método de fazer o ordenar o armazem pela data   
     * da classe Armazem está funcionando quando o armazem está vazio. 
     */
    @Test
    public void testeInventarioItensDataVazio()
    {   assertEquals(0, armazemTeste.getInventario().size());
        
        MyLinkedList listaTributo = armazemTeste.inventarioItensData();
        
        assertEquals(0, listaTributo.size());
        assertTrue(listaTributo.isEmpty());        
    }        
}