package de.jplag.kotlin;

import java.io.File;
import java.util.List;

import de.jplag.Token;

/**
 * This represents the Kotlin language as a language supported by JPlag.
 */
public class Language implements de.jplag.Language {

    private static final String NAME = "Kotlin Parser";
    private static final String SHORT_NAME = "Kotlin";
    private static final int DEFAULT_MIN_TOKEN_MATCH = 8;
    private static final String[] FILE_EXTENSIONS = {".kt"};
    private final KotlinParserAdapter parserAdapter;

    public Language() {
        this.parserAdapter = new KotlinParserAdapter();
    }

    @Override
    public String[] suffixes() {
        return FILE_EXTENSIONS;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getShortName() {
        return SHORT_NAME;
    }

    @Override
    public int minimumTokenMatch() {
        return DEFAULT_MIN_TOKEN_MATCH;
    }

    @Override
    public List<Token> parse(File directory, String[] files) {
        return parserAdapter.parse(directory, files);
    }

    @Override
    public boolean hasErrors() {
        return parserAdapter.hasErrors();
    }
}
