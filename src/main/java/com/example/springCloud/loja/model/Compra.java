package com.example.springCloud.loja.model;

public class Compra {

	private Long pedido_id;
	private int tempoDePreparo;
	private String enderecoDestino;

	public Compra() {
	}

	public Compra(Long pedido_id, int tempoDePreparo, String enderecoDestino) {
		this.pedido_id = pedido_id;
		this.tempoDePreparo = tempoDePreparo;
		this.enderecoDestino = enderecoDestino;
	}

	public Long getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(Long pedido_id) {
		this.pedido_id = pedido_id;
	}

	public int getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(int tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

}
