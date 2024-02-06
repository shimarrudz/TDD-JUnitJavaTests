package br.com.shima;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockitoTests {

    @Test
    public void primeiroTesteMockito() {
        List<String> lista = Mockito.mock(ArrayList.class);

        Mockito.when(lista.size()).thenReturn(20);

        int size = lista.size();

        Assertions.assertThat(size).isEqualTo(20);
    }
}
