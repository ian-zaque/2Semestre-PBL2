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
package Ordenadores;

import Util.Swap;
import Ordenadores.comparadores.ComparaData;
import Model.Produto;
import Util.MyLinkedList;

public class OrdenaDataCres {
    private ComparaData comparator;
    
    /**
     * Construtor da classe OrdenaDataCres. Instancia um objeto da classe ComparaData
     * que será usado no método de ordenação.
     */
    public OrdenaDataCres()
    { comparator = new ComparaData();  }
    
    /**
     * Método de ordenação recursiva crescente baseada em 
     * dividir e conquistar. Quebra a lista até ter uma lista de um elemento. 
     * Retorna esta lista até ela estar completamente ordenada. Chama o método 
     * separar(MyLinkedList, int, int) para retornar o índice do item do meio da
     * lista e chama o método quickSort, dividindo o lado antes do índice (lado esquerdo),
     * oredena e depois do índice (lado direito) e ordena. No final do processo, a
     * lista estará ordenada.
     * 
     * @param lista - lista a ser ordenada.
     * @param inicio - índice da primeira posição da lista.
     * @param fim - índice da última posição da lista.
     * 
     * @return retorna a lista ordenada caso tenha já terminado de fazer todas as
     * trocas.
     * 
     * @see MyLinkedList 
     */
    public MyLinkedList quickSort(MyLinkedList lista, int inicio, int fim)  //ORDENA CRESCENTEMENTE
    {   if (inicio < fim)
        {   int posicaoPivo = separar(lista, inicio, fim);
            quickSort(lista, inicio, posicaoPivo - 1);
            quickSort(lista, posicaoPivo + 1, fim);
        }
     return lista;   
    }

    /**
     * Método que pega o índice do item do meio da lista. Compara os itens para 
     * saber qual o item menor e faz as trocas baseada no critério do comparador. 
     * Percorre a lista até achar este elemento e usa o objeto da Classe Swap 
     * para fazer as trocas de posição dos objetos respectivos. 
     * 
     * @param lista - lista a ser ordenada.
     * @param inicio - índice da primeira posição da lista.
     * @param fim - índice da última posição da lista.
     * 
     * @return - retorna índice do meio da lista que é o fim da lista particionada.
     * @see Swap
     * @see ComparaData
     * @see Produto
     */
    private int separar(MyLinkedList lista, int inicio, int fim) 
    {   Swap swap = new Swap(lista);
        Produto pivo = (Produto) lista.get(inicio).getObj();
        int begin = inicio + 1, end = fim;
        
            while (begin <= end)
            {                   
                if( comparator.compare((Produto)lista.get(begin).getObj() , pivo) <= 0  )           //CRESCENTE
                {  begin++; }                                        
                
                else if( comparator.compare((Produto)lista.get(end).getObj() , pivo) >= 0  )
                {  end--; } 
            
                else
                {  swap.swap(begin, end);
                   begin++;
                   end--;
                }
            }
        swap.swap(inicio, end);          
      return end;
    }   
}