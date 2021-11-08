package nl.koenm.chiefcount.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppUserRequest {

//    private String firstName;
//    private String lastName;
    private String username;
    private String password;
}
