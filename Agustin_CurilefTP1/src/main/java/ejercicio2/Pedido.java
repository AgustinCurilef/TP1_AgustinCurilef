package ejercicio2;

import excepcionesEjercicio2.MesaIncorrectaException;

import java.util.ArrayList;
import java.util.Iterator;

public class Pedido {
    private static int contadorPedido = 0;
    private final int numero;
    private final Mesa mesaCliente;
    private final ArrayList<Bebida> bebidas;
    private final ArrayList<PlatoPrincipal> platos;
    private Double factura;
    private Double propina;

    public Pedido(Mesa mesaCliente) {
        this.mesaCliente = mesaCliente;
        this.bebidas = new ArrayList<>();
        this.platos = new ArrayList<>();
        ++contadorPedido;
        this.numero = contadorPedido;
        this.factura = 0.0;
        this.propina = 0.0;
    }

    public int numeroPedido() {
        return this.numero;
    }

    public void tomarPedido(PlatoPrincipal unPlato, Mesa mesaPedido) throws MesaIncorrectaException {
        if (this.chequearMesa(mesaPedido)) {
            this.platos.add(unPlato);
            this.factura = this.factura + unPlato.precio();
        } else {
            throw new MesaIncorrectaException("Esta mesa no coincide con numero de mesa del pedido.");
        }
    }

    void tomarPedido(Bebida unaBebida, Mesa mesaPedido) throws MesaIncorrectaException {
        if (this.chequearMesa(mesaPedido)) {
            this.bebidas.add(unaBebida);
            this.factura = this.factura + unaBebida.precio();
        } else {
            throw new MesaIncorrectaException("Esta mesa no coincide con numero de mesa del pedido.");
        }
    }

    public int cantidadPlatosPedidos() {
        return this.platos.size();
    }

    public int cantidadBebidasPedidas() {
        return this.bebidas.size();
    }

    public Double calcularTotal(Tarjeta tarjeta) {
        double descuento = tarjeta.aplicarDescuento(this);
        return this.factura - descuento;
    }

    Double calcularBebidas() {
        double totalBebidas = 0.0;

        Bebida bebida;
        for (Iterator<Bebida> var2 = this.bebidas.iterator(); var2.hasNext(); totalBebidas = totalBebidas + bebida.precio()) {
            bebida = var2.next();
        }

        return totalBebidas;
    }

    Double calcularPlatos() {
        double totalPlatos = 0.0;

        PlatoPrincipal plato;
        for (Iterator<PlatoPrincipal> var2 = this.platos.iterator(); var2.hasNext(); totalPlatos = totalPlatos + plato.precio()) {
            plato = var2.next();
        }

        return totalPlatos;
    }

    void cancelarCuenta(Double pago, Double propina) {
        this.factura = this.factura - pago;
        this.propina = propina;
    }

    private boolean chequearMesa(Mesa mesaPedido) {
        return mesaPedido.equals(this.mesaCliente);
    }

    public Double obtenerFactura() {
        return this.factura;
    }

    public Double obtenerPropina() {
        return this.propina;
    }
}