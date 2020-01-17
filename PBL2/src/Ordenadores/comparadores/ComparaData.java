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
package Ordenadores.comparadores;

import java.util.Comparator;
import Model.Produto;

public class ComparaData implements Comparator {

    /**
     * Construtor da classe ComparaData. Instanci um objeto desta classe que 
     * implementa a interface Comparator.
     * @see Comparator
     */
    public ComparaData(){        
    }
    
    /**
     * Método sobreescrito que compara a data de dois objetos e retorna 1
     * se a data do objeto1 vier antes da do objeto2, -1 se vier depois e 0 
     * se forem datas iguais. 
     * 
     * @param o1 - objeto que compara se sua data vem antes ou depois do segundo parâmetro.
     * @param o2 - objeto a ser comparado ao primeiro.
     * 
     * @return retorna 1 se a data do objeto1 vier antes da do objeto2, -1 se vier depois e 0 
     * se forem datas iguais. 
     */
    @Override
    public int compare(Object o1, Object o2)
    {
       if( ((Produto)o1).getDataChegada().isBefore( ((Produto)o2).getDataChegada()) )
       { return -1; }
        
       else if( ((Produto)o1).getDataChegada().isAfter( ((Produto)o2).getDataChegada()) )
       { return 1; }
     return 0; 
    }   
}