package org.ru.vortex;

import arc.util.*;
import mindustry.core.Version;
import mindustry.mod.Plugin;
import org.ru.vortex.modules.Config;

public class Vortex extends Plugin
{
    @Override
    public void init()
    {
        Log.infoTag("Vortex", "Initializing plugin...");
        Time.mark();

        Config.init();

        Version.build = -1;
        Log.infoTag("Vortex", "Plugin initialized in " + Time.elapsed() + "ms");
    }

    @Override
    public void registerServerCommands(CommandHandler handler)
    {

    }

    @Override
    public void registerClientCommands(CommandHandler handler)
    {

    }
}
