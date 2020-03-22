package me.mattiamari.showram;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ShowRam extends JavaPlugin
{
    public void onEnable() {
        this.getCommand("memory").setExecutor(new ShowRamCmd());
    }

    private class ShowRamCmd implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Runtime runtime = Runtime.getRuntime();
            long megabytes = 1024 * 1024;
            long memFree = runtime.freeMemory();
            long memMax = runtime.maxMemory();
            long memUsed = memMax - memFree;
    
            String msg = String.format("JVM memory usage: %d MB / %d MB", memUsed / megabytes, memMax / megabytes);
            sender.sendMessage(msg);
    
            return true;
        }
    }
}
