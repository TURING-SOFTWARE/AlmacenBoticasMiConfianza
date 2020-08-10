package entidades;

import java.util.Date;

public class producto {
    int id;
    String producto;
    String presentacion;
    int lote;
    Date fecha_vencimiento;
    String info_producto;
    String estado_producto;
    Double precio_unid;
    Double precio_caja;

    public producto(int id, String producto, String presentacion, int lote, Date fecha_vencimiento, String info_producto, String estado_producto, Double precio_unid, Double precio_caja) {
        this.id = id;
        this.producto = producto;
        this.presentacion = presentacion;
        this.lote = lote;
        this.fecha_vencimiento = fecha_vencimiento;
        this.info_producto = info_producto;
        this.estado_producto = estado_producto;
        this.precio_unid = precio_unid;
        this.precio_caja = precio_caja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getInfo_producto() {
        return info_producto;
    }

    public void setInfo_producto(String info_producto) {
        this.info_producto = info_producto;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    public Double getPrecio_unid() {
        return precio_unid;
    }

    public void setPrecio_unid(Double precio_unid) {
        this.precio_unid = precio_unid;
    }

    public Double getPrecio_caja() {
        return precio_caja;
    }

    public void setPrecio_caja(Double precio_caja) {
        this.precio_caja = precio_caja;
    }
}
