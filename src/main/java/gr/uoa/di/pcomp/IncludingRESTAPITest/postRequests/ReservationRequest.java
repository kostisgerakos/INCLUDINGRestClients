
package gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"reservationId",
    "validFrom",
    "validUntil",
    "username",
    "testbedAreaId",
    "reservationItems"
})
@NoArgsConstructor
@Getter
@Setter
public class ReservationRequest implements Serializable
{
    @JsonProperty("reservationId")
    public Integer reservationId;
    @JsonProperty("validFrom")
    public String validFrom;
    @JsonProperty("validUntil")
    public String validUntil;
    @JsonProperty("username")
    public String username;
    @JsonProperty("testbedAreaId")
    public Integer testbedAreaId;
    @JsonProperty("reservationItems")
    public List<ReservationItemRequest> reservationItems = null;
    private final static long serialVersionUID = -3084891918047542548L;

}
