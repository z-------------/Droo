package yy.gourlitburo.droo;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

  private Logger logger = getLogger();
  private Server server = getServer();

  private static List<String> sayings = Arrays.asList(
    "Were you born in a barn?", "Get some work done", "Useless scrub", 
    "Stop jacking off", "I'll bust your chops", "Are you born in a water park?", 
    "Stop fapping around", "Are you born in a barn?", "Later, shizlord", "Oy!", 
    "You should know when to give up.", "WERE U BORN IN A BARN???", "GET SUM WERK DUN", 
    "Useless scrub...", "Stop jacking off", "I'LL BUST YOUR CHOPS", 
    "R U BORN IN A WATER PARK??", "Stop fapping around", "R U BORN IN A BARN???", 
    "LATER, SHIZLORD", "OI!!", "U shuld know when 2 give up...", "*snaps fingers*", 
    "*shakes head*", "UGHHHHHHH SCRUB", "BURRRRPPP", "Scrub", "Useless twerp"
  );

  @Override
  public void onEnable() {
    getCommand("droo").setExecutor(this);
    logger.info("Droo ready.");
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    String saying = sayings.get((int) (Math.random() * sayings.size()));

    if (args.length >= 1) { // send to specified player
      Player recipient = server.getPlayer(args[0]);
      if (recipient == null) {
        sender.sendMessage("Could not find player.");
        return true;
      } 

      String senderName;
      if (sender instanceof Player) senderName = ((Player) sender).getDisplayName();
      else if (sender instanceof ConsoleCommandSender) senderName = "the heavens";
      else senderName = sender.getName();

      recipient.sendMessage(String.format("An inspirational message from %s: %s%s%s", senderName, ChatColor.YELLOW, ChatColor.BOLD, saying));
    } else { // send to sender
      sender.sendMessage(String.format("%s%s%s", ChatColor.YELLOW, ChatColor.BOLD, saying));
    }

    return true;
  }

}
