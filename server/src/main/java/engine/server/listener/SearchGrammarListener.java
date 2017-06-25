package engine.server.listener;

import engine.server.domain.InvertedWordSearchEntryMatcher;
import engine.server.domain.SearchEntryMatcher;
import engine.server.domain.WordSearchEntryMatcher;
import engine.server.gen.SearchGrammarBaseListener;
import engine.server.gen.SearchGrammarParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchGrammarListener extends SearchGrammarBaseListener {
    private List<SearchEntryMatcher> sequence = new ArrayList<>();

    public List<SearchEntryMatcher> getSequence() {
        return sequence;
    }

    @Override
    public void exitSearch_term(SearchGrammarParser.Search_termContext ctx) {
        for (SearchGrammarParser.TermContext context : ctx.term()) {
            addToSequence(context);
        }
    }

    private void addToSequence(SearchGrammarParser.TermContext ctx) {
        if (ctx.word() != null) {
            sequence.add(wordMatcherFrom(ctx.word()));
        } else if (ctx.exact_word() != null) {
            sequence.add(wordMatcherFrom(ctx.exact_word()));
        } else if (ctx.not_word() != null) {
            sequence.add(wordMatcherFrom(ctx.not_word()));
        }
    }

    private WordSearchEntryMatcher wordMatcherFrom(SearchGrammarParser.WordContext ctx) {
        String word = ctx.WORD().toString();
        System.out.println("WORD = " + word);
        return new WordSearchEntryMatcher(word);
    }

    private WordSearchEntryMatcher wordMatcherFrom(SearchGrammarParser.Exact_wordContext ctx) {
        String exactWord = String.join(" ",
                ctx.word().stream().map(x -> x.WORD().toString()).collect(Collectors.toList()));
        System.out.println("EXACT_WORD = (" + exactWord + ")");
        return new WordSearchEntryMatcher(exactWord);
    }

    private InvertedWordSearchEntryMatcher wordMatcherFrom(SearchGrammarParser.Not_wordContext ctx) {
        SearchEntryMatcher sourceMatcher;

        System.out.println("NOT_WORD (for next line)");

        if (ctx.word() != null) {
            sourceMatcher = wordMatcherFrom(ctx.word());
        } else if (ctx.exact_word() != null) {
            sourceMatcher = wordMatcherFrom(ctx.exact_word());
        } else {
            throw new IllegalArgumentException("Wrong construction");
        }

        return new InvertedWordSearchEntryMatcher(sourceMatcher);
    }
}
