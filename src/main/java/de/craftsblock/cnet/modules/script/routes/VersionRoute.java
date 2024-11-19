package de.craftsblock.cnet.modules.script.routes;

import de.craftsblock.cnet.modules.script.language.compiler.CNetCompiler;
import de.craftsblock.craftscore.json.Json;
import de.craftsblock.craftsnet.addon.Addon;
import de.craftsblock.craftsnet.api.annotations.AutoRegister;
import de.craftsblock.craftsnet.api.http.*;
import de.craftsblock.craftsnet.api.http.annotations.RequestMethod;
import de.craftsblock.craftsnet.api.http.annotations.Route;

import java.io.IOException;

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
 * @see Addon
 * @see RequestHandler
 * @see AutoRegister
 * @version 1.0.0
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
     * @throws IOException If an I/O error occurs while writing the response.
     */
    @Route("/module/script/version")
    @RequestMethod(HttpMethod.GET)
    public void handleVersion(Exchange exchange) throws IOException {
        Request request = exchange.request();
        Response response = exchange.response();

        // Respond with json containing the addon's name and the compiler version
        response.print(Json.empty()
                .set("name", addon.getMeta().name())
                .set("version", CNetCompiler.VERSION));
    }

}
