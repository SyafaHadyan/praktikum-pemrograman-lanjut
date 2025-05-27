import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

class ParticipantRepository {
    private static Set<Participant> participantList;

    private ParticipantRepository() {
    }

    public static Set<Participant> getInstance() {
        if (participantList == null) {
            participantList = new HashSet<>();
        }

        return participantList;
    }

    public static Iterator<Participant> getIterator() {
        return participantList.iterator();
    }

    public static void addParticipant(Participant... participants) {
        for (Participant participant : participants) {
            if (participant != null) {
                participantList.add(participant);
            }
        }
    }
}

class Participant {
    private static Set<String> participantUsernames = new HashSet<>();

    private UUID userID;
    private String username;
    private LocalDateTime createdAt;

    public Participant(String username) {
        if (participantUsernames.add(username.toLowerCase())) {
            setUserID(UUID.randomUUID());
            setUsername(username);
            setCreatedAt(LocalDateTime.now());

            ParticipantRepository.addParticipant(this);
        }
    }

    private void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getUserID() {
        return this.userID;
    }

    public String getUsername() {
        return this.username;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String toString() {
        return String.format(
                "User ID:\t%s\nUsername:\t%s\nCreated At:\t%s\n",
                getUserID(),
                getUsername(),
                getCreatedAt());
    }
}

class App {
    class ParticipantHandler {
        public static void register() {
            String username = getInput("Username: ");

            new Participant(username);
        }

        public static void search() {
            Iterator<Participant> participantIterator = ParticipantRepository.getIterator();

            String query = getInput("Query: ");

            while (participantIterator.hasNext()) {
                Participant currentParticipant = participantIterator.next();

                if (currentParticipant.getUsername().toLowerCase().contains(query.toLowerCase())) {
                    System.out.println(currentParticipant);
                }
            }
        }

        public static void display() {
            Iterator<Participant> participantIterator = ParticipantRepository.getIterator();

            while (participantIterator.hasNext()) {
                System.out.println(participantIterator.next());
            }
        }
    }

    private static final List<String> COMMAND_LIST = new ArrayList<>(
            Arrays.asList(
                    "Register",
                    "Search username",
                    "Display list",
                    "Quit"));

    private static Scanner scanner;

    public static void start() {
        init();
        startMasterRoutine();
    }

    public static void shutdown() {
        scanner.close();
    }

    private static void init() {
        scanner = new Scanner(System.in);
        ParticipantRepository.getInstance();
        ParticipantRepository.getIterator();
    }

    private static String getInput() {
        return getInput("$ ");
    }

    private static String getInput(String prefix) {
        System.out.print(prefix);

        return scanner.nextLine();
    }

    private static void startMasterRoutine() {
        int option;

        while (true) {
            for (int i = 0; i < COMMAND_LIST.size(); i++) {
                System.out.printf(
                        "[%d] %s\n",
                        i,
                        COMMAND_LIST.get(i));
            }

            try {
                option = Integer.parseUnsignedInt(getInput());
            } catch (NumberFormatException e) {
                option = -1;
            }

            switch (option) {
                case 0:
                    ParticipantHandler.register();
                    break;
                case 1:
                    ParticipantHandler.search();
                    break;
                case 2:
                    ParticipantHandler.display();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}

public class Register {
    public static void main(String[] args) {
        App.start();
        App.shutdown();
    }
}
