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

import Ordenadores.OrdenaDataDec;
import Ordenadores.OrdenaPesoDec;
import Ordenadores.OrdenaPrioriCres;
import Ordenadores.OrdenaValorCres;
import Model.Carro;
import Model.Moto;
import Model.ItemFragil;
import Util.MyLinkedList;
import Model.Produto;

public class PlanoDeCarga {
    private final int idCarroForte;
    private final int idCegonheira;
    private final int idNavioBalsa;
    private final int idNavioConteiner;
    private Despacho despacho;
    
    /**
     * Construtor da classe PlanoDeCarga. Instancia um objeto desta classe
     * Inicializa os IDs dos transportes respectivos a um número
     * escolhido específico. Instancia o atributo da classe Despacho.  
     */
    public PlanoDeCarga()
    {   idCarroForte = 101;
        idCegonheira = 201;
        idNavioBalsa = 301;
        idNavioConteiner = 401;    
        despacho = new Despacho(); 
    }    

    /**
     * Método que retorna o objeto que realiza as operações de 
     * despacho de um plano de carga.
     * @return retorna o objeto que despacha os itens do plano de carga. 
     * @see Despacho
     */
    public Despacho getDespacho()
    { return despacho; }
        
    /**
     * Método que gera uma lista encadeada onde nela estão os carros ordenados 
     * pelo peso decrescentemente. Coloca um item no transporte caso ele seja um 
     * item da classe Carro e não da classe Moto(herda de Carro) e caso o peso 
     * deste carro caiba e não exceda o peso máximo e caiba no transporte. Cada carro
     * carregado no transporte recebe a identificação de que foi levado numa Cegonheira. 
     * 
     * @param inventario - lista encadeada que armazena os itens do inventário.
     * @param pesoMax - valor do peso máximo que pode ser carregado 
     * num caminhão cegonha.
     * 
     * @return retorna lista do transporte ordenada pelo peso decrescentemente. Caso 
     * o inventário esteja vazio ou tenha 1 elemento, retorna-se o inventário.
     * 
     * @see MyLinkedList
     * @see Carro
     * @see Moto
     * @see Produto
     * @see OrdenaPesoDec
     */
    public MyLinkedList planoCegonheira(MyLinkedList inventario, double pesoMax)
    {   if(inventario.isEmpty()) { return inventario;  }        
        if(inventario.size() == 1)  { return inventario;  }
                
        MyLinkedList cegonheira = new MyLinkedList();
        OrdenaPesoDec ordenaCegonheira = new OrdenaPesoDec();
        int cont = 0; double pesoSuporta = 0.0;  
                        
        while( cont < inventario.size() )
        {   Produto produto = (Produto) inventario.get(cont).getObj();
            
        if(produto instanceof Carro && !(produto instanceof Moto) && (pesoSuporta <= pesoMax) && produto.getPesoItem() <= pesoMax && produto.getPesoItem() <= pesoMax - pesoSuporta && !produto.isFoiVendido())
            {   cegonheira.add(produto);
                pesoSuporta += produto.getPesoItem();
                produto.setId(idCegonheira);
            }
            cont++;
        }
        cegonheira = ordenaCegonheira.quickSort(cegonheira, 0, cegonheira.size()-1);
      return cegonheira;  
    }
    
    /**
     * Método que gera uma lista encadeada onde nela estão os carros ordenados 
     * pelo valor crescentemente. Coloca um item no transporte caso ele seja um 
     * objeto de qualquer instancia de classes filhas de Produto e caso o peso 
     * deste Produto caiba e não exceda o peso máximo e caiba no transporte. Cada item
     * carregado no transporte recebe a identificação de que foi levado num Navio de Contêiner.
     * 
     * @param inventario - lista encadeada que armazena os itens do inventário.
     * @param pesoMax - valor do peso máximo que pode ser carregado 
     * num caminhão cegonha.
     * 
     * @return retorna lista do transporte ordenada pelo valor crescentemente. Caso 
     * o inventário esteja vazio ou tenha 1 elemento, retorna-se o inventário.
     * 
     * @see MyLinkedList 
     * @see Produto
     * @see OrdenaValorCres
     */
    public MyLinkedList planoConteiner(MyLinkedList inventario, double pesoMax)
    {   if(inventario.isEmpty()) { return inventario;  }        
        if(inventario.size() == 1)  { return inventario;  }
        
        MyLinkedList navioConteiner = new MyLinkedList();
        OrdenaValorCres ordenaConteiner = new OrdenaValorCres();
        int cont =0; double pesoSuporta = 0.0;
    
        while(cont < inventario.size())
        {   Produto produto = (Produto) inventario.get(cont).getObj();
            
            if(pesoSuporta <= pesoMax && produto.getPesoItem() <= pesoMax && produto.getPesoItem() <= pesoMax - pesoSuporta && !produto.isFoiVendido())
            {   navioConteiner.add(produto);
                pesoSuporta += produto.getPesoItem();
                produto.setId(idNavioConteiner);
            }
          cont++;  
        }
       navioConteiner = ordenaConteiner.quickSort(navioConteiner, 0, navioConteiner.size()-1);       
     return navioConteiner;  
    }
    
    /**
     * Método que gera uma lista encadeada onde nela estão os itens frágeis ordenados 
     * pelo grau de prioridade crescentemente. Coloca um item no transporte caso ele seja um 
     * item da classe ItemFragil e caso o peso deste item no transporte caiba e não exceda
     * o peso máximo e caiba no transporte. Cada item carregado no transporte 
     * recebe a identificação de que foi levado num carro forte. 
     * 
     * @param inventario - lista encadeada que armazena os itens do inventário.
     * @param pesoMax - valor do peso máximo que pode ser carregado 
     * num carro forte.
     * 
     * @return retorna lista do transporte ordenada pelo peso decrescentemente. Caso 
     * o inventário esteja vazio ou tenha 1 elemento, retorna-se o inventário.
     * 
     * @see MyLinkedList
     * @see ItemFragil
     * @see Produto
     * @see OrdenaPrioriCres
     */
    public MyLinkedList planoCarroForte(MyLinkedList inventario, double pesoMax)
    {   if(inventario.isEmpty()) { return inventario;  }        
        if(inventario.size() == 1)  { return inventario;  }
        
        MyLinkedList carroForte = new MyLinkedList();
        OrdenaPrioriCres ordenaCarroForte = new OrdenaPrioriCres();
        int cont = 0; double pesoSuporta = 0.0;
        
        while(cont < inventario.size())
        {   Produto item = (Produto) inventario.get(cont).getObj();
            
            if(item instanceof ItemFragil && pesoSuporta <= pesoMax && item.getPesoItem() <= pesoMax && item.getPesoItem() <= pesoMax - pesoSuporta && !item.isFoiVendido())
            {   carroForte.add(item);
                pesoSuporta += item.getPesoItem();
                item.setId(idCarroForte);
            }
            cont++;
        }
       carroForte = ordenaCarroForte.quickSort(carroForte, 0, carroForte.size()-1);
     return carroForte;
    }
    
    /**
     * Método que gera uma lista encadeada onde nela estão os itens frágeis ordenados 
     * pelo grau de prioridade crescentemente. Coloca um item no transporte caso ele seja um 
     * item da classe Carro ou da classe Moto e caso o peso deste item no transporte caiba 
     * e não exceda o peso máximo e caiba no transporte. Cada item carregado no transporte 
     * recebe a identificação de que foi levado num navio balsa.
     * 
     * @param inventario - lista encadeada que armazena os itens do inventário.
     * @param pesoMax - valor do peso máximo que pode ser carregado. 
     * num carro forte. 
     * 
     * @return retorna lista do transporte ordenada pela data decrescentemente. Caso 
     * o inventário esteja vazio ou tenha 1 elemento, retorna-se o inventário.
     * 
     * @see MyLinkedList
     * @see Carro
     * @see Moto
     * @see Produto
     * @see OrdenaDataDec
     */
    public MyLinkedList planoNavioBalsa(MyLinkedList inventario, double pesoMax)
    {   if(inventario.isEmpty()) { return inventario;  }        
        if(inventario.size() == 1)  { return inventario;  }
        
        MyLinkedList navioBalsa = new MyLinkedList();
        OrdenaDataDec ordenaNavioBalsa = new OrdenaDataDec();
        int cont = 0; double pesoSuporta = 0.0;
        
        while(cont < inventario.size())
        {   Produto prod = (Produto) inventario.get(cont).getObj();
            
            if((prod instanceof Carro || prod instanceof Moto) && pesoSuporta <= pesoMax && prod.getPesoItem() <= pesoMax && prod.getPesoItem() <= pesoMax - pesoSuporta && !prod.isFoiVendido())
            {   navioBalsa.add(prod);
                pesoSuporta += prod.getPesoItem();
                prod.setId(idNavioBalsa);
            }
          cont++;  
        }
      navioBalsa = ordenaNavioBalsa.quickSort(navioBalsa, 0, navioBalsa.size()-1);
     return navioBalsa; 
    }
    
    /**
     * Método que recebe o inventário com todos os itens e a lista dos itens que 
     * serão transportados. Checa os itens que estão na lista transporte e, caso 
     * sejam iguais aos que estão na lista inventario, exclue do inventário. Checa
     * também o Id de transporte. O objeto da classe Despacho recebe o id do primeiro 
     * item do transporte e os atributos de Despacho recebem a soma do frete, peso e valor
     * dos itens do transporte, respectivamente. No final, a lista de Despacho torna-se a lista
     * de itens excluidos do inventario.
     * 
     * @param inventario - lista encadeada que armazena os itens do inventário.
     * @param transporte - lista encadeada que armazena os itens que serão transportados.
     * 
     * @return retorna a lista que armazena os itens da lista transporte que foram excluídos do
     * inventário. Caso o inventário ou o transporte estejam vazios, retorna-se estas listas em 
     * cada caso respectivamente. Caso o transporte tenha 1 elemento, retorna-se a lista transporte. 
     * 
     * @see Produto
     * @see MyLinkedList
     */
   public MyLinkedList despachaCarga(MyLinkedList inventario, MyLinkedList transporte)   
   {   if(inventario.isEmpty()) { return inventario;  }                     
       if(transporte.isEmpty()) { return transporte;  }        
       if(transporte.size() == 1)  { return transporte;  }
       
       MyLinkedList despachados = new MyLinkedList();
           
        for(int contInv = 0; contInv < inventario.size(); contInv++)
        {   for(int contTra = 0; contTra < transporte.size(); contTra++)
            {   if( ((Produto)inventario.get(contInv).getObj()).equals( (Produto)transporte.get(contTra).getObj()) )
                {   
                    if(((Produto)inventario.get(contInv).getObj()).getId() == idCarroForte)            { despacho.setIdTransporte(idCarroForte); }   
                    else if(((Produto)inventario.get(contInv).getObj()).getId() == idCegonheira)       { despacho.setIdTransporte(idCegonheira); }
                    else if(((Produto)inventario.get(contInv).getObj()).getId() == idNavioBalsa)       { despacho.setIdTransporte(idNavioBalsa); }
                    else if(((Produto)inventario.get(contInv).getObj()).getId() == idNavioConteiner)   { despacho.setIdTransporte(idNavioConteiner); }
                    
                    despacho.addSomaFrete( ((Produto)inventario.get(contInv).getObj()).getFrete() );
                    despacho.addSomaPeso( ((Produto)inventario.get(contInv).getObj()).getPesoItem());
                    despacho.addSomaValor(((Produto)inventario.get(contInv).getObj()).getValorItem());
                    despachados.add( (Produto)inventario.remove(contInv) );                    
                }                
            }
        }
       despacho.setListaDespacho(despachados);
     return despachados;  
   } 
}