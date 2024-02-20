package nahos.sn.backend_fed.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nahos.sn.backend_fed.dtos.AuthenticationDto;
import nahos.sn.backend_fed.dtos.AuthenticationResponse;
import nahos.sn.backend_fed.entities.Utilisateur;
import nahos.sn.backend_fed.security.JwtService;
import nahos.sn.backend_fed.services.UtilisateurService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class UtilisateurController {

    private UtilisateurService utilisateurService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @PostMapping("/signup")
    public void inscription(@RequestBody Utilisateur utilisateur)
    {
        this.utilisateurService.inscription(utilisateur);
    }

   /* @PostMapping("/login")
    public Map<String,String> connexion(@RequestBody AuthenticationDto authenticationDto)
    {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDto.username(), authenticationDto.password())
        );

        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authenticationDto.username());
        }
        return null;
    }*/

    @PostMapping("/login")
    public AuthenticationResponse connexion(@RequestBody AuthenticationDto authenticationDto)
    {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDto.username(), authenticationDto.password())
        );

        if(authenticate.isAuthenticated()) {
            AuthenticationResponse response = new AuthenticationResponse();
            Utilisateur user = utilisateurService.loadUserByUsername(authenticationDto.username());
            String jwtS = this.jwtService.generate(authenticationDto.username()).toString();
            final String jwt = jwtS.substring(8);

            response.setJwt(jwt);
            response.setUser_id(user.getUser_id());
            response.setRole_user(String.valueOf(user.getRole().getLibelle()));

            return response;
        }
        return null;
    }

}
