package tech.myic.lib;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MessageHelperImplTest
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
        MessageHelperImpl messageHelperImpl = new MessageHelperImpl.Builder()
                .numberOfParameters(2)
                .applicationDescription("This is a test application to see how the helper library works.")
                .applicationName("Test")
                .build();

        messageHelperImpl.showHelpMessage();

        String expectedOutput = "NAME \n"
                + "\t Test\n"
                + "SYNOPSIS \n"
                + "\t Test.jar -in=<Input file> -out=<Output file> \n"
                + "DESCRIPTION \n"
                + "\tThis is a test application to see how the helper library works. \n"
                + "\t ?, --help, -h \n"
                + "\t\tDisplays usage of the Test program \n"
                + "\t-in=\n"
                + "\t\tMake sure this input option is provided\n"
                + "\t-out=\n"
                + "\t\tMake sure this output option is provided";

        Assertions.assertEquals(expectedOutput, outContent.toString().trim());

    }

}