package tech.myic.lib;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MessageTest
{
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    public static void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams()
    {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testDisplayHelpMessage_success()
    {
        List<CmdOption> cmdOptions = new LinkedList<>();
        CmdOption op1 = CmdOption.createCmdOption("-in=", "Input file", "Make sure this input option is provided");
        cmdOptions.add(op1);
        CmdOption op2 = CmdOption.createCmdOption("-out=", "Output file", "Make sure this output option is provided");
        cmdOptions.add(op2);

        AppParameter appParameter = new AppParameter.Builder()
                .CmdOptions(cmdOptions)
                .NumberOfParameters(2)
                .build();

        Message.displayHelpMessage(appParameter, "Test");

        String expectedOutput = "NAME \n"
                + "\t Test\n"
                + "SYNOPSIS \n"
                + "\t Test.jar -in=<Input file> -out=<Output file> \n"
                + "DESCRIPTION \n"
                + "\tTODO: Application description here \n"
                + "\t ?, --help, -h \n"
                + "\t\t Displays usage of the Test program \n"
                + "\t-in=\n"
                + "\t\tMake sure this input option is provided\n"
                + "\t-out=\n"
                + "\t\tMake sure this output option is provided";
        Assertions.assertEquals(expectedOutput, outContent.toString().trim());

    }

}