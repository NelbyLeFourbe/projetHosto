package sopra.promo404.hopital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "La mati�re n'a pu �tre valid�e")
public class PatientValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PatientValidationException() {
		super();
	}

	public PatientValidationException(String message) {
		super(message);
	}

}