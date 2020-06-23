package com.example.springCloud.loja.dto;



import java.util.List;

public class CompraDto {
	
	private List<ItemDto> itens;
	private EnderecoDto endereco;
	
	
	public List<ItemDto> getItens() {
		return itens;
	}
	public void setItens(List<ItemDto> itens) {
		this.itens = itens;
	}
	public EnderecoDto getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}
	
	

}
