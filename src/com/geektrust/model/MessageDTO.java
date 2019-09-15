package com.geektrust.model;

public class MessageDTO {

	private String kingdom;

	private String message;

	public MessageDTO(String kingdom, String message) {
		super();
		this.kingdom = kingdom;
		this.message = message;
	}

	public String getKingdom() {
		return kingdom;
	}

//	public void setKingdom(String kingdom) {
//		this.kingdom = kingdom;
//	}

	public String getMessage() {
		return message;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kingdom == null) ? 0 : kingdom.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageDTO other = (MessageDTO) obj;
		if (kingdom == null) {
			if (other.kingdom != null)
				return false;
		} else if (!kingdom.equals(other.kingdom))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

}
