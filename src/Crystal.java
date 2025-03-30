/**
 * The Crystal class represents a crystal with a name.
 */
public class Crystal {

    private String name;

    public Crystal(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Crystal{" +
                "name='" + name + '\'' +
                '}';
    }
}
