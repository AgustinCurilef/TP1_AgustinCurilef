package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private final String nombre;
    private List<Inscripcion> inscriptos;
    private LocalDate fechaLimite;
    private LocalDate fechaInicio;

    public Concurso(String nombre, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.fechaLimite = fechaLimite;
        this.fechaInicio = LocalDate.now();
        this.inscriptos = new ArrayList();
    }

    public boolean participanteInscripto(Participante participante) {
        return this.inscriptos.stream().anyMatch((inscripcion) -> {
            return inscripcion.estaInscripto(participante);
        });
    }

    public void nuevaInscripcion(Inscripcion inscripcion) {
        this.inscriptos.add(inscripcion);
    }

    public int cantidadInscriptos() {
        return this.inscriptos.size();
    }

    public boolean puedeInscribirse(LocalDate fechaInscripcion) {
        return fechaInscripcion.isBefore(this.fechaInicio) || fechaInscripcion.isAfter(this.fechaLimite);
    }

    public boolean primerDiaInscripcion(LocalDate fechaIncripcion) {
        return fechaIncripcion.isEqual(this.fechaInicio);
    }
}
