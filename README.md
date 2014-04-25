# PDDL Parser

A Java library for parsing Planning Domain Definition Language and turning it into simple Java objects that can be used
by planning algorithms. It provides a fresh, clean approach to parsing PDDL.

[![Build Status](https://travis-ci.org/gerryai/pddl-parser.svg?branch=master)](https://travis-ci.org/gerryai/pddl-parser) [![Coverage Status](https://coveralls.io/repos/gerryai/pddl-parser/badge.png?branch=master)](https://coveralls.io/r/gerryai/pddl-parser?branch=master)

## Status
*This is a work in progress project, not yet ready for prime time - please contact David Edwards
<david@more.fool.me.uk> if you're interested in using it.*

### What works

Basic STRIPS PDDL parsing, typing, negative preconditions, equality, universal preconditions and conditional-effects.

### What doesn't work

Everything else.

## Usage

### Maven

Add the following to you your `pom.xml` dependencies:

    <dependency>
        <groupId>org.gerryai</groupId>
        <artifactId>pddl-parser</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

### Java

The parser is called on an input stream. There are two basic calls for extracting either a problem or a domain:

    import org.gerryai.planning.model.problem.Problem;
    import org.gerryai.planning.model.domain.Domain;
    import org.gerryai.planning.parser.ParseException;
    import org.gerryai.planning.parser.pddl.PDDLParserService;

    ...

    InputStream problemInputStream = classLoader.getResourceAsStream(getFilePath());
    InputStream domainInputStream = classLoader.getResourceAsStream(getFilePath());

    PDDLParserService parserService = new PDDLParserService();
    try {
        Problem problem = parserService.parseProblem(inputStream);
        Domain domain = parserService.parseDomain(inputStream);
    } catch (ParseException ex) {
        throw new IllegalStateException("Could not parse PDDL file", ex);
    } catch (IOException ex) {
        throw new IllegalStateException("Could not read PDDL file for parsing", ex);
    }

## Contribute

If you'd like to contribute to the project please do so. There are a number of ways you can help:

### Examples

We need plenty of domain and problem examples to fully test the parser. If you have any examples that will test features
not yet covered by the integration tests that you are happy to have published in the project, please send them through.
Bonus points for writing integration tests to parse and check them.

### Bugs

Please raise bug reports as issues on Github. Pull requests to fix them are welcome.

### Features

If you'd like to request a feature, please raise an issue on Github. If you want to work on developing a feature
yourself you're very welcome, but it would be best to raise an issue and discuss first.
