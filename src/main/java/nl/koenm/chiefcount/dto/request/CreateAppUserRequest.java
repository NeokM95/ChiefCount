package nl.koenm.chiefcount.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppUserRequest {

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter a valid email")
    private String email;

    @Size(min = 4, max = 20, message = "Enter username between 4-20 characters")
    private String username;

    @Size(min = 8, max = 20, message = "Password should be at least 8 characters")
    private String password;

}
