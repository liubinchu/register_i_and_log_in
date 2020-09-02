package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liubi
 * @date 2020-09-01 22:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer UserId;
    private String UserName;
    private String password;
}
