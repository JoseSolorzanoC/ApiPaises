package uteq.appdist.apipaises.soapws.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ServiceResponse implements DBResponse {

    private int status;
    private int identif;
    private String additionalMessage;

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int getIdentif() {
        return identif;
    }

}
