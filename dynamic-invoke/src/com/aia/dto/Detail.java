package com.aia.dto;
/**
 * @author Way Liang ASNPHXW
 *
 * @date Jul 3, 2018 
 *
 * @description:
 *
 */
public class Detail {
	private String step="";
	
	private String description="";
	
	private String status="";
	
	private String message="";

	public Detail() {
		super();
	}
	
	


	public Detail(String step, String description, String status, String message) {
		super();
		this.step = step;
		this.description = description;
		this.status = status;
		this.message = message;
	}


	


	public String getStep() {
		return step;
	}




	public void setStep(String step) {
		this.step = step;
	}




	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Detail [description=" + description + ", status=" + status
				+ ", message=" + message + "]";
	}
	
	
}
