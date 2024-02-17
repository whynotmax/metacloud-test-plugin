package eu.metacloudservice.events;

import eu.metacloudservice.CloudAPI;
import eu.metacloudservice.MetaCloudPlugin;
import eu.metacloudservice.events.entrys.ICloudListener;
import eu.metacloudservice.events.entrys.Priority;
import eu.metacloudservice.events.entrys.Subscribe;
import eu.metacloudservice.events.listeners.services.CloudServiceDisconnectedEvent;
import eu.metacloudservice.events.listeners.services.CloudServiceLaunchEvent;
import eu.metacloudservice.pool.player.entrys.CloudPlayer;
import org.bukkit.Bukkit;

public class CloudServiceDisconnectedListener implements ICloudListener {

    /**
     * Handles the event when a cloud service is disconnected.
     *
     * @param  event  The CloudServiceDisconnectedEvent to be handled
     */
    @Subscribe(priority = Priority.HIGHEST)
    public void handleCloudServiceDisconnectedEvent(final CloudServiceDisconnectedEvent event) {
        String service = event.getName();
        String group = CloudAPI.getInstance().getServicePool().getService(service).getGroup().getGroup();
        if (CloudAPI.getInstance().getCurrentService().getService().equalsIgnoreCase(service)) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                CloudPlayer cloudPlayer = CloudAPI.getInstance().getPlayerPool().getPlayer(player.getUniqueId());
                if (cloudPlayer != null) {
                    cloudPlayer.disconnect("Service disconnected: Group: " + group + ", Service: " + service); //or send to your lobby service(s)
                }
            });
        }
    }

}
