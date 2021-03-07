
package gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceId"
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationItemRequest implements Serializable
{

    @JsonProperty("resourceId")
    public Integer resourceId;
    private final static long serialVersionUID = 7624135308184623738L;

}
