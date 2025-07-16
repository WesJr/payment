package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.ItemPedido;
import br.com.fiap.fastfood.payment.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ItemServiceTests {

    @Test
    void testSaveAllItens() {
        ItemRepository repository = Mockito.mock(ItemRepository.class);
        ItemService itemService = new ItemService(repository);

        List<ItemPedido> inputList = getItemPedidos();

        Mockito.when(repository.saveAll(any())).thenReturn(inputList);

        List<ItemPedido> result = itemService.saveAll(inputList);

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getSkuNumber()).isEqualTo("SKU-1");
        assertThat(result.get(1).getSkuNumber()).isEqualTo("SKU-2");

        Mockito.verify(repository).saveAll(inputList);
    }

    private static List<ItemPedido> getItemPedidos() {
        ItemPedido item1 = new ItemPedido();
        item1.setSkuNumber("SKU-1");
        item1.setTitle("Produto 1");
        item1.setUnitPrice(new BigDecimal("100.00"));
        item1.setQuantity(1);
        item1.setTotalAmount(new BigDecimal("100.00"));

        ItemPedido item2 = new ItemPedido();
        item2.setSkuNumber("SKU-2");
        item2.setTitle("Produto 2");
        item2.setUnitPrice(new BigDecimal("200.00"));
        item2.setQuantity(2);
        item2.setTotalAmount(new BigDecimal("400.00"));

        return List.of(item1, item2);
    }
}
