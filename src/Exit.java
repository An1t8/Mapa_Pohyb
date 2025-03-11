public class Exit extends Command{
    @Override
    public String execute() {
        return "Thank you for playing!";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
