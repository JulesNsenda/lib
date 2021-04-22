package tech.myic.lib;

import java.util.List;

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

        String optionComments = "";
        for (CmdOption co : cmdOptions){
            optionComments += ("\t" + co.getKey()).concat("\n").concat("\t\t").concat(co.getComments()).concat("\n");
        }

        System.out.println("NAME \n"
                + "\t " + applicationName + "\n"
                + "SYNOPSIS \n"
                + "\t " + applicationName + ".jar " + sb + "\n"
                + "DESCRIPTION \n"
                + "\tTODO: Application description here \n"
                + "\t ?, --help, -h \n"
                + "\t\t Displays usage of the " + applicationName + " program \n"
                +  optionComments);
    }

}
