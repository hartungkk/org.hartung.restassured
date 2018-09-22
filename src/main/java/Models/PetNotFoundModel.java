package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.util.Objects;

@Generated("com.robohorse.robopojogenerator")
public class PetNotFoundModel {

	@JsonProperty("code")
	private String code;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PetNotFoundModel)) return false;
		PetNotFoundModel that = (PetNotFoundModel) o;
		return Objects.equals(code, that.code) &&
				Objects.equals(type, that.type) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {

		return Objects.hash(code, type, message);
	}

	@Override
 	public String toString(){
		return 
			"PetNotFoundModel{" +
			"code = '" + code + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}