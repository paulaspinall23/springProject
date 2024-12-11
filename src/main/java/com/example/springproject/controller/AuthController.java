//package com.example.springproject.controller;
//
//
//import com.example.springproject.config.Keys;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import se.michaelthelin.spotify.SpotifyApi;
//import se.michaelthelin.spotify.SpotifyHttpManager;
//import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
//import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
//import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
//import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
//
//import java.io.IOException;
//import java.net.URI;
//
//@Controller
//@RequestMapping("/api")
//public class AuthController {
//
//    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/api/get-user-code");
//    private String code = "";
//
//    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
//            .setClientId(Keys.CLIENT_ID.getKey())
//            .setClientSecret(Keys.CLIENT_SECRET.getKey())
//            .setRedirectUri(redirectUri)
//            .build();
//
//    @GetMapping("login")
//    public String spotifyLogin() {
//        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
//                .scope("user-read-private, user-read-email,user-top-read")
//                .show_dialog(true)
//                .build();
//        final URI uri = authorizationCodeUriRequest.execute();
//        return "redirect:" + uri.toString();
//    }
//
//    @GetMapping(value = "get-user-code")
//    public String getSpotifyUserCode(@RequestParam("code") String userCode, HttpServletResponse response) throws IOException {
//        code = userCode;
//        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
//                .build();
//
//        try {
//            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();
//
//            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
//            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
//
//            System.out.println("Access token: " + authorizationCodeCredentials.getAccessToken());
//            System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
//        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        response.sendRedirect("http://localhost:8080/artistlist");
//        return spotifyApi.getAccessToken();
//    }
//
//
//}
