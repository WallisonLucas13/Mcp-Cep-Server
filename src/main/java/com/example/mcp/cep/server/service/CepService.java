package com.example.mcp.cep.server.service;

import com.example.mcp.cep.server.models.CepAddressDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CepService {

    private final RestClient restClient;
    private final String VIACEP_URL;
    private final String DISTANCEMATRIX_URL;
    private final String DISTANCEMATRIX_APIKEY;

    public CepService(@Value("${api.viacep.url}") String baseUrl,
                      @Value("${api.distancematrix.url}") String distanceMatrixUrl,
                      @Value("${api.distancematrix.apikey}") String apikey) {
        this.VIACEP_URL = baseUrl;
        this.DISTANCEMATRIX_URL = distanceMatrixUrl;
        this.DISTANCEMATRIX_APIKEY = apikey;
        this.restClient = RestClient.create();
    }

    public CepAddressDetails getAddressDetails(String cep) {
        var uri = String.format("%s/%s/json/", VIACEP_URL, cep);

        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(CepAddressDetails.class);
    }

    public Object getGeocodeAccurate(String address) {
        String params = String.format("address=%s&key=%s", address, DISTANCEMATRIX_APIKEY);
        var uri = String.format("%s/geocode/json?%s", DISTANCEMATRIX_URL, params);

        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(Object.class);
    }

    public Object getDistanceMatrixAccurate(String origins, String destinations) {
        String params = String.format("origins=%s&destinations=%s&key=%s", origins, destinations, DISTANCEMATRIX_APIKEY);
        var uri = String.format("%s/distancematrix/json?%s", DISTANCEMATRIX_URL, params);

        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(Object.class);
    }
}
