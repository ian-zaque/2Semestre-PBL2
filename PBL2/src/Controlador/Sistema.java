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
package Controlador;

import Model.Produto;
import Ordenadores.OrdenaFreteDec;
import Ordenadores.OrdenaValorDec;
import Util.MyLinkedList;

public class Sistema {
           
    /**
     * Construtor da classe Sistema. Instancia um objeto desta classe.
     */
    public Sistema(){
    }
    
    /**
     * Método que recebe a lista de itens despachados, ordena a lista pelo frete e 
     * adiciona no primeiro nó a lista ordenada. Adiciona no segundo e no terceiro, 
     * respectivamente, o id do tipo de transporte que levou os itens 
     * e a string do nome do transporte. 
     * 
     * @param listaDespachados - é a lista encadeada que armazena os itens que foram
     * despachados do inventário. 
     * 
     * @return retorna a lista encadeada que é o histórico de despacho. Caso a lista
     * passada por parâmetro esteja vazia ou tenha apenas 1 elemento, o parâmetro é retornado. 
     * 
     * @see MyLinkedList
     * @see Despacho
     * @see OrdenaFreteDec 
     */
    public MyLinkedList historicoDespachados(MyLinkedList listaDespachados)
    {   if(listaDespachados.isEmpty()) { return listaDespachados;   }        
        if(listaDespachados.size() == 1) { return listaDespachados;   }
    
        OrdenaFreteDec ordenaFrete = new OrdenaFreteDec();
        MyLinkedList listaOrdenFrete = ordenaFrete.quickSort(listaDespachados, 0, listaDespachados.size()-1);
        MyLinkedList listaHistorico = new MyLinkedList();
                
        listaHistorico.add(listaOrdenFrete);        //A primeira celula da lista será a lista despachada ordenada pelo frete.
        
        if( ((Produto)listaOrdenFrete.get(0).getObj()).getId() == 101)
        { listaHistorico.add(101); listaHistorico.add("CarroForte");        }       //A segunda e terceira será o id do transporte e seu nome, respectivamente.
                    
        else if( ((Produto)listaOrdenFrete.get(0).getObj()).getId() == 201)
        { listaHistorico.add(201); listaHistorico.add("Cegonheira");        } 
        
        else if( ((Produto)listaOrdenFrete.get(0).getObj()).getId() == 301)
        { listaHistorico.add(301); listaHistorico.add("Navio Balsa");       } 
        
        if( ((Produto)listaOrdenFrete.get(0).getObj()).getId() == 401)
        { listaHistorico.add(401); listaHistorico.add("Navio Contêiner");   } 
        
     return listaHistorico;   
    }
    
    /**
     * Método que recebe a lista de itens despachados, ordena a lista pelo 
     * valor dos itens e adiciona no primeiro nó da lista esta outra lista ordenada.
     * Adiciona no segundo nó o id do tipo de transporte, no terceiro, quarto e quinto a soma dos valores
     * dos itens do parâmetros, soma dos pesos e soma dos fretes, respectivamente.  
     * 
     * @param listaDespachada - é a lista encadeada que armazena os itens que foram
     * despachados do inventário. 
     * 
     * @return retorna a lista encadeada que é o relatório de carregamento. Caso a lista
     * passada por parâmetro esteja vazia ou tenha apenas 1 elemento, o parâmetro é retornado. 
     * 
     * @see MyLinkedList
     * @see Despacho
     * @see OrdenaValorDec 
     */
    public MyLinkedList relatorioCarregamento(MyLinkedList listaDespachada)
    {   if(listaDespachada.isEmpty()) { return listaDespachada;   }        
        if(listaDespachada.size() == 1) { return listaDespachada;   }
        
        OrdenaValorDec ordenaValor = new OrdenaValorDec();
        MyLinkedList listaRelat = ordenaValor.quickSort(listaDespachada, 0, listaDespachada.size()-1);
        MyLinkedList relatorio = new MyLinkedList();
        Despacho despacho = new Despacho();
        
        despacho.setListaDespacho(listaRelat);
        despacho.setIdTransporte( ((Produto)listaRelat.get(0).getObj()).getId() );
        
        for(int cont = 0; cont < listaRelat.size(); cont++)
        {   despacho.addSomaFrete( ((Produto)listaRelat.get(cont).getObj()).getFrete() );
            despacho.addSomaPeso(((Produto)listaRelat.get(cont).getObj()).getPesoItem() );
            despacho.addSomaValor(((Produto)listaRelat.get(cont).getObj()).getValorItem() );
        }
        
        relatorio.add(listaRelat);
        relatorio.add(despacho.getIdTransporte());
        relatorio.add(despacho.getSomaValor());
        relatorio.add(despacho.getSomaPeso());
        relatorio.add(despacho.getSomaFrete());
      return relatorio;  
    }
}