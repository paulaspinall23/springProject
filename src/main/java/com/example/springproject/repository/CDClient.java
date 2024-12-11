//package com.example.springproject.repository;
//
//import com.example.springproject.dto.CDDTO;
//import com.example.springproject.exceptions.CDClientException;
//import com.example.springproject.response.MusicBrainzAPI;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//
//@Slf4j
//@Service
//public class CDClient {
//
//    private final RestTemplate restTemplate;
//
//    public CDClient(final RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public MusicBrainzAPI<CDDTO> getAlbums() {
//        final ParameterizedTypeReference<MusicBrainzAPI<CDDTO>> cdResponseAlbums = new ParameterizedTypeReference<MusicBrainzAPI<CDDTO>>() {
//        };
//        try {
//            final ResponseEntity<MusicBrainzAPI<CDDTO>> response = restTemplate.exchange(
//                        "https://api.spotify.com/v1/artists/0WwSkZ7LtFUFjGjMZBMt6T/albums?include_groups=album&market=GB&limit=20&offset=0", HttpMethod.GET, null, cdResponseAlbums);
//
//            if (!response.getStatusCode().is2xxSuccessful()) {
//                log.debug(response.getBody().toString());
//                throw new CDClientException("Non 200 response from CD API");
//            }
//
//            return response.getBody();
//        } catch (RestClientException ex) {
//            throw new CDClientException(ex);
//        }
//    }
//
//    private static final String URL = "https://api.spotify.com/v1/artists/0WwSkZ7LtFUFjGjMZBMt6T/albums?include_groups=album&market=GB&limit=20&offset=0";
//
//    public Object getTest(String token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + token);
//        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//
//        ResponseEntity<Object> response = restTemplate.exchange(URL, HttpMethod.GET, entity,
//                Object.class);
//        LinkedHashMap result = (LinkedHashMap) response.getBody();
//
//        ArrayList items = (ArrayList) result.get("items");
//
//        if (items.size() == 0) {
//            throw new RuntimeException();
//        }
//
//        return result;
//    }
//}
