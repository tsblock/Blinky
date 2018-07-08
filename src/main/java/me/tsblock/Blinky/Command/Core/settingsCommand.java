package me.tsblock.Blinky.Command.Core;

import me.tsblock.Blinky.Command.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class settingsCommand extends Command {
    @Override
    public String getName() {
        return "settings";
    }

    @Override
    public String getDescription() {
        return "Change settings for server you currently in.";
    }

    @Override
    public String getUsage() {
        return "<key> <value> \n";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("config", "cfg");
    }

    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public boolean needArgs() {
        return true;
    }

    @Override
    public void onExecute(GuildMessageReceivedEvent event, Message msg, User user, Guild guild, String... args) {

    }
}
