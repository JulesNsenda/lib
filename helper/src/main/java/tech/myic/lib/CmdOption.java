package tech.myic.lib;

public class CmdOption
{
    private String key;
    private String description;
    private String comments;

    private CmdOption(String key, String description, String comments)
    {
        this.key = key;
        this.description = description;
        this.comments = comments;
    }

    public static CmdOption createCmdOption(String key, String description, String comments)
    {
        return new CmdOption(key, description, comments);
    }

    public String getComments()
    {
        return comments;
    }

    public String getKey()
    {
        return key;
    }

    public String getDescription()
    {
        return description;
    }

}
