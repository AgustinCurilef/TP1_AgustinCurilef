package ejercicio1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Inscripcion {
    private static int puntosAsumar;
    private final Participante participante;
    private Concurso concurso;
    private LocalDateTime fechaInscripcion;

    private Inscripcion(Participante participante, Concurso concurso, LocalDateTime fechaInscripcion) {
        this.participante = participante;
        this.concurso = concurso;
        this.fechaInscripcion = fechaInscripcion;
        puntosAsumar = 10;
    }

    public static void inscribirAEn(Participante unParticipante, Concurso unConcurso) {
        if (!unConcurso.puedeInscribirse(LocalDate.now())) {
            Inscripcion nuevaInscripcion = new Inscripcion(unParticipante, unConcurso, LocalDateTime.now());
            unConcurso.nuevaInscripcion(nuevaInscripcion);
            if (unConcurso.primerDiaInscripcion(LocalDate.now())) {
                unParticipante.sumarPuntos(puntosAsumar);
            }
        } else {
            System.out.println("Lo sentimos, el período de inscripción ha expirado. Ya no se pueden aceptar inscripciones.");
        }

    }

    public boolean estaInscripto(Participante participante) {
        return this.participante.equals(participante);
    }
}