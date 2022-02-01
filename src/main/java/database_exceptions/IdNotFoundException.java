package database_exceptions;
public class IdNotFoundException extends Exception{
	String s;
	public IdNotFoundException(String s){
		this.s=s;
	}
	public String getMessage() {
		return s;
	}
}
