package io.github.antonio.api.controller.exception;

public class StandardError {

	private String timestamp;
	
	private String message;
	
	private String error;
	
	private Integer status;
	
	private String path;
	
	public StandardError() {
		
	}
	
	public StandardError(String timestamp, String message, String error, Integer status, String path) {
		this.message = message;
		this.error = error;
		this.status = status;
		this.path = path;
		this.timestamp = timestamp;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
