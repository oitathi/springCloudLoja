package com.example.springCloud.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springCloud.loja.dto.InfoFornecedorDto;
import com.example.springCloud.loja.dto.InfoPedidoDto;
import com.example.springCloud.loja.dto.ItemDto;



@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

	@RequestMapping( method = RequestMethod.POST, value="/pedido")
	InfoPedidoDto realizaCompra(List<ItemDto> itens);
}
