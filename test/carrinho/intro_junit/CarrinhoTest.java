
package carrinho;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

	private Carrinho car;
	private Produto album1;
	public Produto album2;
	private Produto album3;

	@BeforeEach 
	public void inicializa() {
		car = new Carrinho();
		album1 = new Produto("True", 150.00);
		album2 = new Produto("Stories", 100.00);
		album3 = new Produto("Avicii 01", 50.00);
		car.addItem(album1);
		car.addItem(album2);
		car.addItem(album3);
	} 


	@Test 
	public void testeSomaNovoProduto() {
		Produto album4 = new Produto("TIM", 50.00);
		car.addItem(album4);
		Assertions.assertAll(
				() -> assertThat(car.getValorTotal(), equalTo(350.00)),
				() -> assertThat(car.getQtdeItems(), equalTo(4))
				);

	}

	@Test 
	public void testeValor() {
		assertThat(car.getValorTotal(), equalTo(300.00));
	}


	@Test 
	public void testeLimparCarrinho() {
		car.esvazia();
		Assertions.assertAll(
				() -> assertThat(car.getValorTotal(), equalTo(0.00)),
				() -> assertThat(car.getQtdeItems(), equalTo(0))
				);

	}
}