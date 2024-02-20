package nahos.sn.backend_fed.dtos;

import lombok.Data;

@Data
public class AuthenticationResponse {

    String jwt;
    String role_user;
    Long user_id;
}
