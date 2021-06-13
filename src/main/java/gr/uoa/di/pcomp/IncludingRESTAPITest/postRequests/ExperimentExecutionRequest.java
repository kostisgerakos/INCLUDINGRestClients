package gr.uoa.di.pcomp.IncludingRESTAPITest.postRequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "experimentExecutionId", "startExecution", "endExecution", "experimentStatus", "experimentId" })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExperimentExecutionRequest {

	@JsonProperty("experimentExecutionId")
	private Integer experimentExecutionId;
	@JsonProperty("startExecution")
	private String startExecution;
	@JsonProperty("endExecution")
	private String endExecution;
	@JsonProperty("experimentStatus")
	private Integer experimentStatus;
	@JsonProperty("experimentId")
	private Integer experimentId;
}
