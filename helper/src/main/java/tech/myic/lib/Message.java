package tech.myic.lib;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

class Message
{
    private String optionComments;

    private Message()
    {
    }

    static void displayHelpMessage(AppParameter appParameter, String applicationName)
    {
        List<CmdOption> cmdOptions = appParameter.getOptions();
        StringBuilder sb = new StringBuilder();
        for (CmdOption cmdOption : cmdOptions){
            String key = cmdOption.getKey();
            String description = cmdOption.getDescription();
            sb.append(key.concat("<").concat(description).concat("> "));
        }

        Function<? super CmdOption, String> function = (Function<CmdOption, String>) cmdOption -> cmdOption.getKey().concat("\n\t").concat(cmdOption.getComments());

        System.out.println("NAME \n"
                + "\t " + applicationName + "\n"
                + "SYNOPSIS \n"
                + "\t " + applicationName + ".jar " + sb + "\n"
                + "DESCRIPTION \n"
                + "TODO: Application description here"
                + "\t ?, --help, -h \n"
                + "\t\t Displays usage of the " + applicationName + " program"
                + cmdOptions.stream().map(function).toString());
    }

}
