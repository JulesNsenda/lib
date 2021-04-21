package tech.myic.lib;

import java.util.List;

class Message
{
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

        System.out.println("NAME \n"
                + "\t " + applicationName + "\n"
                + "SYNOPSIS \n"
                + "\t " + applicationName + ".jar " + sb + "\n"
                + "DESCRIPTION \n"
                + "\t ?, --help, -h \n"
                + "\t\t Displays usage of the " + applicationName + " program");
    }

}
