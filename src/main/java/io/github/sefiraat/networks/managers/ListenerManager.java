package io.github.sefiraat.networks.managers;

import com.ytdd9527.networksexpansion.core.listener.NetworksGuideListener;
import io.github.sefiraat.networks.Networks;
import io.github.sefiraat.networks.listeners.ExplosiveToolListener;
import io.github.sefiraat.networks.listeners.SyncListener;
import org.bukkit.event.Listener;

public class ListenerManager {

    public ListenerManager() {
        addListener(new ExplosiveToolListener());
        addListener(new SyncListener());
        addListener(new NetworksGuideListener());
    }

    private void addListener(Listener listener) {
        Networks.getPluginManager().registerEvents(listener, Networks.getInstance());
    }
}
