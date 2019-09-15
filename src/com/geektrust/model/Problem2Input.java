package com.geektrust.model;

public class Problem2Input {
	
	private String fromKingdom;
	
	private String toKingdom;
	
	private String message;

	public Problem2Input(String fromKingdom, String toKingdom, String message) {
		super();
		this.fromKingdom = fromKingdom;
		this.toKingdom = toKingdom;
		this.message = message;
	}

	public String getFromKingdom() {
		return fromKingdom;
	}

	public void setFromKingdom(String fromKingdom) {
		this.fromKingdom = fromKingdom;
	}

	public String getToKingdom() {
		return toKingdom;
	}

	public void setToKingdom(String toKingdom) {
		this.toKingdom = toKingdom;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromKingdom == null) ? 0 : fromKingdom.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((toKingdom == null) ? 0 : toKingdom.hashCode());
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
		Problem2Input other = (Problem2Input) obj;
		if (fromKingdom == null) {
			if (other.fromKingdom != null)
				return false;
		} else if (!fromKingdom.equals(other.fromKingdom))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (toKingdom == null) {
			if (other.toKingdom != null)
				return false;
		} else if (!toKingdom.equals(other.toKingdom))
			return false;
		return true;
	}

}
