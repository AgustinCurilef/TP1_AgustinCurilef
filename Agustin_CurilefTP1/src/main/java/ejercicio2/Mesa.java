package ejercicio2;

import excepcionesEjercicio2.MesaIncorrectaException;

public class Mesa {
    private final int numeroMesa;
    private final int capacidad;
    private Tarjeta tarjeta;
    private Pedido unPedido;

    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
    }

    public void realizarPedido(Pedido miPedido, PlatoPrincipal unPlato) throws MesaIncorrectaException {
        miPedido.tomarPedido(unPlato, this);
    }

    public void realizarPedido(Pedido miPedido, Bebida unaBebida) throws MesaIncorrectaException {
        miPedido.tomarPedido(unaBebida, this);

    }


    public void pagarCuenta(Pedido miPedido, Tarjeta miTarjeta, Propina propina) {
        miTarjeta.realizarPago(miPedido, propina);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Mesa mesa)) {
            return false;
        } else {
            return this.numeroMesa == mesa.numeroMesa && this.capacidad == mesa.capacidad;
        }
    }
}