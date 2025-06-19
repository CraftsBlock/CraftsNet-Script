package de.craftsblock.cnet.modules.script.routes;

import de.craftsblock.cnet.modules.script.language.compiler.CNetCompiler;
import de.craftsblock.craftscore.json.Json;
import de.craftsblock.craftsnet.addon.Addon;
import de.craftsblock.craftsnet.api.http.Exchange;
import de.craftsblock.craftsnet.api.http.HttpMethod;
import de.craftsblock.craftsnet.api.http.RequestHandler;
import de.craftsblock.craftsnet.api.http.annotations.RequestMethod;
import de.craftsblock.craftsnet.api.http.annotations.Route;
import de.craftsblock.craftsnet.autoregister.meta.AutoRegister;

/**
 * The {@link VersionRoute} class defines a route for retrieving the version information
 * of the script module. This class implements the {@link RequestHandler} interface
 * to handle HTTP requests for the specified route.
 * <p>
 * The route is automatically registered using the {@link AutoRegister} annotation.
 * </p>
 *
 * @author Philipp Maywald
 * @author CraftsBlock
 * @version 1.0.0
 * @see Addon
 * @see RequestHandler
 * @see AutoRegister
 * @since 1.0.0-SNAPSHOT
 */
@AutoRegister
public class VersionRoute implements RequestHandler {

    private final Addon addon;

    /**
     * Constructs a new {@code VersionRoute} instance and associates it with the specified addon.
     *
     * @param addon The {@link Addon} instance to provide metadata for the route.
     */
    public VersionRoute(Addon addon) {
        this.addon = addon;
    }

    /**
     * Handles HTTP GET requests for the route {@code /module/script/version}.
     * This method responds with a JSON object containing the addon's name and version.
     *
     * @param exchange The {@link Exchange} object containing the request and response information.
     */
    @Route("/module/script/version")
    @RequestMethod(HttpMethod.GET)
    public Json handleVersion(Exchange exchange) {
        // Respond with json containing the addon's name and the compiler version
        return Json.empty()
                .set("name", addon.getMeta().name())
                .set("version", CNetCompiler.VERSION);
    }

}
