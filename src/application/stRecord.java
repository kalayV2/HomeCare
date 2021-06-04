package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class stRecord {

	private final StringProperty id;
	private final StringProperty name;
	private final StringProperty gender;
	private final StringProperty position;
	private final StringProperty shift;

	public stRecord() {
		id = new SimpleStringProperty(this,"staffId");
		name = new SimpleStringProperty(this,"sName");
		gender = new SimpleStringProperty(this,"sGender");
		position = new SimpleStringProperty(this,"sPosition");
		shift = new SimpleStringProperty(this,"shift");
		
	}
	
	public StringProperty IDpro() {return id;}
	public String getID() {return id.get();}
	public void setID(String newid) {id.set(newid);}
	
	public StringProperty Namepro() {return name;}
	public String getName() {return name.get();}
	public void setName(String newid) {name.set(newid);}
	
	public StringProperty Genpro() {return gender;}
	public String getGender() {return gender.get();}
	public void setGedner(String newid) {gender.set(newid);}
	
	public StringProperty Pospro() {return position;}
	public String getPos() {return position.get();}
	public void setPos(String newid) {position.set(newid);}
	
	public StringProperty Shipro() {return shift;}
	public String getShift() {return shift.get();}
	public void setShift(String newid) {shift.set(newid);}

	public String toString() {
		return String.format("%s[id=%s,name=%s]", getID(),getName(),getGender(),getPos(),getShift());
	}



}
