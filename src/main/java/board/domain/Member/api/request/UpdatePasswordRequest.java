package board.domain.Member.api.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UpdatePasswordRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String asIspassword;

    @NotBlank
    private String toBePassword;

}
