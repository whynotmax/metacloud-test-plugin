package eu.metacloudservice.events;

import eu.metacloudservice.events.entrys.ICloudListener;
import eu.metacloudservice.events.entrys.Priority;
import eu.metacloudservice.events.entrys.Subscribe;
import eu.metacloudservice.events.listeners.services.CloudServiceLaunchEvent;
import org.bukkit.Bukkit;

public class CloudServiceLaunchListener implements ICloudListener {

    /**
     * Handles the event when a cloud service is launched.
     *
     * @param  event  The CloudServiceLaunchEvent to be handled
     */
    @Subscribe(priority = Priority.HIGHEST)
    public void handleCloudServiceLaunchEvent(final CloudServiceLaunchEvent event) {
        String group = event.getGroup();
        String service = event.getName();
        String node = event.getNode();
        Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("Service launched: Group: " + group + ", Service: " + service + ", Node: " + node));
    }

}
