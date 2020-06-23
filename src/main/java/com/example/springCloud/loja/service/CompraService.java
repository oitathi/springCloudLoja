package com.example.springCloud.loja.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springCloud.loja.client.FornecedorClient;
import com.example.springCloud.loja.dto.CompraDto;
import com.example.springCloud.loja.dto.InfoFornecedorDto;
import com.example.springCloud.loja.dto.InfoPedidoDto;
import com.example.springCloud.loja.model.Compra;



@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client; //com ribon e não com feign
	
	@Autowired
	private FornecedorClient fornecedorClient; // com feign

	public Compra realizaCompra(CompraDto compra) {
		
		/* primeira forma: 
		ResponseEntity<InfoFornecedorDto> exchange =   client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(),
				HttpMethod.GET, null, InfoFornecedorDto.class);
		
		System.out.println(exchange.getBody().getEndereco());
		 */

		// segunda forma: 
		
		
		InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		InfoPedidoDto pedido = fornecedorClient.realizaCompra(compra.getItens());
		
		Compra compraFeita = new Compra(pedido.getId(),pedido.getTempoDePreparo(),compra.getEndereco().toString());
		return compraFeita;
		
	}

}
