package de.craftsblock.cnet.modules.script.language;

import de.craftsblock.cnet.modules.script.language.compiler.CNetCompiler;
import de.craftsblock.craftsnet.api.http.Exchange;

/**
 * Base class for scripts in the CNet scripting language.
 * Extend this class to create custom scripts.
 * <p>
 * This class provides a framework for defining scripts that can be executed within the CNet system.
 * Scripts should implement the {@link #execute(Exchange)} method to define their specific behavior.
 * </p>
 * <p>
 * The version of the CNetScript is inherited from {@link CNetCompiler#VERSION}.
 * </p>
 *
 * @author CraftsBlock
 * @author Philipp Maywald
 * @version 1.0.0
 * @since 3.0.7-SNAPSHOT
 */
public abstract class CNetScript {

    /**
     * The version string of the CNetScript.
     * <p>
     * This version string is inherited from {@link CNetCompiler#VERSION}.
     * </p>
     */
    public static final String VERSION = CNetCompiler.VERSION;

    /**
     * Executes the script logic.
     * Implement this method to define the behavior of the script when executed.
     *
     * @param exchange the exchange object providing context for script execution
     * @return {@code true} if the no more output should be done after the script was executed,
     * {@code false} otherwise
     * @throws Exception if any error occurs during script execution
     */
    public abstract boolean execute(Exchange exchange) throws Exception;

}
