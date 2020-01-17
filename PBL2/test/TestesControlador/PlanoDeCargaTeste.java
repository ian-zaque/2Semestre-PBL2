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

import Controlador.PlanoDeCarga;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import Util.MyLinkedList;
import static junit.framework.Assert.assertEquals;
import Model.Barco;
import Model.Carro;
import Model.Joia;
import Model.Moto;
import Model.Quadro;
import Util.Armazem;
import static junit.framework.Assert.assertTrue;

public class PlanoDeCargaTeste {
    private Armazem armazem;
    private PlanoDeCarga planoCarga;
    private Carro car1, car2; Moto moto1, moto2; Barco boat1, boat2; Quadro quadro1, quadro2; Joia joia1, joia2;
    
    /**
     * Este método é executado antes de cada teste. Inicializa os produtos 
     * que serão usados para serem armazenados na lista. Inicializa um objeto
     * da classe Armazem e um da classe PlanoDeCarga. 
     */
    @Before
    public void setUp()
    {   armazem = new Armazem();
        planoCarga = new PlanoDeCarga();
        car1 = new Carro (123456789, 150.0, 13.9, 10.0, 110.0, LocalDate.of(2018,12,10) ,2009, "sedan", "Ford", "alcool");
        car2 = new Carro (123456789, 100.0, 13.9, 11.0, 100.0, LocalDate.of(2018,11,9), 2009, "sedan", "Ford", "alcool");
        moto1 = new Moto(543216789, 45.0, 3.9, 5.1, 51.0, LocalDate.of(2018,10,8), 2010, "corrida", "kawazaki", "gasolina", "50-cc");
        moto2 = new Moto(543216789, 55.0, 3.9, 5.0, 50.0, LocalDate.of(2018,9,7),2010, "corrida", "kawazaki", "gasolina", "50-cc");
        boat1 = new Barco(123498765, 190.0, 4.9, 20, 200.0, LocalDate.of(2018,8,6) ,2007, "mar aberto", "iate", "brabo");
        boat2 = new Barco(123498765, 210.0, 4.9, 21, 210.0, LocalDate.of(2018,7,5), 2007, "mar aberto", "iate", "brabo");
        quadro1 = new Quadro(345623463, 25.0, 56.0, 2.0, 20.0, LocalDate.of(2018,6,4), 1, 30.0, 30.0, "dataPintura", "Ian Zaque");
        quadro2 = new Quadro(345623463, 35.0, 56.0, 2.1, 21.0, LocalDate.of(2018,5,3), 2, 30.0, 30.0, "dataPintura", "Ian Zaque");
        joia1 = new Joia(324565656, 5.0, 67.9, 1.0, 10.0, LocalDate.of(2018,4,2), 3, "Diamante");      
        joia2 = new Joia(324565656, 15.0, 67.9, 1.1, 11.0, LocalDate.of(2018,3,1) ,4, "Diamante");       
    }
    
    /**
     * Teste que checa se o método que gera o plano da cegonheira está funcionando.
     */
    @Test
    public void testePlanoCegonheira()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        assertEquals(car2, armazem.getProduto(0));
        assertEquals(joia1, armazem.getProduto(1));
        assertEquals(boat1, armazem.getProduto(2));
        assertEquals(car1, armazem.getProduto(3));
        assertEquals(moto1, armazem.getProduto(4));
        assertEquals(quadro1, armazem.getProduto(5));
        assertEquals(moto2, armazem.getProduto(6));
        assertEquals(boat2, armazem.getProduto(7));
        assertEquals(joia2, armazem.getProduto(8));
        assertEquals(quadro2, armazem.getProduto(9));
        
        MyLinkedList transporte = planoCarga.planoCegonheira(armazem.getInventario(), 500);
        
        assertEquals(2, transporte.size());
        assertEquals(car1, transporte.get(0).getObj());
        assertEquals(car2, transporte.get(1).getObj());        
    }  
    
    /**
     * Teste que checa se o método que gera o plano da cegonheira está 
     * funcionando quando o armazem está vazio.
     */
    @Test
    public void testePlanoCegonheiraVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoCegonheira(armazem.getInventario(), 500);
        
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o plano da cegonheira está funcionando
     * quando o armazem tem apenas 1 elemento.
     */
    @Test
    public void testePlanoCegonheiraUmElem()
    {   armazem.cadastraProduto(moto1);
        assertEquals(1, armazem.getInventario().size());
        assertEquals(moto1, armazem.getInventario().get(0).getObj());
    
        MyLinkedList transporte = planoCarga.planoCegonheira(armazem.getInventario(), 500);
        assertEquals(1, transporte.size());
        assertEquals(moto1, transporte.get(0).getObj());
        assertTrue(!transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o plano do navio conteiner está funcionando.
     */
    @Test
    public void testePlanoNavioConteiner()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        assertEquals(car2, armazem.getProduto(0));
        assertEquals(joia1, armazem.getProduto(1));
        assertEquals(boat1, armazem.getProduto(2));
        assertEquals(car1, armazem.getProduto(3));
        assertEquals(moto1, armazem.getProduto(4));
        assertEquals(quadro1, armazem.getProduto(5));
        assertEquals(moto2, armazem.getProduto(6));
        assertEquals(boat2, armazem.getProduto(7));
        assertEquals(joia2, armazem.getProduto(8));
        assertEquals(quadro2, armazem.getProduto(9));
        
        MyLinkedList transporte = planoCarga.planoConteiner(armazem.getInventario(), 785);
        
        assertEquals(10, transporte.size());
        assertEquals(joia1, transporte.get(0).getObj());        
        assertEquals(joia2, transporte.get(1).getObj());        
        assertEquals(quadro1, transporte.get(2).getObj());        
        assertEquals(quadro2, transporte.get(3).getObj());
        assertEquals(moto1, transporte.get(4).getObj());
        assertEquals(moto2, transporte.get(5).getObj());
        assertEquals(car2, transporte.get(6).getObj());
        assertEquals(car1, transporte.get(7).getObj());
        assertEquals(boat1, transporte.get(8).getObj());
        assertEquals(boat2, transporte.get(9).getObj());
    }
    
    /**
     * Teste que checa se o método que gera o plano do navio conteiner está funcionando
     * quando o armazem está vazio.
     */
    @Test
    public void testePlanoNavioConteinerVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoConteiner(armazem.getInventario(), 785);
        
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o plano do navio conteiner está funcionando
     * quando o armazem tem apenas 1 elemento.
     */
    @Test
    public void testePlanoNavioConteinerUmElem()
    {   armazem.cadastraProduto(car1);
        assertEquals(1, armazem.getInventario().size());
        assertEquals(car1, armazem.getInventario().get(0).getObj());
    
        MyLinkedList transporte = planoCarga.planoConteiner(armazem.getInventario(), 785);
        assertEquals(1, transporte.size());
        assertEquals(car1, transporte.get(0).getObj());
        assertTrue(!transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o plano do carro forte está funcionando.
     */
    @Test
    public void testePlanoCarroForte()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        assertEquals(car2, armazem.getProduto(0));
        assertEquals(joia1, armazem.getProduto(1));
        assertEquals(boat1, armazem.getProduto(2));
        assertEquals(car1, armazem.getProduto(3));
        assertEquals(moto1, armazem.getProduto(4));
        assertEquals(quadro1, armazem.getProduto(5));
        assertEquals(moto2, armazem.getProduto(6));
        assertEquals(boat2, armazem.getProduto(7));
        assertEquals(joia2, armazem.getProduto(8));
        assertEquals(quadro2, armazem.getProduto(9));
        
        MyLinkedList transporte = planoCarga.planoCarroForte(armazem.getInventario(), 45);
        
        assertEquals(3, transporte.size());
        assertEquals(quadro1, transporte.get(0).getObj());
        assertEquals(joia1, transporte.get(1).getObj());
        assertEquals(joia2, transporte.get(2).getObj());
    }
    
    /**
     * Teste que checa se o método que gera o plano do carro forte está funcionando quando
     * o armazem está vazio.
     */
    @Test
    public void testePlanoCarroForteVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoCarroForte(armazem.getInventario(), 45);
        
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o plano do carro forte está funcionando
     * quando o armazem tem apenas 1 elemento.
     */
    @Test
    public void testePlanoCarroForteUmElem()
    {   armazem.cadastraProduto(quadro1);
        assertEquals(1, armazem.getInventario().size());
        assertEquals(quadro1, armazem.getInventario().get(0).getObj());
    
        MyLinkedList transporte = planoCarga.planoCarroForte(armazem.getInventario(), 45);
        assertEquals(1, transporte.size());
        assertEquals(quadro1, transporte.get(0).getObj());
        assertTrue(!transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o plano do navio balsa está funcionando.
     */
    @Test
    public void testePlanoNavioBalsa()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        assertEquals(car2, armazem.getProduto(0));
        assertEquals(joia1, armazem.getProduto(1));
        assertEquals(boat1, armazem.getProduto(2));
        assertEquals(car1, armazem.getProduto(3));
        assertEquals(moto1, armazem.getProduto(4));
        assertEquals(quadro1, armazem.getProduto(5));
        assertEquals(moto2, armazem.getProduto(6));
        assertEquals(boat2, armazem.getProduto(7));
        assertEquals(joia2, armazem.getProduto(8));
        assertEquals(quadro2, armazem.getProduto(9));
        
        MyLinkedList transporte = planoCarga.planoNavioBalsa(armazem.getInventario(), 261);
        
        assertEquals(3, transporte.size());
        assertEquals(car1, transporte.get(0).getObj());
        assertEquals(car2, transporte.get(1).getObj());
        assertEquals(moto1, transporte.get(2).getObj());
    }
    
    /**
     * Teste que checa se o método que gera o plano do navio balsa está funcionando
     * quando o armazem está vazio.
     */
    @Test
    public void testePlanoNavioBalsaVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoNavioBalsa(armazem.getInventario(), 500);
        
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o plano do navio balsa está funcionando
     * quando o armazem tem apenas 1 elemento.
     */
    @Test
    public void testePlanoNavioBalsaUmElem()
    {   armazem.cadastraProduto(moto1);
        assertEquals(1, armazem.getInventario().size());
        assertEquals(moto1, armazem.getInventario().get(0).getObj());
    
        MyLinkedList transporte = planoCarga.planoNavioBalsa(armazem.getInventario(), 500);
        assertEquals(1, transporte.size());
        assertEquals(moto1, transporte.get(0).getObj());
        assertTrue(!transporte.isEmpty());
    }
    
    /**
     * Teste que checa se o método que despacha o navio balsa está funcionando.
     */
    @Test
    public void testeDespachaNavioBalsa()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        
        MyLinkedList transporte = planoCarga.planoNavioBalsa(armazem.getInventario(), 350);
        
        assertEquals(car1, transporte.get(0).getObj());
        assertEquals(car2, transporte.get(1).getObj());
        assertEquals(moto1, transporte.get(2).getObj());
        assertEquals(moto2, transporte.get(3).getObj());
        
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
        
        assertEquals(4, transporte.size());
        assertEquals(6, armazem.getInventario().size());
        assertEquals(4, despachados.size());
        assertEquals(car2, despachados.get(0).getObj());
        assertEquals(car1, despachados.get(1).getObj());
        assertEquals(moto1, despachados.get(2).getObj());
        assertEquals(moto2, despachados.get(3).getObj());
    }
    
    /**
     * Teste que checa se o método que despacha o navio balsa está funcionando 
     * quando o armazem está vazio.
     */
    @Test 
    public void testeDespachaNavioBalsaVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoNavioBalsa(armazem.getInventario(), 500);
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
        
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
        assertEquals(0, armazem.getInventario().size());
        assertEquals(0, despachados.size());
        assertEquals(null, despachados.get(0));
        assertEquals(null, despachados.get(984));
        assertEquals(null, despachados.get(10));
        assertEquals(null, despachados.get(1));
        assertTrue(despachados.isEmpty());        
    }        
    
    /**
     * Teste que checa se o método que despacha a cegonheira está funcionando.
     */
    @Test
    public void testeDespachaCegonheira()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        
        MyLinkedList transporte = planoCarga.planoCegonheira(armazem.getInventario(), 250);
        
        assertEquals(car1, transporte.get(0).getObj());
        assertEquals(car2, transporte.get(1).getObj());
                
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
        
        assertEquals(2, transporte.size());
        assertEquals(8, armazem.getInventario().size());
        assertEquals(2, despachados.size());
        assertEquals(car2, despachados.get(0).getObj());
        assertEquals(car1, despachados.get(1).getObj());
    }
    
    /**
     * Teste que checa se o método que despacha a cegonheira está funcionando
     * quando o armazem está vazio.
     */
    @Test 
    public void testeDespachaCegonheiraVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoCegonheira(armazem.getInventario(), 250);
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
        
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
        assertEquals(0, armazem.getInventario().size());
        assertEquals(0, despachados.size());
        assertEquals(null, despachados.get(0));
        assertEquals(null, despachados.get(984));
        assertEquals(null, despachados.get(10));
        assertEquals(null, despachados.get(1));
        assertTrue(despachados.isEmpty());        
    }
    
    /**
     * Teste que checa se o método que despacha o carro forte está funcionando.
     */
    @Test
    public void despachaCarroForte()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        
        MyLinkedList transporte = planoCarga.planoCarroForte(armazem.getInventario(), 45);
        
        assertEquals(3, transporte.size());        
        assertEquals(quadro1, transporte.get(0).getObj());
        assertEquals(joia1, transporte.get(1).getObj());
        assertEquals(joia2, transporte.get(2).getObj());
                
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
               
        assertEquals(7, armazem.getInventario().size());        
        assertEquals(3, despachados.size());
                        
        assertEquals(quadro1, despachados.get(1).getObj());
        assertEquals(joia1, despachados.get(0).getObj());
        assertEquals(joia2, despachados.get(2).getObj());        
    }
    
    /**
     * Teste que checa se o método que despacha o carro forte está funcionando
     * quando o armazem está vazio.
     */
    @Test 
    public void testeDespachaCarroForteVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoCarroForte(armazem.getInventario(), 45);
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
        
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
        assertEquals(0, armazem.getInventario().size());
        assertEquals(0, despachados.size());
        assertEquals(null, despachados.get(0));
        assertEquals(null, despachados.get(984));
        assertEquals(null, despachados.get(10));
        assertEquals(null, despachados.get(1));
        assertTrue(despachados.isEmpty());        
    }
    
    /**
     * Teste que checa se o método que despacha o navio contêiner está funcionando.
     */
    @Test
    public void testeDespachaNavioConteiner()
    {   armazem.cadastraProduto(car2);
        armazem.cadastraProduto(joia1);
        armazem.cadastraProduto(boat1);
        armazem.cadastraProduto(car1);
        armazem.cadastraProduto(moto1);
        armazem.cadastraProduto(quadro1);
        armazem.cadastraProduto(moto2);
        armazem.cadastraProduto(boat2);
        armazem.cadastraProduto(joia2);
        armazem.cadastraProduto(quadro2);
        
        assertEquals(10, armazem.getInventario().size());
        
        MyLinkedList transporte = planoCarga.planoConteiner(armazem.getInventario(), 320);
        
        assertEquals(3, transporte.size());
        assertEquals(car2, transporte.get(1).getObj());
        assertEquals(joia1, transporte.get(0).getObj());
        assertEquals(boat1, transporte.get(2).getObj());
        
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
                
        assertEquals(8, armazem.getInventario().size());
        assertEquals(2, despachados.size());
   
        assertEquals(car2, despachados.get(0).getObj());
        assertEquals(boat1, despachados.get(1).getObj());
    }
    
    /**
     * Teste que checa se o método que despacha o navio contêiner está funcionando
     * quando o armazem está vazio.
     */
    @Test 
    public void testeDespachaNavioConteinerVazio()
    {   assertEquals(0, armazem.getInventario().size());
        assertTrue(armazem.getInventario().isEmpty());
        
        MyLinkedList transporte = planoCarga.planoConteiner(armazem.getInventario(), 320);
        assertEquals(0, transporte.size());
        assertEquals(null, transporte.get(0));
        assertEquals(null, transporte.get(984));
        assertEquals(null, transporte.get(10));
        assertEquals(null, transporte.get(1));
        assertTrue(transporte.isEmpty());
        
        MyLinkedList despachados = planoCarga.despachaCarga(armazem.getInventario(), transporte);
        assertEquals(0, armazem.getInventario().size());
        assertEquals(0, despachados.size());
        assertEquals(null, despachados.get(0));
        assertEquals(null, despachados.get(984));
        assertEquals(null, despachados.get(10));
        assertEquals(null, despachados.get(1));
        assertTrue(despachados.isEmpty());        
    }    
}