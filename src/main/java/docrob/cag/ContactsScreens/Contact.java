package docrob.cag.ContactsScreens;

public class Contact {
    private String name;

    private String number;

    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }

    public static Contact createFromCSVString(String string){
        String [] parts = string.split(",");
        Contact contact = new Contact(parts[0], parts[1]);
        return contact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
