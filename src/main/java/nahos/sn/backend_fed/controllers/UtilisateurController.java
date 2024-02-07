package nahos.sn.backend_fed.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nahos.sn.backend_fed.dtos.AuthenticationDto;
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

    @PostMapping("/login")
    public Map<String,String> connexion(@RequestBody AuthenticationDto authenticationDto)
    {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDto.username(), authenticationDto.password())
        );
        log.info("object {}",authenticate);
        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authenticationDto.username());
        }
        return null;
    }

}
