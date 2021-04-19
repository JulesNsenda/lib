package tech.myic.lib;

public class CmdOption
{
    private String key;
    private String description;

    private CmdOption(String key, String description)
    {
        this.key = key;
        this.description = description;
    }

    public static CmdOption createCmdOption(String key, String description)
    {
        return new CmdOption(key, description);

    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
