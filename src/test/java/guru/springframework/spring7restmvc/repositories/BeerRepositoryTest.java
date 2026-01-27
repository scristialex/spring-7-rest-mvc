package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Beer;
import guru.springframework.spring7restmvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
                    Beer savedBeer = beerRepository.save(Beer.builder()
                            .beerName("New name 12345678901234567890123456789012345678901234567890")
                            .beerStyle(BeerStyle.LAGER)
                            .upc("12334234")
                            .price(new BigDecimal("11.99"))
                            .build());

                    beerRepository.flush();
                }
                );



    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("New name")
                        .beerStyle(BeerStyle.LAGER)
                        .upc("12334234")
                        .price(new BigDecimal("11.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}