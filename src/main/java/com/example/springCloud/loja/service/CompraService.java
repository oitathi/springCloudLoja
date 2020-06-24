package com.example.springCloud.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springCloud.loja.client.FornecedorClient;
import com.example.springCloud.loja.dto.CompraDto;
import com.example.springCloud.loja.dto.InfoFornecedorDto;
import com.example.springCloud.loja.dto.InfoPedidoDto;
import com.example.springCloud.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private RestTemplate client; // com ribon e não com feign

	@Autowired
	private FornecedorClient fornecedorClient; // com feign

	public Compra realizaCompra(CompraDto compra) {

		String estado = compra.getEndereco().getEstado();
		/*
		 * primeira forma: ResponseEntity<InfoFornecedorDto> exchange =
		 * client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(),
		 * HttpMethod.GET, null, InfoFornecedorDto.class);
		 * 
		 * System.out.println(exchange.getBody().getEndereco());
		 */

		// segunda forma:

		LOG.info("buscando informações do fornecedor de {}", estado );
		InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("realizando um pedido");
		InfoPedidoDto pedido = fornecedorClient.realizaCompra(compra.getItens());

		Compra compraFeita = new Compra(pedido.getId(), pedido.getTempoDePreparo(), compra.getEndereco().toString());
		return compraFeita;

	}

}
