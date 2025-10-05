package com.example.mcp.cep.server.tool;

import com.example.mcp.cep.server.models.CepAddressDetails;
import com.example.mcp.cep.server.service.CepService;
import com.example.mcp.cep.server.utils.ConvertObjectToStringUtil;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

@Service
public class McpCepTools {

    private final CepService cepService;

    public McpCepTools(CepService cepService) {
        this.cepService = cepService;
    }

    @McpTool(
            name = "cep_address_details",
            description = "Busca detalhes de endereço a partir do CEP fornecido."
    )
    public CepAddressDetails getAddressDetails(@McpToolParam(description = "Cep") String cep) {
        return cepService.getAddressDetails(cep);
    }

    @McpTool(
            name = "geocode_accurate",
            description = "Busca coordenadas geográficas precisas a partir do endereço fornecido."
    )
    public String getGeocodeAccurate(@McpToolParam(description = "Endereço") String address) {
        return ConvertObjectToStringUtil.convert(cepService.getGeocodeAccurate(address));
    }

    @McpTool(
            name = "distance_matrix_accurate",
            description = "Calcula a matriz de distância entre as origens e destinos fornecidos."
    )
    public String getDistanceMatrixAccurate(
            @McpToolParam(description = "Origens") String origins,
            @McpToolParam(description = "Destinos") String destinations) {
        return ConvertObjectToStringUtil.convert(cepService.getDistanceMatrixAccurate(origins, destinations));
    }
}
