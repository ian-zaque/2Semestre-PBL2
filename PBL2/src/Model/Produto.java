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
package Model;

import java.time.LocalDate;
import java.util.Comparator;

public class Produto implements Comparable, Comparator {
    private long codigo;
    private double valorItem;
    private double imposto;
    private double frete;
    private double pesoItem;
    private int id;
    private LocalDate dataChegada;
    private boolean foiVendido;
    
    /**
     * Construtor da classe Produto que implementa as interfaces Comparable e Comparator.
     * Inicializa os atributos da classe correspondentes aos passados por parâmetro.
     * @param codigo - código de identificação do produto.
     * @param valorItem - valor comercial do produto.
     * @param imposto - valor do imposto taxado do produto.
     * @param frete - valor a ser pago para transportar o produto.
     * @param pesoItem - valor correspondente à massa do produto.
     * @param dataChegada - data de recebimento do produto.
     * @see LocalDate 
     * @see Comparator
     * @see Comparable
     */
    public Produto(long codigo, double valorItem, double imposto, double frete, double pesoItem , LocalDate dataChegada) 
    {   this.codigo = codigo;
        this.valorItem = valorItem;
        this.imposto = imposto;
        this.frete = frete;
        this.pesoItem = pesoItem;
        this.dataChegada = dataChegada;
        this.foiVendido = false;
    }   
        
    /**
     * Método que retorna o código de identificação do produto.
     * @return retorna o código de identificação do produto.
     */
    public long getCodigo()
    {  return codigo;  }

    /**
     * Método que retorna o valor comercial do produto.
     * @return retorna o valor comercial do produto.
     */
    public double getValorItem()
    { return valorItem;  }

    /**
     * Método que retorna o valor do imposto taxado do produto.
     * @return retorna o valor do imposto taxado do produto.
     */
    public double getImposto()
    { return imposto;   }

    /**
     * Método que retorna o valor a ser pago para transportar o produto.
     * @return retorna o valor a ser pago para transportar o produto.
     */
    public double getFrete()
    {  return frete;  }

    /**
     * Método que retorna o valor correspondente à massa do produto.
     * @return retorna o valor correspondente à massa do produto.
     */
    public double getPesoItem()
    { return pesoItem;  }

    /**
     * Método que retorna a data de recebimento do produto.
     * @return retorna a data de recebimento do produto.
     */
    public LocalDate getDataChegada()
    { return dataChegada;  }

    /**
     * Método que retorna a identificação do transporte que este produto vai
     * ser transportado.
     * @return retorna a identificação do transporte que este produto vai
     * ser transportado.
     */
    public int getId()
    { return id;  }
    
    /**
     * Método que retorna 'true' se o produto já foi vendido. 'false' caso contrário.
     * @return retorna 'true' se o produto já foi vendido. 'false' caso contrário.
     */
    public boolean isFoiVendido()
    { return foiVendido;  }
       
    /**
     * Método que recebe uma variável booleana para mudar a identificação de vendido ou não.
     * @param sentenca - passa-se uma variável booleana para mudar a identificação
     * de vendido ou não.
     */
    public void setFoiVendido(boolean sentenca)
    {  this.foiVendido = sentenca;   }         
    
    /**
     * Método que modifica o número correspondente ao tipo de transporte que o produto é
     * levado.
     * @param id - número correspondente ao tipo de transporte que o produto é
     * levado.
     */
    public void setId(int id)
    {   this.id = id;  }
            
    /**
     * Método sobreescrito que compara dois objetos pelo peso.  
     * @param obj - objeto a ser comparado com o objeto que chama este método
     * @return 1, caso o peso do que chama o método seja maior que o passado por
     * parâmetro, -1 se for menor e 0 se forem iguais.  
     * @see Comparator
     * @see Comparable
     */
    @Override
    public int compareTo(Object obj) 
    {   if(this.getPesoItem() > ((Produto)obj).getPesoItem()  )
            {   return -1;  }
       
        else if(this.getPesoItem() < ((Produto)obj).getPesoItem() )
            {   return 1;    }      
     return 0;      
    }

    /**
     * Método que recebe dois parâmetros e o primeiro chama o método sobreescrito.
     * compareTo(Object) desta classe
     * @param o1 - objeto que chama o método 'compareTo(Object) desta mesma classe.
     * @param o2 - objeto que é comparado no método mencionado acima.
     * @return - retorna a chamada do método compareTo(Object).
     * @see Comparator
     * @see Comparable
     */
    @Override
    public int compare(Object o1, Object o2)
    { return ((Produto)o1).compareTo(o2);  } 
           
    /**
     * Método sobreescrito que é chamado por um objeto da classe Produto
     * e compara a outro se seus atributos são iguais.
     * @param obj - objeto a ser comparado.
     * @return 'true' se os objetos tiverem os valores dos atributos iguais, 'false' caso contrário.
     */
    @Override
    public boolean equals(Object obj)
    {   if(obj instanceof Produto)
        {   if( ((Produto)obj).dataChegada == this.dataChegada && ((Produto)obj).frete == this.frete && ((Produto)obj).imposto == this.imposto && 
                ((Produto)obj).pesoItem == this.pesoItem && ((Produto)obj).valorItem == this.valorItem )
            { return true;  }       
        }       
     return false;        
    }
}