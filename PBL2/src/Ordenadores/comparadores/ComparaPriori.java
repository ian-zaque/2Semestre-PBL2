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
import Model.ItemFragil;

public class ComparaPriori implements Comparator{

    /**
     * Método sobreescrito que compara o grau de prioridade de dois objetos e retorna 1
     * se o grau de prioridade do objeto1 for maior que o do objeto2, -1 se for menor e 0 
     * se forem iguais.    
     * 
     * @param o1 - objeto que compara se seu grau de prioridade é maior ou menor
     * que o do segundo parâmetro.
     * @param o2 - objeto a ser comparado ao primeiro.
     * 
     * @return retorna 1 se o grau de prioridade do objeto1 for maior que o do objeto2, -1 se for menor e 0 
     * se forem iguais.  
     * 
     * @see ItemFragil 
     */
    @Override
    public int compare(Object o1, Object o2)
    {
        if(((ItemFragil)o1).getGrauPriori() - ((ItemFragil)o2).getGrauPriori() < 0 )
            {   return -1;  }
       
        else if(((ItemFragil)o1).getGrauPriori() - ((ItemFragil)o2).getGrauPriori() > 0 )
            {   return 1;    }
      
     return 0;        
    }   
}