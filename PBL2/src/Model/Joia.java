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

public class Joia extends ItemFragil {
   private String tipoJoia;

   /**
    * Construtor da classe Joia que herda de ItemFragil.
    * Inicializa os atributos da classe correspondentes aos passados por parâmetro.
    * @param codigo - código de identificação do produto.
    * @param valorItem - valor comercial do produto.
    * @param imposto - valor do imposto taxado do produto.
    * @param frete - valor a ser pago para transportar o produto.
    * @param pesoItem - valor correspondente à massa do produto.
    * @param dataChegada - data de recebimento do produto na empresa.  
    * @param grauPriori - grau de prioridade de transportação.
    * @param tipoJoia - String que guarda o tipo de pedra preciosa.  
    * @see LocalDate
    * @see ItemFragil
    */
    public Joia(long codigo, double valorItem, double imposto, double frete, double pesoItem, LocalDate dataChegada, int grauPriori, String tipoJoia) 
    {   super(codigo, valorItem, imposto, frete, pesoItem, dataChegada, grauPriori);
        this.tipoJoia = tipoJoia;
    }       
}