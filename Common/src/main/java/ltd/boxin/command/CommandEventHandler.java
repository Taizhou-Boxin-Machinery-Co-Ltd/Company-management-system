package ltd.boxin.command;

import java.util.*;

public class CommandEventHandler {
    public static final Map<String, Command> command = new HashMap<>();

    //记录
    public static class Command {
        protected final String first_command;
        protected final String[] second_commands;

        public Command(String first_command, String... second_commands) {
            this.first_command = first_command;
            this.second_commands = second_commands;
        }
    }

    public static void register(String command_) {
        if (command_.contains("/")) {
            List<String> strings = new ArrayList<>(Arrays.stream(command_.split(" ")).toList());
            String first_command = strings.get(0);
            strings.remove(0);
            Command command1 = new Command(first_command, strings.toArray(new String[0]));
            command.put(first_command, command1);
        } else {
            new Command(command_, "");
        }
    }

}
