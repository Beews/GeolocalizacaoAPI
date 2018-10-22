package com.wesley.uol.exeption;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.beews.webstart.util.StringUtil;
import com.wesley.uol.dto.ErroDTO;
import com.wesley.uol.util.MsgProperties;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

	@Autowired
	MsgProperties msgProperties;

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<ErroDTO> handleCustomExceptions(CustomException ex, WebRequest request) {
		String menssagem = msgProperties.getMenssagem(ex.getProp(), ex.getParam());
		ErroDTO errorDetails = new ErroDTO(LocalDateTime.now(), menssagem, request.getLocale().getDisplayName(),
				getTipoDeException(ex));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DataAccessResourceFailureException.class)
	public final ResponseEntity<ErroDTO> handleCustomDataAccessResourceFailureException(DataAccessResourceFailureException ex, WebRequest request) {
		ErroDTO errorDetails = new ErroDTO(
				LocalDateTime.now(),
				"Não conseguiu conectar com o banco de dados", 
				ex.getMessage(),
				getTipoDeException(ex));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErroDTO> handleAllExceptions(Exception ex, WebRequest request) {
		ErroDTO errorDetails = new ErroDTO(LocalDateTime.now(), ex.getMessage(), request.getLocale().getDisplayName(),
				getTipoDeException(ex));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	private String getTipoDeException(Exception ex) {
		if(ex.getClass().getSimpleName().equals(Exception.class.getSimpleName()))
			return "Erro Interno";
		return StringUtil.splitCamelCase(ex.getClass().getSimpleName()).replace("Exception", "").trim();
	}

}
