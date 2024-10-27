package io.github.sefiraat.networks.managers;

import com.ytdd9527.networksexpansion.core.listener.NetworksGuideListener;
import io.github.sefiraat.networks.Networks;
import io.github.sefiraat.networks.listeners.ExplosiveToolListener;
import io.github.sefiraat.networks.listeners.SyncListener;
import org.bukkit.event.Listener;

public class ListenerManager {

    public ListenerManager() {
        addListener(new ExplosiveToolListener());
//<<<<<<< HEAD
        addListener(new BlockListener());
        addListener(new NetworksGuideListener());
//=======
        addListener(new SyncListener());
//>>>>>>> 31b943e4a683c3e7836b78647c1834e086fa9a39
    }

    private void addListener(Listener listener) {
        Networks.getPluginManager().registerEvents(listener, Networks.getInstance());
    }
}
