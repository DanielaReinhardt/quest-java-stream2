import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Shield {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Phil Coulson");
        names.add("Melinda May");
        names.add("Daisy Johnson");
        names.add("Leopold Fitz");
        names.add("Jemma Simmons");

        // TODO 1 : map names to agents list
        //Arrays.toString(names.split(" "));
        //braucht man nicht
        // String [] splitted = names.split(" ");
        // String firstname = splitted[0];
        // String lastname = splitted[1];

        List<Agent> agents = new ArrayList<>();
        agents = names.stream()
                .map(new Function<String, Agent>() {
                   
                    @Override
                    public Agent apply(String t) {
                        String[] splitName = t.split(" ");
                        return new Agent(splitName[0], splitName[1]);
                    }
                    
                })
                .collect(Collectors.toList());

        //names.stream().forEach(name -> {
        //    String[] splitName = name.split(" ");
        //    System.out.println(String.format("First name: %s", splitName[0]));
        //    System.out.println(String.format("Last name: %s", splitName[1]));
        //});


        //Und hier ist das in Lambda:
        //agents = names.stream().map(name -> {
        //    return new Agent("firstName", "lastName");
        //}).collect(Collectors.toList());

        showAgents(agents);
    }

    // don't touch anything here !
    private static void showAgents(List<Agent> agents) {
        System.out.println("\nAgents:");
        for (Agent agent : agents) {
            System.out.println(agent.getLastName() + " " + agent.getFirstName());
        }
    }
}