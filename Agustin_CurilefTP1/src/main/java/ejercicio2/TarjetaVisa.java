package ejercicio2;

public class TarjetaVisa extends Tarjeta {
    private Double descuento = 0.03;

    public TarjetaVisa(String titular, int codigo) {
        super("Visa", titular, codigo);
    }

    public double aplicarDescuento(Pedido pedido) {
        Double descuentoBebida = pedido.calcularBebidas() * this.descuento;
        return descuentoBebida;
    }
}