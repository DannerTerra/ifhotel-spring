package br.edu.ifrs.canoas.lds.webapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ifrs.canoas.lds.webapp.domain.PessoaFisica;
import br.edu.ifrs.canoas.lds.webapp.domain.Reserva;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ReservaRepository repository;

    private final String TEST_STRING = "Test String";
    private final Double TEST_DOUBLE = 100.0;
    
    

    @Test
    public void when_FindByThemeContaining_then_ReturnTermPaper(){

        // given
    	
    	PessoaFisica cliente = new PessoaFisica();
    	cliente.setNome("usuario");
    	cliente.setCpf("123456");
    	entityManager.persist(cliente);
    	entityManager.flush();
        
        Reserva reserva = new Reserva();
        reserva.setValor(TEST_DOUBLE);
        reserva.setCliente(cliente);
        entityManager.persist(reserva);
        entityManager.flush();

        // when
        Optional<Reserva> found = repository.findByCliente(cliente);

        // then
        assertThat(found.get().getCliente().getNome()).isEqualTo("usuario");
    }

    @Test
    public void given_noData_when_FindByThemeContaining_then_ReturnEmptyList(){

        // given

        // when
        Optional<Reserva> found = repository.findByCliente(null);

        // then
        assertThat(found).isEmpty();
    }

}