package senior.pe.post.shared.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import senior.pe.post.shared.dto.CustomHttpResponse;

public class BuildResponse {

    public static <T> ResponseEntity<CustomHttpResponse<T>> customResponse(
            T data, HttpStatus httpStatus, MultiValueMap<String, String> headers
    ) {
        CustomHttpResponse<T> response =
                new CustomHttpResponse<>(httpStatus, httpStatus.value(), httpStatus.getReasonPhrase(), data);
        return new ResponseEntity<>(response, headers, httpStatus);
    }

    public static <T> ResponseEntity<CustomHttpResponse<T>> customResponse(T data, HttpStatus httpStatus) {
        CustomHttpResponse<T> response =
                new CustomHttpResponse<>(httpStatus, httpStatus.value(), httpStatus.getReasonPhrase(), data);
        return new ResponseEntity<>(response, httpStatus);
    }

}