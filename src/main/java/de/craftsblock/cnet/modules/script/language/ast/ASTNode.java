package de.craftsblock.cnet.modules.script.language.ast;

import de.craftsblock.cnet.modules.script.language.compiler.CNetInterpreter;
import de.craftsblock.cnet.modules.script.language.compiler.CNetParser;
import de.craftsblock.craftsnet.api.http.Exchange;

/**
 * Abstract base class representing a node in the Abstract Syntax Tree (AST) of the CNet scripting language.
 * Each node must implement methods for parsing and interpreting the node.
 *
 * @author Philipp Maywald
 * @author CraftsBlock
 * @version 1.0.1
 * @since 3.0.7-SNAPSHOT
 */
public abstract class ASTNode {

    private final int line;

    /**
     * Constructs an {@link ASTNode} with the specified line number.
     *
     * @param line the line number in the source code where this node is located
     */
    public ASTNode(int line) {
        this.line = line;
    }

    /**
     * Parses the node using the provided parser.
     * This method is responsible for constructing the AST node from the parsed tokens.
     *
     * @param parser the parser to use for parsing this node
     */
    public abstract void parse(CNetParser parser);

    /**
     * Interprets the node using the provided interpreter and exchange.
     * This method executes the logic represented by the AST node.
     *
     * @param interpreter the interpreter to use for interpreting this node
     * @param exchange    the exchange context in which this node is interpreted
     */
    public abstract boolean interpret(CNetInterpreter interpreter, Exchange exchange) throws Exception;

    /**
     * Returns the line number where this {@link ASTNode} was defined in the source code.
     *
     * @return the line number of this node
     */
    public int getLine() {
        return line;
    }

}
