package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    private Long id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vendor_url")
    private String verdorUrl;
}
