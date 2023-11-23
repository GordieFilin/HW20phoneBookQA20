package dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UpdateContactDTO {
    String id;
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;
}
