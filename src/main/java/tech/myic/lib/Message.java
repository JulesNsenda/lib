package tech.myic.lib;

import java.util.LinkedList;
import java.util.List;

public class Message
{
    private Message()
    {
    }

    public static void displayHelpMessage(AppParameter appParameter, String applicationName)
    {
        List<CmdOption> cmdOptions = appParameter.getOptions();
        StringBuilder sb = new StringBuilder();
        for (CmdOption cmdOption : cmdOptions){
            String key = cmdOption.getKey();
            String description = cmdOption.getDescription();
            sb.append(key.concat("<").concat(description).concat("> "));
        }

        System.out.println("Usage: " + applicationName.concat(".jar ") + sb);
    }

    public static void main(String[] args)
    {
        List<CmdOption> cmdOptions = new LinkedList<>();
        CmdOption op1 = new CmdOption();
        op1.setKey("-in=");
        op1.setDescription("Input file");
        cmdOptions.add(op1);

        AppParameter appParameter = new AppParameter.Builder()
                .CmdOptions(cmdOptions)
                .NumberOfParameters(2)
                .build();

        displayHelpMessage(appParameter, "Test");
    }
}
