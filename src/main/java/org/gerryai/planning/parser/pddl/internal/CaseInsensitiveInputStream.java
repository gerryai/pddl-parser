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

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.IntStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Input stream for ANTLR that converts the input data to lower case for the lexer, essentially making the grammar
 * case insensitive. The original test is still returned for everything except the lexer, so toLowerCase() needs
 * to be used on calls to getText(), etc if the tokens need to be case insensitive too.
 */
public class CaseInsensitiveInputStream  extends ANTLRInputStream {

    private char[] lowerCaseData;

    /**
     * Constructor - see {@link org.antlr.v4.runtime.ANTLRInputStream#ANTLRInputStream(char[], int)}.
     * @param data - input stream as a char array
     * @param numberOfActualCharsInArray actual number of characters in the array
     */
    public CaseInsensitiveInputStream(final char[] data, final int numberOfActualCharsInArray) {
        this.data = data;
        this.n = numberOfActualCharsInArray;
        loadLowerCaseData();
    }

    /**
     * Constructor - see {@link org.antlr.v4.runtime.ANTLRInputStream#ANTLRInputStream(java.io.Reader)}.
     * @param r the reader
     * @throws IOException if an error occurs whilst reading the input
     */
    public CaseInsensitiveInputStream(final Reader r) throws IOException {
        this(r, INITIAL_BUFFER_SIZE, READ_BUFFER_SIZE);
    }

    /**
     * Constructor - see {@link org.antlr.v4.runtime.ANTLRInputStream#ANTLRInputStream(java.io.Reader, int)}.
     * @param r an input stream reader
     * @param initialSize the initial buffer size
     * @throws IOException if an error occurs whilst reading the input
     */
    public CaseInsensitiveInputStream(final Reader r, final int initialSize) throws IOException {
        this(r, initialSize, READ_BUFFER_SIZE);
    }

    /**
     * Construtor - see {@link org.antlr.v4.runtime.ANTLRInputStream#ANTLRInputStream(java.io.InputStream, int, int)}.
     * @param r an input stream reader
     * @param initialSize the initial buffer size
     * @param readChunkSize the read chunk size
     * @throws IOException if an error occurs whilst reading the input
     */
    public CaseInsensitiveInputStream(final Reader r, final int initialSize, final int readChunkSize)
            throws IOException {
        load(r, initialSize, readChunkSize);
    }

    /**
     * Constructor - see {@link org.antlr.v4.runtime.ANTLRInputStream#ANTLRInputStream(java.io.InputStream)}.
     * @param input an input stream
     * @throws IOException if an error occurs whilst reading the input
     */
    public CaseInsensitiveInputStream(final InputStream input) throws IOException {
        this(new InputStreamReader(input), INITIAL_BUFFER_SIZE);
    }

    /**
     * Constructor - see {@link org.antlr.v4.runtime.ANTLRInputStream#ANTLRInputStream(java.io.InputStream, int)}.
     * @param input an input stream
     * @param initialSize the initial buffer size
     * @throws IOException if an error occurs whilst reading the input
     */
    public CaseInsensitiveInputStream(final InputStream input, final int initialSize) throws IOException {
        this(new InputStreamReader(input), initialSize);
    }

    /**
     * Constructor - see {@link org.antlr.v4.runtime.ANTLRInputStream#ANTLRInputStream(java.io.InputStream, int, int)}.
     * @param input an input stream
     * @param initialSize the initial buffer size
     * @param readChunkSize the read chunk size
     * @throws IOException if an error occurs whilst reading the input
     */
    public CaseInsensitiveInputStream(final InputStream input, final int initialSize, final int readChunkSize)
            throws IOException {
        this(new InputStreamReader(input), initialSize, readChunkSize);
    }

    @Override
    public void load(final Reader r, final int size, final int readChunkSize) throws IOException {
        super.load(r, size, readChunkSize);
        loadLowerCaseData();
    }

    @Override
    //CHECKSTYLE:OFF
    public int LA(int i) {
        //CHECKSTYLE:ON
        if (i == 0) {
            return 0; // undefined
        }
        if (i < 0) {
            i++; // e.g., translate LA(-1) to use offset i=0; then data[p+0-1]
            if ((p + i - 1) < 0) {
                return IntStream.EOF; // invalid; no char before first char
            }
        }

        if ((p + i - 1) >= n) {
            return IntStream.EOF;
        }
        return lowerCaseData[p + i - 1];
    }

    /**
     * Reload the data converted to lower case.
     */
    private void loadLowerCaseData() {
        lowerCaseData = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            lowerCaseData[i] = Character.toLowerCase(data[i]);
        }
    }
}
