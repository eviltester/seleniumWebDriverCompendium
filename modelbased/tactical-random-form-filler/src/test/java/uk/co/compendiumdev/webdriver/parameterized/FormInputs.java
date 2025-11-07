package uk.co.compendiumdev.webdriver.parameterized;

public class FormInputs {

    public String firstname="";
    public String lastname="";
    public String age="";
    public String country="";
    public String notes="";

    public FormInputs() {
    }

    public String toString(){
        return String.format("firstname %s lastname %s age %s counry %s notes %s",
                this.firstname, this.lastname, this.age, this.country, this.notes);
    }

    public static FormInputs create(String firstname, String lastname, String age, String country, String notes) {
        FormInputs inputs = new FormInputs();
        inputs.firstname = firstname;
        inputs.lastname = lastname;
        inputs.age = age;
        inputs.country = country;
        inputs.notes = notes;
        return inputs;
    }
}
