package de.craftsblock.cnet.modules.script;

import de.craftsblock.craftsnet.addon.Addon;
import de.craftsblock.cnet.modules.script.listeners.ShareListener;
import de.craftsblock.cnet.modules.script.routes.VersionRoute;
import de.craftsblock.craftsnet.addon.meta.annotations.Meta;

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
@Meta(name = "CraftsNetScript")
public class Script extends Addon {

}
