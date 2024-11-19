package de.craftsblock.cnet.modules.script.listeners;

import de.craftsblock.cnet.modules.script.language.compiler.CNetCompiler;
import de.craftsblock.craftscore.event.EventHandler;
import de.craftsblock.craftscore.event.EventPriority;
import de.craftsblock.craftscore.event.ListenerAdapter;
import de.craftsblock.craftsnet.api.annotations.AutoRegister;
import de.craftsblock.craftsnet.api.http.Exchange;
import de.craftsblock.craftsnet.events.requests.shares.ShareFileLoadedEvent;

import java.io.File;
import java.io.IOException;

/**
 * The {@link ShareListener} class listens for events related to shared files being loaded.
 * It handles the {@link ShareFileLoadedEvent} and compiles eligible files using the {@link CNetCompiler}.
 * <p>
 * The listener is automatically registered using the {@link AutoRegister} annotation.
 * </p>
 *
 * @author Philipp Maywald
 * @author CraftsBlock
 * @version 1.0.0
 * @see ShareFileLoadedEvent
 * @see ListenerAdapter
 * @see CNetCompiler
 * @since 1.0.0-SNAPSHOT
 */
@AutoRegister
public class ShareListener implements ListenerAdapter {

    /**
     * Handles the {@link ShareFileLoadedEvent} when a shared file is loaded.
     * <p>
     * If the event is not canceled and the file is compilable by the {@link CNetCompiler},
     * it compiles the file and cancels the event to prevent further processing.
     * </p>
     *
     * @param event The {@link ShareFileLoadedEvent} triggered when a shared file is loaded.
     * @throws IOException If an I/O error occurs during compilation.
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void handleShareFile(ShareFileLoadedEvent event) throws IOException {
        // Exit if the event is already cancelled
        if (event.isCancelled()) return;
        File file = event.getFile();

        // Check if the file can be compiled by the CNetCompiler
        if (!CNetCompiler.canCompile(file)) return;

        // Load the original content type and append it to the response
        Exchange exchange = event.getExchange();
        exchange.response().setContentType(event.getContentType(), "text/plain");

        // Compile the file and respond via the event's exchange
        CNetCompiler.compile(file, exchange);

        // Cancel the event to prevent further handling
        event.setCancelled(true);
    }

}
