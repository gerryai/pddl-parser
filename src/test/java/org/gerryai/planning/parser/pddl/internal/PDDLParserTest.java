/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.parser.pddl.internal;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
import org.gerryai.planning.parser.pddl.internal.error.SyntaxErrorCollector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Unit tests for the {@link org.gerryai.planning.parser.pddl.internal.PDDLParser} class.
 */
public class PDDLParserTest {

    @Mock
    private PDDLParserUtils mockUtils;

    @Mock
    private CharStream mockCharStream;

    @Mock
    private Lexer mockLexer;

    @Mock
    private InputStream mockInputStream;

    @Mock
    private TokenStream mockTokenStream;


    @Mock
    private SyntaxErrorCollector mockSyntaxErrorCollector;

    @Mock
    private PDDL31Parser mockParser;

    @Mock
    private ParseTreeWalker mockParseTreeWalker;

    @Mock
    private ExtractDomainListener mockExtractDomainListener;

    @Mock
    private ExtractProblemListener mockExtractProblemListener;

    @Mock
    private PDDL31Parser.DomainContext mockDomainParseTree;

    @Mock
    private PDDL31Parser.ProblemContext mockProblemParseTree;

    @Mock
    private Domain mockDomain;

    @Mock
    private Problem mockProblem;

    private PDDLParser parserService;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        when(mockUtils.createInputStream(mockInputStream)).thenReturn(mockCharStream);
        when(mockUtils.createLexer(mockCharStream)).thenReturn(mockLexer);
        when(mockUtils.createTokenStream(mockLexer)).thenReturn(mockTokenStream);
        when(mockUtils.createSyntaxErrorCollector()).thenReturn(mockSyntaxErrorCollector);
        when(mockUtils.createParser(mockTokenStream, mockSyntaxErrorCollector)).thenReturn(mockParser);
        when(mockUtils.createParseTreeWalker()).thenReturn(mockParseTreeWalker);
        when(mockUtils.createExtractDomainListener()).thenReturn(mockExtractDomainListener);
        when(mockUtils.createExtractProblemListener()).thenReturn(mockExtractProblemListener);
        when(mockUtils.getDomainContext(mockParser)).thenReturn(mockDomainParseTree);
        when(mockUtils.getProblemContext(mockParser)).thenReturn(mockProblemParseTree);

        when(mockParser.getEnforceRequirments()).thenReturn(true);
        when(mockExtractDomainListener.extract()).thenReturn(mockDomain);
        when(mockExtractProblemListener.extract()).thenReturn(mockProblem);

        parserService = new PDDLParser(mockUtils);
    }

    @Test
    public void parseDomain() throws Exception {
        assertEquals(mockDomain, parserService.parseDomain(mockInputStream));
        verify(mockParseTreeWalker).walk(mockExtractDomainListener, mockDomainParseTree);
    }

    @Test
    public void parseProblem() throws Exception {
        assertEquals(mockProblem, parserService.parseProblem(mockInputStream));
        verify(mockParseTreeWalker).walk(mockExtractProblemListener, mockProblemParseTree);
    }
}
