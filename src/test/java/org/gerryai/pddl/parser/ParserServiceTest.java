package org.gerryai.pddl.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.pddl.model.Domain;
import org.gerryai.pddl.parser.antlr.PDDL31Parser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Unit tests for the {@link ParserService} class.
 */
public class ParserServiceTest {

    @Mock
    private ParserServiceUtils mockUtils;

    @Mock
    private CharStream mockCharStream;

    @Mock
    private Lexer mockLexer;

    @Mock
    private InputStream mockInputStream;

    @Mock
    private TokenStream mockTokenStream;

    @Mock
    private PDDL31Parser mockParser;

    @Mock
    private ParseTreeWalker mockParseTreeWalker;

    @Mock
    private ExtractDomainListener mockExtractDomainListener;

    @Mock
    private PDDL31Parser.DomainContext mockParseTree;

    @Mock
    private Domain mockDomain;

    private ParserService parserService;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        when(mockUtils.createInputStream(mockInputStream)).thenReturn(mockCharStream);
        when(mockUtils.createLexer(mockCharStream)).thenReturn(mockLexer);
        when(mockUtils.createTokenStream(mockLexer)).thenReturn(mockTokenStream);
        when(mockUtils.createParser(mockTokenStream)).thenReturn(mockParser);
        when(mockUtils.createParseTreeWalker()).thenReturn(mockParseTreeWalker);
        when(mockUtils.createExtractDomainListener()).thenReturn(mockExtractDomainListener);
        when(mockUtils.getDomainContext(mockParser)).thenReturn(mockParseTree);

        when(mockExtractDomainListener.extract()).thenReturn(mockDomain);

        parserService = new ParserService(mockUtils);
    }

    @Test
    public void parse() throws Exception {
        assertEquals(parserService.parse(mockInputStream), mockDomain);
        verify(mockParseTreeWalker).walk(mockExtractDomainListener, mockParseTree);
    }
}
