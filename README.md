# PDDL Parser

A Java library for parsing Planning Domain Definition Language (PDDL) and turning it into simple Java objects that can
be used by planning algorithms. It provides a fresh, clean and reusable approach to parsing PDDL.

[![Build Status](https://travis-ci.org/gerryai/pddl-parser.svg?branch=master)](https://travis-ci.org/gerryai/pddl-parser) [![Coverage Status](https://coveralls.io/repos/gerryai/pddl-parser/badge.svg?branch=master)](https://coveralls.io/r/gerryai/pddl-parser?branch=master)

## Why?

This project was created to help people implementing planning algorithms skip the dull stuff and get to the
interesting part quicker. After all, who wants to write a parser?

The aim of this project is to provide a parser that:

* Can be integrated quickly into a planning project to add PDDL parsing support
* Generates a simple set of Java objects that represent the domain or problem
* Does not require further compilation steps or use domain-specific classes
* Uses code that is clear to understand, reusable, extensible and fully tested

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

```java
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.parser.ParseException;
import org.gerryai.planning.parser.pddl.PDDLParserService;

...

PDDLParserService parserService = new PDDLParserService();

try {
    Domain domain = parserService.parseDomain(new FileInputStream("domain.pddl"));
    Problem problem = parserService.parseProblem(new FileInputStream("problem.pddl"));
} catch (ParseException ex) {
    throw new IllegalStateException("Could not parse PDDL file", ex);
} catch (IOException ex) {
    throw new IllegalStateException("Could not read PDDL file for parsing", ex);
}
```

The `Domain` or `Problem` object returned has methods to access the model as immutable collections of simple objects
representing the various parts of the domain or problem that was defined in the PDDL file.

## Under the hood

The parser uses an Antlr 4 grammar to parse input.

## Contribute

Email <david@more.fool.me.uk> to join us on [Slack](https://gerryai.slack.com/).

Contributions are gratefully received. There are a number of ways you can help:

### Examples

We need plenty of domain and problem examples to fully test the parser. If you have any examples that will test features
not yet covered by the integration tests that you are happy to have published in the project, please send them through.
Bonus points for writing integration tests to parse and check them.

### Bugs

Please raise bug reports as issues on GitHub, preferably with sample code or PDDL files to reproduce. Pull requests to
fix are welcome.

### Features

If you'd like to request a feature, please raise an issue on GitHub. If you want to work on developing a feature
yourself you're very welcome, but it would be best to raise an issue and discuss first.

## License

Copyright &copy; 2014 David Edwards. This project is licensed as GPL v3 - please see the
[LICENSE](https://github.com/gerrai/pddl-parser/blob/master/LICENSE) file for details. If you wish to use this
project in a situation not compatible with the GPL v3 license, or wish to discuss other licensing options, please
contact us.
