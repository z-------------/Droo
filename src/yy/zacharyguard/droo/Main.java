package yy.zacharyguard.droo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender,
            Command command,
            String label,
            String[] args) {
        if (command.getName().equalsIgnoreCase("droo")) {
        	
        	Entity targetPlayer;
        	Boolean isToSelf;
        	
        	List<String> drooSayings = new ArrayList<String>();
        	drooSayings.addAll(Arrays.asList(
        			"Were you born in a barn?", "Get some work done", "Useless scrub", 
        			"Stop jacking off", "I'll bust your chops", "Are you born in a water park?", 
        			"Stop fapping around", "Are you born in a barn?", "Later, shizlord", "Oy!", 
        			"You should know when to give up.", "WERE U BORN IN A BARN???", "GET SUM WERK DUN", 
        			"Useless scrub...", "Stop jacking off", "I'LL BUST YOUR CHOPS", 
        			"R U BORN IN A WATER PARK??", "Stop fapping around", "R U BORN IN A BARN???", 
        			"LATER, SHIZLORD", "OI!!", "U shuld know when 2 give up...", "*snaps fingers*", 
        			"*shakes head*", "UGHHHHHHH SCRUB", "BURRRRPPP", "Scrub", "Useless twerp"
        			));
        	
        	String YELLOW_BOLD = "" + ChatColor.YELLOW + ChatColor.BOLD;
        	
        	if (args.length >= 1) {
        		String targetUsername = args[0];
        		targetPlayer = (Entity) Bukkit.getPlayer(targetUsername);
        		if (targetPlayer == null) {
        			sender.sendMessage("Could not find player " + targetUsername + ".");
        			return false;
        		}
        		isToSelf = false;
        	} else {
        		targetPlayer = (Entity) sender;
        		isToSelf = true;
        	}
        	
        	String selectedDrooSaying = drooSayings.get((int) (Math.random() * drooSayings.size()));
        	
        	if (isToSelf) {
        		targetPlayer.sendMessage(YELLOW_BOLD + selectedDrooSaying);
        	} else {
        		targetPlayer.sendMessage(
        				"An inspirational message from " + sender.getName() + ": " + 
        				YELLOW_BOLD + selectedDrooSaying
        		);
        	}
        	
        	return true;
        }
        return false;
	}
}