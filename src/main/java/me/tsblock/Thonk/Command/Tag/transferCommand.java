package me.tsblock.Thonk.Command.Tag;

import com.mongodb.client.MongoCollection;
import me.tsblock.Thonk.Command.Command;
import me.tsblock.Thonk.Database.MongoConnect;
import me.tsblock.Thonk.utils.Embed;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import org.bson.Document;

public class transferCommand extends Command {
    @Override
    public String getName() {
        return "transfer";
    }

    @Override
    public String getDescription() {
        return "Transfer/Give the ownership of a tag";
    }

    @Override
    public String getUsage() {
        return "<mention> <tag name>";
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
        String totransfer = msg.getMentionedUsers().get(0).getId();
        String name = args[1];
        MongoCollection<Document> col = MongoConnect.getTags();
        if (col.find(new Document("name", name)).first() == null) {
            Embed.sendEmbed("Tag does not exists.", msg.getChannel());
            return;
        }
        if (!user.getId().equals(col.find(new Document("name", name)).first().getString("id"))) {
            Embed.sendEmbed("You don't own the tag", msg.getChannel());
            return;
        }
        MongoConnect.transferTag(name, totransfer);
    }
}
