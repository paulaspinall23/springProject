package com.example.springproject.response;

import com.example.springproject.services.InsecureHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MusicBrainzAPI {

    public static List<MusicBrainzAlbum> getAlbums(String id) throws Exception {
//        String url = "https://musicbrainz.org/ws/2/release-group/?fmt=json&query=arid:614e3804-7d34-41ba-857f-811bad7c2b7a%20status:official%20primarytype:album%20NOT%20status:bootleg%20NOT%20primarytype:single";
        String url = "https://musicbrainz.org/ws/2/release-group/?fmt=json&query=arid:"+id+"%20status:official%20primarytype:album%20NOT%20status:bootleg%20NOT%20primarytype:single";

        HttpClient client = InsecureHttpClient.build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        ReleaseGroupResponse map = new ObjectMapper().readValue(body, ReleaseGroupResponse.class);
        return map.getReleaseGroups();

    }

    public static String getApiResponse(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        return content.toString();
    }
}
