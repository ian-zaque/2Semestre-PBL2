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
package Util;

import Ordenadores.OrdenaDataCres;
import Model.Produto;
import Ordenadores.OrdenaImpostoDec;

public class Armazem {
    private MyLinkedList inventario;
    
    /**
     * Construtor da Classe 'Armazem'. Inicializa o atributo único da classe 
     * que é usado para armazenar os itens da classe 'Produto' que serão os 
     * produtos cadastrados.
     * @see MyLinkedList
     * @see Produto
     */
    public Armazem()
    { inventario = new MyLinkedList();  }
    
    /**
     * Método que retorna o atributo lista encadeada desta classe.
     * @return inventario - retorna a lista que guarda os produtos cadastrados.
     * @see MyLinkedList
     */
    public MyLinkedList getInventario()
    {  return inventario;  }
     
    /**
     * Método que cadastra um produto. O método chama o método 'add(Object)' da 
     * classe MyLinkedList que insere um item numa lista encadeada.
     * @param obj - Produto que é cadastrado.
     * @see MyLinkedList
     * @see Produto
     */
    public void cadastraProduto(Produto obj)
    {     inventario.add(obj);      }    

    /**
     * Método que remove o último produto inserido no inventario. 
     * @return retorna o produto do final da lista 
     */
    public Produto removeProduto()
    {  return (Produto)inventario.remove();  }
    
    /**
     * 
     * @param pos - índice que quer se retornar o produto da lista, através do método
     * 'get(int)' da classe MyLinkedList.
     * @return retorna o produto da posição, passada por, da lista de inventário.  
     */
    public Produto getProduto(int pos)
    { return (Produto)inventario.get(pos).getObj();   }
    
    /**
     * Método que ordena decrescentemente o inventário através do método de
     * ordenação por imposto 'quicksort(MyLinkedList, int, int)' da classe 'OrdenaImportoDec'.
     * @return retorna a lista ordenada decrescentemente por imposto. 
     * Caso a lista esteja vazia ou tenha 1 elemento, retorna a própria lista.
     * @see MyLinkedList
     * @see OrdenaImpostoDec
     */
    public MyLinkedList relatorioTributo()
    {   if(inventario.isEmpty()) { return inventario;  }        
        if(inventario.size() == 1)  { return inventario;  }
    
        OrdenaImpostoDec ordenaImposto = new OrdenaImpostoDec();    
        MyLinkedList listaOrdenImposto = ordenaImposto.quickSort(this.inventario, 0, this.inventario.size());    
      return listaOrdenImposto;
    }   
    
    /**
     * Método que ordena crescentemente o inventário através do método de
     * ordenação por data 'quicksort(MyLinkedList, int, int)' da classe 'OrdenaDataCres'.
     * @return lista ordenada crescentemente por data de recebimento.
     * Caso a lista esteja vazia ou tenha 1 elemento, retorna a própria lista.
     * @see MyLinkedList
     * @see OrdenaDataCres
     */
    public MyLinkedList inventarioItensData()
    {   if(inventario.isEmpty()) { return inventario;  }        
        if(inventario.size() == 1)  { return inventario;  }
        
        OrdenaDataCres ordenaInventario = new OrdenaDataCres(); 
        MyLinkedList listaOrdenData = ordenaInventario.quickSort(this.inventario, 0, this.inventario.size()-1);
      return listaOrdenData;
    }    
}