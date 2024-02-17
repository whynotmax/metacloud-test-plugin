package eu.metacloudservice;

import eu.metacloudservice.events.CloudServiceDisconnectedListener;
import eu.metacloudservice.events.CloudServiceLaunchListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class MetaCloudPlugin extends JavaPlugin {

    @Getter
    private static MetaCloudPlugin instance;

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        instance = this;

        //Register Cloud Listeners
        CloudAPI.getInstance().getEventDriver().registerListener(new CloudServiceLaunchListener());
        CloudAPI.getInstance().getEventDriver().registerListener(new CloudServiceDisconnectedListener());
    }

    /**
     * Called when the plugin is disabled.
     */
    @Override
    public void onDisable() {
        instance = null;
    }
}
