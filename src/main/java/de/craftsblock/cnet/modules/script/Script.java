package de.craftsblock.cnet.modules.script;

import de.craftsblock.craftsnet.CraftsNet;
import de.craftsblock.craftsnet.addon.Addon;
import de.craftsblock.cnet.modules.script.listeners.ShareListener;
import de.craftsblock.cnet.modules.script.routes.VersionRoute;

/**
 * The {@link Script} class is an addon that integrates functionality for scripting into the application.
 * It registers routes and listeners required for the script module during its lifecycle.
 * This class extends the {@link Addon} base class and overrides its lifecycle methods.
 *
 * @author Philipp Maywald
 * @author CraftsBlock
 * @version 1.0.0
 * @see Addon
 * @see VersionRoute
 * @see ShareListener
 * @since 1.0.0-SNAPSHOT
 */
public class Script extends Addon {

    /**
     * Called when the addon is enabled. Initializes the script module by manually registering
     * its routes and listeners.
     * <p><b>Note:</b> The {@code @AutoRegister} annotation is currently not working,
     * so manual registration is implemented as a temporary solution.</p>
     */
    @Override
    public void onEnable() {
        // FIXME: Remove when @AutoRegister is working
        routeRegistry().register(new VersionRoute(this));
        listenerRegistry().register(new ShareListener());
    }

    /**
     * Called when the addon is disabled. Performs any necessary cleanup for the script module.
     */
    @Override
    public void onDisable() {
        // No cleanup logic implemented
    }

}
