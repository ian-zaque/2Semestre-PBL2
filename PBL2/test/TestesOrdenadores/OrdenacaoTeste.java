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
package TestesOrdenadores;

import Ordenadores.OrdenaDataCres;
import Ordenadores.OrdenaDataDec;
import static junit.framework.Assert.assertEquals;
import Model.Barco;
import Model.Carro;
import Model.Joia;
import Model.Moto;
import Model.Quadro;
import Ordenadores.OrdenaFreteDec;
import org.junit.Before;
import org.junit.Test;
import Util.MyLinkedList;
import Ordenadores.OrdenaImpostoCres;
import Ordenadores.OrdenaImpostoDec;
import Ordenadores.OrdenaPesoCres;
import Ordenadores.OrdenaPesoDec;
import Ordenadores.OrdenaPrioriCres;
import Ordenadores.OrdenaPrioriDec;
import Ordenadores.OrdenaValorCres;
import Ordenadores.OrdenaValorDec;
import java.time.LocalDate;
import static junit.framework.Assert.assertTrue;

public class OrdenacaoTeste {
    MyLinkedList lista;
    Carro car1; Moto moto1; Barco boat1; Quadro quadro1, quadro2; Joia joia1, joia2, joia3; 
    
    /**
     * Este método é executado antes de cada teste. Inicializa o objeto lista 
     * encadeada. Inicializa os produtos que serão usados para serem armazenados na lista.
     */
    @Before
    public void setUp()
    {   lista = new MyLinkedList(); 
        car1 = new Carro (123456789, 100.0, 10.0, 10.0, 100.0, LocalDate.of(2018,12,5), 2009, "string", "string", "tipo-combust");
        moto1 = new Moto(543216789, 50.0, 5.0, 5.0, 50.0,LocalDate.of(2018,11,4) , 2010, "string", "string", "string", "tipo-motor");
        boat1 = new Barco(123498765, 200.0, 20.0, 20.0, 200.0, LocalDate.of(2018,10,3) ,2007, "string", "string", "string");
        quadro1 = new Quadro(345623463, 20.0, 2.0, 2.0, 20.0, LocalDate.of(2018,9,2), 1, 30.0, 30.0, "dataPintura" ,"pintor");
        joia1 = new Joia(324565656, 10.0, 1.0, 1.0, 10.0, LocalDate.of(2018,8,1), 2, "tipo-joia");   
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por peso está funcionando.
     */
    @Test
    public void testeOrdenDecresPorPeso()
    {   OrdenaPesoDec ordenaPesoDec = new OrdenaPesoDec();
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);    
        
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());     
        
        lista = ordenaPesoDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertEquals(car1, lista.get(1).getObj());
        assertEquals(moto1, lista.get(2).getObj());
        assertEquals(quadro1, lista.get(3).getObj());
        assertEquals(joia1, lista.get(4).getObj());     
    }      
    
    /**
     * Teste que checa se o método de ordenação decrescente por peso está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenDecresPorPesoVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaPesoDec ordenaPesoDec = new OrdenaPesoDec();
        lista = ordenaPesoDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(10));
        assertEquals(null, lista.get(40));
        assertEquals(null, lista.get(100000));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por peso está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenDecresPorPesoUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaPesoDec ordenaPesoDec = new OrdenaPesoDec();
        lista = ordenaPesoDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por peso está funcionando.
     */
    @Test
    public void testeOrdenCresPorPeso()
    {   OrdenaPesoCres ordenaPesoCres = new OrdenaPesoCres();
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1); 
                       
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());     
        
        lista = ordenaPesoCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(boat1, lista.get(4).getObj());
        assertEquals(car1, lista.get(3).getObj());
        assertEquals(moto1, lista.get(2).getObj());
        assertEquals(quadro1, lista.get(1).getObj());      
        assertEquals(joia1, lista.get(0).getObj());           
    }  
    
    /**
     * Teste que checa se o método de ordenação crescente por peso está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenCresPorPesoVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaPesoCres ordenaPesoCres = new OrdenaPesoCres();
        lista = ordenaPesoCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por peso está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenCresPorPesoUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaPesoCres ordenaPesoCres = new OrdenaPesoCres();
        lista = ordenaPesoCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por imposto está funcionando.
     */
    @Test
    public void testeOrdenCresPorImposto()
    {   OrdenaImpostoCres ordenaImpostoCres = new OrdenaImpostoCres();        
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);
        
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());    
        
        lista = ordenaImpostoCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(boat1, lista.get(4).getObj());
        assertEquals(car1, lista.get(3).getObj());
        assertEquals(moto1, lista.get(2).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(joia1, lista.get(0).getObj());    
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por imposto está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenCresPorImpostoVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaImpostoCres ordenaImpostoCres = new OrdenaImpostoCres();
        lista = ordenaImpostoCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por imposto está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenCresPorImpostoUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaImpostoCres ordenaImpostoCres = new OrdenaImpostoCres();
        lista = ordenaImpostoCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por imposto está funcionando.
     */
    @Test
    public void testeOrdenDecresPorImposto()
    {   OrdenaImpostoDec ordenaImpostoDec = new OrdenaImpostoDec();        
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);  
    
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());    
        
        lista = ordenaImpostoDec.quickSort(lista, 0, lista.size());
        
        assertEquals(5, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertEquals(car1, lista.get(1).getObj());
        assertEquals(moto1, lista.get(2).getObj());
        assertEquals(quadro1, lista.get(3).getObj());
        assertEquals(joia1, lista.get(4).getObj());    
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por imposto está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenDecPorImpostoVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaImpostoDec ordenaImpostoDec = new OrdenaImpostoDec();
        lista = ordenaImpostoDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por imposto está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenDecPorImpostoUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaImpostoDec ordenaImpostoDec = new OrdenaImpostoDec();
        lista = ordenaImpostoDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por valor está funcionando.
     */
    @Test
    public void testeOrdenCresPorValor()
    {   OrdenaValorCres ordenaValorCres = new OrdenaValorCres();        
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);  
        
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());    
        
        lista = ordenaValorCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(boat1, lista.get(4).getObj());
        assertEquals(car1, lista.get(3).getObj());
        assertEquals(moto1, lista.get(2).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(joia1, lista.get(0).getObj()); 
    }   
    
    /**
     * Teste que checa se o método de ordenação crescente por valor está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenCresPorValorVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaValorCres ordenaValorCres = new OrdenaValorCres();
        lista = ordenaValorCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por valor está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenCresPorValorUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaValorCres ordenaValorCres = new OrdenaValorCres();
        lista = ordenaValorCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por valor está funcionando.
     */
    @Test
    public void testeOrdenDecresPorValor()
    {   OrdenaValorDec ordenaValorDec = new OrdenaValorDec();        
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);  
        
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());    
        
        lista = ordenaValorDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertEquals(car1, lista.get(1).getObj());
        assertEquals(moto1, lista.get(2).getObj());
        assertEquals(quadro1, lista.get(3).getObj());
        assertEquals(joia1, lista.get(4).getObj()); 
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente valor está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenDecPorValorVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaValorDec ordenaValorDec = new OrdenaValorDec();
        lista = ordenaValorDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por valor está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenDecPorValorUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaValorDec ordenaValorDec = new OrdenaValorDec();
        lista = ordenaValorDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por grau de prioridade
     * está funcionando.
     */
    @Test
    public void testeOrdenCresPorPriori()
    {   OrdenaPrioriCres ordenaPrioriCres = new OrdenaPrioriCres();        
        Quadro quadro2 = new Quadro(345623463, 35.0, 56.0, 2.1, 21.0, LocalDate.of(2018,12,9), 3, 30.0, 30.0, "dataPintura", "Ian Zaque");
        Joia joia2 = new Joia(324565656, 15.0, 67.9, 1.1, 11.0, LocalDate.of(2018,12,9), 4, "Diamante");  
        lista.add(quadro1);
        lista.add(joia2);
        lista.add(joia1);
        lista.add(quadro2);
         
        lista = ordenaPrioriCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(4, lista.size());
        assertEquals(quadro1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(1).getObj());
        assertEquals(quadro2, lista.get(2).getObj());
        assertEquals(joia2, lista.get(3).getObj());
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por grau de prioridade está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenCresPorPrioriVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaPrioriCres ordenaPrioriCres = new OrdenaPrioriCres();
        lista = ordenaPrioriCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por grau de prioridade está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenCresPorPrioriUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaPrioriCres ordenaPrioriCres = new OrdenaPrioriCres();
        lista = ordenaPrioriCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por grau de prioridade
     * está funcionando.
     */
    @Test
    public void testeOrdenDecresPorPriori()
    {   OrdenaPrioriDec ordenaPrioriDec = new OrdenaPrioriDec();        
        Quadro quadro2 = new Quadro(345623463, 35.0, 56.0, 2.1, 21.0, LocalDate.of(2018,12,9), 3, 30.0, 30.0, "dataPintura", "Ian Zaque");
        Joia joia2 = new Joia(324565656, 15.0, 67.9, 1.1, 11.0, LocalDate.of(2018,12,9), 4, "Diamante");  
        lista.add(quadro1);
        lista.add(joia2);
        lista.add(joia1);
        lista.add(quadro2);
         
        lista = ordenaPrioriDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(4, lista.size());
        assertEquals(quadro1, lista.get(3).getObj());
        assertEquals(joia1, lista.get(2).getObj());
        assertEquals(quadro2, lista.get(1).getObj());
        assertEquals(joia2, lista.get(0).getObj());        
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por grau de prioridade
     * está funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenDecPorPrioriVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaPrioriDec ordenaPrioriDec = new OrdenaPrioriDec();
        lista = ordenaPrioriDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por grau de prioridade está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenDecPorPrioriUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaPrioriDec ordenaPrioriDec = new OrdenaPrioriDec();
        lista = ordenaPrioriDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por data de recebimento
     * está funcionando.
     */
    @Test
    public void testeOrdenCresPorData()
    {   OrdenaDataCres ordenaDataCres = new OrdenaDataCres();
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);  
    
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());    
        
        lista = ordenaDataCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(joia1, lista.get(0).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(3).getObj());
        assertEquals(car1, lista.get(4).getObj());        
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por data de recebimento
     * está funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenCresPorDataVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaDataCres ordenaDataCres = new OrdenaDataCres();
        lista = ordenaDataCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação crescente por data de recebimento está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenCresPorDataUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaDataCres ordenaDataCres = new OrdenaDataCres();
        lista = ordenaDataCres.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por data de recebimento
     * está funcionando.
     */
    @Test
    public void testeOrdenDecPorData()
    {   OrdenaDataDec ordenaDataDec = new OrdenaDataDec();
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);  
    
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());    
        
        lista = ordenaDataDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(joia1, lista.get(4).getObj());
        assertEquals(quadro1, lista.get(3).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(1).getObj());
        assertEquals(car1, lista.get(0).getObj());        
    }

    /**
     * Teste que checa se o método de ordenação decrescente por data de recebimento está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenDecPorDataVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaDataDec ordenaDataDec = new OrdenaDataDec();
        lista = ordenaDataDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por data de recebimento está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenDecPorDataUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaDataDec ordenaDataDec = new OrdenaDataDec();
        lista = ordenaDataDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por frete está funcionando.
     */
    @Test
    public void testeOrdenDecPorFrete()
    {   OrdenaFreteDec ordenaFreteDec = new OrdenaFreteDec();
        lista.add(car1);
        lista.add(quadro1);
        lista.add(boat1);
        lista.add(joia1);
        lista.add(moto1);  
    
        assertEquals(5, lista.size());
        assertEquals(car1, lista.get(0).getObj());
        assertEquals(joia1, lista.get(3).getObj());
        assertEquals(quadro1, lista.get(1).getObj());
        assertEquals(boat1, lista.get(2).getObj());
        assertEquals(moto1, lista.get(4).getObj());  
    
        lista = ordenaFreteDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(5, lista.size());
        assertEquals(joia1, lista.get(4).getObj());
        assertEquals(quadro1, lista.get(3).getObj());
        assertEquals(boat1, lista.get(0).getObj());
        assertEquals(moto1, lista.get(2).getObj());
        assertEquals(car1, lista.get(1).getObj());           
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por frete está 
     * funcionando quando a lista está vazia.
     */
    @Test
    public void testeOrdenDecPorFreteVazio()
    {   assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    
        OrdenaFreteDec ordenaFreteDec = new OrdenaFreteDec();
        lista = ordenaFreteDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(0, lista.size());
        assertEquals(null, lista.get(0));
        assertEquals(null, lista.get(78));
        assertEquals(null, lista.get(64));
        assertEquals(null, lista.get(875240));
        assertTrue(lista.isEmpty());        
    }
    
    /**
     * Teste que checa se o método de ordenação decrescente por frete está 
     * funcionando quando a lista tem apenas 1 elemento.
     */
    @Test
    public void testeOrdenDecPorFreteUmEleme()
    {   lista.add(boat1);
        assertEquals(1, lista.size());
    
        OrdenaFreteDec ordenaFreteDec = new OrdenaFreteDec();
        lista = ordenaFreteDec.quickSort(lista, 0, lista.size()-1);
        
        assertEquals(1, lista.size());
        assertEquals(boat1, lista.get(0).getObj());
        assertTrue(!lista.isEmpty());
    }    
}