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
package TestaTudo;

import TestesControlador.PlanoDeCargaTeste;
import TestesControlador.SistemaTeste;
import TestesControlador.TesteSwap;
import TestesOrdenadores.OrdenacaoTeste;
import TestesUtil.ArmazemTeste;
import TestesUtil.MyLinkedListTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
  {
    PlanoDeCargaTeste.class,
    TesteSwap.class,
    OrdenacaoTeste.class,
    ArmazemTeste.class,
    MyLinkedListTest.class,
    SistemaTeste.class,
})

public class TodosTestes {    
}