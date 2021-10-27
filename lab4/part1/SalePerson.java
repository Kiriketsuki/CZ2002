package part1;
public class SalePerson implements Comparable<SalePerson>{

    private String firstName;
    private String lastName;
    private int totalSales;

    public SalePerson(String firstName, String lastName, int totalSales) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSales = totalSales;
    }

    public String toString() {
        String to_return = String.format("%s %s : %d", lastName, firstName, totalSales);
        return to_return;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getTotalSales() {
        return this.totalSales;
    }
    
    public Boolean equals(SalePerson person) {
        Boolean to_return = false;
        if (person.getFirstName() == this.firstName && person.getLastName() == this.lastName) {
            to_return = true;
        }

        return to_return;
    }

    @Override
    public int compareTo(SalePerson person) {
        int to_return = 0;

        if (this.equals(person)) {
            return to_return;
        }

        if (this.totalSales < person.getTotalSales()) {
            to_return = -1;
        } else if (this.totalSales > person.getTotalSales()) {
            to_return = 1;
        } else {
            to_return = person.getLastName().compareTo(this.lastName);
        }

        return to_return;
    }
    
}
