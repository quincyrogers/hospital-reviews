package org.wecancodeit.movingcompanyreviews;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Mover Not Found")
public class MoverNotFoundException extends Exception {

}