[MARS](http://courses.missouristate.edu/KenVollmar/MARS/index.htm) is a lightweight interactive development environment (IDE) for programming in MIPS assembly language, intended for educational-level use with Patterson and Hennessy's Computer Organization and Design.

MARS has been jointly developed by [Pete Sanderson](http://faculty.otterbein.edu/PSanderson/) (programming) and [Ken Vollmar](http://courses.missouristate.edu/KenVollmar/) (details and paperwork).

## Purpose of this repo

This is a fork of Jarrett's mirror of the MARS Assembler source code, mainly for personal use (though I am not averse to contributions) / adding more theming options. I am currently working on it across two branches:

- `clean`, which stays as close as possible to the original source code and only contains the "features" that I add
- `master`, which contains all of my changes, including a "dark theme" as the default settings.

Huge thanks to Jarrett for maintaining the [original fork](https://github.com/JarrettBillingsley/MARS_Assembler) of MARS.

## Documentation

[Here](http://courses.missouristate.edu/KenVollmar/MARS/Help/MarsHelpIntro.html).

## How to compile (Linux)

1. Install dependencies: Java 8, JavaFX (it is not included in newer versions of OpenJDK).
2. Run `javac @java_files.txt`.
3. Execute `CreateMarsJar.sh` to uhh... create the jar.
4. `java -jar ./Mars.jar`

## License

[MIT](http://www.opensource.org/licenses/mit-license.html). Check the [LICENSE](https://github.com/adolphenom/MARS_Assembler/blob/master/LICENSE) file. All the credits go to the original developers.
