[![Java CI](https://github.com/xtermi2/java21/actions/workflows/maven.yml/badge.svg)](https://github.com/xtermi2/java21/actions/workflows/maven.yml)

# Schedule

- 2023/09/19 General Availability

# Java 21 Features

- [JEP 430: String Templates (Preview)](https://openjdk.org/jeps/430)
    - String templates complement Java's existing string literals and text blocks by coupling literal text with embedded
      expressions and template processors to produce specialized results.
    - see example `StringTemplates.java`
- [JEP 431: Sequenced Collections](https://openjdk.org/jeps/431)
    - Introduce new interfaces to represent collections with a defined encounter order. Each such collection has a
      well-defined first element, second element, and so forth, up to the last element. It also provides uniform APIs
      for accessing its first and last elements, and for processing its elements in reverse order.
    - see example `SequencedCollections.java`
- [JEP 439: Generational ZGC](https://openjdk.org/jeps/439)
    - Improve application performance by extending the Z Garbage Collector (ZGC) to maintain separate generations for
      young and old objects. This will allow ZGC to collect young objects — which tend to die young — more frequently.
- [JEP 440: Record Patterns](https://openjdk.org/jeps/440)
    - Enhance the Java programming language with record patterns to deconstruct record values. Record patterns and type
      patterns can be nested to enable a powerful, declarative, and composable form of data navigation and processing.
    - see example `RecordPatternMatching.java`
- [JEP 441: Pattern Matching for switch](https://openjdk.java.net/jeps/441)
    - The main changes since the 4th preview are:
        - Remove parenthesized patterns, since they did not have sufficient value, and
        - Allow qualified enum constants as case constants in switch expressions and statements.
    - see example `SwitchPatternMatching.java`
- [JEP 442: Foreign Function & Memory API (Third Preview)](https://openjdk.java.net/jeps/442)
    - Introduce an API by which Java programs can interoperate with code and data outside of the Java runtime.
      Combination of 2 APIs introduced in previous JDKs:
    - Foreign-Memory Access API (incubator in 14, 15 and 16)
    - Foreign Linker API (incubator in 16)
    - The main changes since the second preview are:
        - Centralized the management of the lifetimes of native segments in the Arena interface;
        - Enhanced layout paths with a new element to dereference address layouts;
        - Provided a linker option to optimize calls to functions that are short-lived and will not upcall to Java (
          e.g., clock_gettime);
        - Provided a fallback native linker implementation, based on libffi, to facilitate porting; and
        - Removed the VaList class.
    - see example `ForeignFunctionAndMemoryAPI.java`
- [JEP 443: Unnamed Patterns and Variables (Preview)](https://openjdk.org/jeps/443)
    - Enhance the Java language with unnamed patterns, which match a record component without stating the component's
      name or type, and unnamed variables, which can be initialized but not used. Both are denoted by an
      underscore (`_`) character.
    - see example `RecordPatternMatching.java` and `SwitchPatternMatching.java`

- [JEP 444: Virtual Threads](https://openjdk.org/jeps/444)
  - Virtual threads are lightweight threads that dramatically reduce the effort of writing, maintaining, and observing high-throughput concurrent applications. 
  - Minor changes since second preview:
    - Virtual threads now always support thread-local variables. It is no longer possible, as it was in the preview releases, to create virtual threads that cannot have thread-local variables. Guaranteed support for thread-local variables ensures that many more existing libraries can be used unchanged with virtual threads, and helps with the migration of task-oriented code to use virtual threads.
    - Virtual threads created directly with the Thread.Builder API (as opposed to those created through `Executors.newVirtualThreadPerTaskExecutor()`) are now also, by default, monitored throughout their lifetime and observable via the new thread dump described in the Observing virtual threads section.
  - see example `VirtualThreads.java`
- [JEP 445: Unnamed Classes and Instance Main Methods (Preview)](https://openjdk.org/jeps/445)
    - Evolve the Java language so that students can write their first programs without needing to understand language features designed for large programs. Far from using a separate dialect of Java, students can write streamlined declarations for single-class programs and then seamlessly expand their programs to use more advanced features as their skills grow.
    - First, we enhance the protocol by which Java programs are launched to allow instance main methods. Such methods are not static, need not be public, and need not have a String[] parameter.
    - Second, we introduce unnamed classes to make the class declaration implicit
    - see example `UnnamedClasses.java`
- [JEP 446: Scoped Values (Preview)](https://openjdk.org/jeps/446)
    - Enable the sharing of immutable data within and across threads. They are preferred to thread-local variables,
      especially when using large numbers of virtual threads.
    - Unlike a thread-local variable, a scoped value is written once and is then immutable, and is available only for a
      bounded period during execution of the thread.
    - In effect, a scoped value is an implicit method parameter. It is "as if" every method in a sequence of calls has an additional, invisible, parameter. None of the methods declare this parameter and only the methods that have access to the scoped value object can access its value (the data). Scoped values make it possible to pass data securely from a caller to a faraway callee through a sequence of intermediate methods that do not declare a parameter for the data and have no access to the data.
    - see example `ScopedValueServer.java`
- [JEP 448: Vector API (Sixth Incubator)](https://openjdk.org/jeps/448)
    - Introduce an API to express vector computations that reliably compile at runtime to optimal vector instructions on
      supported CPU architectures, thus achieving performance superior to equivalent scalar computations.
    - update to 5th incubator:
      - Add the exclusive or (xor) operation to vector masks.
      - Improve the performance of vector shuffles, especially when used to rearrange the elements of a vector and when converting between vectors.
- [JEP 449: Deprecate the Windows 32-bit x86 Port for Removal](https://openjdk.org/jeps/449)
    - Deprecate the Windows 32-bit x86 port, with the intent to remove it in a future release.
    - Update the build system to issue an error message when an attempt is made to configure a build for Windows 32-bit x86 (x86-32). The error message will be suppressible via a new configuration option (`--enable-deprecated-ports=yes`).
- [JEP 451: Prepare to Disallow the Dynamic Loading of Agents](https://openjdk.org/jeps/451)
    - Issue warnings when agents are loaded dynamically into a running JVM. These warnings aim to prepare users for a future release which disallows the dynamic loading of agents by default in order to improve integrity by default. Serviceability tools that load agents at startup will not cause warnings to be issued in any release.
    - example:
      ```
      WARNING: A {Java,JVM TI} agent has been loaded dynamically (file:/u/bob/agent.jar)
      WARNING: If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning
      WARNING: If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information
      WARNING: Dynamic loading of agents will be disallowed by default in a future release
      ```
- [JEP 452: Key Encapsulation Mechanism API](https://openjdk.org/jeps/452)
    - TODO
- [JEP 453: Structured Concurrency (Preview)](https://openjdk.org/jeps/453)
    - TODO

----------------------

##### Other References

- https://openjdk.org/projects/jdk/21/
