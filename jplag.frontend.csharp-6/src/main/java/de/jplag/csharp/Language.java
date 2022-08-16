package de.jplag.csharp;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import de.jplag.Token;

/**
 * C# language with full support of C# 6 features and below.
 * @author Timur Saglam
 */
public class Language implements de.jplag.Language {
    private static final String NAME = "C# 6 Parser";
    private static final String SHORT_NAME = "C# 6";
    private static final String[] FILE_ENDINGS = new String[] {".cs", ".CS"};
    private static final int DEFAULT_MIN_TOKEN_MATCH = 8;

    private final CSharpParserAdapter parser;

    public Language() {
        parser = new CSharpParserAdapter();
    }

    @Override
    public String[] suffixes() {
        return FILE_ENDINGS;
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
    public List<Token> parse(File dir, String[] files) {
        return parser.parse(dir, Arrays.asList(files));
    }

    @Override
    public boolean hasErrors() {
        return parser.hasErrors();
    }
}
