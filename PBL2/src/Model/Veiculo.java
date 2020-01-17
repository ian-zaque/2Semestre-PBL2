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


public class Veiculo extends Produto {
    private int anoFabric;
    private String modelo;
    private String marca;

    /**
     * Construtor da classe Veiculo que herda da classe 'Produto'. Passa os parâmetros
     * correspondentes à classe 'Produto' através do método 'super()'.
     * Inicializa os atributos passados e os desta classe. 
     * 
     * @param codigo - código de identificação do veículo.
     * @param valorItem - valor comercial do veículo.
     * @param imposto - valor do imposto taxado do veículo.
     * @param frete - valor do preço a ser pago para transportar o veículo.
     * @param pesoItem - valor correspondente à massa do veículo.
     * @param dataChegada - Data que armazena a data de recebimento do veículo. 
     * @param anoFabric - Número que guarda o ano de fabricação do veículo.
     * @param modelo - String que guarda o nome do modelo do veículo.
     * @param marca - String que guarda o nome da marca do veículo.
     * 
     * @see Produto
     * @see LocalDate
     */
    public Veiculo(long codigo, double valorItem, double imposto, double frete, double pesoItem, LocalDate dataChegada, int anoFabric, String modelo, String marca) 
    {   super(codigo, valorItem, imposto, frete, pesoItem , dataChegada);
        this.anoFabric = anoFabric;
        this.marca = marca;
        this.modelo = modelo;
    }    
}