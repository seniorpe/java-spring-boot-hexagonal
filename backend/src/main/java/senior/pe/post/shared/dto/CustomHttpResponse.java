package senior.pe.post.shared.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CustomHttpResponse<T> implements Serializable {

    private static final long serialVersionUID = -6976215642294811763L;

    /**
     * RESPONSE EXAMPLE:
     * {
     *    "httpStatusCode": 404,
     *    "httpStatus": "NOT FOUND",
     *    "reason": "NOT FOUND",
     *    "data": "Clase con cód. 89 no existe",
     *    "timeStamp": "07-09-2021 00:55:18"
     * }
     */
    @NonNull
    private HttpStatus httpStatus;

    @NonNull
    private Integer httpStatusCode;

    @NonNull
    private String reason;

    @NonNull
    private T data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss", timezone = "America/Bogota")
    private Date timestamp = new Date();

}