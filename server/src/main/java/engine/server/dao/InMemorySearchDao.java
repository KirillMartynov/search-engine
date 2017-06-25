package engine.server.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.server.domain.SearchEntry;
import engine.server.service.SearchServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InMemorySearchDao implements SearchDao {
    public static final String source = "[\n" +
            "  {\n" +
            "    \"Name\": \"A+\",\n" +
            "    \"Type\": \"Array\",\n" +
            "    \"Designed by\": \"Arthur Whitney\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ActionScript\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Procedural, Reflective, Scripting, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Gary Grossman\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Ada\",\n" +
            "    \"Type\": \"Compiled, Imperative, Procedural, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Tucker Taft, Jean Ichbiah\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Aldor\",\n" +
            "    \"Type\": \"Iterative\",\n" +
            "    \"Designed by\": \"Richard Dimick Jenks, Barry Trager, Stephen Watt, James Davenport, Robert Sutor, Scott Morrison\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Alef\",\n" +
            "    \"Type\": \"Curly-bracket\",\n" +
            "    \"Designed by\": \"Phil Winterbottom\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ALGOL\",\n" +
            "    \"Type\": \"Compiled, Imperative, Procedural\",\n" +
            "    \"Designed by\": \"Bauer, Bottenbruch, Rutishauser, Samelson, Backus, Katz, Perlis, Wegstein, Naur, Vauquois, van Wijngaarden, Woodger, Green, McCarthy\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Ant\",\n" +
            "    \"Type\": \"Interpreted\",\n" +
            "    \"Designed by\": \"Apache Software Foundation\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"APL\",\n" +
            "    \"Type\": \"Array, Interactive mode, Interpreted\",\n" +
            "    \"Designed by\": \"Kenneth E. Iverson\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"AppleScript\",\n" +
            "    \"Type\": \"Scripting\",\n" +
            "    \"Designed by\": \"Apple Inc.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"AWK\",\n" +
            "    \"Type\": \"Curly-bracket, Scripting\",\n" +
            "    \"Designed by\": \"Alfred Aho, Peter Weinberger, Brian Kernighan\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"B\",\n" +
            "    \"Type\": \"Curly-bracket\",\n" +
            "    \"Designed by\": \"Ken Thompson\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"bash\",\n" +
            "    \"Type\": \"Command line interface, Scripting\",\n" +
            "    \"Designed by\": \"Brian Fox\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"BASIC\",\n" +
            "    \"Type\": \"Imperative, Compiled, Procedural, Interactive mode, Interpreted\",\n" +
            "    \"Designed by\": \"John George Kemeny, Thomas Eugene Kurtz\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"BCPL\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Procedural\",\n" +
            "    \"Designed by\": \"Martin Richards\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Blue\",\n" +
            "    \"Type\": \"Imperative, Object-oriented class-based, Procedural\",\n" +
            "    \"Designed by\": \"University of Sydney\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"C\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Imperative, Procedural\",\n" +
            "    \"Designed by\": \"Dennis Ritchie\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"C#\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Iterative, Object-oriented class-based, Reflective, Procedural\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"C++\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Imperative, Metaprogramming, Object-oriented class-based, Procedural\",\n" +
            "    \"Designed by\": \"Bjarne Stroustrup\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Candle\",\n" +
            "    \"Type\": \"Curly-bracket, Scripting\",\n" +
            "    \"Designed by\": \"Henry Luo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Chapel\",\n" +
            "    \"Type\": \"Array\",\n" +
            "    \"Designed by\": \"David Callahan, Hans Zima, Brad Chamberlain, John Plevyak\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ChucK\",\n" +
            "    \"Type\": \"Curly-bracket, Object-oriented class-based, Reflective, Procedural\",\n" +
            "    \"Designed by\": \"Ge Wang\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Cilk\",\n" +
            "    \"Type\": \"Curly-bracket\",\n" +
            "    \"Designed by\": \"MIT\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Clojure\",\n" +
            "    \"Type\": \"Interactive mode, Reflective\",\n" +
            "    \"Designed by\": \"Rich Hickey\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"COBOL\",\n" +
            "    \"Type\": \"Compiled, Imperative, Procedural\",\n" +
            "    \"Designed by\": \"Grace Hopper, William Selden, Gertrude Tierney, Howard Bromberg, Howard Discount, Vernon Reeves, Jean E. Sammet\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Cobra\",\n" +
            "    \"Type\": \"Compiled, Iterative, Object-oriented class-based, Procedural, Reflective\",\n" +
            "    \"Designed by\": \"Charles Esterbrook\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ColdFusion\",\n" +
            "    \"Type\": \"Object-oriented class-based, Procedural, Scripting\",\n" +
            "    \"Designed by\": \"Adobe Systems\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Common Lisp\",\n" +
            "    \"Type\": \"Compiled, Interactive mode, Object-oriented class-based, Reflective\",\n" +
            "    \"Designed by\": \"Scott Fahlman, Richard P. Gabriel, Dave Moon, Guy Steele, Dan Weinreb\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"csh\",\n" +
            "    \"Type\": \"Command line interface\",\n" +
            "    \"Designed by\": \"Bill Joy\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Curl\",\n" +
            "    \"Type\": \"Compiled, Metaprogramming, Object-oriented class-based, Procedural, Reflective\",\n" +
            "    \"Designed by\": \"Steve Ward\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Cyclone\",\n" +
            "    \"Type\": \"Curly-bracket\",\n" +
            "    \"Designed by\": \"AT&T Labs\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"D\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Imperative, Metaprogramming, Object-oriented class-based, Procedural\",\n" +
            "    \"Designed by\": \"Walter Bright, Andrei Alexandrescu\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"DASL\",\n" +
            "    \"Type\": \"Object-oriented class-based, Curly-bracket, Procedural\",\n" +
            "    \"Designed by\": \"Sun Microsystems Laboratories\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Delphi\",\n" +
            "    \"Type\": \"Compiled, Object-oriented class-based, Reflective\",\n" +
            "    \"Designed by\": \"Apple, Niklaus Wirth, Anders Hejlsberg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"E\",\n" +
            "    \"Type\": \"Curly-bracket, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Mark S. Miller\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ECMAScript\",\n" +
            "    \"Type\": \"Curly-bracket, Procedural, Reflective, Scripting\",\n" +
            "    \"Designed by\": \"Brendan Eich, Ecma International\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Eiffel\",\n" +
            "    \"Type\": \"Compiled, Object-oriented class-based, Procedural, Reflective\",\n" +
            "    \"Designed by\": \"Bertrand Meyer\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Erlang\",\n" +
            "    \"Type\": \"Compiled, Interactive mode\",\n" +
            "    \"Designed by\": \"Joe Armstrong\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Expect\",\n" +
            "    \"Type\": \"Command line interface\",\n" +
            "    \"Designed by\": \"Don Libes\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"F#\",\n" +
            "    \"Type\": \"Interactive mode\",\n" +
            "    \"Designed by\": \"Microsoft Research, Don Syme\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Factor\",\n" +
            "    \"Type\": \"Compiled\",\n" +
            "    \"Designed by\": \"Slava Pestov\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Fancy\",\n" +
            "    \"Type\": \"Compiled, Interactive mode, Metaprogramming, Object-oriented class-based, Scripting\",\n" +
            "    \"Designed by\": \"Christopher Bertels\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Forth\",\n" +
            "    \"Type\": \"Compiled, Interactive mode, Metaprogramming, Reflective\",\n" +
            "    \"Designed by\": \"Charles H. Moore\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Fortran\",\n" +
            "    \"Type\": \"Array, Compiled, Imperative, Procedural\",\n" +
            "    \"Designed by\": \"John Backus\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Go\",\n" +
            "    \"Type\": \"Compiled, Imperative, Procedural\",\n" +
            "    \"Designed by\": \"Robert Griesemer, Rob Pike, Ken Thompson\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Gosu\",\n" +
            "    \"Type\": \"Compiled\",\n" +
            "    \"Designed by\": \"Guidewire Software\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Groovy\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Interpreted, Metaprogramming, Object-oriented class-based, Procedural, Reflective, Scripting\",\n" +
            "    \"Designed by\": \"James Strachan\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Hamilton C shell\",\n" +
            "    \"Type\": \"Command line interface\",\n" +
            "    \"Designed by\": \"Nicole Hamilton\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Harbour\",\n" +
            "    \"Type\": \"Compiled, Object-oriented class-based, Procedural, Reflective\",\n" +
            "    \"Designed by\": \"Antonio Linares\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Haskell\",\n" +
            "    \"Type\": \"Compiled, Functional, Metaprogramming, Interpreted, Interactive mode\",\n" +
            "    \"Designed by\": \"Simon Peyton Jones, Lennart Augustsson, Dave Barton, Brian Boutel, Warren Burton, Joseph Fasel, Kevin Hammond, Ralf Hinze, Paul Hudak, John Hughes, Thomas Johnsson, Mark Jones, John Launchbury, Erik Meijer, John Peterson, Alastair Reid, Colin Runciman, Philip Wadler\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"IDL\",\n" +
            "    \"Type\": \"Array, Interactive mode\",\n" +
            "    \"Designed by\": \"David Stern\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"J\",\n" +
            "    \"Type\": \"Array, Interactive mode, Interpreted, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Ken Iverson, Roger Hui\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Java\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Imperative, Object-oriented class-based, Procedural, Reflective\",\n" +
            "    \"Designed by\": \"James Gosling, Sun Microsystems\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"JavaScript\",\n" +
            "    \"Type\": \"Curly-bracket, Interpreted, Reflective, Procedural, Scripting, Interactive mode\",\n" +
            "    \"Designed by\": \"Brendan Eich\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"JOVIAL\",\n" +
            "    \"Type\": \"Compiled, Procedural\",\n" +
            "    \"Designed by\": \"System Development Corporation\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"JScript\",\n" +
            "    \"Type\": \"Curly-bracket, Procedural, Reflective, Scripting\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Julia\",\n" +
            "    \"Type\": \"Array, Imperative, Interactive mode, Interpreted, Metaprogramming, Object-oriented class-based, Reflective, Scripting\",\n" +
            "    \"Designed by\": \"Jeff Bezanson, Stefan Karpinski, Viral B. Shah, Alan Edelman\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"K\",\n" +
            "    \"Type\": \"Array\",\n" +
            "    \"Designed by\": \"Arthur Whitney\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ksh\",\n" +
            "    \"Type\": \"Command line interface\",\n" +
            "    \"Designed by\": \"David Korn\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Lasso\",\n" +
            "    \"Type\": \"Procedural, Scripting, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Kyle Jessup\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Limbo\",\n" +
            "    \"Type\": \"Curly-bracket\",\n" +
            "    \"Designed by\": \"Sean Dorward, Phil Winterbottom, Rob Pike\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Lisp\",\n" +
            "    \"Type\": \"Metaprogramming, Reflective\",\n" +
            "    \"Designed by\": \"John McCarthy\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Lua\",\n" +
            "    \"Type\": \"Imperative, Interactive mode, Interpreted, Iterative, Metaprogramming, Object-oriented class-based, Reflective, Scripting\",\n" +
            "    \"Designed by\": \"Roberto Ierusalimschy, Waldemar Celes, Luiz Henrique de Figueiredo\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"MATLAB\",\n" +
            "    \"Type\": \"Array, Imperative, Interactive mode, Procedural\",\n" +
            "    \"Designed by\": \"MathWorks\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Mercury\",\n" +
            "    \"Type\": \"Compiled, Functional\",\n" +
            "    \"Designed by\": \"Zoltan Somogyi\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ML\",\n" +
            "    \"Type\": \"Compiled, Interactive mode\",\n" +
            "    \"Designed by\": \"Robin Milner\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Nemerle\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Metaprogramming, Object-oriented class-based, Procedural\",\n" +
            "    \"Designed by\": \"Kamil Skalski, Michal Moskal, Prof. Leszek Pacholski, Pawel Olszta\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Obix\",\n" +
            "    \"Type\": \"Compiled, Interactive mode, Object-oriented class-based, Procedural, Reflective, Scripting\",\n" +
            "    \"Designed by\": \"Christian Neumanns\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Objective-C\",\n" +
            "    \"Type\": \"Compiled, Reflective, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Brad Cox, Tom Love\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Pascal\",\n" +
            "    \"Type\": \"Compiled, Imperative, Interpreted\",\n" +
            "    \"Designed by\": \"Niklaus Wirth\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Perl\",\n" +
            "    \"Type\": \"Curly-bracket, Imperative, Interactive mode, Interpreted, Metaprogramming, Procedural, Reflective, Scripting, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Larry Wall\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"PHP\",\n" +
            "    \"Type\": \"Curly-bracket, Imperative, Interpreted, Object-oriented class-based, Reflective, Scripting\",\n" +
            "    \"Designed by\": \"Rasmus Lerdorf\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Python\",\n" +
            "    \"Type\": \"Imperative, Interactive mode, Interpreted, Iterative, Metaprogramming, Procedural, Reflective, Scripting, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Guido van Rossum\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"R\",\n" +
            "    \"Type\": \"Curly-bracket, Interactive mode, Interpreted, Procedural, Scripting\",\n" +
            "    \"Designed by\": \"Ross Ihaka, Robert Gentleman\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"REXX\",\n" +
            "    \"Type\": \"Command line interface, Interactive mode, Interpreted, Scripting\",\n" +
            "    \"Designed by\": \"Mike Cowlishaw\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"RPG\",\n" +
            "    \"Type\": \"Compiled, Procedural\",\n" +
            "    \"Designed by\": \"IBM\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Ruby\",\n" +
            "    \"Type\": \"Imperative, Interpreted, Metaprogramming, Object-oriented class-based, Reflective, Scripting, Interactive mode\",\n" +
            "    \"Designed by\": \"Yukihiro Matsumoto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Rust\",\n" +
            "    \"Type\": \"Compiled, Curly-bracket, Imperative, Metaprogramming, Procedural\",\n" +
            "    \"Designed by\": \"Graydon Hoare\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"S\",\n" +
            "    \"Type\": \"Array\",\n" +
            "    \"Designed by\": \"Rick Becker, Allan Wilks, John Chambers\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"S-Lang\",\n" +
            "    \"Type\": \"Curly-bracket, Interpreted, Procedural, Scripting, Interactive mode\",\n" +
            "    \"Designed by\": \"John E. Davis\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Scala\",\n" +
            "    \"Type\": \"Curly-bracket, Interactive mode, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Martin Odersky\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Scheme\",\n" +
            "    \"Type\": \"Compiled, Interactive mode, Metaprogramming, Reflective\",\n" +
            "    \"Designed by\": \"Guy L. Steele, Gerald Jay Sussman\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Smalltalk\",\n" +
            "    \"Type\": \"Compiled, Metaprogramming, Scripting, Interactive mode, Object-oriented class-based, Reflective\",\n" +
            "    \"Designed by\": \"Alan Kay, Dan Ingalls, Adele Goldberg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"SQL\",\n" +
            "    \"Type\": \"Data-oriented, Declarative, Extension\",\n" +
            "    \"Designed by\": \"Donald D. Chamberlin, Raymond F. Boyce\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Swift\",\n" +
            "    \"Type\": \"Compiled\",\n" +
            "    \"Designed by\": \"Chris Lattner, Apple Inc.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Turing\",\n" +
            "    \"Type\": \"Compiled\",\n" +
            "    \"Designed by\": \"Ric Holt, James Cordy\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"TUTOR\",\n" +
            "    \"Type\": \"Authoring\",\n" +
            "    \"Designed by\": \"Paul Tenczar, Richard Blomme\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Vala\",\n" +
            "    \"Type\": \"Compiled\",\n" +
            "    \"Designed by\": \"Jürg Billeter, Raffaele Sandrini\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"VBScript\",\n" +
            "    \"Type\": \"Interpreted, Procedural, Scripting, Object-oriented class-based\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Visual Basic\",\n" +
            "    \"Type\": \"Compiled, Procedural\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Visual FoxPro\",\n" +
            "    \"Type\": \"Compiled, Data-oriented, Object-oriented class-based, Procedural\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Windows PowerShell\",\n" +
            "    \"Type\": \"Command line interface, Curly-bracket, Interactive mode, Interpreted, Scripting\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"X#\",\n" +
            "    \"Type\": \"Compiled, Procedural\",\n" +
            "    \"Designed by\": \"COSMOS\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"X++\",\n" +
            "    \"Type\": \"Compiled, Object-oriented class-based, Procedural, Reflective\",\n" +
            "    \"Designed by\": \"Microsoft\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"X10\",\n" +
            "    \"Type\": \"Array, Curly-bracket, Object-oriented class-based, Reflective\",\n" +
            "    \"Designed by\": \"Kemal Ebcioglu, Vijay Saraswat, Vivek Sarkar\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"XL\",\n" +
            "    \"Type\": \"Compiled, Procedural, Reflective, Iterative, Metaprogramming\",\n" +
            "    \"Designed by\": \"Christophe de Dinechin\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"ZPL\",\n" +
            "    \"Type\": \"Array\",\n" +
            "    \"Designed by\": \"Chamberlain\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"zsh\",\n" +
            "    \"Type\": \"Command line interface\",\n" +
            "    \"Designed by\": \"Paul Falstad\"\n" +
            "  }\n" +
            "]";

    private final List<SearchEntry> entries;

    public InMemorySearchDao() {
        ObjectMapper mapper = new ObjectMapper();
        List<SearchEntry> entries = Collections.emptyList();
        try{
            TransformationNode[] values = mapper.readValue(source, TransformationNode[].class);
            entries = Arrays.stream(values).map(x ->
                            new SearchEntry(x.name,
                                            splitAndTrim(x.type),
                                            splitAndTrim(x.designedBy))).collect(Collectors.toList());
            System.out.println(values.length);
        } catch(Exception ignored) {
        }

        this.entries = entries;
    }

    private static List<String> splitAndTrim(String value) {
        return Arrays.stream(value.split(",")).map(String::trim).collect(Collectors.toList());
    }

    @Override
    public List<SearchEntry> getEntries() {
        return entries;
    }

    private static class TransformationNode {
        @JsonProperty("Name")
        public String name;

        @JsonProperty("Type")
        public String type;

        @JsonProperty("Designed by")
        public String designedBy;
    }
}
