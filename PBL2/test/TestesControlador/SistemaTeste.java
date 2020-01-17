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
import Controlador.Sistema;
import Model.Barco;
import Model.Carro;
import Model.Joia;
import Model.Moto;
import Model.Quadro;
import Util.Armazem;
import Util.MyLinkedList;
import java.time.LocalDate;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SistemaTeste {
    private Sistema sistema;
    private PlanoDeCarga planoCarga;
    private Armazem lista;
    private Carro car1, car2; Moto moto1, moto2; Barco boat1, boat2; Quadro quadro1, quadro2; Joia joia1, joia2;
    
    /**
     * Este método é executado antes de cada teste. Inicializa os produtos 
     * que serão usados para serem armazenados na lista. Inicializa um objeto
     * da classe Armazem, da classe PlanoDeCarga e da classe Sistema 
     */
    @Before
    public void setUp()
    {   sistema = new Sistema();
        planoCarga = new PlanoDeCarga();
        lista = new Armazem();
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
     * Teste se o método que gera o histórico de despacho está funcionando.
     */
    @Test
    public void testeHistoricoDespachados()
    {   lista.cadastraProduto(car2);
        lista.cadastraProduto(joia1);
        lista.cadastraProduto(boat1);
        lista.cadastraProduto(car1);
        lista.cadastraProduto(moto1);
        lista.cadastraProduto(quadro1);
        lista.cadastraProduto(moto2);
        lista.cadastraProduto(boat2);
        lista.cadastraProduto(joia2);
        lista.cadastraProduto(quadro2);
        
        assertEquals(10, lista.getInventario().size());
        
        MyLinkedList listaPlano = planoCarga.planoCegonheira(lista.getInventario(), 500);
        assertEquals(2, listaPlano.size());
        
        MyLinkedList listaDespacho = planoCarga.despachaCarga(lista.getInventario(), listaPlano);
        assertEquals(8, lista.getInventario().size());
        assertEquals(2, listaDespacho.size());
        
        MyLinkedList historico = sistema.historicoDespachados(listaDespacho);
        
        assertEquals(2, ((MyLinkedList)historico.get(0).getObj()).size() );
        assertEquals(201, historico.get(1).getObj() );
        assertEquals("Cegonheira", historico.get(2).getObj() );
    }
    
    /**
     * Teste se o método que gera o histórico de despacho está funcionando quando
     * a lista está vazia.
     */
    @Test
    public void testeHistoricoDespachadosVazio()
    {   assertEquals(0, lista.getInventario().size());
        assertTrue(lista.getInventario().isEmpty());
    
        MyLinkedList listaPlano = planoCarga.planoCegonheira(lista.getInventario(), 500);
        assertEquals(0, listaPlano.size());
        
        MyLinkedList listaDespacho = planoCarga.despachaCarga(lista.getInventario(), listaPlano);
        assertEquals(0, listaDespacho.size());
        assertEquals(0, lista.getInventario().size());
        
        MyLinkedList historico = sistema.historicoDespachados(listaDespacho);
        assertEquals(0, historico.size());
        assertTrue(historico.isEmpty());
    }
    
    /**
     * Teste que checa se o método que gera o relatório de carregamento está funcionando.
     */
    @Test
    public void testeRelatorioCarregamento()
    {   lista.cadastraProduto(car2);
        lista.cadastraProduto(joia1);
        lista.cadastraProduto(boat1);
        lista.cadastraProduto(car1);
        lista.cadastraProduto(moto1);
        lista.cadastraProduto(quadro1);
        lista.cadastraProduto(moto2);
        lista.cadastraProduto(boat2);
        lista.cadastraProduto(joia2);
        lista.cadastraProduto(quadro2);
        
        assertEquals(10, lista.getInventario().size());
        
        MyLinkedList listaPlano = planoCarga.planoCegonheira(lista.getInventario(), 500);
        assertEquals(2, listaPlano.size());
        
        MyLinkedList listaDespacho = planoCarga.despachaCarga(lista.getInventario(), listaPlano);
        assertEquals(8, lista.getInventario().size());
        assertEquals(2, listaDespacho.size());
        
        MyLinkedList relatorio = sistema.relatorioCarregamento(listaDespacho);
        
        assertEquals(5, relatorio.size());
        assertEquals(car1, ((MyLinkedList)relatorio.get(0).getObj()).get(0).getObj());
        assertEquals(car2, ((MyLinkedList)relatorio.get(0).getObj()).get(1).getObj());
        assertEquals(201, relatorio.get(1).getObj());
        assertEquals(250.0, relatorio.get(2).getObj());
        assertEquals(210.0, relatorio.get(3).getObj());
        assertEquals(21.0, relatorio.get(4).getObj());
    }
    
    /**
     * Teste que checa se o método que gera o relatório de carregamento está 
     * funcionando quando a lista está vazia. 
     */
    @Test
    public void testeRelatorioCarregamentoVazio()
    {   assertEquals(0, lista.getInventario().size());
        assertTrue(lista.getInventario().isEmpty());
    
        MyLinkedList listaPlano = planoCarga.planoCegonheira(lista.getInventario(), 500);
        assertEquals(0, listaPlano.size());
        
        MyLinkedList listaDespacho = planoCarga.despachaCarga(lista.getInventario(), listaPlano);
        assertEquals(0, listaDespacho.size());
        assertEquals(0, lista.getInventario().size());
        
        MyLinkedList relatorio = sistema.relatorioCarregamento(listaDespacho);
        assertEquals(0, relatorio.size());
        assertEquals(null,relatorio.get(1));
        assertEquals(null,relatorio.get(2));
        assertEquals(null,relatorio.get(3));
        assertEquals(null,relatorio.get(4));
        assertTrue(relatorio.isEmpty());
    }    
}