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

public class Barco extends Veiculo{
    private String motor;

    /**
     * Construtor da classe Barco que herda da classe Veiculo.
     * Inicializa os atributos da classe correspondentes aos passados por parâmetro.
     * @param codigo - código de identificação do produto.
     * @param valorItem - valor comercial do produto.
     * @param imposto - valor do imposto taxado do produto.
     * @param frete - valor a ser pago para transportar o produto.
     * @param pesoItem - valor correspondente à massa do produto.
     * @param dataChegada - data de recebimento do produto.
     * @param anoFabric - Número que guarda o ano de fabricação do veículo.
     * @param modelo - String que guarda o nome do modelo do veículo.
     * @param marca - String que guarda o nome da marca do veículo.
     * @param motor - String que guarda o tipo do motor do veículo.
     * @see LocalDate
     * @see Veiculo
     */
    public Barco(long codigo, double valorItem, double imposto, double frete, double pesoItem, LocalDate dataChegada, int anoFabric, String modelo, String marca, String motor) 
    {   super(codigo, valorItem, imposto, frete, pesoItem, dataChegada, anoFabric, modelo, marca);
        this.motor = motor;
    }     
}