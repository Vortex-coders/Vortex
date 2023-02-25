package org.ru.vortex.modules;

import arc.Core;
import arc.util.Log;
import mindustry.Vars;

import static mindustry.net.Administration.Config.*;
import static org.ru.vortex.State.config;
import static org.ru.vortex.State.gson;

public class Config
{
    public String name = "";
    public String description = "";
    public String botSocketUrl = "";
    public String mongoDatabaseUrl = "";
    public Gamemode gamemode = Gamemode.survival;

    public static void init()
    {
        var file = Vars.dataDirectory.child("config.json");

        if (file.exists())
            config = gson.fromJson(file.readString(), Config.class);
        else
        {
            file.writeString(gson.toJson(config = new Config()));
            Log.infoTag("Config", "Created default config file: " + file.absolutePath());
            Core.app.exit();
        }

        autoPause.set(config.gamemode.isDefault());
        enableVotekick.set(config.gamemode != Gamemode.hub);

        serverName.set(config.name);
        desc.set(config.description);

        motd.set("off");
        showConnectMessages.set(false);
        logging.set(true);
        strict.set(true);
        antiSpam.set(true);

        interactRateWindow.set(1);
        interactRateLimit.set(15);
        messageRateLimit.set(1);
        packetSpamLimit.set(250);

        interactRateKick.set(15);
        messageSpamKick.set(5);

        snapshotInterval.set(250);
    }

    public enum Gamemode
    {
        attack,
        hub,
        pvp,
        sandbox,
        survival;

        public boolean isDefault()
        {
            return (this == attack || this == pvp || this == sandbox || this == survival);
        }
    }
}
