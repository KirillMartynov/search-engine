package engine.server.service;

import engine.server.domain.SearchEntryMatcher;
import engine.server.exception.InvalidQueryException;
import engine.server.gen.SearchGrammarLexer;
import engine.server.gen.SearchGrammarParser;
import engine.server.listener.SearchGrammarListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

public class MatchersFactoryImpl implements MatchersFactory {
    @Override
    public List<SearchEntryMatcher> create(String searchString) {
        SearchGrammarListener listener = new SearchGrammarListener();

        ANTLRInputStream input = new ANTLRInputStream(searchString);
        SearchGrammarLexer lexer = new SearchGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        try {
            SearchGrammarParser parser = new SearchGrammarParser(tokens);
            parser.setErrorHandler(new BailErrorStrategy());
            ParseTree tree = parser.search_term(); // begin parsing at init rule
            ParseTreeWalker walker = new ParseTreeWalker();

            walker.walk(listener, tree);

            return listener.getSequence();
        } catch (Exception e) {
            throw new InvalidQueryException("Input query cannot be parser", e);
        }
    }
}
