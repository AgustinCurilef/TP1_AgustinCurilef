package ejercicio1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ConcursoTest {
    public ConcursoTest() {
    }

    @Test
    public void test01() {
        Participante jose = new Participante("234566", "Jose Perez");
        LocalDate fechaLimite = LocalDate.now();
        Concurso unConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite.plusDays(3L));
        Inscripcion.inscribirAEn(jose, unConcurso);
        Assertions.assertTrue(unConcurso.participanteInscripto(jose));
        Assertions.assertEquals(1, unConcurso.cantidadInscriptos());
        Assertions.assertEquals(10, jose.obtenerPuntos());
    }

    @Test
    public void test02() {
        LocalDate fechaLimite = LocalDate.now();
        Concurso unConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite.plusDays(3L));
        Assertions.assertEquals(0, unConcurso.cantidadInscriptos());
    }

    @Test
    public void test03() {
        Participante jose = new Participante("234566", "Jose Perez");
        LocalDate fechaLimite = LocalDate.now();
        Concurso unConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite.plusDays(3L));
        Assertions.assertFalse(unConcurso.participanteInscripto(jose));
    }

    @Test
    public void test04() {
        Participante jose1 = new Participante("234566", "Jose Perez");
        Participante jose2 = new Participante("234566", "Jose Perez");
        LocalDate fechaLimite = LocalDate.now();
        Concurso unConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite.plusDays(3L));
        Inscripcion.inscribirAEn(jose1, unConcurso);
        Assertions.assertTrue(unConcurso.participanteInscripto(jose2));
        Assertions.assertEquals(1, unConcurso.cantidadInscriptos());
    }

    @Test
    public void test05() {
        Participante jose1 = new Participante("234566", "Jose Perez");
        Participante jorge = new Participante("698712", "Jorge Saldivar");
        LocalDate fechaLimite = LocalDate.now();
        Concurso unConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite.plusDays(3L));
        Inscripcion.inscribirAEn(jose1, unConcurso);
        Inscripcion.inscribirAEn(jorge, unConcurso);
        Assertions.assertTrue(unConcurso.participanteInscripto(jorge));
        Assertions.assertEquals(2, unConcurso.cantidadInscriptos());
    }

    @Test
    public void test06() {
        Participante jose1 = new Participante("234566", "Jose Perez");
        LocalDate fechaLimite = LocalDate.of(2020, 1, 1);
        Concurso unConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite);
        Inscripcion.inscribirAEn(jose1, unConcurso);
        Assertions.assertFalse(unConcurso.participanteInscripto(jose1));
        Assertions.assertEquals(0, unConcurso.cantidadInscriptos());
    }

    @Test
    public void test07() {
        Participante jose1 = new Participante("234566", "Jose Perez");
        LocalDate fechaLimite = LocalDate.now();
        Concurso unConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite.plusDays(3L));
        Concurso dosConcurso = new Concurso("Un Ejercicio1.Concurso", fechaLimite.plusDays(3L));
        Inscripcion.inscribirAEn(jose1, unConcurso);
        Inscripcion.inscribirAEn(jose1, dosConcurso);
        Assertions.assertTrue(unConcurso.participanteInscripto(jose1));
        Assertions.assertTrue(dosConcurso.participanteInscripto(jose1));
        Assertions.assertEquals(20, jose1.obtenerPuntos());
    }
}